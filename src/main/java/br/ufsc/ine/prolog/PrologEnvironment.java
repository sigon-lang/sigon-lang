package br.ufsc.ine.prolog;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

public class PrologEnvironment {

	private static final String SPACE = " ";
	private StringBuffer stringBuffer;
	private Prolog engine;
	private Theory theory;

	public PrologEnvironment() {
		this.engine = new Prolog();
		this.stringBuffer = new StringBuffer();
	}

	public void appendFact(String fact) throws InvalidTheoryException {
		this.stringBuffer.append(fact);
		this.stringBuffer.append(SPACE);
		this.theory = new Theory(this.stringBuffer.toString());
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
