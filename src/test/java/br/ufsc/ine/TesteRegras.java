package br.ufsc.ine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ibm.icu.text.SimpleDateFormat;

import br.ufsc.ine.agent.bridgerules.Body;
import br.ufsc.ine.agent.bridgerules.BridgeRule;
import br.ufsc.ine.agent.bridgerules.Head;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;

public class TesteRegras {

	private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	private static String profilingFile;
	private static long cycles = 0;

	static PlansContextService plansContext = PlansContextService.getInstance();
	static DesiresContextService desiresContext = DesiresContextService.getInstance();
	static CommunicationContextService communicationContext = CommunicationContextService.getInstance();
	static BeliefsContextService beliefsContext = BeliefsContextService.getInstance();

	public static void main(String[] args) {

		profilingFile = "/home/valdirluiz/Documents/resultado-regras/regra1.csv";

		plansContext.appendFact("plan(be(safe),_,[approaching(_),(\\+ approaching(_))],_).");
		plansContext.appendFact("plan(solve(game),_,[(\\+ approaching(_)),approaching(_)],_).");
		desiresContext.appendFact("be(safe).");
		desiresContext.appendFact("solve(game).");

		executorService.scheduleWithFixedDelay(approaching(), 0, 300, TimeUnit.MILLISECONDS);
		executorService.scheduleWithFixedDelay(time(), 0, 10, TimeUnit.MILLISECONDS);

	}

	protected static Runnable time() {
		return () -> {
			SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
			String time = sdf.format(new Date());
			addSense("sense(time" + time + ").");
		};
	}

	protected static Runnable approaching() {
		return () -> {
			addSense("sense(approaching(car)).");
		};
	}

	private static synchronized void addSense(String sense) {
		cycles++;
		long startTime = System.nanoTime();
		communicationContext.appendFact(sense);
		regra1().execute();
		profiling(startTime);
	}

	private static void profiling(long startTime) {
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

	private static BridgeRule regra1() {
		Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
		Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
		Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
		Body desires = Body.builder().context(desiresContext).clause("Y").build();
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
