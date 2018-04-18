package br.ufsc.ine.utils;

import alice.tuprolog.*;

import java.util.Arrays;
import java.util.Iterator;

public class PrologEnvironment {

	private String SPACE = " ";
	private Prolog engine;
	private Theory theory;

	public PrologEnvironment() {
		this.engine = new Prolog();
	}

	public void appendFact(String fact) throws InvalidTheoryException {

		fact = fact.replaceAll("&", ",");
		fact = fact.replaceAll("\\|", ";");


		if(this.theory==null) {
			this.theory = new Theory(fact+SPACE);
		} else{
			this.theory.append(new Theory(fact+SPACE));
		}
		this.engine.setTheory(theory);
	}

	public void updateFact(String fact, String toTest) throws InvalidTheoryException {
		StringBuilder newTheory = new StringBuilder();
		if(this.theory==null){
			this.theory = new Theory(fact);
		}
		Iterator<? extends Term> iterator = this.theory.iterator(this.engine);
		while (iterator.hasNext()){
			Term term = iterator.next();

			if(toTest.startsWith("\\+")){
				toTest = toTest.replace("\\+", "").trim();

			}
			boolean match = this.engine.match(term, Term.createTerm( toTest.substring(0, toTest.length()-1)))
					|| this.engine.match(term, Term.createTerm( "\\+"+toTest.substring(0, toTest.length()-1)));

			if(match){
				newTheory.append(  fact + SPACE );
			} else {
				newTheory.append(  term.toString().endsWith(".") ?  (term.toString()+ SPACE ) : (term.toString()+"."+ SPACE ) );
			}
		}
		this.theory = new Theory(newTheory.toString());
		this.engine.setTheory(theory);
	}




	public SolveInfo solveGoal(String goal) throws MalformedGoalException {
		SolveInfo info = engine.solve(goal);
		return info;
	}


	public Prolog getEngine() {
		return engine;
	}

}
