package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

    Label lblScore = new Label("PUNKTY");
    Label lblPlayer = new Label("gracz: ");
    Label lblComputer = new Label("komputer: ");
    Label lblPlayerScore = new Label("0");
    Label lblComputerScore = new Label("0");
    Label lblWin = new Label("GRATULACJE! Wygrałeś");
    Label lblLose = new Label("Spróbuj szczęścia jeszcze raz");

    ArrayList<Image> diceSides = new ArrayList();

    FlowPane playerDicePanel = new FlowPane(Orientation.HORIZONTAL);
    FlowPane computerDicePanel = new FlowPane(Orientation.HORIZONTAL);
    GridPane grid = new GridPane();
    Scene scene = new Scene(grid, 900, 600, Color.BLACK);

    public ArrayList<Image> getDiceSides() {
        return diceSides;
    }

    //WINDOW
    public void drawWindow(Stage primaryStage) {
        diceSides.add(imgDice1Point);
        diceSides.add(imgDice2Point);
        diceSides.add(imgDice3Point);
        diceSides.add(imgDice4Point);
        diceSides.add(imgDice5Point);
        diceSides.add(imgDice6Point);

        playerDicePanel.setPadding(new Insets(0, 220, 0, 0));
        computerDicePanel.setPadding(new Insets(0, 220, 0, 0));

        BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage boardImage = new BackgroundImage(imgBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardSize);
        Background board = new Background(boardImage);

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setHgap(6);
        grid.setVgap(6);
        grid.setBackground(board);

        grid.add(playerDicePanel, 0, 1, 4, 1);
        grid.add(computerDicePanel, 0,0, 4,1);

        primaryStage.setTitle("The Dice Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //LABELS
    public void setLabels() {
        lblScore.setFont(new Font("Helvetica", 20));
        lblScore.setTextFill(Color.web("#000"));

        lblPlayer.setFont(new Font("Helvetica", 16));
        lblPlayer.setTextFill(Color.web("#000"));
        lblComputer.setFont(new Font("Helvetica", 16));
        lblComputer.setTextFill(Color.web("#000"));

        lblPlayerScore.setFont(new Font("Helvetica", 16));
        lblPlayerScore.setTextFill(Color.web("#000"));
        lblComputerScore.setFont(new Font("Helvetica", 16));
        lblComputerScore.setTextFill(Color.web("#000"));

        lblWin.setFont(new Font("Helvetica", 25));
        lblWin.setTextFill(Color.web("#FFF"));
        lblLose.setFont(new Font("Helvetica", 25));
        lblLose.setTextFill(Color.web("#FFF"));
    }
    public void drawScoreTable() {
        grid.add(lblScore, 6, 0, 3, 3);
        grid.add(lblPlayer, 6, 2, 1, 1);
        grid.add(lblPlayerScore, 7, 2, 1, 1);
        grid.add(lblComputer, 6, 1, 1, 1);
        grid.add(lblComputerScore, 7, 1, 1, 1);
    }
    //FLOW PANES
    public void drawRollResult(GameStatus status) {
        playerDicePanel.getChildren().clear();
        computerDicePanel.getChildren().clear();
        for(int i = 0; i < 4; i++) {
            playerDicePanel.getChildren().add(new ImageView(status.getPlayerPool().get(i)));
            computerDicePanel.getChildren().add(new ImageView(status.getComputerPool().get(i)));
        }
    }
    public void drawReroll(GameStatus status) {
        playerDicePanel.getChildren().clear();
        for(int i = 0; i < 4; i++) {
            playerDicePanel.getChildren().add(new ImageView(status.getPlayerPool().get(i)));
        }
    }
    //SCORES
    public void drawScores(GameStatus status) {
        lblPlayerScore.setText(status.playerScoreToString());
        lblComputerScore.setText(status.computerScoreToString());
    }
    //ENDGAME
    public void endGame(GameStatus status) {
        if(status.isGameRunning() == false && status.getPlayerScore() >=status.getPointsToWin() || status.getComputerScore() >=status.getPointsToWin()) {
            if(status.getPlayerScore() > status.getComputerScore()) {
                playerDicePanel.getChildren().clear();
                computerDicePanel.getChildren().clear();
                grid.add(lblWin, 1, 0, 1,1);
            } else {
                playerDicePanel.getChildren().clear();
                computerDicePanel.getChildren().clear();
                grid.add(lblLose, 1, 0, 1, 1);
            }
        }
    }
    public void clearBoard() {
        lblPlayerScore.setText("0");
        lblComputerScore.setText("0");
    }
}
