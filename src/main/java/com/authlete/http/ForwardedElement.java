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


import java.util.ArrayList;
import java.util.Collection;
import org.antlr.v4.runtime.misc.ParseCancellationException;


/**
 * This class represents the forwarded element as defined in <a href=
 * "https://www.rfc-editor.org/rfc/rfc7239.html#section-4">RFC 7239:
 * Forwarded HTTP Extension, Section 4&#x2E; Forwarded HTTP Header Field</a>.
 *
 * <p><b>Definition</b></p>
 *
 * <pre>
 * Forwarded   = 1#forwarded-element
 *
 * forwarded-element =
 *     [ forwarded-pair ] *( ";" [ forwarded-pair ] )
 *
 * forwarded-pair = token "=" value
 * value          = token / quoted-string
 *
 * token = &lt;Defined in [<a href="https://www.rfc-editor.org/rfc/rfc7230.html">RFC7230</a>], <!--
 * --><a href="https://www.rfc-editor.org/rfc/rfc7230.html#section-3.2.6">Section 3.2.6</a>&gt;
 * quoted-string = &lt;Defined in [<a href="https://www.rfc-editor.org/rfc/rfc7230.html">RFC7230</a>], <!--
 * --><a href="https://www.rfc-editor.org/rfc/rfc7230.html#section-3.2.6">Section 3.2.6</a>&gt;
 * </pre>
 *
 * <p><b>Sample Code</b></p>
 *
 * <pre>
 * ForwardedElement element = ForwardedElement.parse(
 *         <span style="color: darkred;">"for=192.0.2.60;proto=http;by=203.0.113.43;host=example.com"</span>);
 * assertNotNull(element);
 * assertEquals(4, element.size());
 *
 * <span style="color: green;">// for</span>
 * ForwardedPair forPair = element.get(0);
 * assertNotNull(forPair);
 *
 * Token forName = forPair.getName();
 * assertNotNull(forName);
 * assertEquals(<span style="color: darkred;">"for"</span>, forName.getValue());
 *
 * Object forValue = forPair.getValue();
 * assertNotNull(forValue);
 * assertEquals(Token.class, forValue.getClass());
 * assertEquals(<span style="color: darkred;">"192.0.2.60"</span>, ((Token)forValue).getValue());
 *
 * <span style="color: green;">// proto</span>
 * ForwardedPair protoPair = element.get(1);
 * assertNotNull(protoPair);
 *
 * Token protoName = protoPair.getName();
 * assertNotNull(protoName);
 * assertEquals(<span style="color: darkred;">"proto"</span>, protoName.getValue());
 *
 * Object protoValue = protoPair.getValue();
 * assertNotNull(protoValue);
 * assertEquals(Token.class, protoValue.getClass());
 * assertEquals(<span style="color: darkred;">"http"</span>, ((Token)protoValue).getValue());
 *
 * <span style="color: green;">// by</span>
 * ForwardedPair byPair = element.get(2);
 * assertNotNull(byPair);
 *
 * Token byName = byPair.getName();
 * assertNotNull(byName);
 * assertEquals(<span style="color: darkred;">"by"</span>, byName.getValue());
 *
 * Object byValue = byPair.getValue();
 * assertNotNull(byValue);
 * assertEquals(Token.class, byValue.getClass());
 * assertEquals(<span style="color: darkred;">"203.0.113.43"</span>, ((Token)byValue).getValue());
 *
 * <span style="color: green;">// host</span>
 * ForwardedPair hostPair = element.get(3);
 * assertNotNull(hostPair);
 *
 * Token hostName = hostPair.getName();
 * assertNotNull(hostName);
 * assertEquals(<span style="color: darkred;">"host"</span>, hostName.getValue());
 *
 * Object hostValue = hostPair.getValue();
 * assertNotNull(hostValue);
 * assertEquals(Token.class, hostValue.getClass());
 * assertEquals(<span style="color: darkred;">"example.com"</span>, ((Token)hostValue).getValue());
 *
 * <span style="color: green;">// Search</span>
 * assertEquals(<span style="color: darkred;">"192.0.2.60"</span>,   element.getFor());
 * assertEquals(<span style="color: darkred;">"http"</span>,         element.getProto());
 * assertEquals(<span style="color: darkred;">"203.0.113.43"</span>, element.getBy());
 * assertEquals(<span style="color: darkred;">"example.com"</span>,  element.getHost());
 * </pre>
 *
 * @see <a href="https://www.rfc-editor.org/rfc/rfc7239.html#section-4"
 *      >RFC 7239: Forwarded HTTP Extension, Section 4. Forwarded HTTP Header Field</a>
 */
public class ForwardedElement extends ArrayList<ForwardedPair>
{
    private static final long serialVersionUID = 1L;


    private static final String PARAMETER_NAME_BY    = "by";
    private static final String PARAMETER_NAME_FOR   = "for";
    private static final String PARAMETER_NAME_HOST  = "host";
    private static final String PARAMETER_NAME_PROTO = "proto";


    /**
     * The default constructor.
     */
    public ForwardedElement()
    {
        super();
    }


    /**
     * A constructor with the initial elements.
     *
     * @param elements
     *         The initial elements.
     */
    public ForwardedElement(Collection<? extends ForwardedPair> elements)
    {
        super(elements);
    }


    /**
     * A constructor with the initial capacity.
     *
     * @param capacity
     *         The initial capacity.
     */
    public ForwardedElement(int capacity)
    {
        super(capacity);
    }


    /**
     * Get the value of the forwarded pair whose parameter name is "by"
     * (case-insensitive).
     *
     * @return
     *         The value of the forwarded pair whose parameter name is "by"
     *         (case-insensitive). {@code null} is returned if this forwarded
     *         element does not include such a forwarded pair.
     */
    public String getBy()
    {
        return getValue(PARAMETER_NAME_BY);
    }


    /**
     * Get the forwarded pair whose parameter name is "by" (case-insensitive).
     *
     * @return
     *         The forwarded pair whose parameter name is "by"
     *         (case-insensitive). {@code null} is returned if this forwarded
     *         element does not include such a forwarded pair.
     */
    public ForwardedPair getByPair()
    {
        return getPair(PARAMETER_NAME_BY);
    }


    /**
     * Get the value of the forwarded pair whose parameter name is "for"
     * (case-insensitive).
     *
     * @return
     *         The value of the forwarded pair whose parameter name is "for"
     *         (case-insensitive). {@code null} is returned if this forwarded
     *         element does not include such a forwarded pair.
     */
    public String getFor()
    {
        return getValue(PARAMETER_NAME_FOR);
    }


    /**
     * Get the forwarded pair whose parameter name is "for" (case-insensitive).
     *
     * @return
     *         The forwarded pair whose parameter name is "for"
     *         (case-insensitive). {@code null} is returned if this forwarded
     *         element does not include such a forwarded pair.
     */
    public ForwardedPair getForPair()
    {
        return getPair(PARAMETER_NAME_FOR);
    }


    /**
     * Get the value of the forwarded pair whose parameter name is "host"
     * (case-insensitive).
     *
     * @return
     *         The value of the forwarded pair whose parameter name is "host"
     *         (case-insensitive). {@code null} is returned if this forwarded
     *         element does not include such a forwarded pair.
     */
    public String getHost()
    {
        return getValue(PARAMETER_NAME_HOST);
    }


    /**
     * Get the forwarded pair whose parameter name is "host" (case-insensitive).
     *
     * @return
     *         The forwarded pair whose parameter name is "host"
     *         (case-insensitive). {@code null} is returned if this forwarded
     *         element does not include such a forwarded pair.
     */
    public ForwardedPair getHostPair()
    {
        return getPair(PARAMETER_NAME_HOST);
    }


    /**
     * Get the value of the forwarded pair whose parameter name is "proto"
     * (case-insensitive).
     *
     * @return
     *         The value of the forwarded pair whose parameter name is "proto"
     *         (case-insensitive). {@code null} is returned if this forwarded
     *         element does not include such a forwarded pair.
     */
    public String getProto()
    {
        return getValue(PARAMETER_NAME_PROTO);
    }


    /**
     * Get the forwarded pair whose parameter name is "proto" (case-insensitive).
     *
     * @return
     *         The forwarded pair whose parameter name is "proto"
     *         (case-insensitive). {@code null} is returned if this forwarded
     *         element does not include such a forwarded pair.
     */
    public ForwardedPair getProtoPair()
    {
        return getPair(PARAMETER_NAME_PROTO);
    }


    /**
     * Get the forwarded pair that has the specified parameter name.
     *
     * @param parameterName
     *         A parameter name such as "for" (case-insensitive).
     *
     * @return
     *         The forwarded pair that has the specified parameter name.
     *         {@code null} is returned if this forwarded element does not
     *         include such a forwarded pair.
     */
    public ForwardedPair getPair(String parameterName)
    {
        for (ForwardedPair pair : this)
        {
            if (pair == null)
            {
                continue;
            }

            Token name = pair.getName();

            if (name == null)
            {
                continue;
            }

            if (parameterName.equalsIgnoreCase(name.getValue()))
            {
                return pair;
            }
        }

        return null;
    }


    /**
     * Get the value of the forwarded pair that has the specified parameter name.
     *
     * @param parameterName
     *         A parameter name such as "for" (case-insensitive).
     *
     * @return
     *         The value of the forwarded pair that has the specified parameter name.
     *         {@code null} is returned if this forwarded element does not
     *         include such a forwarded pair.
     */
    public String getValue(String parameterName)
    {
        return extractValue(parameterName, getPair(parameterName));
    }


    private static String extractValue(String parameterName, ForwardedPair pair)
    {
        if (pair == null)
        {
            return null;
        }

        Object value = pair.getValue();

        if (value == null)
        {
            return null;
        }

        if (value instanceof Token)
        {
            return ((Token)value).getValue();
        }

        if (value instanceof QuotedString)
        {
            return ((QuotedString)value).getValue();
        }

        // This should not happen.
        throw new IllegalStateException(String.format(
                "The value of the parameter '%s' is neither Token nor QuotedString, but %s",
                parameterName, value.getClass().getName()));
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        int size = size();

        for (int i = 0; i < size; i++)
        {
            ForwardedPair pair = get(i);

            if (pair == null)
            {
                continue;
            }

            if (i != 0)
            {
                sb.append(";");
            }

            sb.append(pair.toString());
        }

        return sb.toString();
    }


    /**
     * Parse the input string as a forwarded element.
     *
     * @param input
     *         A string to be parsed as a forwarded element.
     *
     * @return
     *         The parsed forwarded element.
     *
     * @throws ParseCancellationException
     *         The input string could not be parsed successfully.
     */
    public static ForwardedElement parse(String input) throws ParseCancellationException
    {
        return new HttpFieldParser().parseForwardedElement(input);
    }
}
