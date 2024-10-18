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
import java.util.regex.Pattern;
import org.antlr.v4.runtime.misc.ParseCancellationException;


/**
 * This class represents the quoted string as defined in <a href=
 * "https://www.rfc-editor.org/rfc/rfc9110.html#section-5.6.4">RFC 9110:
 * HTTP Semantics, Section 5&#x2E;6&#x2E;4&#x2E; Quoted Strings</a>.
 *
 * <p><b>Definition</b></p>
 *
 * <pre>
 * quoted-string = DQUOTE *( qdtext / quoted-pair ) DQUOTE
 * qdtext        = HTAB / SP / %x21 / %x23-5B / %x5D-7E / obs-text
 * quoted-pair   = "\" ( HTAB / SP / VCHAR / obs-text )
 * </pre>
 *
 * <p><b>Sample Code 1</b></p>
 *
 * <pre>
 * <span style="color: green;">// Parse the string as a quoted string. Note that a quoted
 * // string must be enclosed with double quotes.</span>
 * QuotedString qs = QuotedString.parse(<span style="color: darkred;">"\"qs\""</span>);
 *
 * <span style="color: green;">// The string returned from the getValue() method is not
 * // enclosed with double quotes.</span>
 * assertEquals(<span style="color: darkred;">"qs"</span>, qs.getValue());
 *
 * <span style="color: green;">// The string returned from the toString() method is
 * // enclosed with double quotes.</span>
 * assertEquals(<span style="color: darkred;">"\"qs\""</span>, qs.toString());
 * </pre>
 *
 * <p><b>Sample Code 2</b></p>
 *
 * <pre>
 * <span style="color: green;">// Parse a quoted string without content.</span>
 * QuotedString qs = QuotedString.parse(<span style="color: darkred;">"\"\""</span>);
 *
 * <span style="color: green;">// The getValue() method returns an empty string.</span>
 * assertEquals(<span style="color: darkred;">""</span>, qs.getValue());
 *
 * <span style="color: green;">// The toString() method returns a string containing
 * // two double quotes.</span>
 * assertEquals(<span style="color: darkred;">"\"\""</span>, qs.toString());
 * </pre>
 *
 * <p><b>Sample Code 3</b></p>
 *
 * <pre>
 * <span style="color: green;">// !\!\"\\</span>
 * String escaped = <span style="color: darkred;">"!\\!\\\"\\\\"</span>;
 *
 * <span style="color: green;">// !!"\</span>
 * String unescaped = <span style="color: darkred;">"!!\"\\"</span>;
 *
 * <span style="color: green;">// "!\!\"\\"</span>
 * String input = new StringBuilder()
 *     .append(<span style="color: darkred;">'"'</span>).append(escaped)<!--
 *     -->.append(<span style="color: darkred;">'"'</span>).toString();
 *
 * <span style="color: green;">// Parse</span>
 * QuotedString qs = QuotedString.parse(input);
 *
 * <span style="color: green;">// (Escaped) value</span>
 * assertEquals(escaped, qs.getValue());
 *
 * <span style="color: green;">// Unescaped value</span>
 * assertEquals(unescaped, qs.getUnescapedValue());
 * </pre>
 *
 * @see <a href="https://www.rfc-editor.org/rfc/rfc9110.html#section-5.6.4"
 *      >RFC 9110: HTTP Semantics, Section 5.6.4. Quoted Strings</a>
 */
public class QuotedString implements Serializable
{
    private static final long serialVersionUID = 1L;


    // The pattern representing "quoted-pair", which is defined as follows in
    // RFC 9110: HTTP Semantics, Section 5.6.4. Quoted Strings.
    //
    //   quoted-pair = "\" ( HTAB / SP / VCHAR / obs-text )
    //
    private static final Pattern PATTERN_ESCAPE =
            Pattern.compile("\\\\([\t \u0021-\u007E\u0080-\u00FF])");


    /**
     * The content of this quoted string.
     */
    private String value;


    /**
     * The default constructor.
     */
    public QuotedString()
    {
        this(null);
    }


    /**
     * A constructor with the content of this quoted string.
     *
     * @param value
     *         The content of this quoted string.
     */
    public QuotedString(String value)
    {
        this.value = value;
    }


    /**
     * Get the content of this quoted string.
     *
     * @return
     *         The content of this quoted string.
     */
    public String getValue()
    {
        return value;
    }


    /**
     * Set the content of this quoted string.
     *
     * @param value
     *         The content of this quoted string.
     *
     * @return
     *         {@code this} object.
     */
    public QuotedString setValue(String value)
    {
        this.value = value;

        return this;
    }


    /**
     * Get the content of this quoted string with quoted pairs unescaped.
     * See the JavaDoc of this {@link QuotedString} class for the behavior
     * of this method.
     *
     * @return
     *         The content of this quoted string with quoted pairs unescaped.
     */
    public String getUnescapedValue()
    {
        if (value == null)
        {
            return null;
        }

        return PATTERN_ESCAPE.matcher(value).replaceAll("$1");
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

        QuotedString that = (QuotedString)obj;

        return Objects.equals(value, that.value);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(value);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append('"');

        if (value != null)
        {
            sb.append(value);
        }

        sb.append('"');

        return sb.toString();
    }


    /**
     * Parse the input string as a quoted string.
     *
     * @param input
     *         A string to be parsed as a quoted string.
     *
     * @return
     *         The parsed quoted string.
     *
     * @throws ParseCancellationException
     *         The input string could not be parsed successfully.
     */
    public static QuotedString parse(String input) throws ParseCancellationException
    {
        return new HttpFieldParser().parseQuotedString(input);
    }
}
