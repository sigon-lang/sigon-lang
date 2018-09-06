package br.ufsc.ine.negotiation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.utils.PrologEnvironment;

public class NegotiationContextService implements ContextService{
	
	private static NegotiationContextService instance = new NegotiationContextService();
	private static PrologEnvironment prologEnvironment;
	//estratégias -> ações (plano)
	//ações (protocolo) (provavelmente será alterado)
	private List<LangContext> strategies = new ArrayList<>();
	
	private NegotiationContextService() {
		prologEnvironment = new PrologEnvironment();
	}
	

	public static NegotiationContextService getInstance() {		
		return instance;
	}	
	
	
	public List<LangContext> strategies(){
		return strategies;
	}
	
	public void negotiation(List<LangContext> strategies) {
		this.strategies = strategies;
		List<String> clauses = strategies.stream().map(c -> c.getClauses()).flatMap(l -> l.stream())

				.collect(Collectors.toList());

		clauses.forEach(clause -> {
			try {
				this.addInitialFact(clause);
			} catch (InvalidTheoryException e) {
				e.printStackTrace();
			}
		});
		
	}

	@Override
	public boolean verify(String fact) {
		SolveInfo solveGoal;
		try {
			solveGoal = prologEnvironment.solveGoal(fact);
			return solveGoal.isSuccess();
		} catch (MalformedGoalException e) {
			return false;
		}
	}

	@Override
	public void appendFact(String c) {
		try {
			boolean update = false;
			String toTest = null;

			if(c.trim().endsWith(").")){
				StringBuilder builder = new StringBuilder();
				String toReplace = c.substring(c.indexOf("(")+1, c.lastIndexOf(")"));
				Arrays.stream(toReplace.split(",")).map( i-> "_,").forEach(builder::append);
				StringBuilder test = new StringBuilder();
				test.append(c.substring(0, c.indexOf("(")));
				test.append("(");
				test.append(builder.toString().substring(0,builder.toString().length()-1));
				test.append(").");
				toTest = test.toString();

				update = (c.startsWith("\\+") && this.verify("\\+" + toTest))
						|| (!c.startsWith("\\+") && this.verify("\\+" + toTest))
						|| this.verify(toTest.replace("\\+", ""));


			} else if(!c.trim().endsWith(").") && (c.startsWith("\\+") || this.verify("\\+" + c))  ){
				if(!c.startsWith("\\+") && verify("\\+"+c)){
					toTest = c;
					update = true;
				} else if(c.startsWith("\\+")) {
					String test = c.substring(2);
					if(this.verify(test)){
						toTest = test;
						update = true;
					}
				}
			}

			if(update){
				prologEnvironment.updateFact(c, toTest);
			} else {
				prologEnvironment.appendFact(c);
			}
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void addInitialFact(String fact) throws InvalidTheoryException {
		prologEnvironment.appendFact(fact);
	}

	@Override
	public String getName() {
		return "_negotiation";
	}


	@Override
	public Theory getTheory() {
		return prologEnvironment.getEngine().getTheory();
	}
	/*
	public static void Main(String [] args) {
		LangContext nc = new LangContext();		
		
		nc.setName("_negotiation");
		nc.addClause("aux1.");
		nc.addClause("aux2.");
		List<LangContext> ncs = new ArrayList<>();
		ncs.add(nc);       

		NegotiationContextService.getInstance().negotiation(ncs);
		System.out.println(NegotiationContextService.getInstance().getTheory());
		
		
		
		
		
	}*/

}
