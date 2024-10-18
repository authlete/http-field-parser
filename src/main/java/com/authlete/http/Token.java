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
 * This class represents the token as defined in <a href=
 * "https://www.rfc-editor.org/rfc/rfc9110.html#section-5.6.2">RFC 9110:
 * HTTP Semantics, Section 5&#x2E;6&#x2E;2&#x2E; Tokens</a>.
 *
 * <p><b>Definition</b></p>
 *
 * <pre>
 * token = 1*tchar
 *
 * tchar = "!" / "#" / "$" / "%" / "&amp;" / "'" / "*"
 *       / "+" / "-" / "." / "^" / "_" / "`" / "|" / "~"
 *       / DIGIT / ALPHA
 *       ; any VCHAR, except delimiters
 * </pre>
 *
 * <p><b>Sample Code</b></p>
 *
 * <pre>
 * <span style="color: green;">// Parse the string as a token.</span>
 * Token token = Token.parse(<span style="color: darkred;">"token"</span>);
 *
 * <span style="color: green;">// The getValue() method returns the raw value of the token.</span>
 * assertEquals(<span style="color: darkred;">"token"</span>, token.getValue());
 * </pre>
 *
 * @see <a href="https://www.rfc-editor.org/rfc/rfc9110.html#section-5.6.2"
 *      >RFC 9110: HTTP Semantics, Section 5.6.2. Tokens</a>
 */
public class Token implements Serializable
{
    private static final long serialVersionUID = 1L;


    /**
     * The raw value of this token.
     */
    private String value;


    /**
     * The default constructor.
     */
    public Token()
    {
        this(null);
    }


    /**
     * A constructor with the raw value of this token.
     *
     * @param value
     *         The raw value of this token.
     */
    public Token(String value)
    {
        this.value = value;
    }


    /**
     * Get the raw value of this token.
     *
     * @return
     *         The raw value of this token.
     */
    public String getValue()
    {
        return value;
    }


    /**
     * Set the raw value of this token.
     *
     * @param value
     *         The raw value of this token.
     *
     * @return
     *         {@code this} object.
     */
    public Token setValue(String value)
    {
        this.value = value;

        return this;
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

        Token that = (Token)obj;

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
        return (value != null) ? value : "";
    }


    /**
     * Parse the input string as a token.
     *
     * @param input
     *         A string to be parsed as a token.
     *
     * @return
     *         The parsed token.
     *
     * @throws ParseCancellationException
     *         The input string could not be parsed successfully.
     */
    public static Token parse(String input) throws ParseCancellationException
    {
        return new HttpFieldParser().parseToken(input);
    }
}
