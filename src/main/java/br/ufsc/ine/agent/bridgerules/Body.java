package br.ufsc.ine.agent.bridgerules;

import alice.tuprolog.*;
import br.ufsc.ine.agent.context.ContextService;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.regex.Matcher;

import org.abego.treelayout.util.FixedNodeExtentProvider;

@Builder
@Data
public class Body {

	public static final String END = ".";
	private ContextService context;
	private String clause;
	private String notClause;
	private Body and;
	private Body or;

	private Head head;

	@Builder.Default
	private List<String> variableFacts = new ArrayList<>();

	public boolean verify() {
		try {
			Theory contextTheory = defineBodyTheory();

			Prolog prolog = new Prolog();
			prolog.setTheory(contextTheory);

			String toTest = this.toString().endsWith(".") ? this.toString() : this.toString() + END;

			SolveInfo solve = prolog.solve(toTest);

			try {
				if (head != null && !head.isVariable()) {
					variableFacts.add(head.getClause());
				} else {

					if (head.getClause().contains("(") && head.getClause().contains(")")) {
						String clauses = head.getClause().substring(head.getClause().indexOf("(") + 1,
								head.getClause().indexOf(")"));
						String[] split = clauses.trim().split(",");
						String previousBinding = "";
						
						
						

						boolean hasOpenAlternatives = true;
						while (hasOpenAlternatives) {
							hasOpenAlternatives = solve.hasOpenAlternatives();
							

							StringBuilder builder = new StringBuilder();
							

							for (int i = 0; i < split.length; i++) {

								split[i] = split[i].replace(" ", "");
								if (Character.isUpperCase(split[i].charAt(0))) {
									Term solution = solve.getTerm(split[i].trim());									
									builder.append(solution.toString().replaceAll("_([0-9])*", "_"));

								} else {
									builder.append(split[i]);
								}
								if (i + 1 < split.length) {
									builder.append(",");
								}
							}
							if(previousBinding.equals(builder.toString()) && hasOpenAlternatives) {
								hasOpenAlternatives = false;
							}
							
							previousBinding = builder.toString();
							

							variableFacts.add(
									head.getClause().substring(0, head.getClause().indexOf("(") + 1) + builder + ").");
							solve = prolog.solveNext();

						}

						return solve.isSuccess();
					}

					Term solution = solve.getTerm(this.head.getTerm());
					if (solution.toString().contains("|")) {
						String[] result = solution.toString().substring(1, solution.toString().length() - 1)
								.split("\\|");
						for (String s : result) {
							String item = s.replaceAll("_([0-9])*", "_") + ".";
							variableFacts.add(item);
						}
					} else {
						variableFacts.add(solution.toString().replaceAll("_([0-9])*", "_") + ".");
					}
				}
			} catch (Exception e) {

			}

			return solve.isSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void appendFact() {

	}

	private void inferenceParsing(StringBuilder builder, String[] value) {
		/* teste :- aux , aux2 */

		String bodyTerms = value[1];
		String contextName = context.getName();

		String[] terms = bodyTerms.split(",");
		for (String term : terms) {
			builder.append(contextName + "(" + term.substring(0, term.length() - 1) + ") ");
			builder.append(" , ");

		}
		builder.deleteCharAt(builder.length() - 1); // remover o ultimo ,
		builder.append(".\n");

	}

	private void parseInference(StringBuilder builder, String[] value) {
		String contextName = context.getName();
		builder.append(contextName + "(" + value[0].trim() + "):-"); // assumindo que terá apenas um termo na cabeça

		String term = "";
		String[] terms3;
		String[] terms4 = value[1].split("(?<=\\)(,)) | ;");
		
		if(value[1].contains("(") && value[1].contains(",") && ! value[1].contains(";")) {
			terms3 = value[1].split("(?<=\\)(,))"); //problema com o or gambiarra mode on
		}else {
			if(value[1].contains(";")) {
				terms3 = value[1].split("(?<=;)");

			}else {
				terms3 = value[1].split("(?<=,)");
			}
			
			
		}
		
		/*if(!value[1].contains("(")) {
			
		}else {
			if(value[1].contains(";")) {
				terms3 = value[1].split("(?<=;)"); //problema com o or gambiarra mode on
			}
			else	{
				
			}
			
		}*/
		
		
		//TODO arrumar REGEX para capturar todos os casos: & e Or misturados

		
		

		for (int i = 0; i < terms3.length; i++) {

			term = terms3[i].substring(0, terms3[i].length() - 1).trim();
			if (terms3[i].endsWith(",") || terms3[i].endsWith(";")) {
				builder.append(contextName + "(" + term + ")");
				builder.append(terms3[i].charAt(terms3[i].length() - 1));
			} else {
				builder.append(contextName + "(" + term + ")");
			}

		}
		builder.append(".\n");

	}

	private void inferenceParsingFull(StringBuilder builder, String[] value) {
		/* teste :- aux , aux2 */
		String contextName = context.getName();
		for (String bodyTerms : value) {
			String[] terms = bodyTerms.trim().replace(".", "").split(",");
			for (String term : terms) {

				builder.append(contextName + "(" + term.substring(0, term.length()) + ") ");
				builder.append(" ,");

			}
			builder.deleteCharAt(builder.length() - 1);
			builder.append(":-");

		}
		builder.replace(builder.length() - 2, builder.length(), ".\n");

	}

	private Theory defineBodyTheory() throws InvalidTheoryException {

		StringBuilder builder = new StringBuilder();
		//String terms = context.getTheory().toString().replaceAll("(.*):-[\\s]*(.*)([,| ; ]?[\\s]*)*", "$1:- $2");
		String terms = context.getTheory().toString().replaceAll("(.*):-[\\s]*(.*)(,|\\s*;\\s*?[\\s]*)*", "$1:- $2");
		String[] contextSplit = terms
				// .replaceAll("_([0-9])*", "_").trim()
				.replaceAll("\\n\\n", "/").replaceAll("_", "").split("/");

		// String contextName = context.getName().replaceAll("_", "");
		String contextName = context.getName();

		for (String s : contextSplit) {
			if (!s.isEmpty()) {
				String result = s.replaceAll("_([0-9])*", "_").trim();
				if (result.contains(":-")) {
					parseInference(builder, result.split(":-"));

				} else {
					builder.append(contextName + "(" + result.substring(0, result.length() - 1) + "). \n");
				}

			}
		}

		// TODO: nao esta recursivo
		Theory contextTheory = new Theory(builder.toString());
		builder = new StringBuilder();

		addAndOr(builder, this);
		Theory andOrTheory = new Theory(builder.toString());
		contextTheory.append(andOrTheory);

		return contextTheory;
	}

	private void addAndOr(StringBuilder builder, Body body) {
		if (body.getAndOrClause().isPresent()) {
			if (body.and != null) {
				String terms = body.and.context.getTheory().toString().replaceAll("(.*):-[\\s]*(.*).", "$1:- $2.");
				String[] split = terms.replaceAll("_([0-9])*", "_").trim().split("\\n");

				// qual era a necessidade de ser um split pela quebra de linha e não pelo .?

				/*
				 * if(body.and.context.getTheory().toString().contains(":-")) { split =
				 * body.and.context.getTheory().toString() .replaceAll("_([0-9])*", "_")
				 * .trim().split("\\."); }
				 */

				for (String s : split) {
					if (!s.isEmpty())
						builder.append(body.and.context.getName() + "(" + s.substring(0, s.length() - 1) + "). \n");
				}

				if (body.and.getAndOrClause().isPresent()) {
					addAndOr(builder, body.and);
				}

			} else if (body.or != null) {
				String[] split = body.or.context.getTheory().toString().replaceAll("\\n", "")
						.replaceAll("_([0-9])*", "_")

						.trim().split("/.");
				for (String s : split) {
					if (!s.isEmpty())
						builder.append(body.or.context.getName() + "(" + s.substring(0, s.length() - 1) + "). \n");
				}

				if (body.or.getAndOrClause().isPresent()) {
					addAndOr(builder, body.or);
				}
			}
		}
	}

	public List<String> getVariableFacts() {
		return Collections.unmodifiableList(variableFacts);
	}

	private void getBodyValue(StringBuilder builder, Body body) {

		if (body.notClause != null) {
			builder.append("\\+");
		}
		builder.append(getContextClause(body));

		if (body.and != null || body.or != null) {
			this.getBodyValue(builder, body);
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		if (this.notClause != null) {
			builder.append("\\+");
		}
		builder.append(this.getContextClause());

		if (this.getConnector().isPresent()) {
			String head = replaceFirstOccurrenceOfString(builder.toString(), ".", "");
			builder = new StringBuilder();
			builder.append(head);
			builder.append(replaceFirstOccurrenceOfString(this.getConnector().get(), ".", ""));

		}
		return builder.toString();
	}

	public Optional<String> getConnector() {
		// ; / , logical or / and (short circuit)
		if (this.and != null) {
			return Optional.ofNullable(" , " + this.and);
		} else if (this.or != null) {
			return Optional.ofNullable(" ; " + this.or);
		}
		return Optional.empty();
	}

	public String getContextClause() {

		if (this.clause != null) {
			if (this.clause.startsWith("member(")) {
				return this.clause + ".";
			}

			return this.context.getName() + "(" + this.clause.replace(".", "") + ")";
		}

		return this.context.getName() + "(" + this.notClause.replace(".", "") + ")";

	}

	private String getContextClause(Body body) {

		if (clause != null) {
			if (body.clause.startsWith("member(")) {
				return this.clause + ".";
			}

			if (body.clause != null) {
				return body.context.getName() + "(" + body.clause.replace(".", "") + ")";
			}
		}

		return body.context.getName() + "(" + body.notClause.replace(".", "") + ")";

	}

	public Optional<String> getAndOrClause() {
		if (this.and != null) {
			return Optional.ofNullable(this.getContextClause());
		} else if (this.or != null) {
			return Optional.ofNullable(this.or.getContextClause());
		}
		return Optional.empty();
	}

	private static String replaceFirstOccurrenceOfString(String inputString, String stringToReplace,
			String stringToReplaceWith) {
		if (!inputString.contains(stringToReplace)) {
			return inputString;
		}
		int length = stringToReplace.length();
		int inputLength = inputString.length();

		int startingIndexofTheStringToReplace = inputString.indexOf(stringToReplace);

		String finalString = inputString.substring(0, startingIndexofTheStringToReplace) + stringToReplaceWith
				+ inputString.substring(startingIndexofTheStringToReplace + length, inputLength);

		return finalString;

	}

	public void setHead(Head head) {
		this.head = head;
	}
}
