package br.ufsc.ine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import br.ufsc.ine.agent.bridgerules.Body;
import br.ufsc.ine.agent.bridgerules.BridgeRule;
import br.ufsc.ine.agent.bridgerules.Head;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;

public class TesteRegras {

 	private static String profilingFile = "/home/valdirluiz/Documents/resultado-regras/100-0-regra2.csv";
	private static long cycles = 0;

	static PlansContextService plansContext = PlansContextService.getInstance();
	static DesiresContextService desiresContext = DesiresContextService.getInstance();
	static CommunicationContextService communicationContext = CommunicationContextService.getInstance();
	static BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
	static IntentionsContextService intentionContext = IntentionsContextService.getInstance();

	public static void main(String[] args) {
 
		beliefsContext.appendFact("approaching(car).");
		plansContext.appendFact("plan(be(safe),_,[approaching(_),(\\+ approaching(_))],_).");
		plansContext.appendFact("plan(solve(game),_,[(\\+ approaching(_)),approaching(_)],_).");

		desiresContext.appendFact("be(safe).");
		desiresContext.appendFact("solve(game).");

		intentionContext.appendFact("be(safe).");
		intentionContext.appendFact("solve(game).");

		try (Stream<String> stream = Files.lines(Paths.get("/home/valdirluiz/Documents/resultado-regras/100-0"))) {

			stream.forEach(line -> {
				addSense(line);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static synchronized void addSense(String sense) {
		cycles++;
		communicationContext.appendFact(sense);

		long startTime = System.nanoTime();
		regra2().execute();
		long endTime = System.nanoTime();
		profiling(startTime, endTime);
	}

	private static void profiling(long startTime, long endTime) {
		if (profilingFile != null) {

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

	private static BridgeRule regra1() {
		Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
		Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
		Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
		Body desires = Body.builder().context(intentionContext).clause("Y").build();
		body.setAnd(plan);
		plan.setAnd(planMember);
		planMember.setAnd(desires);
		BridgeRule r1 = BridgeRule.builder().head(Head.builder().context(beliefsContext).clause("X").build()).body(body)
				.build();
		r1.execute();
		return r1;
	}

	private static BridgeRule regra2() {

		Body body = Body.builder().context(communicationContext).clause("sense(X)").build();

		BridgeRule r1 = BridgeRule.builder().head(Head.builder().context(beliefsContext).clause("X").build()).body(body)
				.build();
		return r1;
	}

}
