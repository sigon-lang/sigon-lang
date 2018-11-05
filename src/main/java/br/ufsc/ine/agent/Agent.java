package br.ufsc.ine.agent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.stream.Collectors;

import agent.AgentParser.BodyContext;
import agent.AgentParser.HeadContext;
import alice.tuprolog.InvalidTheoryException;
import br.ufsc.ine.agent.bridgerules.BridgeRulesService;
import br.ufsc.ine.agent.bridgerules.Head;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.Actuator;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.communication.Sensor;
import br.ufsc.ine.agent.context.custom.CustomContext;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import br.ufsc.ine.negotiation.NegotiationContextService;
import br.ufsc.ine.parser.AgentWalker;
import rx.Observable;

public class Agent {

	private static final String DESIRES = "desires";
	private static final String BELIEFS = "beliefs";
	private static final String INTENTIONS = "intentions";
	private List<Sensor> sensors = new ArrayList<>();
	private List<Actuator> actuators = new ArrayList<>();
	public static boolean removeBelief = false;
	private String profilingFile;
	// TODO: Profiling true
	private boolean doProfiling = false;
	private CustomContext[] customContexts;

	public void run(AgentWalker walker, CustomContext[] contexts) {
		this.customContexts = contexts;
		this.initAgent(walker);
		this.subscribeSensors();
		this.startSensors();
		CommunicationContextService.getInstance().actuators(this.actuators);
	}

	public void run(AgentWalker walker, ContextService[] contexts) {

		initCustomClauses(walker, contexts);
		this.initAgent(walker);
		this.subscribeSensors();
		this.startSensors();
		CommunicationContextService.getInstance().actuators(this.actuators);
	}

	public void initCustomClauses(AgentWalker walker, ContextService[] contexts) {

		for (ContextService contextService : contexts) {
			List<LangContext> langCustom = getContext(walker, contextService.getName());
			for (LangContext langContext : langCustom) {
				//langContext.setName(langContext.getName().replaceAll("_", ""));
				for (String clause : langContext.getClauses()) {
					contextService.appendFact(clause);
				}

			}

			BridgeRulesService.getInstance().addCustomContext(contextService);
		}
	}

	private void subscribeSensors() {
		List<Observable<String>> observables = this.sensors.stream().map(s -> s.getPublisher())
				.collect(Collectors.toList());
		observables.forEach(
				stringObservable -> 
					stringObservable.subscribe(this::bdiAlgorithmCycle, Throwable::printStackTrace)					
		);

	}

	long cycles = 0;

	private synchronized void bdiAlgorithmCycle(String literal) {
		if (literal.startsWith("-")) {
			literal = literal.replace("-", "").trim();
			removeBelief = true;
		} else if (literal.startsWith("not")) {
			literal = literal.replace(" ", "");
			literal = literal.replace("not", "\\+").trim();
		}
		cycles++;
		long startTime = System.nanoTime();

		CommunicationContextService.getInstance().appendFact(this.getSense(literal));
		executeBridgeRules();
		BridgeRulesService.getInstance().executeBdiRules();
		PlansContextService.getInstance().executePlanAlgorithm();
		if (doProfiling)
			profiling(startTime);
	}

	private synchronized void executeBridgeRules() {
		rules.forEach((head, body) -> {
			BridgeRulesService.getInstance().createBridgeRule(head, body);

		}

		);
	}

	private void profiling(long startTime) {
		if (profilingFile != null) {
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(profilingFile, true));
				writer.append(cycles + ";" + duration + System.lineSeparator());
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String getSense(String literal) {
		return "sense(" + literal.substring(0, literal.length() - 1) + ").";
	}

	private void startSensors() {
		this.sensors.stream().forEach(s -> {
			Thread sensorThread = new Thread(s);
			sensorThread.start();
		});
	}

	private void initAgent(AgentWalker walker) {

		List<LangContext> desires = getContext(walker, DESIRES);
		List<LangContext> beliefs = getContext(walker, BELIEFS);
		List<LangContext> intentions = getContext(walker, INTENTIONS);

		walker.getLangActuators().forEach(a -> {
			try {
				Class<?> clazz = Class.forName(a.getImplementation());
				Constructor<?> ctor = clazz.getConstructor();
				Actuator actuator = (Actuator) ctor.newInstance();
				actuator.setName(a.getIdentifier());
				actuators.add(actuator);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: implementar log
			}
		});

		walker.getLangSensors().stream().map(s -> s.getImplementation()).forEach(implementation -> {
			try {
				Class<?> clazz = Class.forName(implementation);
				Constructor<?> ctor = clazz.getConstructor();
				Sensor sensor = (Sensor) ctor.newInstance();
				sensors.add(sensor);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: implementar log
			}

		});

		BeliefsContextService.getInstance().beliefs(beliefs);
		DesiresContextService.getInstance().desires(desires);
		IntentionsContextService.getInstance().intentions(intentions);
		PlansContextService.getInstance().plans(walker.getPlans());
		PlansContextService.getInstance().plansClauses(walker.getPlansClauses());
		if (this.customContexts != null)
			for (CustomContext context : this.customContexts) {
				// BridgeRulesService.getInstance().addCustomContext(context);
			}

		walker.getBridgeRules().forEach(a -> {
			// BridgeRulesService.getInstance().createBridgeRule(a.head(), a.body());
			rules.put(a.head(), a.body());

		}

		);

		// BridgeRulesService.getInstance().rules(walker.getBridgeRules());

	}

	private HashMap<HeadContext, BodyContext> rules = new HashMap<>();

	private List<LangContext> getContext(AgentWalker walker, String context) {		
		return walker.getLangContexts().stream().filter(c -> c.getName().equals(context)).collect(Collectors.toList());
	}

	public void setProfilingFile(String profilingFile) {
		this.profilingFile = profilingFile;
	}
}
