package com.kodilla;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Initialization initializator = new Initialization();
		GameEngine processor = new GameEngine();
		GameStatus status = new GameStatus();
		Display window = new Display();
		UserInterface ui = new UserInterface();

		initializator.initializeGame(primaryStage, window, status);
		ui.startGameButton(processor, window, status);
	}
	public static void main(String[] args) {
		launch(args);
	}
}