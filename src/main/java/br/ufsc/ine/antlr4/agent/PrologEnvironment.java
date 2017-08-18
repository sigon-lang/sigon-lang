package br.ufsc.ine.antlr4.agent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

public class PrologEnvironment {

	public boolean run(List<String> lines, String goal) throws Exception {

		File file = File.createTempFile("teste1", "pl");
		Path path = Paths.get(file.getPath());
		Files.write(path, lines, Charset.forName("UTF-8"));

		Prolog engine = new Prolog();

		Theory theory = new Theory(new FileInputStream(file.getPath()));
		engine.setTheory(theory);

		goal = "?- " + goal;

		SolveInfo info = engine.solve(goal);
		if (!info.isSuccess()) {
			return false;
		} else if (!engine.hasOpenAlternatives()) {
			return true;
		}
		return false;

	}

}
