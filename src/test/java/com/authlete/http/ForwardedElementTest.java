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


public class ForwardedElementTest
{
    @Test
    public void test_element_one_pair_with_token()
    {
        ForwardedElement element = ForwardedElement.parse("for=192.0.2.60");
        assertNotNull(element);
        assertEquals(1, element.size());

        ForwardedPair pair = element.get(0);
        assertNotNull(pair);

        Token name = pair.getName();
        assertNotNull(name);
        assertEquals("for", name.getValue());

        Object value = pair.getValue();
        assertNotNull(value);
        assertEquals(Token.class, value.getClass());
        assertEquals("192.0.2.60", ((Token)value).getValue());
    }


    @Test
    public void test_element_one_pair_with_quoted_string()
    {
        ForwardedElement element = ForwardedElement.parse("for=\"_gazonk\"");
        assertNotNull(element);
        assertEquals(1, element.size());

        ForwardedPair pair = element.get(0);
        assertNotNull(pair);

        Token name = pair.getName();
        assertNotNull(name);
        assertEquals("for", name.getValue());

        Object value = pair.getValue();
        assertNotNull(value);
        assertEquals(QuotedString.class, value.getClass());
        assertEquals("_gazonk", ((QuotedString)value).getValue());
    }


    @Test
    public void test_element_multiple_pairs()
    {
        ForwardedElement element = ForwardedElement.parse(
                "for=192.0.2.60;proto=http;by=203.0.113.43;host=example.com");
        assertNotNull(element);
        assertEquals(4, element.size());

        // for
        ForwardedPair forPair = element.get(0);
        assertNotNull(forPair);

        Token forName = forPair.getName();
        assertNotNull(forName);
        assertEquals("for", forName.getValue());

        Object forValue = forPair.getValue();
        assertNotNull(forValue);
        assertEquals(Token.class, forValue.getClass());
        assertEquals("192.0.2.60", ((Token)forValue).getValue());

        // proto
        ForwardedPair protoPair = element.get(1);
        assertNotNull(protoPair);

        Token protoName = protoPair.getName();
        assertNotNull(protoName);
        assertEquals("proto", protoName.getValue());

        Object protoValue = protoPair.getValue();
        assertNotNull(protoValue);
        assertEquals(Token.class, protoValue.getClass());
        assertEquals("http", ((Token)protoValue).getValue());

        // by
        ForwardedPair byPair = element.get(2);
        assertNotNull(byPair);

        Token byName = byPair.getName();
        assertNotNull(byName);
        assertEquals("by", byName.getValue());

        Object byValue = byPair.getValue();
        assertNotNull(byValue);
        assertEquals(Token.class, byValue.getClass());
        assertEquals("203.0.113.43", ((Token)byValue).getValue());

        // host
        ForwardedPair hostPair = element.get(3);
        assertNotNull(hostPair);

        Token hostName = hostPair.getName();
        assertNotNull(hostName);
        assertEquals("host", hostName.getValue());

        Object hostValue = hostPair.getValue();
        assertNotNull(hostValue);
        assertEquals(Token.class, hostValue.getClass());
        assertEquals("example.com", ((Token)hostValue).getValue());

        // Search
        assertEquals("192.0.2.60",   element.getFor());
        assertEquals("http",         element.getProto());
        assertEquals("203.0.113.43", element.getBy());
        assertEquals("example.com",  element.getHost());
    }


    @Test
    public void test_equals()
    {
        ForwardedElement element1 = ForwardedElement.parse(
                "for=192.0.2.60;proto=http;by=203.0.113.43;host=example.com");

        ForwardedElement element2 = ForwardedElement.parse(
                "for = 192.0.2.60 ; proto = http ; by = 203.0.113.43 ; host = example.com");

        ForwardedElement element3 = ForwardedElement.parse(
                "for = 192.0.1.60 ; proto = http ; by = 203.0.113.43 ; host = example.com");

        assertEquals(element1, element2);
        assertEquals(element1.hashCode(), element2.hashCode());

        assertNotEquals(element1, element3);
        assertNotEquals(element1.hashCode(), element3.hashCode());
    }


    @Test
    public void test_tostring()
    {
        ForwardedElement element = ForwardedElement.parse(
                "for = \"[2001:db8:cafe::17]\" ; proto = http ; by = 203.0.113.43 ; host = example.com");

        assertEquals("for=\"[2001:db8:cafe::17]\";proto=http;by=203.0.113.43;host=example.com", element.toString());
    }
}
