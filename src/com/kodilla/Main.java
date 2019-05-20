package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {
	Image imgBoard = new Image("file:resources/woodBoard.jpg");
	ArrayList<Image> dicePointsList = new ArrayList<Image>();

	FlowPane playerDicePanel = new FlowPane(Orientation.HORIZONTAL);
	FlowPane computerDicePanel = new FlowPane(Orientation.HORIZONTAL);

	boolean [] playerSetToRoll = new boolean [4];
	boolean [] computerSetToRoll = new boolean [4];

	@Override
	public void start(Stage primaryStage){
		BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, false);
		BackgroundImage boardImage = new BackgroundImage(imgBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardSize);
		Background board = new Background(boardImage);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(12, 12, 12, 12));
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setBackground(board);

		grid.add(playerDicePanel, 0, 3, 1, 1);
		grid.add(computerDicePanel, 0,0,1,1);

		Scene scene = new Scene(grid, 900, 600, Color.BLACK);

		primaryStage.setTitle("The Dice Game");
		primaryStage.setScene(scene);
		primaryStage.show();

		Initialization initializator = new Initialization();
		initializator.initializeDice(playerSetToRoll, playerDicePanel);
		initializator.initializeDice(computerSetToRoll, computerDicePanel);
		dicePointsList = initializator.initializeDicePointsList();

		GameMechanic gameProcessor = new GameMechanic();
		gameProcessor.roll(grid, playerDicePanel, computerDicePanel, dicePointsList, playerSetToRoll, computerSetToRoll);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
