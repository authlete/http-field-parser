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
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class ForwardedPairTest
{
    @Test
    public void test_parse_pair_name()
    {
        Token name = new HttpFieldParser().parseForwardedPairName("name");
        assertNotNull(name);
        assertEquals("name", name.getValue());
    }


    @Test
    public void test_parse_pair_value_token()
    {
        Object value = new HttpFieldParser().parseForwardedPairValue("value");
        assertNotNull(value);
        assertEquals(Token.class, value.getClass());
        assertEquals("value", ((Token)value).getValue());
    }


    @Test
    public void test_parse_pair_value_quoted_string()
    {
        Object value = new HttpFieldParser().parseForwardedPairValue("\"value\"");
        assertNotNull(value);
        assertEquals(QuotedString.class, value.getClass());
        assertEquals("value", ((QuotedString)value).getValue());
    }


    @Test
    public void test_parse_pair_with_token()
    {
        ForwardedPair pair = ForwardedPair.parse("name=value");
        assertNotNull(pair);

        Token name = pair.getName();
        assertNotNull(name);
        assertEquals("name", name.getValue());

        Object value = pair.getValue();
        assertNotNull(value);
        assertEquals(Token.class, value.getClass());
        assertEquals("value", ((Token)value).getValue());
    }


    @Test
    public void test_parse_pair_with_quoted_string()
    {
        ForwardedPair pair = ForwardedPair.parse("name=\"value\"");
        assertNotNull(pair);

        Token name = pair.getName();
        assertNotNull(name);
        assertEquals("name", name.getValue());

        Object value = pair.getValue();
        assertNotNull(value);
        assertEquals(QuotedString.class, value.getClass());
        assertEquals("value", ((QuotedString)value).getValue());
    }


    @Test
    public void test_equals()
    {
        ForwardedPair pair1 =
                new ForwardedPair(
                        new Token("name"),
                        new Token("value"));

        ForwardedPair pair2 =
                new ForwardedPair(
                        new Token(new StringBuilder().append("na").append("me").toString()),
                        new Token(new StringBuilder().append("va").append("lue").toString()));

        ForwardedPair pair3 =
                new ForwardedPair(
                        new Token("name"),
                        new Token("value3"));

        assertEquals(pair1, pair2);
        assertEquals(pair1.hashCode(), pair2.hashCode());

        assertNotEquals(pair1, pair3);
        assertNotEquals(pair1.hashCode(), pair3.hashCode());
    }


    @Test
    public void test_tostring_pair_with_token()
    {
        ForwardedPair pair =
                new ForwardedPair(
                        new Token("name"),
                        new Token("value"));

        assertEquals("name=value", pair.toString());
    }


    @Test
    public void test_tostring_pair_with_quoted_string()
    {
        ForwardedPair pair =
                new ForwardedPair(
                        new Token("name"),
                        new QuotedString("value"));

        assertEquals("name=\"value\"", pair.toString());
    }


    @Test
    public void test_invalid_value_type()
    {
        // The type of the value must be Token or QuotedString.
        assertThrows(IllegalArgumentException.class,
                () -> new ForwardedPair().setValue("value"));
    }
}
