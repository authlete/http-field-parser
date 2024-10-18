// Generated from com/authlete/http/antlr/AntlrHttpFieldParser.g4 by ANTLR 4.13.2
package com.authlete.http.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AntlrHttpFieldParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=1, SEMICOLON=2, EQUALS=3, TokenCharacterSequence=4, WhiteSpaceCharacterSequence=5, 
		QuotedStringOpen=6, QuotedStringClose=7, QuotedStringContent=8;
	public static final int
		RULE_token = 0, RULE_tokenWithEOF = 1, RULE_whiteSpace = 2, RULE_quotedString = 3, 
		RULE_quotedStringWithEOF = 4, RULE_quotedStringContent = 5, RULE_forwardedFieldValue = 6, 
		RULE_forwardedFieldValueWithEOF = 7, RULE_forwardedElement = 8, RULE_forwardedElementWithEOF = 9, 
		RULE_forwardedPair = 10, RULE_forwardedPairWithEOF = 11, RULE_forwardedPairName = 12, 
		RULE_forwardedPairNameWithEOF = 13, RULE_forwardedPairValue = 14, RULE_forwardedPairValueWithEOF = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"token", "tokenWithEOF", "whiteSpace", "quotedString", "quotedStringWithEOF", 
			"quotedStringContent", "forwardedFieldValue", "forwardedFieldValueWithEOF", 
			"forwardedElement", "forwardedElementWithEOF", "forwardedPair", "forwardedPairWithEOF", 
			"forwardedPairName", "forwardedPairNameWithEOF", "forwardedPairValue", 
			"forwardedPairValueWithEOF"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "';'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMA", "SEMICOLON", "EQUALS", "TokenCharacterSequence", "WhiteSpaceCharacterSequence", 
			"QuotedStringOpen", "QuotedStringClose", "QuotedStringContent"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AntlrHttpFieldParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AntlrHttpFieldParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TokenContext extends ParserRuleContext {
		public TerminalNode TokenCharacterSequence() { return getToken(AntlrHttpFieldParser.TokenCharacterSequence, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitToken(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(TokenCharacterSequence);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TokenWithEOFContext extends ParserRuleContext {
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AntlrHttpFieldParser.EOF, 0); }
		public TokenWithEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenWithEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterTokenWithEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitTokenWithEOF(this);
		}
	}

	public final TokenWithEOFContext tokenWithEOF() throws RecognitionException {
		TokenWithEOFContext _localctx = new TokenWithEOFContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tokenWithEOF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			token();
			setState(35);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhiteSpaceContext extends ParserRuleContext {
		public TerminalNode WhiteSpaceCharacterSequence() { return getToken(AntlrHttpFieldParser.WhiteSpaceCharacterSequence, 0); }
		public WhiteSpaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whiteSpace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterWhiteSpace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitWhiteSpace(this);
		}
	}

	public final WhiteSpaceContext whiteSpace() throws RecognitionException {
		WhiteSpaceContext _localctx = new WhiteSpaceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_whiteSpace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(WhiteSpaceCharacterSequence);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuotedStringContext extends ParserRuleContext {
		public TerminalNode QuotedStringOpen() { return getToken(AntlrHttpFieldParser.QuotedStringOpen, 0); }
		public TerminalNode QuotedStringClose() { return getToken(AntlrHttpFieldParser.QuotedStringClose, 0); }
		public List<QuotedStringContentContext> quotedStringContent() {
			return getRuleContexts(QuotedStringContentContext.class);
		}
		public QuotedStringContentContext quotedStringContent(int i) {
			return getRuleContext(QuotedStringContentContext.class,i);
		}
		public QuotedStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterQuotedString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitQuotedString(this);
		}
	}

	public final QuotedStringContext quotedString() throws RecognitionException {
		QuotedStringContext _localctx = new QuotedStringContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_quotedString);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(QuotedStringOpen);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QuotedStringContent) {
				{
				{
				setState(40);
				quotedStringContent();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(QuotedStringClose);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuotedStringWithEOFContext extends ParserRuleContext {
		public QuotedStringContext quotedString() {
			return getRuleContext(QuotedStringContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AntlrHttpFieldParser.EOF, 0); }
		public QuotedStringWithEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedStringWithEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterQuotedStringWithEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitQuotedStringWithEOF(this);
		}
	}

	public final QuotedStringWithEOFContext quotedStringWithEOF() throws RecognitionException {
		QuotedStringWithEOFContext _localctx = new QuotedStringWithEOFContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quotedStringWithEOF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			quotedString();
			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuotedStringContentContext extends ParserRuleContext {
		public TerminalNode QuotedStringContent() { return getToken(AntlrHttpFieldParser.QuotedStringContent, 0); }
		public QuotedStringContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedStringContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterQuotedStringContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitQuotedStringContent(this);
		}
	}

	public final QuotedStringContentContext quotedStringContent() throws RecognitionException {
		QuotedStringContentContext _localctx = new QuotedStringContentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_quotedStringContent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(QuotedStringContent);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedFieldValueContext extends ParserRuleContext {
		public List<ForwardedElementContext> forwardedElement() {
			return getRuleContexts(ForwardedElementContext.class);
		}
		public ForwardedElementContext forwardedElement(int i) {
			return getRuleContext(ForwardedElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AntlrHttpFieldParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AntlrHttpFieldParser.COMMA, i);
		}
		public List<WhiteSpaceContext> whiteSpace() {
			return getRuleContexts(WhiteSpaceContext.class);
		}
		public WhiteSpaceContext whiteSpace(int i) {
			return getRuleContext(WhiteSpaceContext.class,i);
		}
		public ForwardedFieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedFieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedFieldValue(this);
		}
	}

	public final ForwardedFieldValueContext forwardedFieldValue() throws RecognitionException {
		ForwardedFieldValueContext _localctx = new ForwardedFieldValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forwardedFieldValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			forwardedElement();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==WhiteSpaceCharacterSequence) {
				{
				{
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WhiteSpaceCharacterSequence) {
					{
					{
					setState(54);
					whiteSpace();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				match(COMMA);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WhiteSpaceCharacterSequence) {
					{
					{
					setState(61);
					whiteSpace();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67);
				forwardedElement();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedFieldValueWithEOFContext extends ParserRuleContext {
		public ForwardedFieldValueContext forwardedFieldValue() {
			return getRuleContext(ForwardedFieldValueContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AntlrHttpFieldParser.EOF, 0); }
		public ForwardedFieldValueWithEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedFieldValueWithEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedFieldValueWithEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedFieldValueWithEOF(this);
		}
	}

	public final ForwardedFieldValueWithEOFContext forwardedFieldValueWithEOF() throws RecognitionException {
		ForwardedFieldValueWithEOFContext _localctx = new ForwardedFieldValueWithEOFContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forwardedFieldValueWithEOF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			forwardedFieldValue();
			setState(74);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedElementContext extends ParserRuleContext {
		public List<ForwardedPairContext> forwardedPair() {
			return getRuleContexts(ForwardedPairContext.class);
		}
		public ForwardedPairContext forwardedPair(int i) {
			return getRuleContext(ForwardedPairContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(AntlrHttpFieldParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(AntlrHttpFieldParser.SEMICOLON, i);
		}
		public List<WhiteSpaceContext> whiteSpace() {
			return getRuleContexts(WhiteSpaceContext.class);
		}
		public WhiteSpaceContext whiteSpace(int i) {
			return getRuleContext(WhiteSpaceContext.class,i);
		}
		public ForwardedElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedElement(this);
		}
	}

	public final ForwardedElementContext forwardedElement() throws RecognitionException {
		ForwardedElementContext _localctx = new ForwardedElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forwardedElement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			forwardedPair();
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WhiteSpaceCharacterSequence) {
						{
						{
						setState(77);
						whiteSpace();
						}
						}
						setState(82);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(83);
					match(SEMICOLON);
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WhiteSpaceCharacterSequence) {
						{
						{
						setState(84);
						whiteSpace();
						}
						}
						setState(89);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(90);
					forwardedPair();
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedElementWithEOFContext extends ParserRuleContext {
		public ForwardedElementContext forwardedElement() {
			return getRuleContext(ForwardedElementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AntlrHttpFieldParser.EOF, 0); }
		public ForwardedElementWithEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedElementWithEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedElementWithEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedElementWithEOF(this);
		}
	}

	public final ForwardedElementWithEOFContext forwardedElementWithEOF() throws RecognitionException {
		ForwardedElementWithEOFContext _localctx = new ForwardedElementWithEOFContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forwardedElementWithEOF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			forwardedElement();
			setState(97);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedPairContext extends ParserRuleContext {
		public ForwardedPairNameContext forwardedPairName() {
			return getRuleContext(ForwardedPairNameContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(AntlrHttpFieldParser.EQUALS, 0); }
		public ForwardedPairValueContext forwardedPairValue() {
			return getRuleContext(ForwardedPairValueContext.class,0);
		}
		public List<WhiteSpaceContext> whiteSpace() {
			return getRuleContexts(WhiteSpaceContext.class);
		}
		public WhiteSpaceContext whiteSpace(int i) {
			return getRuleContext(WhiteSpaceContext.class,i);
		}
		public ForwardedPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedPair(this);
		}
	}

	public final ForwardedPairContext forwardedPair() throws RecognitionException {
		ForwardedPairContext _localctx = new ForwardedPairContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forwardedPair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			forwardedPairName();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WhiteSpaceCharacterSequence) {
				{
				{
				setState(100);
				whiteSpace();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			match(EQUALS);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WhiteSpaceCharacterSequence) {
				{
				{
				setState(107);
				whiteSpace();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			forwardedPairValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedPairWithEOFContext extends ParserRuleContext {
		public ForwardedPairContext forwardedPair() {
			return getRuleContext(ForwardedPairContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AntlrHttpFieldParser.EOF, 0); }
		public ForwardedPairWithEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedPairWithEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedPairWithEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedPairWithEOF(this);
		}
	}

	public final ForwardedPairWithEOFContext forwardedPairWithEOF() throws RecognitionException {
		ForwardedPairWithEOFContext _localctx = new ForwardedPairWithEOFContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forwardedPairWithEOF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			forwardedPair();
			setState(116);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedPairNameContext extends ParserRuleContext {
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public ForwardedPairNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedPairName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedPairName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedPairName(this);
		}
	}

	public final ForwardedPairNameContext forwardedPairName() throws RecognitionException {
		ForwardedPairNameContext _localctx = new ForwardedPairNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forwardedPairName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			token();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedPairNameWithEOFContext extends ParserRuleContext {
		public ForwardedPairNameContext forwardedPairName() {
			return getRuleContext(ForwardedPairNameContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AntlrHttpFieldParser.EOF, 0); }
		public ForwardedPairNameWithEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedPairNameWithEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedPairNameWithEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedPairNameWithEOF(this);
		}
	}

	public final ForwardedPairNameWithEOFContext forwardedPairNameWithEOF() throws RecognitionException {
		ForwardedPairNameWithEOFContext _localctx = new ForwardedPairNameWithEOFContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forwardedPairNameWithEOF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			forwardedPairName();
			setState(121);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedPairValueContext extends ParserRuleContext {
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public QuotedStringContext quotedString() {
			return getRuleContext(QuotedStringContext.class,0);
		}
		public ForwardedPairValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedPairValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedPairValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedPairValue(this);
		}
	}

	public final ForwardedPairValueContext forwardedPairValue() throws RecognitionException {
		ForwardedPairValueContext _localctx = new ForwardedPairValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forwardedPairValue);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TokenCharacterSequence:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				token();
				}
				break;
			case QuotedStringOpen:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				quotedString();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForwardedPairValueWithEOFContext extends ParserRuleContext {
		public ForwardedPairValueContext forwardedPairValue() {
			return getRuleContext(ForwardedPairValueContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AntlrHttpFieldParser.EOF, 0); }
		public ForwardedPairValueWithEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardedPairValueWithEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).enterForwardedPairValueWithEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrHttpFieldParserListener ) ((AntlrHttpFieldParserListener)listener).exitForwardedPairValueWithEOF(this);
		}
	}

	public final ForwardedPairValueWithEOFContext forwardedPairValueWithEOF() throws RecognitionException {
		ForwardedPairValueWithEOFContext _localctx = new ForwardedPairValueWithEOFContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forwardedPairValueWithEOF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			forwardedPairValue();
			setState(128);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\b\u0083\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003*\b\u0003\n\u0003\f\u0003"+
		"-\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0005\u00068\b\u0006"+
		"\n\u0006\f\u0006;\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006?\b\u0006"+
		"\n\u0006\f\u0006B\t\u0006\u0001\u0006\u0005\u0006E\b\u0006\n\u0006\f\u0006"+
		"H\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b"+
		"O\b\b\n\b\f\bR\t\b\u0001\b\u0001\b\u0005\bV\b\b\n\b\f\bY\t\b\u0001\b\u0005"+
		"\b\\\b\b\n\b\f\b_\t\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\n"+
		"f\b\n\n\n\f\ni\t\n\u0001\n\u0001\n\u0005\nm\b\n\n\n\f\np\t\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e~\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0000"+
		"|\u0000 \u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u0004"+
		"%\u0001\u0000\u0000\u0000\u0006\'\u0001\u0000\u0000\u0000\b0\u0001\u0000"+
		"\u0000\u0000\n3\u0001\u0000\u0000\u0000\f5\u0001\u0000\u0000\u0000\u000e"+
		"I\u0001\u0000\u0000\u0000\u0010L\u0001\u0000\u0000\u0000\u0012`\u0001"+
		"\u0000\u0000\u0000\u0014c\u0001\u0000\u0000\u0000\u0016s\u0001\u0000\u0000"+
		"\u0000\u0018v\u0001\u0000\u0000\u0000\u001ax\u0001\u0000\u0000\u0000\u001c"+
		"}\u0001\u0000\u0000\u0000\u001e\u007f\u0001\u0000\u0000\u0000 !\u0005"+
		"\u0004\u0000\u0000!\u0001\u0001\u0000\u0000\u0000\"#\u0003\u0000\u0000"+
		"\u0000#$\u0005\u0000\u0000\u0001$\u0003\u0001\u0000\u0000\u0000%&\u0005"+
		"\u0005\u0000\u0000&\u0005\u0001\u0000\u0000\u0000\'+\u0005\u0006\u0000"+
		"\u0000(*\u0003\n\u0005\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000"+
		"\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0005\u0007\u0000\u0000/\u0007"+
		"\u0001\u0000\u0000\u000001\u0003\u0006\u0003\u000012\u0005\u0000\u0000"+
		"\u00012\t\u0001\u0000\u0000\u000034\u0005\b\u0000\u00004\u000b\u0001\u0000"+
		"\u0000\u00005F\u0003\u0010\b\u000068\u0003\u0004\u0002\u000076\u0001\u0000"+
		"\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		"<@\u0005\u0001\u0000\u0000=?\u0003\u0004\u0002\u0000>=\u0001\u0000\u0000"+
		"\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000"+
		"\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CE\u0003"+
		"\u0010\b\u0000D9\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001"+
		"\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\r\u0001\u0000\u0000\u0000"+
		"HF\u0001\u0000\u0000\u0000IJ\u0003\f\u0006\u0000JK\u0005\u0000\u0000\u0001"+
		"K\u000f\u0001\u0000\u0000\u0000L]\u0003\u0014\n\u0000MO\u0003\u0004\u0002"+
		"\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000SW\u0005\u0002\u0000\u0000TV\u0003\u0004\u0002\u0000"+
		"UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000Z\\\u0003\u0014\n\u0000[P\u0001\u0000\u0000\u0000\\_\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000"+
		"^\u0011\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0003\u0010"+
		"\b\u0000ab\u0005\u0000\u0000\u0001b\u0013\u0001\u0000\u0000\u0000cg\u0003"+
		"\u0018\f\u0000df\u0003\u0004\u0002\u0000ed\u0001\u0000\u0000\u0000fi\u0001"+
		"\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hj\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jn\u0005\u0003\u0000"+
		"\u0000km\u0003\u0004\u0002\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0003\u001c\u000e\u0000"+
		"r\u0015\u0001\u0000\u0000\u0000st\u0003\u0014\n\u0000tu\u0005\u0000\u0000"+
		"\u0001u\u0017\u0001\u0000\u0000\u0000vw\u0003\u0000\u0000\u0000w\u0019"+
		"\u0001\u0000\u0000\u0000xy\u0003\u0018\f\u0000yz\u0005\u0000\u0000\u0001"+
		"z\u001b\u0001\u0000\u0000\u0000{~\u0003\u0000\u0000\u0000|~\u0003\u0006"+
		"\u0003\u0000}{\u0001\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000~\u001d"+
		"\u0001\u0000\u0000\u0000\u007f\u0080\u0003\u001c\u000e\u0000\u0080\u0081"+
		"\u0005\u0000\u0000\u0001\u0081\u001f\u0001\u0000\u0000\u0000\n+9@FPW]"+
		"gn}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}