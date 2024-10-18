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


import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import com.authlete.http.antlr.AntlrHttpFieldLexer;
import com.authlete.http.antlr.AntlrHttpFieldParser;


class HttpFieldParser
{
    // The pattern representing "obs-fold", which is defined as follows in
    // RFC 9112: HTTP/1.1, Section 5.2. Obsolete Line Folding.
    //
    //   obs-fold = OWS CRLF RWS
    //            ; obsolete line folding
    //
    private static final Pattern PATTERN_OBS_FOLD =
            Pattern.compile("[\\s\\t]*\\r\\n[\\s\\t]+");


    private static Object translate(ParseTree tree)
    {
        HttpFieldParserListener listener = new HttpFieldParserListener();

        // Walk the parsed tree. This may throw a ParseCancellationException.
        ParseTreeWalker.DEFAULT.walk(listener, tree);

        return listener.getResult();
    }


    private static AntlrHttpFieldParser createParser(String input)
    {
        // Create a lexer.
        AntlrHttpFieldLexer lexer = createLexer(input);

        // Prepare a token stream for the parser.
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser.
        AntlrHttpFieldParser parser =
                new AntlrHttpFieldParser(tokens);

        // Set up an error listener.
        parser.removeErrorListeners();
        parser.addErrorListener(HttpFieldErrorListener.INSTANCE);

        return parser;
    }


    private static AntlrHttpFieldLexer createLexer(String input)
    {
        // Create a lexer.
        AntlrHttpFieldLexer lexer =
                new AntlrHttpFieldLexer(CharStreams.fromString(input));

        // Set up an error listener.
        lexer.removeErrorListeners();
        lexer.addErrorListener(HttpFieldErrorListener.INSTANCE);

        return lexer;
    }


    private static String canonicalizeFieldValue(String input)
    {
        if (input == null)
        {
            return null;
        }

        // Remove all leading and trailing spaces.
        input = input.trim();

        // Replace all obs-fold into a single space.
        input = PATTERN_OBS_FOLD.matcher(input).replaceAll(" ");

        return input;
    }


    /**
     * Parse {@code token}.
     */
    public Token parseToken(String input)
    {
        return (Token)translate(createParser(input)
                .tokenWithEOF());
    }


    /**
     * Parse {@code quotedString}.
     */
    public QuotedString parseQuotedString(String input)
    {
        return (QuotedString)translate(createParser(input)
                .quotedStringWithEOF());
    }


    /**
     * Parse {@code forwardedFieldValue}.
     */
    public ForwardedFieldValue parseForwardedFieldValue(String input)
    {
        // Canonicalize the field value.
        input = canonicalizeFieldValue(input);

        return (ForwardedFieldValue)translate(createParser(input)
                .forwardedFieldValueWithEOF());
    }


    /**
     * Parse {@code forwardElement}.
     */
    public ForwardedElement parseForwardedElement(String input)
    {
        return (ForwardedElement)translate(createParser(input)
                .forwardedElementWithEOF());
    }


    /**
     * Parse {@code forwardedPair}.
     */
    public ForwardedPair parseForwardedPair(String input)
    {
        return (ForwardedPair)translate(createParser(input)
                .forwardedPairWithEOF());
    }


    /**
     * Parse {@code forwardedPairName}.
     */
    public Token parseForwardedPairName(String input)
    {
        return (Token)translate(createParser(input)
                .forwardedPairNameWithEOF());
    }


    /**
     * Parse {@code forwardedPairValue}.
     */
    public Object parseForwardedPairValue(String input)
    {
        return translate(createParser(input)
                .forwardedPairValueWithEOF());
    }
}
