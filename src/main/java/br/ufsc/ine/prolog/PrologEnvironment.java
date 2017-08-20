package br.ufsc.ine.prolog;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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

	public static void main(String args[]) throws Exception {
		Prolog engine = new Prolog();
		engine.setTheory(new Theory("mortal(socrates)."));
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			// interpreter main loop
			String goal;
			do {
				System.out.print("?- ");
				goal = stdin.readLine();
			} while (goal.equals(""));
			try {
				SolveInfo info = engine.solve(goal);
				if (engine.isHalted())
					break;
				else if (!info.isSuccess())
					System.out.println("no.");
				else if (!engine.hasOpenAlternatives()) {
					System.out.println(info);
				} else { // main case
				} // end main case
			} catch (MalformedGoalException ex) {
				System.err.println("syntax error.");
			} // end try
		} // end main loop

	}

	public Prolog getEngine() {
		return engine;
	}

}
