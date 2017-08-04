// Generated from Agent.g4 by ANTLR 4.5
package br.ufsc.ine.agent_project;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AgentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		BELIEFS=18, DESIRES=19, INTENTIONS=20, PLANS=21, LCLETTER=22, UCLETTER=23, 
		DIGIT=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"BELIEFS", "DESIRES", "INTENTIONS", "PLANS", "LCLETTER", "UCLETTER", "DIGIT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "'_'", "'prop'", "'fol'", "'plan'", "','", 
		"'action'", "'['", "']'", "':-'", "'.'", "'!'", "'not'", "'and'", "'or'", 
		"'beliefs'", "'desires'", "'intentions'", "'plans'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "BELIEFS", "DESIRES", "INTENTIONS", 
		"PLANS", "LCLETTER", "UCLETTER", "DIGIT", "WS"
	};
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


	public AgentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Agent.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u0095\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\3\2\6\4\2aac|\3\2C\\\3\2\62;\5\2\13\f\17"+
		"\17\"\"\u0094\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\79\3"+
		"\2\2\2\t;\3\2\2\2\13=\3\2\2\2\rB\3\2\2\2\17F\3\2\2\2\21K\3\2\2\2\23M\3"+
		"\2\2\2\25T\3\2\2\2\27V\3\2\2\2\31X\3\2\2\2\33[\3\2\2\2\35]\3\2\2\2\37"+
		"_\3\2\2\2!c\3\2\2\2#g\3\2\2\2%j\3\2\2\2\'r\3\2\2\2)z\3\2\2\2+\u0085\3"+
		"\2\2\2-\u008b\3\2\2\2/\u008d\3\2\2\2\61\u008f\3\2\2\2\63\u0091\3\2\2\2"+
		"\65\66\7*\2\2\66\4\3\2\2\2\678\7+\2\28\6\3\2\2\29:\7<\2\2:\b\3\2\2\2;"+
		"<\7a\2\2<\n\3\2\2\2=>\7r\2\2>?\7t\2\2?@\7q\2\2@A\7r\2\2A\f\3\2\2\2BC\7"+
		"h\2\2CD\7q\2\2DE\7n\2\2E\16\3\2\2\2FG\7r\2\2GH\7n\2\2HI\7c\2\2IJ\7p\2"+
		"\2J\20\3\2\2\2KL\7.\2\2L\22\3\2\2\2MN\7c\2\2NO\7e\2\2OP\7v\2\2PQ\7k\2"+
		"\2QR\7q\2\2RS\7p\2\2S\24\3\2\2\2TU\7]\2\2U\26\3\2\2\2VW\7_\2\2W\30\3\2"+
		"\2\2XY\7<\2\2YZ\7/\2\2Z\32\3\2\2\2[\\\7\60\2\2\\\34\3\2\2\2]^\7#\2\2^"+
		"\36\3\2\2\2_`\7p\2\2`a\7q\2\2ab\7v\2\2b \3\2\2\2cd\7c\2\2de\7p\2\2ef\7"+
		"f\2\2f\"\3\2\2\2gh\7q\2\2hi\7t\2\2i$\3\2\2\2jk\7d\2\2kl\7g\2\2lm\7n\2"+
		"\2mn\7k\2\2no\7g\2\2op\7h\2\2pq\7u\2\2q&\3\2\2\2rs\7f\2\2st\7g\2\2tu\7"+
		"u\2\2uv\7k\2\2vw\7t\2\2wx\7g\2\2xy\7u\2\2y(\3\2\2\2z{\7k\2\2{|\7p\2\2"+
		"|}\7v\2\2}~\7g\2\2~\177\7p\2\2\177\u0080\7v\2\2\u0080\u0081\7k\2\2\u0081"+
		"\u0082\7q\2\2\u0082\u0083\7p\2\2\u0083\u0084\7u\2\2\u0084*\3\2\2\2\u0085"+
		"\u0086\7r\2\2\u0086\u0087\7n\2\2\u0087\u0088\7c\2\2\u0088\u0089\7p\2\2"+
		"\u0089\u008a\7u\2\2\u008a,\3\2\2\2\u008b\u008c\t\2\2\2\u008c.\3\2\2\2"+
		"\u008d\u008e\t\3\2\2\u008e\60\3\2\2\2\u008f\u0090\t\4\2\2\u0090\62\3\2"+
		"\2\2\u0091\u0092\t\5\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\32\2\2\u0094"+
		"\64\3\2\2\2\3\2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}