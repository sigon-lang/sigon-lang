package cleaning;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import agent.AgentLexer;
import agent.AgentParser;
import agent.AgentParser.PlannerContextContext;
import br.ufsc.ine.agent.Agent;
import br.ufsc.ine.parser.AgentWalker;
import br.ufsc.ine.parser.VerboseListener;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	static GridPane root;

	static int SIZE = 10;
	static int length = SIZE;
	static int width = SIZE;
	static int garbage[][] = new int[SIZE][SIZE];

	public static int rowIndex = 0;
	public static int columnIndex = 0;
	private static int full = 3;

	@Override
	public void start(Stage primaryStage) {

		root = new GridPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setHgap(2);
		root.setVgap(2);
		root.getStyleClass().addAll("game-root");

		// add the agent
		addChildrens(null, null, root, "A");

		// add garbage
		addChildrens(3, 2, root, "G");
		garbage[3][2] = 1;

		// add garbage
		addChildrens(4, 5, root, "G");
		garbage[4][5] = 1;

		// add garbage
		addChildrens(6, 7, root, "G");
		garbage[6][7] = 1;

		Scene scene = new Scene(root, 550, 550);
		scene.getStylesheets().add("cleaning/game.css");

		primaryStage.setTitle("Exemplo 1");
		primaryStage.setScene(scene);
		primaryStage.show();

		scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
			PositionSensor.positionObservable.onNext("not clear.");
		});

	}

	private static void startAgent() {
		try {

			File agentFile = new File("/home/valdir/Documents/sigon-lang/src/test/java/cleaning/r1.on");
			CharStream stream = CharStreams.fromFileName(agentFile.getAbsolutePath());
			AgentLexer lexer = new AgentLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			AgentParser parser = new AgentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(new VerboseListener());

			ParseTree tree = parser.agent();
			ParseTreeWalker walker = new ParseTreeWalker();

			AgentWalker agentWalker = new AgentWalker();
			walker.walk(agentWalker, tree);

			Agent agent = new Agent();
			agent.run(agentWalker);

		} catch (IOException e) {
			System.out.println("I/O exception.");
		}
	}

	public static void nextSlot() {
		if (columnIndex < SIZE - 1) {
			addChildrens(rowIndex, columnIndex, root, "");
			columnIndex++;
			if (garbage[rowIndex][columnIndex] == 1) {
				PositionSensor.positionObservable.onNext("garbage.");
			} else {
				addChildrens(rowIndex, columnIndex, root, "A");
				String content = "position(" + (columnIndex + 1) + "," + (rowIndex) + ").";
				PositionSensor.positionObservable.onNext(content);
			}

		} else {
			addChildrens(rowIndex, columnIndex, root, "");
			rowIndex++;
			columnIndex = 0;
			if (garbage[rowIndex][columnIndex] == 1) {
				PositionSensor.positionObservable.onNext("garbage");
			} else {
				addChildrens(rowIndex, columnIndex, root, "A");
				String content = "position(" + (columnIndex + 1) + "," + (rowIndex) + ").";
				PositionSensor.positionObservable.onNext(content);

			}

		}

	}

	private static void addChildrens(Integer row, Integer column, GridPane root, String text) {

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {

				Button button = new Button();

				button.setPrefHeight(50);
				button.setPrefWidth(50);
				button.setAlignment(Pos.CENTER);

				if (y == rowIndex && x == columnIndex) {

					if (text.equals("A") || text.equals("G")) {
						button.getStyleClass().addAll("game-button");
						button.setText("A");
					} else {
						button.getStyleClass().addAll("game-button-active");
						button.setText("");
					}
					root.setRowIndex(button, y);
					root.setColumnIndex(button, x);
					root.getChildren().add(button);
				} else if ((row != null && column != null) && (y == row && x == column)) {
					button.setText(text);
					button.getStyleClass().addAll("game-button");
					root.setRowIndex(button, y);
					root.setColumnIndex(button, x);
					root.getChildren().add(button);
				} else if (row == null && column == null) {
					button.setText("");
					button.getStyleClass().addAll("game-button-active");
					root.setRowIndex(button, y);
					root.setColumnIndex(button, x);
					root.getChildren().add(button);
				}

			}
		}

	}

	public static void startEnvironment() {
		launch();
	}

	public static void main(String[] args) {
		startAgent();
		startEnvironment();
	}

	public static void burnGarbage() {
		full--;
		addChildrens(rowIndex, columnIndex, root, "A");

		if (full == 0) {
			PositionSensor.positionObservable.onNext("clear.");
		} else {
			PositionSensor.positionObservable.onNext("-garbage.");
		}

	}

	private static int radomBetween(int min, int max) {
		Random random = new Random();
		return random.nextInt(max + 1 - min) + min;
	}
}