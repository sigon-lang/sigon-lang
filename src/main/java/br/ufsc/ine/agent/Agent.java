package br.ufsc.ine.agent;

import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.ine.agent.flow.BeliefsHandler;
import br.ufsc.ine.agent.flow.ContextHandler;
import br.ufsc.ine.agent.flow.DesiresHandler;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.beliefs.BeliefsContext;
import br.ufsc.ine.context.desires.DesiresContext;
import br.ufsc.ine.context.intentions.IntentionsContext;
import br.ufsc.ine.environment.Environment;
import br.ufsc.ine.environment.FileEnvironment;
import br.ufsc.ine.parser.ContextWalker;
import br.ufsc.ine.parser.PlanWalker;
import rx.Observable;

public class Agent {

	private static final String DESIRES = "desires";
	private static final String BELIEFS = "beliefs";
	private Environment environment;

	public Agent() {
		BeliefsContext.startService();
		DesiresContext.startService();
		IntentionsContext.startService();

		// TODO: permitir que o usuário possa definir seu proprio ambiente
		environment = new FileEnvironment();
		
		environment.init();
	}

	public void run(ContextWalker walker, PlanWalker planWalker) {

		this.initAgent(walker);
		List<Observable<String>> sensors = environment.getSensors();

		ContextHandler desiresHandler = new DesiresHandler();
		ContextHandler beliefsHandler = new BeliefsHandler();

		desiresHandler.setSuccessor(beliefsHandler);

		sensors.stream().forEach(sensor -> {

			sensor.
				subscribe(desiresHandler::handleRequest, Throwable::printStackTrace);
		});

	}

	 

	private void initAgent(ContextWalker walker) {

		List<Context> desires = getContext(walker, DESIRES);
		List<Context> beliefs = getContext(walker, BELIEFS);

		BeliefsContext.getInstance().beliefs(beliefs);
		DesiresContext.getInstance().desires(desires);

		// Flowable
		// .just(desires)
		// .subscribe(IntentionsContext.getInstance()::checkIntentions);
	}

	private List<Context> getContext(ContextWalker walker, String context) {
		return walker.getContexts().stream().filter(c -> c.getName().equals(context)).collect(Collectors.toList());
	}

}
