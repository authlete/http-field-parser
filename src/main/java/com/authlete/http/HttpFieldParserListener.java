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


import java.util.ArrayDeque;
import java.util.Deque;
import com.authlete.http.antlr.AntlrHttpFieldParser.ForwardedElementContext;
import com.authlete.http.antlr.AntlrHttpFieldParser.ForwardedFieldValueContext;
import com.authlete.http.antlr.AntlrHttpFieldParser.ForwardedPairContext;
import com.authlete.http.antlr.AntlrHttpFieldParser.QuotedStringContentContext;
import com.authlete.http.antlr.AntlrHttpFieldParser.QuotedStringContext;
import com.authlete.http.antlr.AntlrHttpFieldParser.TokenContext;
import com.authlete.http.antlr.AntlrHttpFieldParserBaseListener;


class HttpFieldParserListener extends AntlrHttpFieldParserBaseListener
{
    private Deque<Object> mStack = new ArrayDeque<>();


    public Object getResult()
    {
        return peek();
    }


    private void push(Object object)
    {
        mStack.addFirst(object);
    }


    private Object pop()
    {
        return mStack.removeFirst();
    }


    private Object peek()
    {
        return mStack.peekFirst();
    }


    @Override
    public void enterForwardedFieldValue(ForwardedFieldValueContext ctx)
    {
        push(new ForwardedFieldValue());
    }


    @Override
    public void exitForwardedFieldValue(ForwardedFieldValueContext ctx)
    {
        Deque<ForwardedElement> elements = new ArrayDeque<>();

        while (!(peek() instanceof ForwardedFieldValue))
        {
            elements.push((ForwardedElement)pop());
        }

        ((ForwardedFieldValue)peek()).addAll(elements);
    }


    @Override
    public void enterForwardedElement(ForwardedElementContext ctx)
    {
        push(new ForwardedElement());
    }


    @Override
    public void exitForwardedElement(ForwardedElementContext ctx)
    {
        Deque<ForwardedPair> pairs = new ArrayDeque<>();

        while (!(peek() instanceof ForwardedElement))
        {
            pairs.push((ForwardedPair)pop());
        }

        ((ForwardedElement)peek()).addAll(pairs);
    }


    @Override
    public void exitForwardedPair(ForwardedPairContext ctx)
    {
        Object value = pop();
        Token  name  = (Token)pop();

        push(new ForwardedPair(name, value));
    }


    @Override
    public void exitToken(TokenContext ctx)
    {
        String value = ctx.getText();

        push(new Token(value));
    }


    @Override
    public void enterQuotedString(QuotedStringContext ctx)
    {
        push(new QuotedString());
    }


    @Override
    public void exitQuotedString(QuotedStringContext ctx)
    {
        QuotedString instance = (QuotedString)peek();

        if (instance.getValue() == null)
        {
            instance.setValue("");
        }
    }


    @Override
    public void exitQuotedStringContent(QuotedStringContentContext ctx)
    {
        String value = ctx.getText();

        ((QuotedString)peek()).setValue(value);
    }
}
