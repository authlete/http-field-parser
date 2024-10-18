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


import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;


/**
 * An error listener for the parser and lexer.
 *
 * @see <a href="https://stackoverflow.com/a/26573239/1174054"
 *      >The accepted answer to the question "Handling errors in ANTLR4"</a>
 */
class HttpFieldErrorListener extends BaseErrorListener
{
    public static final HttpFieldErrorListener INSTANCE = new HttpFieldErrorListener();


    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer, Object offendingSymbol,
            int line, int charPositionInLine, String msg,
            RecognitionException cause) throws ParseCancellationException
    {
        // Construct an error message.
        String message = buildMessage(line, charPositionInLine, msg);

        throw new ParseCancellationException(message, cause);
    }


    private static String buildMessage(int line, int charPositionInLine, String msg)
    {
        return String.format("line %d:%d %s", line, charPositionInLine, msg);
    }
}
