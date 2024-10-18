// Generated from com/authlete/http/antlr/AntlrHttpFieldParser.g4 by ANTLR 4.13.2
package com.authlete.http.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AntlrHttpFieldParser}.
 */
public interface AntlrHttpFieldParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(AntlrHttpFieldParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(AntlrHttpFieldParser.TokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#tokenWithEOF}.
	 * @param ctx the parse tree
	 */
	void enterTokenWithEOF(AntlrHttpFieldParser.TokenWithEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#tokenWithEOF}.
	 * @param ctx the parse tree
	 */
	void exitTokenWithEOF(AntlrHttpFieldParser.TokenWithEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#whiteSpace}.
	 * @param ctx the parse tree
	 */
	void enterWhiteSpace(AntlrHttpFieldParser.WhiteSpaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#whiteSpace}.
	 * @param ctx the parse tree
	 */
	void exitWhiteSpace(AntlrHttpFieldParser.WhiteSpaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#quotedString}.
	 * @param ctx the parse tree
	 */
	void enterQuotedString(AntlrHttpFieldParser.QuotedStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#quotedString}.
	 * @param ctx the parse tree
	 */
	void exitQuotedString(AntlrHttpFieldParser.QuotedStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#quotedStringWithEOF}.
	 * @param ctx the parse tree
	 */
	void enterQuotedStringWithEOF(AntlrHttpFieldParser.QuotedStringWithEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#quotedStringWithEOF}.
	 * @param ctx the parse tree
	 */
	void exitQuotedStringWithEOF(AntlrHttpFieldParser.QuotedStringWithEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#quotedStringContent}.
	 * @param ctx the parse tree
	 */
	void enterQuotedStringContent(AntlrHttpFieldParser.QuotedStringContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#quotedStringContent}.
	 * @param ctx the parse tree
	 */
	void exitQuotedStringContent(AntlrHttpFieldParser.QuotedStringContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterForwardedFieldValue(AntlrHttpFieldParser.ForwardedFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitForwardedFieldValue(AntlrHttpFieldParser.ForwardedFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedFieldValueWithEOF}.
	 * @param ctx the parse tree
	 */
	void enterForwardedFieldValueWithEOF(AntlrHttpFieldParser.ForwardedFieldValueWithEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedFieldValueWithEOF}.
	 * @param ctx the parse tree
	 */
	void exitForwardedFieldValueWithEOF(AntlrHttpFieldParser.ForwardedFieldValueWithEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedElement}.
	 * @param ctx the parse tree
	 */
	void enterForwardedElement(AntlrHttpFieldParser.ForwardedElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedElement}.
	 * @param ctx the parse tree
	 */
	void exitForwardedElement(AntlrHttpFieldParser.ForwardedElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedElementWithEOF}.
	 * @param ctx the parse tree
	 */
	void enterForwardedElementWithEOF(AntlrHttpFieldParser.ForwardedElementWithEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedElementWithEOF}.
	 * @param ctx the parse tree
	 */
	void exitForwardedElementWithEOF(AntlrHttpFieldParser.ForwardedElementWithEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedPair}.
	 * @param ctx the parse tree
	 */
	void enterForwardedPair(AntlrHttpFieldParser.ForwardedPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedPair}.
	 * @param ctx the parse tree
	 */
	void exitForwardedPair(AntlrHttpFieldParser.ForwardedPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairWithEOF}.
	 * @param ctx the parse tree
	 */
	void enterForwardedPairWithEOF(AntlrHttpFieldParser.ForwardedPairWithEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairWithEOF}.
	 * @param ctx the parse tree
	 */
	void exitForwardedPairWithEOF(AntlrHttpFieldParser.ForwardedPairWithEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairName}.
	 * @param ctx the parse tree
	 */
	void enterForwardedPairName(AntlrHttpFieldParser.ForwardedPairNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairName}.
	 * @param ctx the parse tree
	 */
	void exitForwardedPairName(AntlrHttpFieldParser.ForwardedPairNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairNameWithEOF}.
	 * @param ctx the parse tree
	 */
	void enterForwardedPairNameWithEOF(AntlrHttpFieldParser.ForwardedPairNameWithEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairNameWithEOF}.
	 * @param ctx the parse tree
	 */
	void exitForwardedPairNameWithEOF(AntlrHttpFieldParser.ForwardedPairNameWithEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairValue}.
	 * @param ctx the parse tree
	 */
	void enterForwardedPairValue(AntlrHttpFieldParser.ForwardedPairValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairValue}.
	 * @param ctx the parse tree
	 */
	void exitForwardedPairValue(AntlrHttpFieldParser.ForwardedPairValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairValueWithEOF}.
	 * @param ctx the parse tree
	 */
	void enterForwardedPairValueWithEOF(AntlrHttpFieldParser.ForwardedPairValueWithEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrHttpFieldParser#forwardedPairValueWithEOF}.
	 * @param ctx the parse tree
	 */
	void exitForwardedPairValueWithEOF(AntlrHttpFieldParser.ForwardedPairValueWithEOFContext ctx);
}