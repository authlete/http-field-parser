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


public class TokenTest
{
    @Test
    public void test_parse_valid()
    {
        Token token = Token.parse("token");

        assertEquals("token", token.getValue());
    }


    @Test
    public void test_parse_invalid()
    {
        // '[' and ']' are invalid characters in "Token".
        // See RFC 9110: HTTP Semantics, Section 5.6.2. Tokens.
        assertThrows(RuntimeException.class, () -> Token.parse("[token]"));
    }


    @Test
    public void test_equals()
    {
        Token token1 = Token.parse("token");
        Token token2 = Token.parse(new StringBuilder().append("to").append("ken").toString());
        Token token3 = Token.parse("token3");

        assertEquals(token1, token2);
        assertEquals(token1.hashCode(), token2.hashCode());

        assertNotEquals(token1, token3);
        assertNotEquals(token1.hashCode(), token3.hashCode());
    }


    @Test
    public void test_tostring()
    {
        Token token = Token.parse("token");

        assertEquals("token", token.toString());
    }
}
