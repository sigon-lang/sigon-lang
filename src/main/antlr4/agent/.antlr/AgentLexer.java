// Generated from /home/valdir/Documents/agent-project/src/main/antlr4/agent/Agent.g4 by ANTLR 4.7
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
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, BELIEFS=20, DESIRES=21, INTENTIONS=22, PLANS=23, LCLETTER=24, 
		UCLETTER=25, DIGIT=26, WS=27, BlockComment=28, LineComment=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "BELIEFS", "DESIRES", "INTENTIONS", "PLANS", "LCLETTER", 
		"UCLETTER", "DIGIT", "WS", "BlockComment", "LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "'prop'", "'fol'", "'_'", "','", "'plan'", 
		"'action'", "'\"'", "'['", "']'", "':-'", "'.'", "'!'", "'not'", "'and'", 
		"'or'", "'.semantic'", "'beliefs'", "'desires'", "'intentions'", "'plans'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "BELIEFS", "DESIRES", 
		"INTENTIONS", "PLANS", "LCLETTER", "UCLETTER", "DIGIT", "WS", "BlockComment", 
		"LineComment"
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
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00c2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\7\35\u00ae\n\35\f\35\16\35\u00b1\13\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00bc\n\36\f\36\16\36\u00bf\13"+
		"\36\3\36\3\36\3\u00af\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37\3\2\7\4\2aac|\3\2C\\\3\2\62;\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\2\u00c3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2"+
		"\2\2\13H\3\2\2\2\rL\3\2\2\2\17N\3\2\2\2\21P\3\2\2\2\23U\3\2\2\2\25\\\3"+
		"\2\2\2\27^\3\2\2\2\31`\3\2\2\2\33b\3\2\2\2\35e\3\2\2\2\37g\3\2\2\2!i\3"+
		"\2\2\2#m\3\2\2\2%q\3\2\2\2\'t\3\2\2\2)~\3\2\2\2+\u0086\3\2\2\2-\u008e"+
		"\3\2\2\2/\u0099\3\2\2\2\61\u009f\3\2\2\2\63\u00a1\3\2\2\2\65\u00a3\3\2"+
		"\2\2\67\u00a5\3\2\2\29\u00a9\3\2\2\2;\u00b7\3\2\2\2=>\7*\2\2>\4\3\2\2"+
		"\2?@\7+\2\2@\6\3\2\2\2AB\7<\2\2B\b\3\2\2\2CD\7r\2\2DE\7t\2\2EF\7q\2\2"+
		"FG\7r\2\2G\n\3\2\2\2HI\7h\2\2IJ\7q\2\2JK\7n\2\2K\f\3\2\2\2LM\7a\2\2M\16"+
		"\3\2\2\2NO\7.\2\2O\20\3\2\2\2PQ\7r\2\2QR\7n\2\2RS\7c\2\2ST\7p\2\2T\22"+
		"\3\2\2\2UV\7c\2\2VW\7e\2\2WX\7v\2\2XY\7k\2\2YZ\7q\2\2Z[\7p\2\2[\24\3\2"+
		"\2\2\\]\7$\2\2]\26\3\2\2\2^_\7]\2\2_\30\3\2\2\2`a\7_\2\2a\32\3\2\2\2b"+
		"c\7<\2\2cd\7/\2\2d\34\3\2\2\2ef\7\60\2\2f\36\3\2\2\2gh\7#\2\2h \3\2\2"+
		"\2ij\7p\2\2jk\7q\2\2kl\7v\2\2l\"\3\2\2\2mn\7c\2\2no\7p\2\2op\7f\2\2p$"+
		"\3\2\2\2qr\7q\2\2rs\7t\2\2s&\3\2\2\2tu\7\60\2\2uv\7u\2\2vw\7g\2\2wx\7"+
		"o\2\2xy\7c\2\2yz\7p\2\2z{\7v\2\2{|\7k\2\2|}\7e\2\2}(\3\2\2\2~\177\7d\2"+
		"\2\177\u0080\7g\2\2\u0080\u0081\7n\2\2\u0081\u0082\7k\2\2\u0082\u0083"+
		"\7g\2\2\u0083\u0084\7h\2\2\u0084\u0085\7u\2\2\u0085*\3\2\2\2\u0086\u0087"+
		"\7f\2\2\u0087\u0088\7g\2\2\u0088\u0089\7u\2\2\u0089\u008a\7k\2\2\u008a"+
		"\u008b\7t\2\2\u008b\u008c\7g\2\2\u008c\u008d\7u\2\2\u008d,\3\2\2\2\u008e"+
		"\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091\7v\2\2\u0091\u0092\7g\2\2"+
		"\u0092\u0093\7p\2\2\u0093\u0094\7v\2\2\u0094\u0095\7k\2\2\u0095\u0096"+
		"\7q\2\2\u0096\u0097\7p\2\2\u0097\u0098\7u\2\2\u0098.\3\2\2\2\u0099\u009a"+
		"\7r\2\2\u009a\u009b\7n\2\2\u009b\u009c\7c\2\2\u009c\u009d\7p\2\2\u009d"+
		"\u009e\7u\2\2\u009e\60\3\2\2\2\u009f\u00a0\t\2\2\2\u00a0\62\3\2\2\2\u00a1"+
		"\u00a2\t\3\2\2\u00a2\64\3\2\2\2\u00a3\u00a4\t\4\2\2\u00a4\66\3\2\2\2\u00a5"+
		"\u00a6\t\5\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\34\2\2\u00a88\3\2\2\2"+
		"\u00a9\u00aa\7\61\2\2\u00aa\u00ab\7,\2\2\u00ab\u00af\3\2\2\2\u00ac\u00ae"+
		"\13\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b0\3\2\2\2"+
		"\u00af\u00ad\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3"+
		"\7,\2\2\u00b3\u00b4\7\61\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\35\2\2"+
		"\u00b6:\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00b9\7\61\2\2\u00b9\u00bd"+
		"\3\2\2\2\u00ba\u00bc\n\6\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c1\b\36\2\2\u00c1<\3\2\2\2\5\2\u00af\u00bd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}