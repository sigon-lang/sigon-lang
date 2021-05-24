// Generated from /home/rr/repositorios/sigon/sigon-lang/src/main/antlr4/agent/Agent.g4 by ANTLR 4.8
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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, CUSTOMNAME=30, NUMERAL=31, 
		CONSTANT=32, VARIABLE=33, AND=34, OR=35, LeftParen=36, RightParen=37, 
		STRING=38, WS=39, BlockComment=40, LineComment=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "CUSTOMNAME", "NUMERAL", "CONSTANT", 
			"VARIABLE", "AND", "OR", "LeftParen", "RightParen", "STRING", "ALPHA", 
			"CHARACTER", "LCLETTER", "UCLETTER", "DIGIT", "WS", "BlockComment", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':-'", "'.'", "':'", "'communication'", "'planner'", "'beliefs'", 
			"'desires'", "'intentions'", "'plan'", "','", "'_'", "'action'", "'sensor'", 
			"'actuator'", "'+'", "'-'", "'+!'", "'-!'", "'['", "']'", "'!'", "'<'", 
			"'=<'", "'>'", "'>='", "'not '", "'~'", "'->0.'", "'0.'", null, null, 
			null, null, "'&'", "'|'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "CUSTOMNAME", "NUMERAL", "CONSTANT", 
			"VARIABLE", "AND", "OR", "LeftParen", "RightParen", "STRING", "WS", "BlockComment", 
			"LineComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0138\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u00e4\n\37"+
		"\f\37\16\37\u00e7\13\37\3 \6 \u00ea\n \r \16 \u00eb\3!\3!\7!\u00f0\n!"+
		"\f!\16!\u00f3\13!\3\"\3\"\7\"\u00f7\n\"\f\"\16\"\u00fa\13\"\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\7\'\u0106\n\'\f\'\16\'\u0109\13\'\3\'\3\'\3(\3("+
		"\5(\u010f\n(\3)\3)\3)\5)\u0114\n)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\3.\3."+
		"\3.\3.\7.\u0124\n.\f.\16.\u0127\13.\3.\3.\3.\3.\3.\3/\3/\3/\3/\7/\u0132"+
		"\n/\f/\16/\u0135\13/\3/\3/\3\u0125\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O\2Q\2S\2"+
		"U\2W\2Y)[*]+\3\2\b\6\2\f\f\17\17$$^^\4\2aac|\3\2C\\\3\2\62;\5\2\13\f\17"+
		"\17\"\"\4\2\f\f\17\17\2\u013c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5b\3\2\2\2\7d\3\2\2\2\tf\3\2\2"+
		"\2\13t\3\2\2\2\r|\3\2\2\2\17\u0084\3\2\2\2\21\u008c\3\2\2\2\23\u0097\3"+
		"\2\2\2\25\u009c\3\2\2\2\27\u009e\3\2\2\2\31\u00a0\3\2\2\2\33\u00a7\3\2"+
		"\2\2\35\u00ae\3\2\2\2\37\u00b7\3\2\2\2!\u00b9\3\2\2\2#\u00bb\3\2\2\2%"+
		"\u00be\3\2\2\2\'\u00c1\3\2\2\2)\u00c3\3\2\2\2+\u00c5\3\2\2\2-\u00c7\3"+
		"\2\2\2/\u00c9\3\2\2\2\61\u00cc\3\2\2\2\63\u00ce\3\2\2\2\65\u00d1\3\2\2"+
		"\2\67\u00d6\3\2\2\29\u00d8\3\2\2\2;\u00dd\3\2\2\2=\u00e0\3\2\2\2?\u00e9"+
		"\3\2\2\2A\u00ed\3\2\2\2C\u00f4\3\2\2\2E\u00fb\3\2\2\2G\u00fd\3\2\2\2I"+
		"\u00ff\3\2\2\2K\u0101\3\2\2\2M\u0103\3\2\2\2O\u010e\3\2\2\2Q\u0113\3\2"+
		"\2\2S\u0115\3\2\2\2U\u0117\3\2\2\2W\u0119\3\2\2\2Y\u011b\3\2\2\2[\u011f"+
		"\3\2\2\2]\u012d\3\2\2\2_`\7<\2\2`a\7/\2\2a\4\3\2\2\2bc\7\60\2\2c\6\3\2"+
		"\2\2de\7<\2\2e\b\3\2\2\2fg\7e\2\2gh\7q\2\2hi\7o\2\2ij\7o\2\2jk\7w\2\2"+
		"kl\7p\2\2lm\7k\2\2mn\7e\2\2no\7c\2\2op\7v\2\2pq\7k\2\2qr\7q\2\2rs\7p\2"+
		"\2s\n\3\2\2\2tu\7r\2\2uv\7n\2\2vw\7c\2\2wx\7p\2\2xy\7p\2\2yz\7g\2\2z{"+
		"\7t\2\2{\f\3\2\2\2|}\7d\2\2}~\7g\2\2~\177\7n\2\2\177\u0080\7k\2\2\u0080"+
		"\u0081\7g\2\2\u0081\u0082\7h\2\2\u0082\u0083\7u\2\2\u0083\16\3\2\2\2\u0084"+
		"\u0085\7f\2\2\u0085\u0086\7g\2\2\u0086\u0087\7u\2\2\u0087\u0088\7k\2\2"+
		"\u0088\u0089\7t\2\2\u0089\u008a\7g\2\2\u008a\u008b\7u\2\2\u008b\20\3\2"+
		"\2\2\u008c\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7v\2\2\u008f\u0090"+
		"\7g\2\2\u0090\u0091\7p\2\2\u0091\u0092\7v\2\2\u0092\u0093\7k\2\2\u0093"+
		"\u0094\7q\2\2\u0094\u0095\7p\2\2\u0095\u0096\7u\2\2\u0096\22\3\2\2\2\u0097"+
		"\u0098\7r\2\2\u0098\u0099\7n\2\2\u0099\u009a\7c\2\2\u009a\u009b\7p\2\2"+
		"\u009b\24\3\2\2\2\u009c\u009d\7.\2\2\u009d\26\3\2\2\2\u009e\u009f\7a\2"+
		"\2\u009f\30\3\2\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7e\2\2\u00a2\u00a3"+
		"\7v\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7p\2\2\u00a6"+
		"\32\3\2\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7p\2\2\u00aa"+
		"\u00ab\7u\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7t\2\2\u00ad\34\3\2\2\2\u00ae"+
		"\u00af\7c\2\2\u00af\u00b0\7e\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7w\2\2"+
		"\u00b2\u00b3\7c\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6"+
		"\7t\2\2\u00b6\36\3\2\2\2\u00b7\u00b8\7-\2\2\u00b8 \3\2\2\2\u00b9\u00ba"+
		"\7/\2\2\u00ba\"\3\2\2\2\u00bb\u00bc\7-\2\2\u00bc\u00bd\7#\2\2\u00bd$\3"+
		"\2\2\2\u00be\u00bf\7/\2\2\u00bf\u00c0\7#\2\2\u00c0&\3\2\2\2\u00c1\u00c2"+
		"\7]\2\2\u00c2(\3\2\2\2\u00c3\u00c4\7_\2\2\u00c4*\3\2\2\2\u00c5\u00c6\7"+
		"#\2\2\u00c6,\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8.\3\2\2\2\u00c9\u00ca\7?"+
		"\2\2\u00ca\u00cb\7>\2\2\u00cb\60\3\2\2\2\u00cc\u00cd\7@\2\2\u00cd\62\3"+
		"\2\2\2\u00ce\u00cf\7@\2\2\u00cf\u00d0\7?\2\2\u00d0\64\3\2\2\2\u00d1\u00d2"+
		"\7p\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7\"\2\2\u00d5"+
		"\66\3\2\2\2\u00d6\u00d7\7\u0080\2\2\u00d78\3\2\2\2\u00d8\u00d9\7/\2\2"+
		"\u00d9\u00da\7@\2\2\u00da\u00db\7\62\2\2\u00db\u00dc\7\60\2\2\u00dc:\3"+
		"\2\2\2\u00dd\u00de\7\62\2\2\u00de\u00df\7\60\2\2\u00df<\3\2\2\2\u00e0"+
		"\u00e1\7a\2\2\u00e1\u00e5\5O(\2\u00e2\u00e4\5Q)\2\u00e3\u00e2\3\2\2\2"+
		"\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6>\3"+
		"\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ea\5W,\2\u00e9\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec@\3\2\2\2"+
		"\u00ed\u00f1\5S*\2\u00ee\u00f0\5Q)\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3"+
		"\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2B\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f4\u00f8\5U+\2\u00f5\u00f7\5Q)\2\u00f6\u00f5\3\2\2\2\u00f7"+
		"\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9D\3\2\2\2"+
		"\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7(\2\2\u00fcF\3\2\2\2\u00fd\u00fe\7~"+
		"\2\2\u00feH\3\2\2\2\u00ff\u0100\7*\2\2\u0100J\3\2\2\2\u0101\u0102\7+\2"+
		"\2\u0102L\3\2\2\2\u0103\u0107\7$\2\2\u0104\u0106\n\2\2\2\u0105\u0104\3"+
		"\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7$\2\2\u010bN\3\2\2\2\u010c"+
		"\u010f\5S*\2\u010d\u010f\5U+\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2"+
		"\u010fP\3\2\2\2\u0110\u0114\5S*\2\u0111\u0114\5U+\2\u0112\u0114\5W,\2"+
		"\u0113\u0110\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0112\3\2\2\2\u0114R\3"+
		"\2\2\2\u0115\u0116\t\3\2\2\u0116T\3\2\2\2\u0117\u0118\t\4\2\2\u0118V\3"+
		"\2\2\2\u0119\u011a\t\5\2\2\u011aX\3\2\2\2\u011b\u011c\t\6\2\2\u011c\u011d"+
		"\3\2\2\2\u011d\u011e\b-\2\2\u011eZ\3\2\2\2\u011f\u0120\7\61\2\2\u0120"+
		"\u0121\7,\2\2\u0121\u0125\3\2\2\2\u0122\u0124\13\2\2\2\u0123\u0122\3\2"+
		"\2\2\u0124\u0127\3\2\2\2\u0125\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126"+
		"\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\7,\2\2\u0129\u012a\7\61"+
		"\2\2\u012a\u012b\3\2\2\2\u012b\u012c\b.\2\2\u012c\\\3\2\2\2\u012d\u012e"+
		"\7\61\2\2\u012e\u012f\7\61\2\2\u012f\u0133\3\2\2\2\u0130\u0132\n\7\2\2"+
		"\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\b/\2\2\u0137"+
		"^\3\2\2\2\f\2\u00e5\u00eb\u00f1\u00f8\u0107\u010e\u0113\u0125\u0133\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}