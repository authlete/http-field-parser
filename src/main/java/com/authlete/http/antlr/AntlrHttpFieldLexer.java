// Generated from com/authlete/http/antlr/AntlrHttpFieldLexer.g4 by ANTLR 4.13.2
package com.authlete.http.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AntlrHttpFieldLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=1, SEMICOLON=2, EQUALS=3, TokenCharacterSequence=4, WhiteSpaceCharacterSequence=5, 
		QuotedStringOpen=6, QuotedStringClose=7, QuotedStringContent=8;
	public static final int
		INSIDE_QUOTED_STRING=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE_QUOTED_STRING"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMA", "SEMICOLON", "EQUALS", "TokenCharacterSequence", "TokenCharacter", 
			"WhiteSpaceCharacterSequence", "WhiteSpaceCharacter", "QuotedStringCharacterSequence", 
			"QuotedStringCharacter", "QuotedStringOpen", "QuotedStringClose", "QuotedStringContent"
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


	public AntlrHttpFieldLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AntlrHttpFieldLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\bB\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000\u0007"+
		"\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007"+
		"\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007"+
		"\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n"+
		"\u0007\n\u0002\u000b\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003\"\b\u0003\u000b"+
		"\u0003\f\u0003#\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005)\b\u0005"+
		"\u000b\u0005\f\u0005*\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007"+
		"0\b\u0007\u000b\u0007\f\u00071\u0001\b\u0001\b\u0001\b\u0003\b7\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0000\u0000\f\u0002\u0001\u0004\u0002\u0006\u0003\b\u0004"+
		"\n\u0000\f\u0005\u000e\u0000\u0010\u0000\u0012\u0000\u0014\u0006\u0016"+
		"\u0007\u0018\b\u0002\u0000\u0001\u0004\t\u0000!!#\'*+-.09AZ^z||~~\u0002"+
		"\u0000\t\t  \u0005\u0000\t\t !#[]~\u0080\u00ff\u0003\u0000\t\t ~\u0080"+
		"\u00ff@\u0000\u0002\u0001\u0000\u0000\u0000\u0000\u0004\u0001\u0000\u0000"+
		"\u0000\u0000\u0006\u0001\u0000\u0000\u0000\u0000\b\u0001\u0000\u0000\u0000"+
		"\u0000\f\u0001\u0000\u0000\u0000\u0000\u0014\u0001\u0000\u0000\u0000\u0001"+
		"\u0016\u0001\u0000\u0000\u0000\u0001\u0018\u0001\u0000\u0000\u0000\u0002"+
		"\u001a\u0001\u0000\u0000\u0000\u0004\u001c\u0001\u0000\u0000\u0000\u0006"+
		"\u001e\u0001\u0000\u0000\u0000\b!\u0001\u0000\u0000\u0000\n%\u0001\u0000"+
		"\u0000\u0000\f(\u0001\u0000\u0000\u0000\u000e,\u0001\u0000\u0000\u0000"+
		"\u0010/\u0001\u0000\u0000\u0000\u00126\u0001\u0000\u0000\u0000\u00148"+
		"\u0001\u0000\u0000\u0000\u0016<\u0001\u0000\u0000\u0000\u0018@\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0005,\u0000\u0000\u001b\u0003\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0005;\u0000\u0000\u001d\u0005\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0005=\u0000\u0000\u001f\u0007\u0001\u0000\u0000\u0000 \""+
		"\u0003\n\u0004\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\t\u0001\u0000\u0000"+
		"\u0000%&\u0007\u0000\u0000\u0000&\u000b\u0001\u0000\u0000\u0000\')\u0003"+
		"\u000e\u0006\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000"+
		"*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+\r\u0001\u0000\u0000"+
		"\u0000,-\u0007\u0001\u0000\u0000-\u000f\u0001\u0000\u0000\u0000.0\u0003"+
		"\u0012\b\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0011\u0001\u0000\u0000"+
		"\u000037\u0007\u0002\u0000\u000045\u0005\\\u0000\u000057\u0007\u0003\u0000"+
		"\u000063\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u00007\u0013\u0001"+
		"\u0000\u0000\u000089\u0005\"\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0006"+
		"\t\u0000\u0000;\u0015\u0001\u0000\u0000\u0000<=\u0005\"\u0000\u0000=>"+
		"\u0001\u0000\u0000\u0000>?\u0006\n\u0001\u0000?\u0017\u0001\u0000\u0000"+
		"\u0000@A\u0003\u0010\u0007\u0000A\u0019\u0001\u0000\u0000\u0000\u0006"+
		"\u0000\u0001#*16\u0002\u0005\u0001\u0000\u0004\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}