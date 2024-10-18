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


import java.io.Serializable;
import java.util.Objects;
import org.antlr.v4.runtime.misc.ParseCancellationException;


/**
 * This class represents the forwarded pair as defined in <a href=
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
 * <p><b>Sample Code 1</b></p>
 *
 * <pre>
 * <span style="color: green;">// Parse the string as a forwarded pair.</span>
 * ForwardedPair pair = ForwardedPair.parse(<span style="color: darkred;">"name=value"</span>);
 * assertNotNull(pair);
 *
 * <span style="color: green;">// The name of the forwarded pair.</span>
 * Token name = pair.getName();
 * assertNotNull(name);
 * assertEquals(<span style="color: darkred;">"name"</span>, name.getValue());
 *
 * <span style="color: green;">// The value of the forwarded pair.</span>
 * Object value = pair.getValue();
 * assertNotNull(value);
 * assertEquals(Token.class, value.getClass());
 * assertEquals(<span style="color: darkred;">"value"</span>, ((Token)value).getValue());
 * </pre>
 *
 * <p><b>Sample Code 2</b></p>
 *
 * <pre>
 * <span style="color: green;">// Parse the string as a forwarded pair.</span>
 * ForwardedPair pair = ForwardedPair.parse(<span style="color: darkred;">"name=\"value\""</span>);
 * assertNotNull(pair);
 *
 * <span style="color: green;">// The name of the forwarded pair.</span>
 * Token name = pair.getName();
 * assertNotNull(name);
 * assertEquals(<span style="color: darkred;">"name"</span>, name.getValue());
 *
 * <span style="color: green;">// The value of the forwarded pair. Note that this time
 * // the getValue() method returns a QuotedString instance.</span>
 * Object value = pair.getValue();
 * assertNotNull(value);
 * assertEquals(QuotedString.class, value.getClass());
 * assertEquals(<span style="color: darkred;">"value"</span>, ((QuotedString)value).getValue());
 * </pre>
 *
 * @see <a href="https://www.rfc-editor.org/rfc/rfc7239.html#section-4"
 *      >RFC 7239: Forwarded HTTP Extension, Section 4. Forwarded HTTP Header Field</a>
 */
public class ForwardedPair implements Serializable
{
    private static final long serialVersionUID = 1L;


    /**
     * The name of this forwarded pair.
     */
    private Token name;


    /**
     * The value of this forwarded pair.
     */
    private Object value;


    /**
     * The default constructor.
     */
    public ForwardedPair()
    {
        this(null, null);
    }


    /**
     * A constructor with the name and value of this forwarded pair.
     *
     * @param name
     *         The name of this forwarded pair.
     *
     * @param value
     *         The value of this forwarded pair.
     *
     * @throws IllegalArgumentException
     *         The {@code value} is not an instance of either {@link Token} or
     *         {@link QuotedString}, or null.
     */
    public ForwardedPair(Token name, Object value) throws IllegalArgumentException
    {
        this.name  = name;
        this.value = validateValue(value);
    }


    /**
     * Get the name of this forwarded pair.
     *
     * @return
     *         The name of this forwarded pair.
     */
    public Token getName()
    {
        return name;
    }


    /**
     * Set the name of this forwarded pair.
     *
     * @param name
     *         The name of this forwarded pair.
     *
     * @return
     *         {@code this} object.
     */
    public ForwardedPair setName(Token name)
    {
        this.name = name;

        return this;
    }


    /**
     * Get the value of this forwarded pair.
     *
     * @return
     *         The value of this forwarded pair.
     */
    public Object getValue()
    {
        return value;
    }


    /**
     * Set the value of this forwarded pair.
     *
     * @param value
     *         The value of this forwarded pair.
     *
     * @return
     *         {@code this} object.
     *
     * @throws IllegalArgumentException
     *         The {@code value} is not an instance of either {@link Token} or
     *         {@link QuotedString}, or null.
     */
    public ForwardedPair setValue(Object value) throws IllegalArgumentException
    {
        this.value = validateValue(value);

        return this;
    }


    /**
     * Check if the {@code value} is an instance of {@link Token} or {@link QuotedString},
     * or null.
     *
     * @param value
     *         A value to be checked.
     *
     * @return
     *         The given value.
     *
     * @throws IllegalArgumentException
     *         The {@code value} is not an instance of either {@link Token} or
     *         {@link QuotedString}, or null.
     */
    private static Object validateValue(Object value) throws IllegalArgumentException
    {
        if (value == null)
        {
            return value;
        }

        if (value instanceof Token ||
            value instanceof QuotedString)
        {
            return value;
        }

        throw new IllegalArgumentException(
                "'value' must be an instance of either Token or QuotedString, or null.");
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (obj == this)
        {
            return true;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        ForwardedPair that = (ForwardedPair)obj;

        return Objects.equals(name, that.name) &&
               Objects.equals(value, that.value);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(name, value);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        if (name != null)
        {
            sb.append(name.toString());
        }

        sb.append('=');

        if (value != null)
        {
            sb.append(value.toString());
        }

        return sb.toString();
    }


    /**
     * Parse the input string as a forwarded pair.
     *
     * @param input
     *         A string to be parsed as a forwarded pair.
     *
     * @return
     *         The parsed forwarded pair.
     *
     * @throws ParseCancellationException
     *         The input string could not be parsed successfully.
     */
    public static ForwardedPair parse(String input) throws ParseCancellationException
    {
        return new HttpFieldParser().parseForwardedPair(input);
    }
}
