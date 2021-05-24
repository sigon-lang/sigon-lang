// Generated from /home/rr/repositorios/sigon/sigon-lang/src/main/antlr4/agent/Agent.g4 by ANTLR 4.8
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
	public static final int
		RULE_agent = 0, RULE_context = 1, RULE_bridgeRule = 2, RULE_logicalContext = 3, 
		RULE_functionalContext = 4, RULE_communicationContext = 5, RULE_plannerContext = 6, 
		RULE_logicalContextName = 7, RULE_primitiveContextName = 8, RULE_customContextName = 9, 
		RULE_plan = 10, RULE_somethingToBeTrue = 11, RULE_planPreconditions = 12, 
		RULE_planPostconditions = 13, RULE_conditions = 14, RULE_action = 15, 
		RULE_actionPreconditions = 16, RULE_actionPostconditions = 17, RULE_functionInvocation = 18, 
		RULE_functionName = 19, RULE_sensor = 20, RULE_sensorIdentifier = 21, 
		RULE_sensorImplementation = 22, RULE_actuator = 23, RULE_actuatorIdentifier = 24, 
		RULE_actuatorImplementation = 25, RULE_internalOperator = 26, RULE_beliefAdition = 27, 
		RULE_beliefRemotion = 28, RULE_desireAdition = 29, RULE_desireRemotion = 30, 
		RULE_argumentList = 31, RULE_expression = 32, RULE_compoundAction = 33, 
		RULE_plansFormulas = 34, RULE_contextName = 35, RULE_head = 36, RULE_body = 37, 
		RULE_term = 38, RULE_formulas = 39, RULE_atom = 40, RULE_operator = 41, 
		RULE_negation = 42, RULE_annotation = 43, RULE_preAction = 44, RULE_gradedValue = 45, 
		RULE_cost = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"agent", "context", "bridgeRule", "logicalContext", "functionalContext", 
			"communicationContext", "plannerContext", "logicalContextName", "primitiveContextName", 
			"customContextName", "plan", "somethingToBeTrue", "planPreconditions", 
			"planPostconditions", "conditions", "action", "actionPreconditions", 
			"actionPostconditions", "functionInvocation", "functionName", "sensor", 
			"sensorIdentifier", "sensorImplementation", "actuator", "actuatorIdentifier", 
			"actuatorImplementation", "internalOperator", "beliefAdition", "beliefRemotion", 
			"desireAdition", "desireRemotion", "argumentList", "expression", "compoundAction", 
			"plansFormulas", "contextName", "head", "body", "term", "formulas", "atom", 
			"operator", "negation", "annotation", "preAction", "gradedValue", "cost"
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
		public CommunicationContextContext communicationContext() {
			return getRuleContext(CommunicationContextContext.class,0);
		}
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
			setState(94);
			communicationContext();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__20) | (1L << CUSTOMNAME))) != 0)) {
				{
				setState(97);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case CUSTOMNAME:
					{
					setState(95);
					context();
					}
					break;
				case T__20:
					{
					setState(96);
					bridgeRule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
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
		public LogicalContextContext logicalContext() {
			return getRuleContext(LogicalContextContext.class,0);
		}
		public FunctionalContextContext functionalContext() {
			return getRuleContext(FunctionalContextContext.class,0);
		}
		public ContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context; }
	}

	public final ContextContext context() throws RecognitionException {
		ContextContext _localctx = new ContextContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_context);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
			case CUSTOMNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				logicalContext();
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				functionalContext();
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
		enterRule(_localctx, 4, RULE_bridgeRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			head();
			setState(109);
			match(T__0);
			setState(110);
			body();
			setState(111);
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

	public static class LogicalContextContext extends ParserRuleContext {
		public LogicalContextNameContext logicalContextName() {
			return getRuleContext(LogicalContextNameContext.class,0);
		}
		public FormulasContext formulas() {
			return getRuleContext(FormulasContext.class,0);
		}
		public LogicalContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalContext; }
	}

	public final LogicalContextContext logicalContext() throws RecognitionException {
		LogicalContextContext _localctx = new LogicalContextContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_logicalContext);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			logicalContextName();
			setState(114);
			match(T__2);
			setState(115);
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

	public static class FunctionalContextContext extends ParserRuleContext {
		public CommunicationContextContext communicationContext() {
			return getRuleContext(CommunicationContextContext.class,0);
		}
		public PlannerContextContext plannerContext() {
			return getRuleContext(PlannerContextContext.class,0);
		}
		public FunctionalContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionalContext; }
	}

	public final FunctionalContextContext functionalContext() throws RecognitionException {
		FunctionalContextContext _localctx = new FunctionalContextContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionalContext);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				communicationContext();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				plannerContext();
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

	public static class CommunicationContextContext extends ParserRuleContext {
		public List<SensorContext> sensor() {
			return getRuleContexts(SensorContext.class);
		}
		public SensorContext sensor(int i) {
			return getRuleContext(SensorContext.class,i);
		}
		public List<ActuatorContext> actuator() {
			return getRuleContexts(ActuatorContext.class);
		}
		public ActuatorContext actuator(int i) {
			return getRuleContext(ActuatorContext.class,i);
		}
		public CommunicationContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_communicationContext; }
	}

	public final CommunicationContextContext communicationContext() throws RecognitionException {
		CommunicationContextContext _localctx = new CommunicationContextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_communicationContext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__3);
			setState(122);
			match(T__2);
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(125);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
					{
					setState(123);
					sensor();
					}
					break;
				case T__13:
					{
					setState(124);
					actuator();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 || _la==T__13 );
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

	public static class PlannerContextContext extends ParserRuleContext {
		public PlansFormulasContext plansFormulas() {
			return getRuleContext(PlansFormulasContext.class,0);
		}
		public PlannerContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plannerContext; }
	}

	public final PlannerContextContext plannerContext() throws RecognitionException {
		PlannerContextContext _localctx = new PlannerContextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_plannerContext);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__4);
			setState(130);
			match(T__2);
			setState(131);
			plansFormulas();
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

	public static class LogicalContextNameContext extends ParserRuleContext {
		public PrimitiveContextNameContext primitiveContextName() {
			return getRuleContext(PrimitiveContextNameContext.class,0);
		}
		public CustomContextNameContext customContextName() {
			return getRuleContext(CustomContextNameContext.class,0);
		}
		public LogicalContextNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalContextName; }
	}

	public final LogicalContextNameContext logicalContextName() throws RecognitionException {
		LogicalContextNameContext _localctx = new LogicalContextNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_logicalContextName);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				primitiveContextName();
				}
				break;
			case CUSTOMNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
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
		public PrimitiveContextNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveContextName; }
	}

	public final PrimitiveContextNameContext primitiveContextName() throws RecognitionException {
		PrimitiveContextNameContext _localctx = new PrimitiveContextNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveContextName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
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
		public TerminalNode CUSTOMNAME() { return getToken(AgentParser.CUSTOMNAME, 0); }
		public CustomContextNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customContextName; }
	}

	public final CustomContextNameContext customContextName() throws RecognitionException {
		CustomContextNameContext _localctx = new CustomContextNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_customContextName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(CUSTOMNAME);
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
		public TerminalNode LeftParen() { return getToken(AgentParser.LeftParen, 0); }
		public SomethingToBeTrueContext somethingToBeTrue() {
			return getRuleContext(SomethingToBeTrueContext.class,0);
		}
		public CompoundActionContext compoundAction() {
			return getRuleContext(CompoundActionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AgentParser.RightParen, 0); }
		public PlanPreconditionsContext planPreconditions() {
			return getRuleContext(PlanPreconditionsContext.class,0);
		}
		public PlanPostconditionsContext planPostconditions() {
			return getRuleContext(PlanPostconditionsContext.class,0);
		}
		public CostContext cost() {
			return getRuleContext(CostContext.class,0);
		}
		public InternalOperatorContext internalOperator() {
			return getRuleContext(InternalOperatorContext.class,0);
		}
		public PlanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plan; }
	}

	public final PlanContext plan() throws RecognitionException {
		PlanContext _localctx = new PlanContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_plan);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__8);
			setState(142);
			match(LeftParen);
			setState(143);
			somethingToBeTrue();
			setState(144);
			match(T__9);
			setState(145);
			compoundAction();
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(146);
				match(T__9);
				setState(147);
				planPreconditions();
				setState(148);
				match(T__9);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) {
					{
					setState(149);
					internalOperator();
					}
				}

				setState(152);
				planPostconditions();
				}
				break;
			}
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(156);
				match(T__9);
				setState(157);
				cost();
				}
			}

			setState(160);
			match(RightParen);
			setState(161);
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
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SomethingToBeTrueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_somethingToBeTrue; }
	}

	public final SomethingToBeTrueContext somethingToBeTrue() throws RecognitionException {
		SomethingToBeTrueContext _localctx = new SomethingToBeTrueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_somethingToBeTrue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			term(0);
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

	public static class PlanPreconditionsContext extends ParserRuleContext {
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public PlanPreconditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_planPreconditions; }
	}

	public final PlanPreconditionsContext planPreconditions() throws RecognitionException {
		PlanPreconditionsContext _localctx = new PlanPreconditionsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_planPreconditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			conditions();
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

	public static class PlanPostconditionsContext extends ParserRuleContext {
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public PlanPostconditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_planPostconditions; }
	}

	public final PlanPostconditionsContext planPostconditions() throws RecognitionException {
		PlanPostconditionsContext _localctx = new PlanPostconditionsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_planPostconditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			conditions();
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

	public static class ConditionsContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditions; }
	}

	public final ConditionsContext conditions() throws RecognitionException {
		ConditionsContext _localctx = new ConditionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_conditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(169);
				match(T__10);
				}
				break;
			case T__18:
			case T__25:
			case T__26:
			case CONSTANT:
				{
				setState(170);
				term(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(AgentParser.LeftParen, 0); }
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AgentParser.RightParen, 0); }
		public ActionPreconditionsContext actionPreconditions() {
			return getRuleContext(ActionPreconditionsContext.class,0);
		}
		public ActionPostconditionsContext actionPostconditions() {
			return getRuleContext(ActionPostconditionsContext.class,0);
		}
		public CostContext cost() {
			return getRuleContext(CostContext.class,0);
		}
		public InternalOperatorContext internalOperator() {
			return getRuleContext(InternalOperatorContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__11);
			setState(174);
			match(LeftParen);
			setState(175);
			functionInvocation();
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(176);
				match(T__9);
				setState(177);
				actionPreconditions();
				setState(178);
				match(T__9);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) {
					{
					setState(179);
					internalOperator();
					}
				}

				setState(182);
				actionPostconditions();
				}
				break;
			}
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(186);
				match(T__9);
				setState(187);
				cost();
				}
			}

			setState(190);
			match(RightParen);
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

	public static class ActionPreconditionsContext extends ParserRuleContext {
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public ActionPreconditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionPreconditions; }
	}

	public final ActionPreconditionsContext actionPreconditions() throws RecognitionException {
		ActionPreconditionsContext _localctx = new ActionPreconditionsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_actionPreconditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			conditions();
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

	public static class ActionPostconditionsContext extends ParserRuleContext {
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public ActionPostconditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionPostconditions; }
	}

	public final ActionPostconditionsContext actionPostconditions() throws RecognitionException {
		ActionPostconditionsContext _localctx = new ActionPostconditionsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_actionPostconditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			conditions();
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
		public TerminalNode LeftParen() { return getToken(AgentParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(AgentParser.RightParen, 0); }
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
		enterRule(_localctx, 36, RULE_functionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			functionName();
			setState(197);
			match(LeftParen);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT || _la==VARIABLE) {
				{
				setState(198);
				argumentList();
				}
			}

			setState(201);
			match(RightParen);
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
		public TerminalNode CONSTANT() { return getToken(AgentParser.CONSTANT, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(CONSTANT);
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

	public static class SensorContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(AgentParser.LeftParen, 0); }
		public SensorIdentifierContext sensorIdentifier() {
			return getRuleContext(SensorIdentifierContext.class,0);
		}
		public SensorImplementationContext sensorImplementation() {
			return getRuleContext(SensorImplementationContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AgentParser.RightParen, 0); }
		public SensorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensor; }
	}

	public final SensorContext sensor() throws RecognitionException {
		SensorContext _localctx = new SensorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sensor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__12);
			setState(206);
			match(LeftParen);
			setState(207);
			sensorIdentifier();
			setState(208);
			match(T__9);
			setState(209);
			sensorImplementation();
			setState(210);
			match(RightParen);
			setState(211);
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

	public static class SensorIdentifierContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AgentParser.STRING, 0); }
		public SensorIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensorIdentifier; }
	}

	public final SensorIdentifierContext sensorIdentifier() throws RecognitionException {
		SensorIdentifierContext _localctx = new SensorIdentifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sensorIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(STRING);
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

	public static class SensorImplementationContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AgentParser.STRING, 0); }
		public SensorImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensorImplementation; }
	}

	public final SensorImplementationContext sensorImplementation() throws RecognitionException {
		SensorImplementationContext _localctx = new SensorImplementationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_sensorImplementation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(STRING);
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

	public static class ActuatorContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(AgentParser.LeftParen, 0); }
		public ActuatorIdentifierContext actuatorIdentifier() {
			return getRuleContext(ActuatorIdentifierContext.class,0);
		}
		public ActuatorImplementationContext actuatorImplementation() {
			return getRuleContext(ActuatorImplementationContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AgentParser.RightParen, 0); }
		public ActuatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actuator; }
	}

	public final ActuatorContext actuator() throws RecognitionException {
		ActuatorContext _localctx = new ActuatorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_actuator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__13);
			setState(218);
			match(LeftParen);
			setState(219);
			actuatorIdentifier();
			setState(220);
			match(T__9);
			setState(221);
			actuatorImplementation();
			setState(222);
			match(RightParen);
			setState(223);
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

	public static class ActuatorIdentifierContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AgentParser.STRING, 0); }
		public ActuatorIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actuatorIdentifier; }
	}

	public final ActuatorIdentifierContext actuatorIdentifier() throws RecognitionException {
		ActuatorIdentifierContext _localctx = new ActuatorIdentifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_actuatorIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(STRING);
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

	public static class ActuatorImplementationContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AgentParser.STRING, 0); }
		public ActuatorImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actuatorImplementation; }
	}

	public final ActuatorImplementationContext actuatorImplementation() throws RecognitionException {
		ActuatorImplementationContext _localctx = new ActuatorImplementationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_actuatorImplementation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(STRING);
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

	public static class InternalOperatorContext extends ParserRuleContext {
		public BeliefAditionContext beliefAdition() {
			return getRuleContext(BeliefAditionContext.class,0);
		}
		public BeliefRemotionContext beliefRemotion() {
			return getRuleContext(BeliefRemotionContext.class,0);
		}
		public DesireAditionContext desireAdition() {
			return getRuleContext(DesireAditionContext.class,0);
		}
		public InternalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_internalOperator; }
	}

	public final InternalOperatorContext internalOperator() throws RecognitionException {
		InternalOperatorContext _localctx = new InternalOperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_internalOperator);
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				beliefAdition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				beliefRemotion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				desireAdition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				desireAdition();
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

	public static class BeliefAditionContext extends ParserRuleContext {
		public BeliefAditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beliefAdition; }
	}

	public final BeliefAditionContext beliefAdition() throws RecognitionException {
		BeliefAditionContext _localctx = new BeliefAditionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_beliefAdition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__14);
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

	public static class BeliefRemotionContext extends ParserRuleContext {
		public BeliefRemotionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beliefRemotion; }
	}

	public final BeliefRemotionContext beliefRemotion() throws RecognitionException {
		BeliefRemotionContext _localctx = new BeliefRemotionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_beliefRemotion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__15);
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

	public static class DesireAditionContext extends ParserRuleContext {
		public DesireAditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desireAdition; }
	}

	public final DesireAditionContext desireAdition() throws RecognitionException {
		DesireAditionContext _localctx = new DesireAditionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_desireAdition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__16);
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

	public static class DesireRemotionContext extends ParserRuleContext {
		public DesireRemotionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desireRemotion; }
	}

	public final DesireRemotionContext desireRemotion() throws RecognitionException {
		DesireRemotionContext _localctx = new DesireRemotionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_desireRemotion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(T__17);
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
		enterRule(_localctx, 62, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			expression();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(244);
				match(T__9);
				setState(245);
				expression();
				}
				}
				setState(250);
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
		public TerminalNode CONSTANT() { return getToken(AgentParser.CONSTANT, 0); }
		public TerminalNode VARIABLE() { return getToken(AgentParser.VARIABLE, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !(_la==CONSTANT || _la==VARIABLE) ) {
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

	public static class CompoundActionContext extends ParserRuleContext {
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public CompoundActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundAction; }
	}

	public final CompoundActionContext compoundAction() throws RecognitionException {
		CompoundActionContext _localctx = new CompoundActionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_compoundAction);
		int _la;
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(253);
				match(T__18);
				setState(254);
				action();
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(255);
					match(T__9);
					setState(256);
					action();
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262);
				match(T__19);
				}
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(T__10);
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
		enterRule(_localctx, 68, RULE_plansFormulas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==T__11) {
				{
				{
				setState(269);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(267);
					plan();
					}
					break;
				case T__11:
					{
					setState(268);
					action();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(275);
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

	public static class ContextNameContext extends ParserRuleContext {
		public LogicalContextNameContext logicalContextName() {
			return getRuleContext(LogicalContextNameContext.class,0);
		}
		public ContextNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextName; }
	}

	public final ContextNameContext contextName() throws RecognitionException {
		ContextNameContext _localctx = new ContextNameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_contextName);
		try {
			setState(279);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
			case CUSTOMNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				logicalContextName();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				match(T__4);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
				match(T__3);
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

	public static class HeadContext extends ParserRuleContext {
		public ContextNameContext contextName() {
			return getRuleContext(ContextNameContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(AgentParser.VARIABLE, 0); }
		public List<NegationContext> negation() {
			return getRuleContexts(NegationContext.class);
		}
		public NegationContext negation(int i) {
			return getRuleContext(NegationContext.class,i);
		}
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(T__20);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25 || _la==T__26) {
				{
				setState(282);
				negation();
				}
			}

			setState(285);
			contextName();
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(286);
				term(0);
				}
				break;
			case 2:
				{
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==T__26) {
					{
					setState(287);
					negation();
					}
				}

				setState(290);
				match(VARIABLE);
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
		public List<PlanContext> plan() {
			return getRuleContexts(PlanContext.class);
		}
		public PlanContext plan(int i) {
			return getRuleContext(PlanContext.class,i);
		}
		public List<NegationContext> negation() {
			return getRuleContexts(NegationContext.class);
		}
		public NegationContext negation(int i) {
			return getRuleContext(NegationContext.class,i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(AgentParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(AgentParser.VARIABLE, i);
		}
		public List<TerminalNode> AND() { return getTokens(AgentParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(AgentParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(AgentParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(AgentParser.OR, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25 || _la==T__26) {
				{
				setState(293);
				negation();
				}
			}

			setState(296);
			contextName();
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__25:
			case T__26:
			case CONSTANT:
			case VARIABLE:
				{
				setState(302);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(297);
					term(0);
					}
					break;
				case 2:
					{
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__25 || _la==T__26) {
						{
						setState(298);
						negation();
						}
					}

					setState(301);
					match(VARIABLE);
					}
					break;
				}
				}
				break;
			case T__8:
				{
				setState(304);
				plan();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(307);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==T__26) {
					{
					setState(308);
					negation();
					}
				}

				setState(311);
				contextName();
				setState(320);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__18:
				case T__25:
				case T__26:
				case CONSTANT:
				case VARIABLE:
					{
					setState(317);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						setState(312);
						term(0);
						}
						break;
					case 2:
						{
						setState(314);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__25 || _la==T__26) {
							{
							setState(313);
							negation();
							}
						}

						setState(316);
						match(VARIABLE);
						}
						break;
					}
					}
					break;
				case T__8:
					{
					setState(319);
					plan();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(326);
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

	public static class TermContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(AgentParser.CONSTANT, 0); }
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(AgentParser.LeftParen, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(AgentParser.RightParen, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode AND() { return getToken(AgentParser.AND, 0); }
		public TerminalNode OR() { return getToken(AgentParser.OR, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
			case CONSTANT:
				{
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==T__26) {
					{
					setState(328);
					negation();
					}
				}

				setState(331);
				match(CONSTANT);
				setState(347);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(332);
					annotation();
					}
					break;
				case 2:
					{
					{
					setState(333);
					match(LeftParen);
					setState(334);
					atom();
					setState(339);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__9) {
						{
						{
						setState(335);
						match(T__9);
						setState(336);
						atom();
						}
						}
						setState(341);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(342);
					match(RightParen);
					}
					setState(345);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						setState(344);
						annotation();
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case T__18:
				{
				{
				setState(349);
				match(T__18);
				setState(350);
				term(0);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(351);
					match(T__9);
					setState(352);
					term(0);
					}
					}
					setState(357);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(358);
				match(T__19);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(370);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(368);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(362);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(363);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(364);
						term(4);
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(365);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(366);
						match(T__0);
						setState(367);
						term(2);
						}
						break;
					}
					} 
				}
				setState(372);
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

	public static class FormulasContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public FormulasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulas; }
	}

	public final FormulasContext formulas() throws RecognitionException {
		FormulasContext _localctx = new FormulasContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_formulas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__25) | (1L << T__26) | (1L << CONSTANT))) != 0)) {
				{
				{
				setState(373);
				term(0);
				setState(374);
				match(T__1);
				}
				}
				setState(380);
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

	public static class AtomContext extends ParserRuleContext {
		public List<TerminalNode> NUMERAL() { return getTokens(AgentParser.NUMERAL); }
		public TerminalNode NUMERAL(int i) {
			return getToken(AgentParser.NUMERAL, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(AgentParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(AgentParser.CONSTANT, i);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(AgentParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(AgentParser.VARIABLE, i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << NUMERAL) | (1L << CONSTANT) | (1L << VARIABLE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) {
				{
				setState(382);
				operator();
				setState(383);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << NUMERAL) | (1L << CONSTANT) | (1L << VARIABLE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
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

	public static class NegationContext extends ParserRuleContext {
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_negation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
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

	public static class AnnotationContext extends ParserRuleContext {
		public PreActionContext preAction() {
			return getRuleContext(PreActionContext.class,0);
		}
		public GradedValueContext gradedValue() {
			return getRuleContext(GradedValueContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_annotation);
		try {
			setState(396);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(391);
				preAction();
				setState(393);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(392);
					gradedValue();
					}
					break;
				}
				}
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				gradedValue();
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

	public static class PreActionContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(AgentParser.CONSTANT, 0); }
		public PreActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preAction; }
	}

	public final PreActionContext preAction() throws RecognitionException {
		PreActionContext _localctx = new PreActionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_preAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(T__18);
			setState(399);
			match(CONSTANT);
			setState(400);
			match(T__19);
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

	public static class GradedValueContext extends ParserRuleContext {
		public TerminalNode NUMERAL() { return getToken(AgentParser.NUMERAL, 0); }
		public GradedValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gradedValue; }
	}

	public final GradedValueContext gradedValue() throws RecognitionException {
		GradedValueContext _localctx = new GradedValueContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_gradedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(T__27);
			setState(403);
			match(NUMERAL);
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

	public static class CostContext extends ParserRuleContext {
		public TerminalNode NUMERAL() { return getToken(AgentParser.NUMERAL, 0); }
		public CostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cost; }
	}

	public final CostContext cost() throws RecognitionException {
		CostContext _localctx = new CostContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_cost);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			match(T__28);
			setState(406);
			match(NUMERAL);
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
		case 38:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u019b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\7\2d\n\2\f\2\16\2g\13\2\3"+
		"\2\3\2\3\3\3\3\5\3m\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\5"+
		"\6z\n\6\3\7\3\7\3\7\3\7\6\7\u0080\n\7\r\7\16\7\u0081\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\5\t\u008a\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u0099\n\f\3\f\3\f\5\f\u009d\n\f\3\f\3\f\5\f\u00a1\n\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u00ae\n\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\5\21\u00b7\n\21\3\21\3\21\5\21\u00bb\n\21\3\21"+
		"\3\21\5\21\u00bf\n\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\5\24"+
		"\u00ca\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\5\34\u00ec\n\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3!\7!\u00f9\n!\f!\16!\u00fc\13!\3\"\3\"\3#\3#\3#\3#"+
		"\7#\u0104\n#\f#\16#\u0107\13#\3#\3#\3#\5#\u010c\n#\3$\3$\5$\u0110\n$\7"+
		"$\u0112\n$\f$\16$\u0115\13$\3%\3%\3%\5%\u011a\n%\3&\3&\5&\u011e\n&\3&"+
		"\3&\3&\5&\u0123\n&\3&\5&\u0126\n&\3\'\5\'\u0129\n\'\3\'\3\'\3\'\5\'\u012e"+
		"\n\'\3\'\5\'\u0131\n\'\3\'\5\'\u0134\n\'\3\'\3\'\5\'\u0138\n\'\3\'\3\'"+
		"\3\'\5\'\u013d\n\'\3\'\5\'\u0140\n\'\3\'\5\'\u0143\n\'\7\'\u0145\n\'\f"+
		"\'\16\'\u0148\13\'\3(\3(\5(\u014c\n(\3(\3(\3(\3(\3(\3(\7(\u0154\n(\f("+
		"\16(\u0157\13(\3(\3(\3(\5(\u015c\n(\5(\u015e\n(\3(\3(\3(\3(\7(\u0164\n"+
		"(\f(\16(\u0167\13(\3(\3(\5(\u016b\n(\3(\3(\3(\3(\3(\3(\7(\u0173\n(\f("+
		"\16(\u0176\13(\3)\3)\3)\7)\u017b\n)\f)\16)\u017e\13)\3*\3*\3*\3*\5*\u0184"+
		"\n*\3+\3+\3,\3,\3-\3-\5-\u018c\n-\3-\5-\u018f\n-\3.\3.\3.\3.\3/\3/\3/"+
		"\3\60\3\60\3\60\3\60\2\3N\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\b\3\2\b\n\3\2\"#\3\2$%\4\2\r"+
		"\r!#\4\2\21\22\30\33\3\2\34\35\2\u019d\2`\3\2\2\2\4l\3\2\2\2\6n\3\2\2"+
		"\2\bs\3\2\2\2\ny\3\2\2\2\f{\3\2\2\2\16\u0083\3\2\2\2\20\u0089\3\2\2\2"+
		"\22\u008b\3\2\2\2\24\u008d\3\2\2\2\26\u008f\3\2\2\2\30\u00a5\3\2\2\2\32"+
		"\u00a7\3\2\2\2\34\u00a9\3\2\2\2\36\u00ad\3\2\2\2 \u00af\3\2\2\2\"\u00c2"+
		"\3\2\2\2$\u00c4\3\2\2\2&\u00c6\3\2\2\2(\u00cd\3\2\2\2*\u00cf\3\2\2\2,"+
		"\u00d7\3\2\2\2.\u00d9\3\2\2\2\60\u00db\3\2\2\2\62\u00e3\3\2\2\2\64\u00e5"+
		"\3\2\2\2\66\u00eb\3\2\2\28\u00ed\3\2\2\2:\u00ef\3\2\2\2<\u00f1\3\2\2\2"+
		">\u00f3\3\2\2\2@\u00f5\3\2\2\2B\u00fd\3\2\2\2D\u010b\3\2\2\2F\u0113\3"+
		"\2\2\2H\u0119\3\2\2\2J\u011b\3\2\2\2L\u0128\3\2\2\2N\u016a\3\2\2\2P\u017c"+
		"\3\2\2\2R\u017f\3\2\2\2T\u0185\3\2\2\2V\u0187\3\2\2\2X\u018e\3\2\2\2Z"+
		"\u0190\3\2\2\2\\\u0194\3\2\2\2^\u0197\3\2\2\2`e\5\f\7\2ad\5\4\3\2bd\5"+
		"\6\4\2ca\3\2\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3"+
		"\2\2\2hi\7\2\2\3i\3\3\2\2\2jm\5\b\5\2km\5\n\6\2lj\3\2\2\2lk\3\2\2\2m\5"+
		"\3\2\2\2no\5J&\2op\7\3\2\2pq\5L\'\2qr\7\4\2\2r\7\3\2\2\2st\5\20\t\2tu"+
		"\7\5\2\2uv\5P)\2v\t\3\2\2\2wz\5\f\7\2xz\5\16\b\2yw\3\2\2\2yx\3\2\2\2z"+
		"\13\3\2\2\2{|\7\6\2\2|\177\7\5\2\2}\u0080\5*\26\2~\u0080\5\60\31\2\177"+
		"}\3\2\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\r\3\2\2\2\u0083\u0084\7\7\2\2\u0084\u0085\7\5\2\2\u0085"+
		"\u0086\5F$\2\u0086\17\3\2\2\2\u0087\u008a\5\22\n\2\u0088\u008a\5\24\13"+
		"\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\21\3\2\2\2\u008b\u008c"+
		"\t\2\2\2\u008c\23\3\2\2\2\u008d\u008e\7 \2\2\u008e\25\3\2\2\2\u008f\u0090"+
		"\7\13\2\2\u0090\u0091\7&\2\2\u0091\u0092\5\30\r\2\u0092\u0093\7\f\2\2"+
		"\u0093\u009c\5D#\2\u0094\u0095\7\f\2\2\u0095\u0096\5\32\16\2\u0096\u0098"+
		"\7\f\2\2\u0097\u0099\5\66\34\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009b\5\34\17\2\u009b\u009d\3\2\2\2\u009c\u0094"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009f\7\f\2\2\u009f"+
		"\u00a1\5^\60\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a3\7\'\2\2\u00a3\u00a4\7\4\2\2\u00a4\27\3\2\2\2\u00a5\u00a6"+
		"\5N(\2\u00a6\31\3\2\2\2\u00a7\u00a8\5\36\20\2\u00a8\33\3\2\2\2\u00a9\u00aa"+
		"\5\36\20\2\u00aa\35\3\2\2\2\u00ab\u00ae\7\r\2\2\u00ac\u00ae\5N(\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\37\3\2\2\2\u00af\u00b0\7\16\2"+
		"\2\u00b0\u00b1\7&\2\2\u00b1\u00ba\5&\24\2\u00b2\u00b3\7\f\2\2\u00b3\u00b4"+
		"\5\"\22\2\u00b4\u00b6\7\f\2\2\u00b5\u00b7\5\66\34\2\u00b6\u00b5\3\2\2"+
		"\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\5$\23\2\u00b9\u00bb"+
		"\3\2\2\2\u00ba\u00b2\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00bd\7\f\2\2\u00bd\u00bf\5^\60\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\'\2\2\u00c1!\3\2\2\2\u00c2\u00c3"+
		"\5\36\20\2\u00c3#\3\2\2\2\u00c4\u00c5\5\36\20\2\u00c5%\3\2\2\2\u00c6\u00c7"+
		"\5(\25\2\u00c7\u00c9\7&\2\2\u00c8\u00ca\5@!\2\u00c9\u00c8\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\7\'\2\2\u00cc\'\3\2\2\2"+
		"\u00cd\u00ce\7\"\2\2\u00ce)\3\2\2\2\u00cf\u00d0\7\17\2\2\u00d0\u00d1\7"+
		"&\2\2\u00d1\u00d2\5,\27\2\u00d2\u00d3\7\f\2\2\u00d3\u00d4\5.\30\2\u00d4"+
		"\u00d5\7\'\2\2\u00d5\u00d6\7\4\2\2\u00d6+\3\2\2\2\u00d7\u00d8\7(\2\2\u00d8"+
		"-\3\2\2\2\u00d9\u00da\7(\2\2\u00da/\3\2\2\2\u00db\u00dc\7\20\2\2\u00dc"+
		"\u00dd\7&\2\2\u00dd\u00de\5\62\32\2\u00de\u00df\7\f\2\2\u00df\u00e0\5"+
		"\64\33\2\u00e0\u00e1\7\'\2\2\u00e1\u00e2\7\4\2\2\u00e2\61\3\2\2\2\u00e3"+
		"\u00e4\7(\2\2\u00e4\63\3\2\2\2\u00e5\u00e6\7(\2\2\u00e6\65\3\2\2\2\u00e7"+
		"\u00ec\58\35\2\u00e8\u00ec\5:\36\2\u00e9\u00ec\5<\37\2\u00ea\u00ec\5<"+
		"\37\2\u00eb\u00e7\3\2\2\2\u00eb\u00e8\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ea\3\2\2\2\u00ec\67\3\2\2\2\u00ed\u00ee\7\21\2\2\u00ee9\3\2\2\2\u00ef"+
		"\u00f0\7\22\2\2\u00f0;\3\2\2\2\u00f1\u00f2\7\23\2\2\u00f2=\3\2\2\2\u00f3"+
		"\u00f4\7\24\2\2\u00f4?\3\2\2\2\u00f5\u00fa\5B\"\2\u00f6\u00f7\7\f\2\2"+
		"\u00f7\u00f9\5B\"\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fbA\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00fe\t\3\2\2\u00feC\3\2\2\2\u00ff\u0100\7\25\2\2\u0100\u0105\5 \21\2"+
		"\u0101\u0102\7\f\2\2\u0102\u0104\5 \21\2\u0103\u0101\3\2\2\2\u0104\u0107"+
		"\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0108\u0109\7\26\2\2\u0109\u010c\3\2\2\2\u010a\u010c\7"+
		"\r\2\2\u010b\u00ff\3\2\2\2\u010b\u010a\3\2\2\2\u010cE\3\2\2\2\u010d\u0110"+
		"\5\26\f\2\u010e\u0110\5 \21\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2"+
		"\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u0114G\3\2\2\2\u0115\u0113\3\2\2\2\u0116"+
		"\u011a\5\20\t\2\u0117\u011a\7\7\2\2\u0118\u011a\7\6\2\2\u0119\u0116\3"+
		"\2\2\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011aI\3\2\2\2\u011b\u011d"+
		"\7\27\2\2\u011c\u011e\5V,\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0125\5H%\2\u0120\u0126\5N(\2\u0121\u0123\5V,\2\u0122"+
		"\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\7#"+
		"\2\2\u0125\u0120\3\2\2\2\u0125\u0122\3\2\2\2\u0126K\3\2\2\2\u0127\u0129"+
		"\5V,\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u0133\5H%\2\u012b\u0131\5N(\2\u012c\u012e\5V,\2\u012d\u012c\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\7#\2\2\u0130\u012b\3\2"+
		"\2\2\u0130\u012d\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0134\5\26\f\2\u0133"+
		"\u0130\3\2\2\2\u0133\u0132\3\2\2\2\u0134\u0146\3\2\2\2\u0135\u0137\t\4"+
		"\2\2\u0136\u0138\5V,\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139"+
		"\3\2\2\2\u0139\u0142\5H%\2\u013a\u0140\5N(\2\u013b\u013d\5V,\2\u013c\u013b"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140\7#\2\2\u013f"+
		"\u013a\3\2\2\2\u013f\u013c\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u0143\5\26"+
		"\f\2\u0142\u013f\3\2\2\2\u0142\u0141\3\2\2\2\u0143\u0145\3\2\2\2\u0144"+
		"\u0135\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2"+
		"\2\2\u0147M\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014b\b(\1\2\u014a\u014c"+
		"\5V,\2\u014b\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u015d\7\"\2\2\u014e\u015e\5X-\2\u014f\u0150\7&\2\2\u0150\u0155\5R*\2"+
		"\u0151\u0152\7\f\2\2\u0152\u0154\5R*\2\u0153\u0151\3\2\2\2\u0154\u0157"+
		"\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157"+
		"\u0155\3\2\2\2\u0158\u0159\7\'\2\2\u0159\u015b\3\2\2\2\u015a\u015c\5X"+
		"-\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d"+
		"\u014e\3\2\2\2\u015d\u014f\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u016b\3\2"+
		"\2\2\u015f\u0160\7\25\2\2\u0160\u0165\5N(\2\u0161\u0162\7\f\2\2\u0162"+
		"\u0164\5N(\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2"+
		"\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169"+
		"\7\26\2\2\u0169\u016b\3\2\2\2\u016a\u0149\3\2\2\2\u016a\u015f\3\2\2\2"+
		"\u016b\u0174\3\2\2\2\u016c\u016d\f\5\2\2\u016d\u016e\t\4\2\2\u016e\u0173"+
		"\5N(\6\u016f\u0170\f\3\2\2\u0170\u0171\7\3\2\2\u0171\u0173\5N(\4\u0172"+
		"\u016c\3\2\2\2\u0172\u016f\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0174\u0175\3\2\2\2\u0175O\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178"+
		"\5N(\2\u0178\u0179\7\4\2\2\u0179\u017b\3\2\2\2\u017a\u0177\3\2\2\2\u017b"+
		"\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017dQ\3\2\2\2"+
		"\u017e\u017c\3\2\2\2\u017f\u0183\t\5\2\2\u0180\u0181\5T+\2\u0181\u0182"+
		"\t\5\2\2\u0182\u0184\3\2\2\2\u0183\u0180\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"S\3\2\2\2\u0185\u0186\t\6\2\2\u0186U\3\2\2\2\u0187\u0188\t\7\2\2\u0188"+
		"W\3\2\2\2\u0189\u018b\5Z.\2\u018a\u018c\5\\/\2\u018b\u018a\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018f\5\\/\2\u018e\u0189\3\2"+
		"\2\2\u018e\u018d\3\2\2\2\u018fY\3\2\2\2\u0190\u0191\7\25\2\2\u0191\u0192"+
		"\7\"\2\2\u0192\u0193\7\26\2\2\u0193[\3\2\2\2\u0194\u0195\7\36\2\2\u0195"+
		"\u0196\7!\2\2\u0196]\3\2\2\2\u0197\u0198\7\37\2\2\u0198\u0199\7!\2\2\u0199"+
		"_\3\2\2\2\60cely\177\u0081\u0089\u0098\u009c\u00a0\u00ad\u00b6\u00ba\u00be"+
		"\u00c9\u00eb\u00fa\u0105\u010b\u010f\u0113\u0119\u011d\u0122\u0125\u0128"+
		"\u012d\u0130\u0133\u0137\u013c\u013f\u0142\u0146\u014b\u0155\u015b\u015d"+
		"\u0165\u016a\u0172\u0174\u017c\u0183\u018b\u018e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}