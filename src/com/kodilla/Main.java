package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Initialization initializator = new Initialization();
		GameEngine processor = new GameEngine();
		GameStatus status = new GameStatus();
		Display window = new Display();

		initializator.initializeGame(primaryStage, window, status);
		processor.theGame(window, status);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
