package br.ufsc.ine.context.bayesian;

import java.util.ArrayList;
import java.util.List;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;
import norsys.netica.Environ;
import norsys.netica.Net;
import norsys.netica.NeticaException;
import norsys.netica.Streamer;
import norsys.neticaEx.aliases.Node;

public class BayesianContextService implements ContextService {

	private static BayesianContextService instance = new BayesianContextService();
	private List<String> beliefs = new ArrayList<String>();
	private Net net;
	private Node isAware;
	private Node carComming;
	private Node listeningMusic;
	private Node distraction;
	
	private double awareValue = 0.0;
	
	


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
		

		try {
			carComming.finding().clear();
			switch (fact) {
			case "vehicle":								
				carComming.finding().enterState("yes");				
				break;
			case "-vehicle":
				carComming.finding().enterState("no");
				break;
			case "listeningMusic":				
				listeningMusic.finding().enterState("yes");				
				break;
			case "-listeningMusic":
				listeningMusic.finding().enterState("no");			
				break;
			case "distraction":				
				distraction.finding().enterState("yes");				
				break;
			case "-distraction":
				distraction.finding().enterState("no");
				break;
			
			default:
				if( fact.contains("aware(")) {
					awareValue = Double.parseDouble(fact.substring(6, 8))/100;
					
				}	
				System.out.println("Current threshold "+awareValue);
			
				break;
			}
			
		} catch (NeticaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//beliefs.add(fact);

	}
	
	@Override
	public void addInitialFact(String fact) throws InvalidTheoryException {
		// TODO Auto-generated method stub

		try {
		
			Node.setConstructorClass("norsys.neticaEx.aliases.Node");
			Environ env = new Environ(null);
			net = new Net();
			
			isAware = new Node("IsAware", "yes,no", net);
			carComming = new Node("vehicle", "yes,no", net);
			listeningMusic = new Node("listeningMusic", "yes,no", net);
			distraction = new Node("distraction", "yes,no", net);
			
			carComming.addLink(isAware); // link from visitAsia to tuberculosis
			listeningMusic.addLink(isAware); // link from visitAsia to tuberculosis
			distraction.addLink(isAware); // link from visitAsia to tuberculosis

			// isAware.setKind (Node.DECISION_NODE);
			isAware.setCPTable(0.01, 0.99);

			// isAware yes no
			carComming.setCPTable("yes", 0.99, 0.01);
			carComming.setCPTable("no", 0.01, 0.99);

			// isAware yes no
			listeningMusic.setCPTable("yes", 0.05, 0.95);
			listeningMusic.setCPTable("no", 0.01, 0.99);

			// isAware yes no
			distraction.setCPTable("yes", 0.05, 0.95);
			distraction.setCPTable("no", 0.01, 0.99);

		} catch (NeticaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public String getName() {

		return "_bayesian";
	}

	public static double getBeliefValue() {

		//return BayesianContextService.getInstance().awareValue;
		return 0.0;

	}

	/*
	 * TODO: 1- Parametrizar o método 2- Definir como integrar com o ciclo de
	 * raciocinio 3- Integrar com o ciclo e definir como será feita a saída
	 */
	public boolean queryAwareNode() {
		try {

			

			
			//net.setName("Awareness");

			
			//isAware.setTitle("Is aware of a vehicle");

			
			//carComming.finding().enterState("present");
			//distraction.finding().enterState("present");
			net.compile();
			double a = BayesianContextService.getInstance().awareValue;
			System.out.println(BayesianContextService.getInstance().awareValue);

			double belief = isAware.getBelief("yes");
			System.out.println("\nThe probability of being aware is " + belief);
			
			if(Double.compare(belief, a) > 0) {
				return true;
			}
			double c = belief - BayesianContextService.getInstance().awareValue;
			
			Streamer stream = new Streamer("data/awareness.dne");
			//net.write(stream);

			//net.finalize(); // free resources immediately and safely; not strictly necessary, but a good
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
