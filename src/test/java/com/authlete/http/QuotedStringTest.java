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
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class QuotedStringTest
{
    @Test
    public void test_parse_valid()
    {
        QuotedString qs = QuotedString.parse("\"qs\"");

        assertEquals("qs", qs.getValue());
    }


    @Test
    public void test_parse_invalid_double_quote()
    {
        // %x22 (double quote)
        assertThrows(RuntimeException.class,
                () -> QuotedString.parse("\"\"\""));
    }


    @Test
    public void test_parse_invalid_backslash()
    {
        // %5C (backslash)
        assertThrows(RuntimeException.class,
                () -> QuotedString.parse("\"\\\""));
    }


    @Test
    public void test_unescape()
    {
        // !\!\"\\
        String escaped = "!\\!\\\"\\\\";

        // !!"\
        String unescaped = "!!\"\\";

        // "!\!\"\\"
        String input = new StringBuilder().append('"').append(escaped).append('"').toString();

        // Parse
        QuotedString qs = QuotedString.parse(input);

        // (Escaped) value
        assertEquals(escaped, qs.getValue());

        // Unescaped value
        assertEquals(unescaped, qs.getUnescapedValue());
    }


    @Test
    public void test_empty()
    {
        QuotedString qs = QuotedString.parse("\"\"");

        assertEquals("", qs.getValue());
        assertEquals("\"\"", qs.toString());
    }


    @Test
    public void test_equals()
    {
        QuotedString qs1 = QuotedString.parse("\"qs\"");
        QuotedString qs2 = QuotedString.parse(new StringBuilder().append("\"q").append("s\"").toString());
        QuotedString qs3 = QuotedString.parse("\"qs3\"");

        assertEquals(qs1, qs2);
        assertEquals(qs1.hashCode(), qs2.hashCode());

        assertNotEquals(qs1, qs3);
        assertNotEquals(qs1.hashCode(), qs3.hashCode());
    }


    @Test
    public void test_tostring()
    {
        QuotedString qs = QuotedString.parse("\"qs\"");

        assertEquals("\"qs\"", qs.toString());
    }
}
