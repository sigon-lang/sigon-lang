// Generated from agent/Agent.g4 by ANTLR 4.7
package agent;
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
		BELIEFS=18, DESIRES=19, INTENTIONS=20, PLANS=21, LCLETTER=22, UCLETTER=23, 
		DIGIT=24, WS=25;
	public static final int
		RULE_agent = 0, RULE_contextDeclare = 1, RULE_primitiveContext = 2, RULE_customContext = 3, 
		RULE_type = 4, RULE_plan = 5, RULE_action = 6, RULE_somethingToBeTrue = 7, 
		RULE_compoundaction = 8, RULE_preconditions = 9, RULE_postconditions = 10, 
		RULE_formulas = 11, RULE_bridgeRules = 12, RULE_head = 13, RULE_body = 14, 
		RULE_propClause = 15, RULE_folClause = 16, RULE_propLogExpr = 17, RULE_folLogExpr = 18, 
		RULE_character = 19;
	public static final String[] ruleNames = {
		"agent", "contextDeclare", "primitiveContext", "customContext", "type", 
		"plan", "action", "somethingToBeTrue", "compoundaction", "preconditions", 
		"postconditions", "formulas", "bridgeRules", "head", "body", "propClause", 
		"folClause", "propLogExpr", "folLogExpr", "character"
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
		public List<ContextDeclareContext> contextDeclare() {
			return getRuleContexts(ContextDeclareContext.class);
		}
		public ContextDeclareContext contextDeclare(int i) {
			return getRuleContext(ContextDeclareContext.class,i);
		}
		public List<BridgeRulesContext> bridgeRules() {
			return getRuleContexts(BridgeRulesContext.class);
		}
		public BridgeRulesContext bridgeRules(int i) {
			return getRuleContext(BridgeRulesContext.class,i);
		}
		public AgentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterAgent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitAgent(this);
		}
	}

	public final AgentContext agent() throws RecognitionException {
		AgentContext _localctx = new AgentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_agent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << BELIEFS) | (1L << DESIRES) | (1L << INTENTIONS) | (1L << PLANS))) != 0)) {
				{
				{
				setState(40);
				contextDeclare();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(46);
				bridgeRules();
				}
				}
				setState(51);
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

	public static class ContextDeclareContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormulasContext formulas() {
			return getRuleContext(FormulasContext.class,0);
		}
		public PrimitiveContextContext primitiveContext() {
			return getRuleContext(PrimitiveContextContext.class,0);
		}
		public CustomContextContext customContext() {
			return getRuleContext(CustomContextContext.class,0);
		}
		public ContextDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterContextDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitContextDeclare(this);
		}
	}

	public final ContextDeclareContext contextDeclare() throws RecognitionException {
		ContextDeclareContext _localctx = new ContextDeclareContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_contextDeclare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEFS:
			case DESIRES:
			case INTENTIONS:
			case PLANS:
				{
				setState(52);
				primitiveContext();
				}
				break;
			case T__3:
				{
				setState(53);
				customContext();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(56);
			match(T__0);
			setState(57);
			type();
			setState(58);
			match(T__1);
			setState(59);
			match(T__2);
			setState(60);
			formulas();
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

	public static class PrimitiveContextContext extends ParserRuleContext {
		public TerminalNode BELIEFS() { return getToken(AgentParser.BELIEFS, 0); }
		public TerminalNode DESIRES() { return getToken(AgentParser.DESIRES, 0); }
		public TerminalNode INTENTIONS() { return getToken(AgentParser.INTENTIONS, 0); }
		public TerminalNode PLANS() { return getToken(AgentParser.PLANS, 0); }
		public PrimitiveContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveContext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterPrimitiveContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitPrimitiveContext(this);
		}
	}

	public final PrimitiveContextContext primitiveContext() throws RecognitionException {
		PrimitiveContextContext _localctx = new PrimitiveContextContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_primitiveContext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BELIEFS) | (1L << DESIRES) | (1L << INTENTIONS) | (1L << PLANS))) != 0)) ) {
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

	public static class CustomContextContext extends ParserRuleContext {
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
		public CustomContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customContext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterCustomContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitCustomContext(this);
		}
	}

	public final CustomContextContext customContext() throws RecognitionException {
		CustomContextContext _localctx = new CustomContextContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_customContext);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				match(T__3);
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(70); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(69);
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
				setState(72); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
				{
				{
				setState(74);
				character();
				}
				}
				setState(79);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
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

	public static class PlanContext extends ParserRuleContext {
		public SomethingToBeTrueContext somethingToBeTrue() {
			return getRuleContext(SomethingToBeTrueContext.class,0);
		}
		public CompoundactionContext compoundaction() {
			return getRuleContext(CompoundactionContext.class,0);
		}
		public PreconditionsContext preconditions() {
			return getRuleContext(PreconditionsContext.class,0);
		}
		public PostconditionsContext postconditions() {
			return getRuleContext(PostconditionsContext.class,0);
		}
		public PlanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterPlan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitPlan(this);
		}
	}

	public final PlanContext plan() throws RecognitionException {
		PlanContext _localctx = new PlanContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_plan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__6);
			setState(83);
			match(T__0);
			setState(84);
			somethingToBeTrue();
			setState(85);
			match(T__7);
			setState(86);
			compoundaction();
			setState(87);
			match(T__7);
			setState(88);
			preconditions();
			setState(89);
			match(T__7);
			setState(90);
			postconditions();
			setState(91);
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
		public PreconditionsContext preconditions() {
			return getRuleContext(PreconditionsContext.class,0);
		}
		public PostconditionsContext postconditions() {
			return getRuleContext(PostconditionsContext.class,0);
		}
		public PropClauseContext propClause() {
			return getRuleContext(PropClauseContext.class,0);
		}
		public FolClauseContext folClause() {
			return getRuleContext(FolClauseContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__8);
			setState(94);
			match(T__0);
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(95);
				propClause();
				}
				break;
			case 2:
				{
				setState(96);
				folClause();
				}
				break;
			}
			setState(99);
			match(T__7);
			setState(100);
			preconditions();
			setState(101);
			match(T__7);
			setState(102);
			postconditions();
			setState(103);
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

	public static class SomethingToBeTrueContext extends ParserRuleContext {
		public PropClauseContext propClause() {
			return getRuleContext(PropClauseContext.class,0);
		}
		public FolClauseContext folClause() {
			return getRuleContext(FolClauseContext.class,0);
		}
		public SomethingToBeTrueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_somethingToBeTrue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterSomethingToBeTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitSomethingToBeTrue(this);
		}
	}

	public final SomethingToBeTrueContext somethingToBeTrue() throws RecognitionException {
		SomethingToBeTrueContext _localctx = new SomethingToBeTrueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_somethingToBeTrue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(105);
				propClause();
				}
				break;
			case 2:
				{
				setState(106);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterCompoundaction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitCompoundaction(this);
		}
	}

	public final CompoundactionContext compoundaction() throws RecognitionException {
		CompoundactionContext _localctx = new CompoundactionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compoundaction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(109);
				match(T__9);
				setState(110);
				action();
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(111);
					match(T__7);
					setState(112);
					action();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				match(T__10);
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

	public static class PreconditionsContext extends ParserRuleContext {
		public PropClauseContext propClause() {
			return getRuleContext(PropClauseContext.class,0);
		}
		public FolClauseContext folClause() {
			return getRuleContext(FolClauseContext.class,0);
		}
		public PreconditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preconditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterPreconditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitPreconditions(this);
		}
	}

	public final PreconditionsContext preconditions() throws RecognitionException {
		PreconditionsContext _localctx = new PreconditionsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_preconditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(122);
				propClause();
				}
				break;
			case 2:
				{
				setState(123);
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

	public static class PostconditionsContext extends ParserRuleContext {
		public PropClauseContext propClause() {
			return getRuleContext(PropClauseContext.class,0);
		}
		public FolClauseContext folClause() {
			return getRuleContext(FolClauseContext.class,0);
		}
		public PostconditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postconditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterPostconditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitPostconditions(this);
		}
	}

	public final PostconditionsContext postconditions() throws RecognitionException {
		PostconditionsContext _localctx = new PostconditionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_postconditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(126);
				propClause();
				}
				break;
			case 2:
				{
				setState(127);
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

	public static class FormulasContext extends ParserRuleContext {
		public List<PropClauseContext> propClause() {
			return getRuleContexts(PropClauseContext.class);
		}
		public PropClauseContext propClause(int i) {
			return getRuleContext(PropClauseContext.class,i);
		}
		public List<PropLogExprContext> propLogExpr() {
			return getRuleContexts(PropLogExprContext.class);
		}
		public PropLogExprContext propLogExpr(int i) {
			return getRuleContext(PropLogExprContext.class,i);
		}
		public List<FolClauseContext> folClause() {
			return getRuleContexts(FolClauseContext.class);
		}
		public FolClauseContext folClause(int i) {
			return getRuleContext(FolClauseContext.class,i);
		}
		public List<FolLogExprContext> folLogExpr() {
			return getRuleContexts(FolLogExprContext.class);
		}
		public FolLogExprContext folLogExpr(int i) {
			return getRuleContext(FolLogExprContext.class,i);
		}
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
		public FormulasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterFormulas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitFormulas(this);
		}
	}

	public final FormulasContext formulas() throws RecognitionException {
		FormulasContext _localctx = new FormulasContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_formulas);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LCLETTER) {
					{
					{
					setState(135);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(130);
						propClause();
						}
						break;
					case 2:
						{
						{
						setState(131);
						propClause();
						setState(132);
						match(T__11);
						setState(133);
						propLogExpr(0);
						}
						}
						break;
					}
					setState(137);
					match(T__12);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LCLETTER) {
					{
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(144);
						folClause();
						}
						break;
					case 2:
						{
						{
						setState(145);
						folClause();
						setState(146);
						match(T__11);
						setState(147);
						folLogExpr(0);
						}
						}
						break;
					}
					setState(151);
					match(T__12);
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6 || _la==T__8) {
					{
					{
					setState(160);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__6:
						{
						setState(158);
						plan();
						}
						break;
					case T__8:
						{
						setState(159);
						action();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(162);
					match(T__12);
					}
					}
					setState(168);
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

	public static class BridgeRulesContext extends ParserRuleContext {
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public BridgeRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bridgeRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterBridgeRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitBridgeRules(this);
		}
	}

	public final BridgeRulesContext bridgeRules() throws RecognitionException {
		BridgeRulesContext _localctx = new BridgeRulesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bridgeRules);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			head();
			setState(172);
			match(T__11);
			setState(173);
			body();
			setState(174);
			match(T__12);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PropClauseContext propClause() {
			return getRuleContext(PropClauseContext.class,0);
		}
		public FolClauseContext folClause() {
			return getRuleContext(FolClauseContext.class,0);
		}
		public PrimitiveContextContext primitiveContext() {
			return getRuleContext(PrimitiveContextContext.class,0);
		}
		public CustomContextContext customContext() {
			return getRuleContext(CustomContextContext.class,0);
		}
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitHead(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(176);
			match(T__13);
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEFS:
			case DESIRES:
			case INTENTIONS:
			case PLANS:
				{
				setState(177);
				primitiveContext();
				}
				break;
			case T__3:
				{
				setState(178);
				customContext();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(181);
			match(T__0);
			setState(182);
			type();
			setState(183);
			match(T__1);
			}
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(185);
				match(T__14);
				}
			}

			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(188);
				propClause();
				}
				break;
			case 2:
				{
				setState(189);
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
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<PrimitiveContextContext> primitiveContext() {
			return getRuleContexts(PrimitiveContextContext.class);
		}
		public PrimitiveContextContext primitiveContext(int i) {
			return getRuleContext(PrimitiveContextContext.class,i);
		}
		public List<CustomContextContext> customContext() {
			return getRuleContexts(CustomContextContext.class);
		}
		public CustomContextContext customContext(int i) {
			return getRuleContext(CustomContextContext.class,i);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEFS:
			case DESIRES:
			case INTENTIONS:
			case PLANS:
				{
				setState(192);
				primitiveContext();
				}
				break;
			case T__3:
				{
				setState(193);
				customContext();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(196);
			match(T__0);
			setState(197);
			type();
			setState(198);
			match(T__1);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(199);
				match(T__14);
				}
			}

			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(202);
				propClause();
				}
				break;
			case 2:
				{
				setState(203);
				folClause();
				}
				break;
			}
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15 || _la==T__16) {
				{
				{
				setState(206);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(209);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BELIEFS:
				case DESIRES:
				case INTENTIONS:
				case PLANS:
					{
					setState(207);
					primitiveContext();
					}
					break;
				case T__3:
					{
					setState(208);
					customContext();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(211);
				match(T__0);
				setState(212);
				type();
				setState(213);
				match(T__1);
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(214);
					match(T__14);
					}
				}

				setState(219);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(217);
					propClause();
					}
					break;
				case 2:
					{
					setState(218);
					folClause();
					}
					break;
				}
				}
				}
				setState(225);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterPropClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitPropClause(this);
		}
	}

	public final PropClauseContext propClause() throws RecognitionException {
		PropClauseContext _localctx = new PropClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(LCLETTER);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(227);
					character();
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterFolClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitFolClause(this);
		}
	}

	public final FolClauseContext folClause() throws RecognitionException {
		FolClauseContext _localctx = new FolClauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_folClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(LCLETTER);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
				{
				{
				setState(234);
				character();
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(240);
			match(T__0);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==LCLETTER || _la==UCLETTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
				{
				{
				setState(242);
				character();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(248);
				match(T__7);
				setState(249);
				_la = _input.LA(1);
				if ( !(_la==LCLETTER || _la==UCLETTER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLETTER) | (1L << UCLETTER) | (1L << DIGIT))) != 0)) {
					{
					{
					setState(250);
					character();
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(261);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterPropLogExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitPropLogExpr(this);
		}
	}

	public final PropLogExprContext propLogExpr() throws RecognitionException {
		return propLogExpr(0);
	}

	private PropLogExprContext propLogExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PropLogExprContext _localctx = new PropLogExprContext(_ctx, _parentState);
		PropLogExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_propLogExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(264);
			propClause();
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PropLogExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_propLogExpr);
					setState(266);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(267);
					_la = _input.LA(1);
					if ( !(_la==T__15 || _la==T__16) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(268);
					propLogExpr(3);
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterFolLogExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitFolLogExpr(this);
		}
	}

	public final FolLogExprContext folLogExpr() throws RecognitionException {
		return folLogExpr(0);
	}

	private FolLogExprContext folLogExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FolLogExprContext _localctx = new FolLogExprContext(_ctx, _parentState);
		FolLogExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_folLogExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(275);
			folClause();
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FolLogExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_folLogExpr);
					setState(277);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(278);
					_la = _input.LA(1);
					if ( !(_la==T__15 || _la==T__16) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(279);
					folLogExpr(3);
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).enterCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentListener ) ((AgentListener)listener).exitCharacter(this);
		}
	}

	public final CharacterContext character() throws RecognitionException {
		CharacterContext _localctx = new CharacterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_character);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return propLogExpr_sempred((PropLogExprContext)_localctx, predIndex);
		case 18:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u0122\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\5\6\5D\n\5\r\5\16\5E\3\5\6\5I\n\5\r\5\16\5J\3\5\7\5N\n\5\f\5\16\5Q"+
		"\13\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\5\bd\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\5\tn\n\t\3\n\3\n\3\n\3\n"+
		"\7\nt\n\n\f\n\16\nw\13\n\3\n\3\n\5\n{\n\n\3\13\3\13\5\13\177\n\13\3\f"+
		"\3\f\5\f\u0083\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u008a\n\r\3\r\3\r\7\r\u008e"+
		"\n\r\f\r\16\r\u0091\13\r\3\r\3\r\3\r\3\r\3\r\5\r\u0098\n\r\3\r\3\r\7\r"+
		"\u009c\n\r\f\r\16\r\u009f\13\r\3\r\3\r\5\r\u00a3\n\r\3\r\3\r\7\r\u00a7"+
		"\n\r\f\r\16\r\u00aa\13\r\5\r\u00ac\n\r\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\5\17\u00b6\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00bd\n\17\3\17"+
		"\3\17\5\17\u00c1\n\17\3\20\3\20\5\20\u00c5\n\20\3\20\3\20\3\20\3\20\5"+
		"\20\u00cb\n\20\3\20\3\20\5\20\u00cf\n\20\3\20\3\20\3\20\5\20\u00d4\n\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00da\n\20\3\20\3\20\5\20\u00de\n\20\7\20\u00e0"+
		"\n\20\f\20\16\20\u00e3\13\20\3\21\3\21\7\21\u00e7\n\21\f\21\16\21\u00ea"+
		"\13\21\3\22\3\22\7\22\u00ee\n\22\f\22\16\22\u00f1\13\22\3\22\3\22\3\22"+
		"\7\22\u00f6\n\22\f\22\16\22\u00f9\13\22\3\22\3\22\3\22\7\22\u00fe\n\22"+
		"\f\22\16\22\u0101\13\22\7\22\u0103\n\22\f\22\16\22\u0106\13\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0110\n\23\f\23\16\23\u0113\13"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u011b\n\24\f\24\16\24\u011e\13"+
		"\24\3\25\3\25\3\25\2\4$&\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(\2\7\3\2\24\27\3\2\30\31\3\2\7\b\3\2\22\23\3\2\30\32\2\u0132\2-\3\2"+
		"\2\2\48\3\2\2\2\6@\3\2\2\2\bC\3\2\2\2\nR\3\2\2\2\fT\3\2\2\2\16_\3\2\2"+
		"\2\20m\3\2\2\2\22z\3\2\2\2\24~\3\2\2\2\26\u0082\3\2\2\2\30\u00ab\3\2\2"+
		"\2\32\u00ad\3\2\2\2\34\u00b2\3\2\2\2\36\u00c4\3\2\2\2 \u00e4\3\2\2\2\""+
		"\u00eb\3\2\2\2$\u0109\3\2\2\2&\u0114\3\2\2\2(\u011f\3\2\2\2*,\5\4\3\2"+
		"+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\63\3\2\2\2/-\3\2\2\2\60\62\5"+
		"\32\16\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\3"+
		"\3\2\2\2\65\63\3\2\2\2\669\5\6\4\2\679\5\b\5\28\66\3\2\2\28\67\3\2\2\2"+
		"9:\3\2\2\2:;\7\3\2\2;<\5\n\6\2<=\7\4\2\2=>\7\5\2\2>?\5\30\r\2?\5\3\2\2"+
		"\2@A\t\2\2\2A\7\3\2\2\2BD\7\6\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2"+
		"\2\2FH\3\2\2\2GI\t\3\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KO\3\2"+
		"\2\2LN\5(\25\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\t\3\2\2\2QO\3"+
		"\2\2\2RS\t\4\2\2S\13\3\2\2\2TU\7\t\2\2UV\7\3\2\2VW\5\20\t\2WX\7\n\2\2"+
		"XY\5\22\n\2YZ\7\n\2\2Z[\5\24\13\2[\\\7\n\2\2\\]\5\26\f\2]^\7\4\2\2^\r"+
		"\3\2\2\2_`\7\13\2\2`c\7\3\2\2ad\5 \21\2bd\5\"\22\2ca\3\2\2\2cb\3\2\2\2"+
		"de\3\2\2\2ef\7\n\2\2fg\5\24\13\2gh\7\n\2\2hi\5\26\f\2ij\7\4\2\2j\17\3"+
		"\2\2\2kn\5 \21\2ln\5\"\22\2mk\3\2\2\2ml\3\2\2\2n\21\3\2\2\2op\7\f\2\2"+
		"pu\5\16\b\2qr\7\n\2\2rt\5\16\b\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2"+
		"\2vx\3\2\2\2wu\3\2\2\2xy\7\r\2\2y{\3\2\2\2zo\3\2\2\2z{\3\2\2\2{\23\3\2"+
		"\2\2|\177\5 \21\2}\177\5\"\22\2~|\3\2\2\2~}\3\2\2\2\177\25\3\2\2\2\u0080"+
		"\u0083\5 \21\2\u0081\u0083\5\"\22\2\u0082\u0080\3\2\2\2\u0082\u0081\3"+
		"\2\2\2\u0083\27\3\2\2\2\u0084\u008a\5 \21\2\u0085\u0086\5 \21\2\u0086"+
		"\u0087\7\16\2\2\u0087\u0088\5$\23\2\u0088\u008a\3\2\2\2\u0089\u0084\3"+
		"\2\2\2\u0089\u0085\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\7\17\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u0089\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u00ac\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0098\5\"\22\2\u0093\u0094\5\"\22\2\u0094\u0095\7\16\2\2\u0095\u0096"+
		"\5&\24\2\u0096\u0098\3\2\2\2\u0097\u0092\3\2\2\2\u0097\u0093\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\7\17\2\2\u009a\u009c\3\2\2\2\u009b\u0097\3"+
		"\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00ac\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a3\5\f\7\2\u00a1\u00a3\5\16"+
		"\b\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\7\17\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a7\u00aa\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u008f\3\2\2\2\u00ab\u009d\3\2\2\2\u00ab\u00a8\3\2"+
		"\2\2\u00ac\31\3\2\2\2\u00ad\u00ae\5\34\17\2\u00ae\u00af\7\16\2\2\u00af"+
		"\u00b0\5\36\20\2\u00b0\u00b1\7\17\2\2\u00b1\33\3\2\2\2\u00b2\u00b5\7\20"+
		"\2\2\u00b3\u00b6\5\6\4\2\u00b4\u00b6\5\b\5\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\3\2\2\u00b8\u00b9\5\n"+
		"\6\2\u00b9\u00ba\7\4\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00bd\7\21\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00c1\5 "+
		"\21\2\u00bf\u00c1\5\"\22\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1"+
		"\35\3\2\2\2\u00c2\u00c5\5\6\4\2\u00c3\u00c5\5\b\5\2\u00c4\u00c2\3\2\2"+
		"\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7\3\2\2\u00c7\u00c8"+
		"\5\n\6\2\u00c8\u00ca\7\4\2\2\u00c9\u00cb\7\21\2\2\u00ca\u00c9\3\2\2\2"+
		"\u00ca\u00cb\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00cf\5 \21\2\u00cd\u00cf"+
		"\5\"\22\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00e1\3\2\2\2"+
		"\u00d0\u00d3\t\5\2\2\u00d1\u00d4\5\6\4\2\u00d2\u00d4\5\b\5\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\3\2\2\u00d6"+
		"\u00d7\5\n\6\2\u00d7\u00d9\7\4\2\2\u00d8\u00da\7\21\2\2\u00d9\u00d8\3"+
		"\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00de\5 \21\2\u00dc"+
		"\u00de\5\"\22\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e0\3"+
		"\2\2\2\u00df\u00d0\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\37\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e8\7\30\2"+
		"\2\u00e5\u00e7\5(\25\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9!\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ef\7\30\2\2\u00ec\u00ee\5(\25\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3"+
		"\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\7\3\2\2\u00f3\u00f7\t\3\2\2\u00f4\u00f6\5("+
		"\25\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u0104\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7\n"+
		"\2\2\u00fb\u00ff\t\3\2\2\u00fc\u00fe\5(\25\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0103\3\2"+
		"\2\2\u0101\u00ff\3\2\2\2\u0102\u00fa\3\2\2\2\u0103\u0106\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0107\u0108\7\4\2\2\u0108#\3\2\2\2\u0109\u010a\b\23\1\2\u010a\u010b"+
		"\5 \21\2\u010b\u0111\3\2\2\2\u010c\u010d\f\4\2\2\u010d\u010e\t\5\2\2\u010e"+
		"\u0110\5$\23\5\u010f\u010c\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112%\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115"+
		"\b\24\1\2\u0115\u0116\5\"\22\2\u0116\u011c\3\2\2\2\u0117\u0118\f\4\2\2"+
		"\u0118\u0119\t\5\2\2\u0119\u011b\5&\24\5\u011a\u0117\3\2\2\2\u011b\u011e"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\'\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011f\u0120\t\6\2\2\u0120)\3\2\2\2&-\638EJOcmuz~\u0082"+
		"\u0089\u008f\u0097\u009d\u00a2\u00a8\u00ab\u00b5\u00bc\u00c0\u00c4\u00ca"+
		"\u00ce\u00d3\u00d9\u00dd\u00e1\u00e8\u00ef\u00f7\u00ff\u0104\u0111\u011c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}