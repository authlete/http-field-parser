/*
 * Copyright (C) 2024 Authlete, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.authlete.http;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;


public class ForwardedFieldValueTest
{
    @Test
    public void test_parse_multiple_elements()
    {
        ForwardedFieldValue ffv = ForwardedFieldValue.parse(String.join(", ",
                "for=\"_gazonk\"",
                "For=\"[2001:db8:cafe::17]:4711\"",
                "for=192.0.2.60;proto=http;by=203.0.113.43",
                "for=192.0.2.43;host=example.com"
        ));

        assertNotNull(ffv);
        assertEquals(4, ffv.size());

        // 0
        assertEquals("_gazonk", ffv.get(0).getFor());

        // 1
        assertEquals("[2001:db8:cafe::17]:4711", ffv.get(1).getFor());

        // 2
        assertEquals("192.0.2.60",   ffv.get(2).getFor());
        assertEquals("http",         ffv.get(2).getProto());
        assertEquals("203.0.113.43", ffv.get(2).getBy());

        // 3
        assertEquals("192.0.2.43",  ffv.get(3).getFor());
        assertEquals("example.com", ffv.get(3).getHost());
    }


    @Test
    public void test_equals()
    {
        ForwardedFieldValue ffv1 = ForwardedFieldValue.parse("for=1, for=2");
        ForwardedFieldValue ffv2 = ForwardedFieldValue.parse("for = 1 , for = 2");
        ForwardedFieldValue ffv3 = ForwardedFieldValue.parse("for=1, for=3");

        assertEquals(ffv1, ffv2);
        assertEquals(ffv1.hashCode(), ffv2.hashCode());

        assertNotEquals(ffv1, ffv3);
        assertNotEquals(ffv1.hashCode(), ffv3.hashCode());
    }


    @Test
    public void test_tostring()
    {
        ForwardedFieldValue ffv = ForwardedFieldValue.parse("for = 1 , for = \"2\"");

        assertEquals("for=1, for=\"2\"", ffv.toString());
    }


    @Test
    public void test_canonicalization()
    {
        // A field value with leading and trailing white spaces,
        // and an obs-fold (Obsolete Line Folding).
        String fieldValue = " \t for=1\r\n   , for=2 \t ";

        // The input string is processed after canonicalization,
        // where leading and trailing white spaces are removed and
        // obs-fold's are replaced with a single white space.
        ForwardedFieldValue ffv = ForwardedFieldValue.parse(fieldValue);

        assertEquals("for=1, for=2", ffv.toString());
    }


    @Test
    public void test_comma_in_quoted_string()
    {
        // A field value with quoted strings including commas.
        String fieldValue = "for=\"a,b\", for=\"c,d\"";

        // Parse the field value.
        ForwardedFieldValue ffv = ForwardedFieldValue.parse(fieldValue);

        assertEquals(2, ffv.size());

        // The commas in the quoted strings must not be interpreted as
        // delimiters between forwarded elements.
        assertEquals("a,b", ffv.get(0).getFor());
        assertEquals("c,d", ffv.get(1).getFor());
    }


    @Test
    public void test_semicolon_in_quoted_string()
    {
        // A field value with quoted strings including semicolons.
        String fieldValue = "for=\"a;b\";proto=https, for=\"c;d\";host=example.com";

        // Parse the field value.
        ForwardedFieldValue ffv = ForwardedFieldValue.parse(fieldValue);

        assertEquals(2, ffv.size());

        // The semicolons in the quoted strings must not be interpreted as
        // delimiters between forwarded pairs.
        assertEquals("a;b", ffv.get(0).getFor());
        assertEquals("https", ffv.get(0).getProto());
        assertEquals("c;d", ffv.get(1).getFor());
        assertEquals("example.com", ffv.get(1).getHost());
    }
}
