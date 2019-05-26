package com.kodilla;

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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Display {
    Image imgBoard = new Image("file:resources/woodBoard.jpg");
    Image imgDice1Point = new Image("file:resources/dice1.png");
    Image imgDice2Point = new Image("file:resources/dice2.png");
    Image imgDice3Point = new Image("file:resources/dice3.png");
    Image imgDice4Point = new Image("file:resources/dice4.png");
    Image imgDice5Point = new Image("file:resources/dice5.png");
    Image imgDice6Point = new Image("file:resources/dice6.png");

    ArrayList<ImageView> diceSides = new ArrayList();

    FlowPane playerDicePanel = new FlowPane(Orientation.HORIZONTAL);
    FlowPane computerDicePanel = new FlowPane(Orientation.HORIZONTAL);
    GridPane grid = new GridPane();
    Scene scene = new Scene(grid, 900, 600, Color.BLACK);

    //WINDOW
    public void drawWindow(Stage primaryStage) {
        diceSides.add(new ImageView(imgDice1Point));
        diceSides.add(new ImageView(imgDice2Point));
        diceSides.add(new ImageView(imgDice3Point));
        diceSides.add(new ImageView(imgDice4Point));
        diceSides.add(new ImageView(imgDice5Point));
        diceSides.add(new ImageView(imgDice6Point));

        BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage boardImage = new BackgroundImage(imgBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardSize);
        Background board = new Background(boardImage);

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(12, 12, 12, 12));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setBackground(board);

        primaryStage.setTitle("The Dice Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //FLOW PANES
    public void drawRollResult(GameStatus status) {
        for(int x = 0; x < 5; x++) {
            while (status.playerRollResult.get(x) > 0) {
                playerDicePanel.getChildren().add(diceSides.get(x));
                status.playerRollResult.replace(x, status.playerRollResult.get(x) - 1);
            }
            while (status.computerRollResult.get(x) > 0) {
                computerDicePanel.getChildren().add(diceSides.get(x));
                status.computerRollResult.replace(x, status.computerRollResult.get(x) - 1);
            }
        }

        grid.add(playerDicePanel, 0, 0, 1, 1);
        grid.add(computerDicePanel, 0,1, 1,1);
    }
    //BUTTONS
    public void drawBtnStartGame(Button btnStartGame) {
        grid.add(btnStartGame, 0, 0, 1, 1);

    }
    public void deleteButton(Button deletedButton) {
        grid.getChildren().remove(deletedButton);
    }
}
