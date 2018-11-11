package br.ufsc.ine.negotiation;

import alice.tuprolog.EngineManager;
import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

public class MainProlog {

	public static void main(String[] args) {

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("bc(aux2). \n bc(teste) :- bc(aux) , bc(aux2).");
			// builder.append("bc(teste :- aux).");
			Theory contextTheory;
			/*
			 * bc(not have(beta,screw)). bc(not have(beta,screwDriver)). bc(not
			 * have(alpha,nail)). bc(have(mi,screwDriver)). bc(have(alpha,picture)).
			 * bc(have(alpha,screw)). bc(have(alpha,hammer)). bc(have(beta,nail)).
			 */
			contextTheory = new Theory(builder.toString());
			Prolog prolog = new Prolog();
			
			prolog.setTheory(contextTheory);
			System.out.println(contextTheory.toJSON());
			SolveInfo solve = prolog.solve("bc(teste).");
			System.out.println(solve);
		} catch (InvalidTheoryException | MalformedGoalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
