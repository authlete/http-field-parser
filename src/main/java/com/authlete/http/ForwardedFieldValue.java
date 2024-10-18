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
 * This class represents the value of the {@code Forwarded} HTTP field as defined
 * in <a href="https://www.rfc-editor.org/rfc/rfc7239.html#section-4">RFC 7239:
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
 * ForwardedFieldValue ffv = ForwardedFieldValue.parse(String.join(<span style="color: darkred;">", "</span>,
 *         <span style="color: darkred;">"for=\"_gazonk\""</span>,
 *         <span style="color: darkred;">"For=\"[2001:db8:cafe::17]:4711\""</span>,
 *         <span style="color: darkred;">"for=192.0.2.60;proto=http;by=203.0.113.43"</span>,
 *         <span style="color: darkred;">"for=192.0.2.43;host=example.com"</span>
 * ));
 *
 * assertNotNull(ffv);
 * assertEquals(4, ffv.size());
 *
 * <span style="color: green;">// 0</span>
 * assertEquals(<span style="color: darkred;">"_gazonk"</span>, ffv.get(0).getFor());
 *
 * <span style="color: green;">// 1</span>
 * assertEquals(<span style="color: darkred;">"[2001:db8:cafe::17]:4711"</span>, ffv.get(1).getFor());
 *
 * <span style="color: green;">// 2</span>
 * assertEquals(<span style="color: darkred;">"192.0.2.60"</span>,   ffv.get(2).getFor());
 * assertEquals(<span style="color: darkred;">"http"</span>,         ffv.get(2).getProto());
 * assertEquals(<span style="color: darkred;">"203.0.113.43"</span>, ffv.get(2).getBy());
 *
 * <span style="color: green;">// 3</span>
 * assertEquals(<span style="color: darkred;">"192.0.2.43"</span>,  ffv.get(3).getFor());
 * assertEquals(<span style="color: darkred;">"example.com"</span>, ffv.get(3).getHost());
 * </pre>
 *
 * @see <a href="https://www.rfc-editor.org/rfc/rfc7239.html#section-4"
 *      >RFC 7239: Forwarded HTTP Extension, Section 4. Forwarded HTTP Header Field</a>
 */
public class ForwardedFieldValue extends ArrayList<ForwardedElement>
{
    private static final long serialVersionUID = 1L;


    /**
     * The default constructor.
     */
    public ForwardedFieldValue()
    {
        super();
    }


    /**
     * A constructor with the initial elements.
     *
     * @param elements
     *         The initial elements.
     */
    public ForwardedFieldValue(Collection<? extends ForwardedElement> elements)
    {
        super(elements);
    }


    /**
     * A constructor with the initial capacity.
     *
     * @param capacity
     *         The initial capacity.
     */
    public ForwardedFieldValue(int capacity)
    {
        super(capacity);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        int size = size();

        for (int i = 0; i < size; i++)
        {
            ForwardedElement element = get(i);

            if (element == null)
            {
                continue;
            }

            if (i != 0)
            {
                sb.append(", ");
            }

            sb.append(element.toString());
        }

        return sb.toString();
    }


    /**
     * Parse the input string as the value of a {@code Forwarded} HTTP field.
     *
     * @param input
     *         A string to be parsed as the value of a {@code Forwarded} HTTP field.
     *
     * @return
     *         The parsed value of the {@code Forwarded} HTTP field.
     *
     * @throws ParseCancellationException
     *         The input string could not be parsed successfully.
     */
    public static ForwardedFieldValue parse(String input) throws ParseCancellationException
    {
        return new HttpFieldParser().parseForwardedFieldValue(input);
    }
}
