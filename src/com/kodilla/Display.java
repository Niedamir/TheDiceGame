package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Display {
    Image imgBoard = new Image("file:resources/woodBoard.jpg");
    Image imgDice1Point = new Image("file:resources/dice1.png");
    Image imgDice2Point = new Image("file:resources/dice2.png");
    Image imgDice3Point = new Image("file:resources/dice3.png");
    Image imgDice4Point = new Image("file:resources/dice4.png");
    Image imgDice5Point = new Image("file:resources/dice5.png");
    Image imgDice6Point = new Image("file:resources/dice6.png");

    FlowPane playerDicePanel = new FlowPane(Orientation.HORIZONTAL);
    FlowPane computerDicePanel = new FlowPane(Orientation.HORIZONTAL);

    public void drawWindow(Stage primaryStage) {
        BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage boardImage = new BackgroundImage(imgBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardSize);
        Background board = new Background(boardImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(12, 12, 12, 12));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setBackground(board);

        Scene scene = new Scene(grid, 900, 600, Color.BLACK);

        primaryStage.setTitle("The Dice Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
