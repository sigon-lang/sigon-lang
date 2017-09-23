package br.ufsc.ine.agent;

import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.beliefs.BeliefsContext;
import br.ufsc.ine.context.desires.DesiresContext;
import br.ufsc.ine.context.intentions.IntentionsContext;
import br.ufsc.ine.environment.Environment;
import br.ufsc.ine.environment.FileEnvironment;
import br.ufsc.ine.parser.ContextWalker;
import br.ufsc.ine.parser.PlanWalker;
import io.reactivex.Flowable;
import rx.Observable;

public class Agent {

	private static final String DESIRES = "desires";
	private static final String BELIEFS = "beliefs";
	private Environment environment;
	
	public Agent() {
		BeliefsContext.startService();
		DesiresContext.startService();
		IntentionsContext.startService();
		
		//TODO: permitir que o usuário possa definir seu proprio ambiente
		environment = new FileEnvironment();
	}

	public void run(ContextWalker walker, PlanWalker planWalker) {
		this.initFlow(walker);
		Observable<String> observable = environment.observe();
		
		//TODO: add no contexto de crenças
		observable.subscribe(System.out::println);
	}

	private void initFlow(ContextWalker walker) {
		
		List<Context> desires = getContext(walker, DESIRES);
		List<Context> beliefs = getContext(walker, BELIEFS);
		
		BeliefsContext.getInstance().beliefs(beliefs);
		DesiresContext.getInstance().desires(desires);
		 
		Flowable
		.just(desires)
		.subscribe(IntentionsContext.getInstance()::checkIntentions);
	}

	private List<Context> getContext(ContextWalker walker, String context) {
		return walker.getContexts().stream().filter(c -> c.getName().equals(context)).collect(Collectors.toList());
	}

}
