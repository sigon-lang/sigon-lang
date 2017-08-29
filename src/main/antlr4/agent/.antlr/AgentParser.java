// Generated from /home/valdir/Documents/agent-project/src/main/antlr4/agent/Agent.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AgentParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, BELIEFS=20, DESIRES=21, INTENTIONS=22, PLANS=23, LCLETTER=24, 
		UCLETTER=25, DIGIT=26, WS=27, BlockComment=28, LineComment=29;
	public static final int
		RULE_agent = 0, RULE_context = 1, RULE_param = 2, RULE_contextName = 3, 
		RULE_primitiveContextName = 4, RULE_customContextName = 5, RULE_type = 6, 
		RULE_customType = 7, RULE_plan = 8, RULE_action = 9, RULE_functionInvocation = 10, 
		RULE_functionName = 11, RULE_argumentList = 12, RULE_expression = 13, 
		RULE_compoundaction = 14, RULE_listOfClauses = 15, RULE_formulas = 16, 
		RULE_propFormula = 17, RULE_folFormula = 18, RULE_plansFormulas = 19, 
		RULE_bridgeRule = 20, RULE_head = 21, RULE_body = 22, RULE_propClause = 23, 
		RULE_folClause = 24, RULE_propLogExpr = 25, RULE_folLogExpr = 26, RULE_character = 27, 
		RULE_semanticRules = 28;
	public static final String[] ruleNames = {
		"agent", "context", "param", "contextName", "primitiveContextName", "customContextName", 
		"type", "customType", "plan", "action", "functionInvocation", "functionName", 
		"argumentList", "expression", "compoundaction", "listOfClauses", "formulas", 
		"propFormula", "folFormula", "plansFormulas", "bridgeRule", "head", "body", 
		"propClause", "folClause", "propLogExpr", "folLogExpr", "character", "semanticRules"
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

	@Override
	public String getGrammarFileName() { return "Agent.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AgentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AgentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(AgentParser.EOF, 0); }
		public List<ContextContext> context() {
			return getRuleContexts(ContextContext.class);
		}
		public ContextContext context(int i) {
			return getRuleContext(ContextContext.class,i);
		}
		public List<BridgeRuleContext> bridgeRule() {
			return getRuleContexts(BridgeRuleContext.class);
		}
		public BridgeRuleContext bridgeRule(int i) {
			return getRuleContext(BridgeRuleContext.class,i);
		}
		public AgentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agent; }
	}

	public final AgentContext agent() throws RecognitionException {
		AgentContext _localctx = new AgentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_agent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__14) | (1L << BELIEFS) | (1L << DESIRES) | (1L << INTENTIONS) | (1L << PLANS))) != 0)) {
				{
				setState(60);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
				case BELIEFS:
				case DESIRES:
				case INTENTIONS:
				case PLANS:
					{
					setState(58);
					context();
					}
					break;
				case T__14:
					{
					setState(59);
					bridgeRule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
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

	public static class ContextContext extends ParserRuleContext {
		public ContextNameContext contextName() {
			return getRuleContext(ContextNameContext.class,0);
		}
		public FormulasContext formulas() {
			return getRuleContext(FormulasContext.class,0);
		}
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode PLANS() { return getToken(AgentParser.PLANS, 0); }
		public PlansFormulasContext plansFormulas() {
			return getRuleContext(PlansFormulasContext.class,0);
		}
		public ContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context; }
	}

	public final ContextContext context() throws RecognitionException {
		ContextContext _localctx = new ContextContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_context);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case BELIEFS:
			case DESIRES:
			case INTENTIONS:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				contextName();
				setState(68);
				match(T__0);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
					{
					setState(69);
					param();
					}
				}

				setState(72);
				match(T__1);
				setState(73);
				match(T__2);
				setState(74);
				formulas();
				}
				break;
			case PLANS:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(PLANS);
				setState(77);
				match(T__0);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3 || _la==T__4) {
					{
					setState(78);
					_la = _input.LA(1);
					if ( !(_la==T__3 || _la==T__4) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(81);
				match(T__1);
				setState(82);
				match(T__2);
				setState(83);
				plansFormulas();
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

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			type();
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

	public static class ContextNameContext extends ParserRuleContext {
		public PrimitiveContextNameContext primitiveContextName() {
			return getRuleContext(PrimitiveContextNameContext.class,0);
		}
		public CustomContextNameContext customContextName() {
			return getRuleContext(CustomContextNameContext.class,0);
		}
		public ContextNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextName; }
	}

	public final ContextNameContext contextName() throws RecognitionException {
		ContextNameContext _localctx = new ContextNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_contextName);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEFS:
			case DESIRES:
			case INTENTIONS:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				primitiveContextName();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				customContextName();
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

	public static class PrimitiveContextNameContext extends ParserRuleContext {
		public TerminalNode BELIEFS() { return getToken(AgentParser.BELIEFS, 0); }
		public TerminalNode DESIRES() { return getToken(AgentParser.DESIRES, 0); }
		public TerminalNode INTENTIONS() { return getToken(AgentParser.INTENTIONS, 0); }
		public PrimitiveContextNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveContextName; }
	}

	public final PrimitiveContextNameContext primitiveContextName() throws RecognitionException {
		PrimitiveContextNameContext _localctx = new PrimitiveContextNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primitiveContextName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BELIEFS) | (1L << DESIRES) | (1L << INTENTIONS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class CustomContextNameContext extends ParserRuleContext {
		public List<CharacterContext> character() {
			return getRuleContexts(CharacterContext.class);
		}
		public CharacterContext character(int i) {
			return getRuleContext(CharacterContext.class,i);
		}
		public List<TerminalNode> LCLETTER() { return getTokens(AgentParser.LCLETTER); }
		public TerminalNode LCLETTER(int i) {
			return getToken(AgentParser.LCLETTER, i);
		}
		public List<TerminalNode> UCLETTER() { return getTokens(AgentParser.UCLETTER); }
		public TerminalNode UCLETTER(int i) {
			return getToken(AgentParser.UCLETTER, i);
		}
		public CustomContextNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customContextName; }
	}

	public final CustomContextNameContext customContextName() throws RecognitionException {
		CustomContextNameContext _localctx = new CustomContextNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_customContextName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__5);
			setState(96); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(95);
					_la = _input.LA(1);
					if ( !(_la==LCLETTER || _la==UCLETTER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(98); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
				{
				{
				setState(100);
				character();
				}
				}
				setState(105);
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

	public static class TypeContext extends ParserRuleContext {
		public CustomTypeContext customType() {
			return getRuleContext(CustomTypeContext.class,0);
		}
		public SemanticRulesContext semanticRules() {
			return getRuleContext(SemanticRulesContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(T__4);
				}
				break;
			case LCLETTER:
			case UCLETTER:
			case DIGIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				customType();
				{
				setState(109);
				match(T__6);
				setState(110);
				semanticRules();
				}
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

	public static class CustomTypeContext extends ParserRuleContext {
		public List<CharacterContext> character() {
			return getRuleContexts(CharacterContext.class);
		}
		public CharacterContext character(int i) {
			return getRuleContext(CharacterContext.class,i);
		}
		public CustomTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customType; }
	}

	public final CustomTypeContext customType() throws RecognitionException {
		CustomTypeContext _localctx = new CustomTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_customType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				character();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0) );
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

	public static class PlanContext extends ParserRuleContext {
		public List<ListOfClausesContext> listOfClauses() {
			return getRuleContexts(ListOfClausesContext.class);
		}
		public ListOfClausesContext listOfClauses(int i) {
			return getRuleContext(ListOfClausesContext.class,i);
		}
		public CompoundactionContext compoundaction() {
			return getRuleContext(CompoundactionContext.class,0);
		}
		public PlanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plan; }
	}

	public final PlanContext plan() throws RecognitionException {
		PlanContext _localctx = new PlanContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_plan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__7);
			setState(120);
			match(T__0);
			setState(121);
			listOfClauses();
			setState(122);
			match(T__6);
			setState(123);
			compoundaction();
			setState(124);
			match(T__6);
			setState(125);
			listOfClauses();
			setState(126);
			match(T__6);
			setState(127);
			listOfClauses();
			setState(128);
			match(T__1);
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

	public static class ActionContext extends ParserRuleContext {
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public List<ListOfClausesContext> listOfClauses() {
			return getRuleContexts(ListOfClausesContext.class);
		}
		public ListOfClausesContext listOfClauses(int i) {
			return getRuleContext(ListOfClausesContext.class,i);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__8);
			setState(131);
			match(T__0);
			setState(132);
			functionInvocation();
			setState(133);
			match(T__6);
			setState(134);
			listOfClauses();
			setState(135);
			match(T__6);
			setState(136);
			listOfClauses();
			setState(137);
			match(T__1);
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

	public static class FunctionInvocationContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			functionName();
			setState(140);
			match(T__0);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(141);
				argumentList();
				}
			}

			setState(144);
			match(T__1);
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

	public static class FunctionNameContext extends ParserRuleContext {
		public List<TerminalNode> LCLETTER() { return getTokens(AgentParser.LCLETTER); }
		public TerminalNode LCLETTER(int i) {
			return getToken(AgentParser.LCLETTER, i);
		}
		public List<CharacterContext> character() {
			return getRuleContexts(CharacterContext.class);
		}
		public CharacterContext character(int i) {
			return getRuleContext(CharacterContext.class,i);
		}
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(146);
					match(LCLETTER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(149); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
				{
				{
				setState(151);
				character();
				}
				}
				setState(156);
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

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			expression();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(158);
				match(T__6);
				setState(159);
				expression();
				}
				}
				setState(164);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<CharacterContext> character() {
			return getRuleContexts(CharacterContext.class);
		}
		public CharacterContext character(int i) {
			return getRuleContext(CharacterContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__9);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
				{
				{
				setState(166);
				character();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(T__9);
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

	public static class CompoundactionContext extends ParserRuleContext {
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public CompoundactionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundaction; }
	}

	public final CompoundactionContext compoundaction() throws RecognitionException {
		CompoundactionContext _localctx = new CompoundactionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_compoundaction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(174);
				match(T__10);
				setState(175);
				action();
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(176);
					match(T__6);
					setState(177);
					action();
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(183);
				match(T__11);
				}
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

	public static class ListOfClausesContext extends ParserRuleContext {
		public List<PropClauseContext> propClause() {
			return getRuleContexts(PropClauseContext.class);
		}
		public PropClauseContext propClause(int i) {
			return getRuleContext(PropClauseContext.class,i);
		}
		public List<FolClauseContext> folClause() {
			return getRuleContexts(FolClauseContext.class);
		}
		public FolClauseContext folClause(int i) {
			return getRuleContext(FolClauseContext.class,i);
		}
		public ListOfClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listOfClauses; }
	}

	public final ListOfClausesContext listOfClauses() throws RecognitionException {
		ListOfClausesContext _localctx = new ListOfClausesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_listOfClauses);
		int _la;
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LCLETTER:
					{
					setState(187);
					propClause();
					}
					break;
				case T__10:
					{
					setState(188);
					match(T__10);
					setState(189);
					propClause();
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(190);
						match(T__6);
						setState(191);
						propClause();
						}
						}
						setState(196);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(197);
					match(T__11);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LCLETTER:
					{
					setState(201);
					folClause();
					}
					break;
				case T__10:
					{
					setState(202);
					match(T__10);
					setState(203);
					folClause();
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(204);
						match(T__6);
						setState(205);
						folClause();
						}
						}
						setState(210);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(211);
					match(T__11);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
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

	public static class FormulasContext extends ParserRuleContext {
		public List<PropFormulaContext> propFormula() {
			return getRuleContexts(PropFormulaContext.class);
		}
		public PropFormulaContext propFormula(int i) {
			return getRuleContext(PropFormulaContext.class,i);
		}
		public List<FolFormulaContext> folFormula() {
			return getRuleContexts(FolFormulaContext.class);
		}
		public FolFormulaContext folFormula(int i) {
			return getRuleContext(FolFormulaContext.class,i);
		}
		public FormulasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulas; }
	}

	public final FormulasContext formulas() throws RecognitionException {
		FormulasContext _localctx = new FormulasContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_formulas);
		int _la;
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LCLETTER) {
					{
					{
					setState(217);
					propFormula();
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LCLETTER) {
					{
					{
					setState(223);
					folFormula();
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class PropFormulaContext extends ParserRuleContext {
		public PropClauseContext propClause() {
			return getRuleContext(PropClauseContext.class,0);
		}
		public PropLogExprContext propLogExpr() {
			return getRuleContext(PropLogExprContext.class,0);
		}
		public PropFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propFormula; }
	}

	public final PropFormulaContext propFormula() throws RecognitionException {
		PropFormulaContext _localctx = new PropFormulaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_propFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(231);
				propClause();
				}
				break;
			case 2:
				{
				{
				setState(232);
				propClause();
				setState(233);
				match(T__12);
				setState(234);
				propLogExpr(0);
				}
				}
				break;
			}
			setState(238);
			match(T__13);
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

	public static class FolFormulaContext extends ParserRuleContext {
		public FolClauseContext folClause() {
			return getRuleContext(FolClauseContext.class,0);
		}
		public FolLogExprContext folLogExpr() {
			return getRuleContext(FolLogExprContext.class,0);
		}
		public FolFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_folFormula; }
	}

	public final FolFormulaContext folFormula() throws RecognitionException {
		FolFormulaContext _localctx = new FolFormulaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_folFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(240);
				folClause();
				}
				break;
			case 2:
				{
				{
				setState(241);
				folClause();
				setState(242);
				match(T__12);
				setState(243);
				folLogExpr(0);
				}
				}
				break;
			}
			setState(247);
			match(T__13);
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

	public static class PlansFormulasContext extends ParserRuleContext {
		public List<PlanContext> plan() {
			return getRuleContexts(PlanContext.class);
		}
		public PlanContext plan(int i) {
			return getRuleContext(PlanContext.class,i);
		}
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public PlansFormulasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plansFormulas; }
	}

	public final PlansFormulasContext plansFormulas() throws RecognitionException {
		PlansFormulasContext _localctx = new PlansFormulasContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_plansFormulas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7 || _la==T__8) {
				{
				{
				setState(251);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(249);
					plan();
					}
					break;
				case T__8:
					{
					setState(250);
					action();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(253);
				match(T__13);
				}
				}
				setState(259);
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

	public static class BridgeRuleContext extends ParserRuleContext {
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public BridgeRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bridgeRule; }
	}

	public final BridgeRuleContext bridgeRule() throws RecognitionException {
		BridgeRuleContext _localctx = new BridgeRuleContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bridgeRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			head();
			setState(261);
			match(T__12);
			setState(262);
			body();
			setState(263);
			match(T__13);
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

	public static class HeadContext extends ParserRuleContext {
		public ContextNameContext contextName() {
			return getRuleContext(ContextNameContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PropClauseContext propClause() {
			return getRuleContext(PropClauseContext.class,0);
		}
		public FolClauseContext folClause() {
			return getRuleContext(FolClauseContext.class,0);
		}
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(265);
			match(T__14);
			setState(266);
			contextName();
			setState(267);
			match(T__0);
			setState(268);
			type();
			setState(269);
			match(T__1);
			}
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(271);
				match(T__15);
				}
			}

			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(274);
				propClause();
				}
				break;
			case 2:
				{
				setState(275);
				folClause();
				}
				break;
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

	public static class BodyContext extends ParserRuleContext {
		public List<ContextNameContext> contextName() {
			return getRuleContexts(ContextNameContext.class);
		}
		public ContextNameContext contextName(int i) {
			return getRuleContext(ContextNameContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<PropClauseContext> propClause() {
			return getRuleContexts(PropClauseContext.class);
		}
		public PropClauseContext propClause(int i) {
			return getRuleContext(PropClauseContext.class,i);
		}
		public List<FolClauseContext> folClause() {
			return getRuleContexts(FolClauseContext.class);
		}
		public FolClauseContext folClause(int i) {
			return getRuleContext(FolClauseContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			contextName();
			setState(279);
			match(T__0);
			setState(280);
			type();
			setState(281);
			match(T__1);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(282);
				match(T__15);
				}
			}

			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(285);
				propClause();
				}
				break;
			case 2:
				{
				setState(286);
				folClause();
				}
				break;
			}
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16 || _la==T__17) {
				{
				{
				setState(289);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(290);
				contextName();
				setState(291);
				match(T__0);
				setState(292);
				type();
				setState(293);
				match(T__1);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(294);
					match(T__15);
					}
				}

				setState(299);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(297);
					propClause();
					}
					break;
				case 2:
					{
					setState(298);
					folClause();
					}
					break;
				}
				}
				}
				setState(305);
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

	public static class PropClauseContext extends ParserRuleContext {
		public TerminalNode LCLETTER() { return getToken(AgentParser.LCLETTER, 0); }
		public List<CharacterContext> character() {
			return getRuleContexts(CharacterContext.class);
		}
		public CharacterContext character(int i) {
			return getRuleContext(CharacterContext.class,i);
		}
		public PropClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propClause; }
	}

	public final PropClauseContext propClause() throws RecognitionException {
		PropClauseContext _localctx = new PropClauseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_propClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(LCLETTER);
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(307);
					character();
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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

	public static class FolClauseContext extends ParserRuleContext {
		public List<TerminalNode> LCLETTER() { return getTokens(AgentParser.LCLETTER); }
		public TerminalNode LCLETTER(int i) {
			return getToken(AgentParser.LCLETTER, i);
		}
		public List<CharacterContext> character() {
			return getRuleContexts(CharacterContext.class);
		}
		public CharacterContext character(int i) {
			return getRuleContext(CharacterContext.class,i);
		}
		public List<TerminalNode> UCLETTER() { return getTokens(AgentParser.UCLETTER); }
		public TerminalNode UCLETTER(int i) {
			return getToken(AgentParser.UCLETTER, i);
		}
		public FolClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_folClause; }
	}

	public final FolClauseContext folClause() throws RecognitionException {
		FolClauseContext _localctx = new FolClauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_folClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(LCLETTER);
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
				{
				{
				setState(314);
				character();
				}
				}
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(320);
			match(T__0);
			{
			setState(321);
			_la = _input.LA(1);
			if ( !(_la==LCLETTER || _la==UCLETTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
				{
				{
				setState(322);
				character();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(328);
				match(T__6);
				setState(329);
				_la = _input.LA(1);
				if ( !(_la==LCLETTER || _la==UCLETTER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
					{
					{
					setState(330);
					character();
					}
					}
					setState(335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(341);
			match(T__1);
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

	public static class PropLogExprContext extends ParserRuleContext {
		public PropClauseContext propClause() {
			return getRuleContext(PropClauseContext.class,0);
		}
		public List<PropLogExprContext> propLogExpr() {
			return getRuleContexts(PropLogExprContext.class);
		}
		public PropLogExprContext propLogExpr(int i) {
			return getRuleContext(PropLogExprContext.class,i);
		}
		public PropLogExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propLogExpr; }
	}

	public final PropLogExprContext propLogExpr() throws RecognitionException {
		return propLogExpr(0);
	}

	private PropLogExprContext propLogExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PropLogExprContext _localctx = new PropLogExprContext(_ctx, _parentState);
		PropLogExprContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_propLogExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(344);
			propClause();
			}
			_ctx.stop = _input.LT(-1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PropLogExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_propLogExpr);
					setState(346);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(347);
					_la = _input.LA(1);
					if ( !(_la==T__16 || _la==T__17) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(348);
					propLogExpr(3);
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FolLogExprContext extends ParserRuleContext {
		public FolClauseContext folClause() {
			return getRuleContext(FolClauseContext.class,0);
		}
		public List<FolLogExprContext> folLogExpr() {
			return getRuleContexts(FolLogExprContext.class);
		}
		public FolLogExprContext folLogExpr(int i) {
			return getRuleContext(FolLogExprContext.class,i);
		}
		public FolLogExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_folLogExpr; }
	}

	public final FolLogExprContext folLogExpr() throws RecognitionException {
		return folLogExpr(0);
	}

	private FolLogExprContext folLogExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FolLogExprContext _localctx = new FolLogExprContext(_ctx, _parentState);
		FolLogExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_folLogExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(355);
			folClause();
			}
			_ctx.stop = _input.LT(-1);
			setState(362);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FolLogExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_folLogExpr);
					setState(357);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(358);
					_la = _input.LA(1);
					if ( !(_la==T__16 || _la==T__17) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(359);
					folLogExpr(3);
					}
					} 
				}
				setState(364);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CharacterContext extends ParserRuleContext {
		public TerminalNode LCLETTER() { return getToken(AgentParser.LCLETTER, 0); }
		public TerminalNode UCLETTER() { return getToken(AgentParser.UCLETTER, 0); }
		public TerminalNode DIGIT() { return getToken(AgentParser.DIGIT, 0); }
		public CharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character; }
	}

	public final CharacterContext character() throws RecognitionException {
		CharacterContext _localctx = new CharacterContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_character);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class SemanticRulesContext extends ParserRuleContext {
		public List<CharacterContext> character() {
			return getRuleContexts(CharacterContext.class);
		}
		public CharacterContext character(int i) {
			return getRuleContext(CharacterContext.class,i);
		}
		public SemanticRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semanticRules; }
	}

	public final SemanticRulesContext semanticRules() throws RecognitionException {
		SemanticRulesContext _localctx = new SemanticRulesContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_semanticRules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(367);
				character();
				}
				}
				setState(370); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0) );
			setState(372);
			match(T__18);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return propLogExpr_sempred((PropLogExprContext)_localctx, predIndex);
		case 26:
			return folLogExpr_sempred((FolLogExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean propLogExpr_sempred(PropLogExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean folLogExpr_sempred(FolLogExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u0179\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\7\2?\n\2\f"+
		"\2\16\2B\13\2\3\2\3\2\3\3\3\3\3\3\5\3I\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3R\n\3\3\3\3\3\3\3\5\3W\n\3\3\4\3\4\3\5\3\5\5\5]\n\5\3\6\3\6\3\7\3"+
		"\7\6\7c\n\7\r\7\16\7d\3\7\7\7h\n\7\f\7\16\7k\13\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bs\n\b\3\t\6\tv\n\t\r\t\16\tw\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\5"+
		"\f\u0091\n\f\3\f\3\f\3\r\6\r\u0096\n\r\r\r\16\r\u0097\3\r\7\r\u009b\n"+
		"\r\f\r\16\r\u009e\13\r\3\16\3\16\3\16\7\16\u00a3\n\16\f\16\16\16\u00a6"+
		"\13\16\3\17\3\17\7\17\u00aa\n\17\f\17\16\17\u00ad\13\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\7\20\u00b5\n\20\f\20\16\20\u00b8\13\20\3\20\3\20\5\20"+
		"\u00bc\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u00c3\n\21\f\21\16\21\u00c6"+
		"\13\21\3\21\3\21\5\21\u00ca\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u00d1\n"+
		"\21\f\21\16\21\u00d4\13\21\3\21\3\21\5\21\u00d8\n\21\5\21\u00da\n\21\3"+
		"\22\7\22\u00dd\n\22\f\22\16\22\u00e0\13\22\3\22\7\22\u00e3\n\22\f\22\16"+
		"\22\u00e6\13\22\5\22\u00e8\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u00ef\n"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\5\24\u00f8\n\24\3\24\3\24\3\25"+
		"\3\25\5\25\u00fe\n\25\3\25\3\25\7\25\u0102\n\25\f\25\16\25\u0105\13\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0113"+
		"\n\27\3\27\3\27\5\27\u0117\n\27\3\30\3\30\3\30\3\30\3\30\5\30\u011e\n"+
		"\30\3\30\3\30\5\30\u0122\n\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u012a"+
		"\n\30\3\30\3\30\5\30\u012e\n\30\7\30\u0130\n\30\f\30\16\30\u0133\13\30"+
		"\3\31\3\31\7\31\u0137\n\31\f\31\16\31\u013a\13\31\3\32\3\32\7\32\u013e"+
		"\n\32\f\32\16\32\u0141\13\32\3\32\3\32\3\32\7\32\u0146\n\32\f\32\16\32"+
		"\u0149\13\32\3\32\3\32\3\32\7\32\u014e\n\32\f\32\16\32\u0151\13\32\7\32"+
		"\u0153\n\32\f\32\16\32\u0156\13\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u0160\n\33\f\33\16\33\u0163\13\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\7\34\u016b\n\34\f\34\16\34\u016e\13\34\3\35\3\35\3\36\6\36\u0173"+
		"\n\36\r\36\16\36\u0174\3\36\3\36\3\36\2\4\64\66\37\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\7\3\2\6\7\3\2\26\30\3\2\32"+
		"\33\3\2\23\24\3\2\32\34\2\u0188\2@\3\2\2\2\4V\3\2\2\2\6X\3\2\2\2\b\\\3"+
		"\2\2\2\n^\3\2\2\2\f`\3\2\2\2\16r\3\2\2\2\20u\3\2\2\2\22y\3\2\2\2\24\u0084"+
		"\3\2\2\2\26\u008d\3\2\2\2\30\u0095\3\2\2\2\32\u009f\3\2\2\2\34\u00a7\3"+
		"\2\2\2\36\u00bb\3\2\2\2 \u00d9\3\2\2\2\"\u00e7\3\2\2\2$\u00ee\3\2\2\2"+
		"&\u00f7\3\2\2\2(\u0103\3\2\2\2*\u0106\3\2\2\2,\u010b\3\2\2\2.\u0118\3"+
		"\2\2\2\60\u0134\3\2\2\2\62\u013b\3\2\2\2\64\u0159\3\2\2\2\66\u0164\3\2"+
		"\2\28\u016f\3\2\2\2:\u0172\3\2\2\2<?\5\4\3\2=?\5*\26\2><\3\2\2\2>=\3\2"+
		"\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7\2\2\3D\3\3"+
		"\2\2\2EF\5\b\5\2FH\7\3\2\2GI\5\6\4\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7"+
		"\4\2\2KL\7\5\2\2LM\5\"\22\2MW\3\2\2\2NO\7\31\2\2OQ\7\3\2\2PR\t\2\2\2Q"+
		"P\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\4\2\2TU\7\5\2\2UW\5(\25\2VE\3\2\2\2"+
		"VN\3\2\2\2W\5\3\2\2\2XY\5\16\b\2Y\7\3\2\2\2Z]\5\n\6\2[]\5\f\7\2\\Z\3\2"+
		"\2\2\\[\3\2\2\2]\t\3\2\2\2^_\t\3\2\2_\13\3\2\2\2`b\7\b\2\2ac\t\4\2\2b"+
		"a\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ei\3\2\2\2fh\58\35\2gf\3\2\2\2"+
		"hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\r\3\2\2\2ki\3\2\2\2ls\7\6\2\2ms\7\7\2"+
		"\2no\5\20\t\2op\7\t\2\2pq\5:\36\2qs\3\2\2\2rl\3\2\2\2rm\3\2\2\2rn\3\2"+
		"\2\2s\17\3\2\2\2tv\58\35\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\21"+
		"\3\2\2\2yz\7\n\2\2z{\7\3\2\2{|\5 \21\2|}\7\t\2\2}~\5\36\20\2~\177\7\t"+
		"\2\2\177\u0080\5 \21\2\u0080\u0081\7\t\2\2\u0081\u0082\5 \21\2\u0082\u0083"+
		"\7\4\2\2\u0083\23\3\2\2\2\u0084\u0085\7\13\2\2\u0085\u0086\7\3\2\2\u0086"+
		"\u0087\5\26\f\2\u0087\u0088\7\t\2\2\u0088\u0089\5 \21\2\u0089\u008a\7"+
		"\t\2\2\u008a\u008b\5 \21\2\u008b\u008c\7\4\2\2\u008c\25\3\2\2\2\u008d"+
		"\u008e\5\30\r\2\u008e\u0090\7\3\2\2\u008f\u0091\5\32\16\2\u0090\u008f"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\4\2\2\u0093"+
		"\27\3\2\2\2\u0094\u0096\7\32\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2"+
		"\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009c\3\2\2\2\u0099\u009b"+
		"\58\35\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\31\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a4\5\34\17"+
		"\2\u00a0\u00a1\7\t\2\2\u00a1\u00a3\5\34\17\2\u00a2\u00a0\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\33\3\2\2"+
		"\2\u00a6\u00a4\3\2\2\2\u00a7\u00ab\7\f\2\2\u00a8\u00aa\58\35\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\f\2\2\u00af\35\3\2\2"+
		"\2\u00b0\u00b1\7\r\2\2\u00b1\u00b6\5\24\13\2\u00b2\u00b3\7\t\2\2\u00b3"+
		"\u00b5\5\24\13\2\u00b4\u00b2\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3"+
		"\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00ba\7\16\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b0\3\2\2\2\u00bb\u00bc\3"+
		"\2\2\2\u00bc\37\3\2\2\2\u00bd\u00ca\5\60\31\2\u00be\u00bf\7\r\2\2\u00bf"+
		"\u00c4\5\60\31\2\u00c0\u00c1\7\t\2\2\u00c1\u00c3\5\60\31\2\u00c2\u00c0"+
		"\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\16\2\2\u00c8\u00ca\3"+
		"\2\2\2\u00c9\u00bd\3\2\2\2\u00c9\u00be\3\2\2\2\u00ca\u00da\3\2\2\2\u00cb"+
		"\u00d8\5\62\32\2\u00cc\u00cd\7\r\2\2\u00cd\u00d2\5\62\32\2\u00ce\u00cf"+
		"\7\t\2\2\u00cf\u00d1\5\62\32\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2"+
		"\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d5\u00d6\7\16\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00cb\3\2\2\2"+
		"\u00d7\u00cc\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00c9\3\2\2\2\u00d9\u00d7"+
		"\3\2\2\2\u00da!\3\2\2\2\u00db\u00dd\5$\23\2\u00dc\u00db\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e8\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\5&\24\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00de\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e8"+
		"#\3\2\2\2\u00e9\u00ef\5\60\31\2\u00ea\u00eb\5\60\31\2\u00eb\u00ec\7\17"+
		"\2\2\u00ec\u00ed\5\64\33\2\u00ed\u00ef\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ee"+
		"\u00ea\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7\20\2\2\u00f1%\3\2\2\2"+
		"\u00f2\u00f8\5\62\32\2\u00f3\u00f4\5\62\32\2\u00f4\u00f5\7\17\2\2\u00f5"+
		"\u00f6\5\66\34\2\u00f6\u00f8\3\2\2\2\u00f7\u00f2\3\2\2\2\u00f7\u00f3\3"+
		"\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7\20\2\2\u00fa\'\3\2\2\2\u00fb"+
		"\u00fe\5\22\n\2\u00fc\u00fe\5\24\13\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc"+
		"\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\7\20\2\2\u0100\u0102\3\2\2\2"+
		"\u0101\u00fd\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104"+
		"\3\2\2\2\u0104)\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\5,\27\2\u0107"+
		"\u0108\7\17\2\2\u0108\u0109\5.\30\2\u0109\u010a\7\20\2\2\u010a+\3\2\2"+
		"\2\u010b\u010c\7\21\2\2\u010c\u010d\5\b\5\2\u010d\u010e\7\3\2\2\u010e"+
		"\u010f\5\16\b\2\u010f\u0110\7\4\2\2\u0110\u0112\3\2\2\2\u0111\u0113\7"+
		"\22\2\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0117\5\60\31\2\u0115\u0117\5\62\32\2\u0116\u0114\3\2\2\2\u0116\u0115"+
		"\3\2\2\2\u0117-\3\2\2\2\u0118\u0119\5\b\5\2\u0119\u011a\7\3\2\2\u011a"+
		"\u011b\5\16\b\2\u011b\u011d\7\4\2\2\u011c\u011e\7\22\2\2\u011d\u011c\3"+
		"\2\2\2\u011d\u011e\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u0122\5\60\31\2\u0120"+
		"\u0122\5\62\32\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122\u0131\3"+
		"\2\2\2\u0123\u0124\t\5\2\2\u0124\u0125\5\b\5\2\u0125\u0126\7\3\2\2\u0126"+
		"\u0127\5\16\b\2\u0127\u0129\7\4\2\2\u0128\u012a\7\22\2\2\u0129\u0128\3"+
		"\2\2\2\u0129\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u012e\5\60\31\2\u012c"+
		"\u012e\5\62\32\2\u012d\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u0130\3"+
		"\2\2\2\u012f\u0123\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132/\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0138\7\32\2\2"+
		"\u0135\u0137\58\35\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136"+
		"\3\2\2\2\u0138\u0139\3\2\2\2\u0139\61\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013f\7\32\2\2\u013c\u013e\58\35\2\u013d\u013c\3\2\2\2\u013e\u0141\3"+
		"\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0142\u0143\7\3\2\2\u0143\u0147\t\4\2\2\u0144\u0146\58"+
		"\35\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0154\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\7\t"+
		"\2\2\u014b\u014f\t\4\2\2\u014c\u014e\58\35\2\u014d\u014c\3\2\2\2\u014e"+
		"\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0153\3\2"+
		"\2\2\u0151\u014f\3\2\2\2\u0152\u014a\3\2\2\2\u0153\u0156\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2"+
		"\2\2\u0157\u0158\7\4\2\2\u0158\63\3\2\2\2\u0159\u015a\b\33\1\2\u015a\u015b"+
		"\5\60\31\2\u015b\u0161\3\2\2\2\u015c\u015d\f\4\2\2\u015d\u015e\t\5\2\2"+
		"\u015e\u0160\5\64\33\5\u015f\u015c\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f"+
		"\3\2\2\2\u0161\u0162\3\2\2\2\u0162\65\3\2\2\2\u0163\u0161\3\2\2\2\u0164"+
		"\u0165\b\34\1\2\u0165\u0166\5\62\32\2\u0166\u016c\3\2\2\2\u0167\u0168"+
		"\f\4\2\2\u0168\u0169\t\5\2\2\u0169\u016b\5\66\34\5\u016a\u0167\3\2\2\2"+
		"\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\67"+
		"\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\t\6\2\2\u01709\3\2\2\2\u0171"+
		"\u0173\58\35\2\u0172\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\7\25\2\2\u0177"+
		";\3\2\2\2.>@HQV\\dirw\u0090\u0097\u009c\u00a4\u00ab\u00b6\u00bb\u00c4"+
		"\u00c9\u00d2\u00d7\u00d9\u00de\u00e4\u00e7\u00ee\u00f7\u00fd\u0103\u0112"+
		"\u0116\u011d\u0121\u0129\u012d\u0131\u0138\u013f\u0147\u014f\u0154\u0161"+
		"\u016c\u0174";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}