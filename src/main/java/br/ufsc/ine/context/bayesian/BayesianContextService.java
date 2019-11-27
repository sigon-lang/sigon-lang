package br.ufsc.ine.context.bayesian;

import java.util.ArrayList;
import java.util.List;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;
import norsys.netica.Environ;
import norsys.netica.Net;
import norsys.netica.Streamer;
import norsys.neticaEx.aliases.Node;

public class BayesianContextService implements ContextService {

	private static BayesianContextService instance = new BayesianContextService();
	private List<String> beliefs = new ArrayList<String>();

	@Override
	public Theory getTheory() {
		// TODO Auto-generated method stub
		return null;
	}

	public static BayesianContextService getInstance() {
		return instance;
	}

	@Override
	public boolean verify(String fact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void appendFact(String fact) {
		beliefs.add(fact);

	}

	@Override
	public void addInitialFact(String fact) throws InvalidTheoryException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {

		return "BaeyesianContext";
	}

	public static double getBeliefValue() {

		return 0.0;

	}

	/*
	 * TODO: 1- Parametrizar o método 2- Definir como integrar com o ciclo de
	 * raciocinio 3- Integrar com o ciclo e definir como será feita a saída
	 */
	public static boolean queryAwareNode() {
		try {

			Node.setConstructorClass("norsys.neticaEx.aliases.Node");
			Environ env = new Environ(null);

			Net net = new Net();
			net.setName("Awareness");

			Node isAware = new Node("IsAware", "yes,no", net);
			Node carComming = new Node("CarComming", "present,absent", net);
			Node listeningMusic = new Node("ListeningMusic", "yes,no", net);
			Node distraction = new Node("Distraction", "present,absent", net);

			isAware.setTitle("Is aware of a vehicle");

			carComming.addLink(isAware); // link from visitAsia to tuberculosis
			listeningMusic.addLink(isAware); // link from visitAsia to tuberculosis
			distraction.addLink(isAware); // link from visitAsia to tuberculosis

			// isAware.setKind (Node.DECISION_NODE);
			isAware.setCPTable(0.01, 0.99);

			// isAware yes no
			carComming.setCPTable("yes", 0.05, 0.95);
			carComming.setCPTable("no", 0.01, 0.99);

			// isAware yes no
			listeningMusic.setCPTable("yes", 0.05, 0.95);
			listeningMusic.setCPTable("no", 0.01, 0.99);

			// isAware yes no
			distraction.setCPTable("yes", 0.05, 0.95);
			distraction.setCPTable("no", 0.01, 0.99);

			carComming.finding().enterState("present");
			distraction.finding().enterState("present");
			net.compile();

			double belief = isAware.getBelief("yes");
			System.out.println("\nThe probability of being aware is " + belief);
			if (belief - BayesianContextService.getBeliefValue() > 0.0) {
				BayesianContextService.getInstance().beliefs.add("aware");
				return true;

			}

			Streamer stream = new Streamer("data/awareness.dne");
			net.write(stream);

			net.finalize(); // free resources immediately and safely; not strictly necessary, but a good
							// habit

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getBeliefs() {
		return beliefs;

	}

}
