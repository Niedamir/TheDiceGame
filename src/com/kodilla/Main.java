package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
	Image imgBoard = new Image("file:resources/woodBoard.jpg");
	Image imgDice1Point = new Image("file:resources/dice1.png");
	Image imgDice2Point = new Image("file:resources/dice2.png");
	Image imgDice3Point = new Image("file:resources/dice3.png");
	Image imgDice4Point = new Image("file:resources/dice4.png");
	Image imgDice5Point = new Image("file:resources/dice5.png");
	Image imgDice6Point = new Image("file:resources/dice6.png");

	ArrayList<Image> dicePoints = new ArrayList<Image>();

	FlowPane playerDicePanel = new FlowPane(Orientation.HORIZONTAL);
	FlowPane computerDicePanel = new FlowPane(Orientation.HORIZONTAL);

	Pool playerPool = new Pool(new HashMap());
	Pool computerPool = new Pool(new HashMap());

	int playerScore = 0;
	int computerScore = 0;

	boolean playerTurn = true;
	boolean [] playerSetToRoll = new boolean [4];
	boolean [] computerSetToRoll = new boolean [4];

//	public void playerTurn() {}
//	public void computerTurn() {}


	@Override
	public void start(Stage primaryStage){
		dicePoints.add(imgDice1Point);
		dicePoints.add(imgDice2Point);
		dicePoints.add(imgDice3Point);
		dicePoints.add(imgDice4Point);
		dicePoints.add(imgDice5Point);
		dicePoints.add(imgDice6Point);

		for(int i = 0; i < 4; i++) {
			playerSetToRoll[i] = true;
			playerDicePanel.getChildren().add(new ImageView(imgDice6Point));
			computerSetToRoll[i] = true;
			computerDicePanel.getChildren().add(new ImageView(imgDice6Point));
		}

		BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, false);
		BackgroundImage boardImage = new BackgroundImage(imgBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardSize);
		Background board = new Background(boardImage);

		Button btnRoll = new Button();
		btnRoll.setText("Rzuć kośćmi");
		btnRoll.setOnAction((e) -> {
			playerPool.rollPool(playerSetToRoll);
			playerPool.displayPool(playerDicePanel, dicePoints);
			computerPool.rollPool(computerSetToRoll);
			computerPool.displayPool(computerDicePanel, dicePoints);
		});

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(12, 12, 12, 12));
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setBackground(board);

		grid.add(playerDicePanel, 0, 3, 1, 1);
		grid.add(computerDicePanel, 0,0,1,1);

		grid.add(btnRoll, 15,15, 1,1);

		Scene scene = new Scene(grid, 900, 600, Color.BLACK);

		primaryStage.setTitle("The Dice Game");
		primaryStage.setScene(scene);
		primaryStage.show();

//		while(computerScore < 100 && playerScore < 100) {
//			playerTurn();
//			computerTurn();
//		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
