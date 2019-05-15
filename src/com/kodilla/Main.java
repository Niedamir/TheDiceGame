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

public class Main extends Application {
	Image imgBoard = new Image("file:resources/woodBoard.jpg");
	Image imgDice1Point = new Image("file:resources/dice1.png");
	Image imgDice2Point = new Image("file:resources/dice2.png");
	Image imgDice3Point = new Image("file:resources/dice3.png");
	Image imgDice4Point = new Image("file:resources/dice4.png");
	Image imgDice5Point = new Image("file:resources/dice5.png");
	Image imgDice6Point = new Image("file:resources/dice6.png");

	ArrayList<Image> dicePoints = new ArrayList<Image>();

	FlowPane playerPool = new FlowPane(Orientation.HORIZONTAL);
	FlowPane computerPool = new FlowPane(Orientation.HORIZONTAL);

	Dice playerDice1 = new Dice();
	Dice playerDice2 = new Dice();
	Dice playerDice3 = new Dice();
	Dice computerDice1 = new Dice();
	Dice computerDice2 = new Dice();
	Dice computerDice3 = new Dice();
	int playerScore = 0;
	int computerScore = 0;

	boolean playerTurn = true;
	boolean [] playerSetToRoll = new boolean [3];

	@Override
	public void start(Stage primaryStage){
		dicePoints.add(imgDice1Point);
		dicePoints.add(imgDice2Point);
		dicePoints.add(imgDice3Point);
		dicePoints.add(imgDice4Point);
		dicePoints.add(imgDice5Point);
		dicePoints.add(imgDice6Point);

		BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, false);
		BackgroundImage boardImage = new BackgroundImage(imgBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardSize);
		Background board = new Background(boardImage);

		Button btnStart = new Button();
		btnStart.setText("Rozpocznij grę");
		btnStart.setOnAction((e) -> {
			ImageView imgComputerDice1 = new ImageView(computerDice1.roll(dicePoints));
			computerPool.getChildren().add(imgComputerDice1);
			ImageView imgComputerDice2 = new ImageView(computerDice2.roll(dicePoints));
			computerPool.getChildren().add(imgComputerDice2);
			ImageView imgComputerDice3 = new ImageView(computerDice3.roll(dicePoints));
			computerPool.getChildren().add(imgComputerDice3);
			ImageView imgPlayerDice1 = new ImageView(playerDice1.roll(dicePoints));
			playerPool.getChildren().add(imgPlayerDice1);
			ImageView imgPlayerDice2 = new ImageView(playerDice2.roll(dicePoints));
			playerPool.getChildren().add(imgPlayerDice2);
			ImageView imgPlayerDice3 = new ImageView(playerDice3.roll(dicePoints));
			playerPool.getChildren().add(imgPlayerDice3);
		});

		Button btnSetToRoll1 = new Button();
		btnSetToRoll1.setText("Zaznacz");
		btnSetToRoll1.setOnAction((e) -> {
			if (playerTurn == true && playerSetToRoll [0] == false) {
				playerSetToRoll[0] = true;
				btnSetToRoll1.setText("Odznacz");
			}
			else {
				playerSetToRoll[0] = false;
				btnSetToRoll1.setText("Zaznacz");
			}
		});
		Button btnSetToRoll2 = new Button();
		btnSetToRoll2.setText("Zaznacz");
		btnSetToRoll2.setOnAction((e) -> {
			if (playerTurn == true && playerSetToRoll [1] == false) {
				playerSetToRoll[1] = true;
				btnSetToRoll2.setText("Odznacz");
			}
			else {
				playerSetToRoll[1] = false;
				btnSetToRoll2.setText("Zaznacz");
			}
		});
		Button btnSetToRoll3 = new Button();
		btnSetToRoll3.setText("Zaznacz");
		btnSetToRoll3.setOnAction((e) -> {
			if (playerTurn == true && playerSetToRoll [2] == false) {
				playerSetToRoll[2] = true;
				btnSetToRoll3.setText("Odznacz");
			}
			else {
				playerSetToRoll[2] = false;
				btnSetToRoll3.setText("Zaznacz");
			}
		});

		Button btnRoll = new Button();
		btnRoll.setText("Rzuć kośćmi");
		btnRoll.setOnAction((e) -> {
			if (playerTurn == true && playerSetToRoll [0] == true) {
				ImageView imgPlayerDice1 = new ImageView(playerDice1.roll(dicePoints));
				playerPool.getChildren().add(imgPlayerDice1);
			}
			if (playerTurn == true && playerSetToRoll [1] == true) {
				ImageView imgPlayerDice2 = new ImageView(playerDice2.roll(dicePoints));
				playerPool.getChildren().add(imgPlayerDice2);
			}
			if (playerTurn == true && playerSetToRoll [2] == true) {
				ImageView imgPlayerDice3 = new ImageView(playerDice3.roll(dicePoints));
				playerPool.getChildren().add(imgPlayerDice3);
			}
		});

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(12, 12, 12, 12));
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setBackground(board);

		grid.add(btnStart, 5, 5, 5,5);
		grid.add(btnRoll, 15, 15, 5,5);

		grid.add(playerPool, 0, 3, 1, 1);
		grid.add(computerPool, 0,0,1,1);
		grid.add(btnSetToRoll1, 0, 15, 1, 1);
		grid.add(btnSetToRoll2, 5, 15, 1, 1);
		grid.add(btnSetToRoll3, 10, 15, 1, 1);

		Scene scene = new Scene(grid, 900, 600, Color.BLACK);

		primaryStage.setTitle("The Dice Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
