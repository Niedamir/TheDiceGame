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
    Label lblYourDice = new Label("Twoje kości");
    Label lblComputerDice = new Label("Kości przeciwnika");

    Label lblGameTitle = new Label("Kości");
    Label lblInstruction = new Label("Gra polega na zbieraniu punktów. Pierwszy gracz,\nktóry osiągnie 300 punktów" +
                                        "wygrywa. Po każdym\nrzucie możesz raz przerzucić jedną kość. Gdy uznasz,\n" +
                                        "że wynik Cię satysfakocjonuje kliknij\nprzyciszk PODLICZ PUNKTY. Kliknięcie" +
                                        "przycisku\nGRAJ DALEJ spowoduje uruchomienie nastpnej\nrundy rozgrywki.");
    Label lblPunctation = new Label("Punkty naliczane są za ilość oczek na kostce.\nJeżeli posiadasz dwie kostki" +
                                        "o tej samej liczbie\noczek (para), wówczas punkty są mnożone przez 5.\nJeżeli" +
                                        "posiadasz trzy kostki o tej samej liczbie\n oczek (trójka), punkty są mnożone" +
                                        "przez 10. Przy\nczterech kostkach z tą samą liczbą oczek\notrzymasz 100 punktów.");

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

        playerDicePanel.setPadding(new Insets(30, 220, -30, 0));
        computerDicePanel.setPadding(new Insets(30, 220, -30, 0));

        BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage boardImage = new BackgroundImage(imgBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardSize);
        Background board = new Background(boardImage);

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setHgap(6);
        grid.setVgap(6);
        grid.setBackground(board);

        grid.add(playerDicePanel, 0, 3, 4, 1);
        grid.add(computerDicePanel, 0,0, 4,1);

        primaryStage.setTitle("The Dice Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //LABELS
    public void setLabels() {
        lblGameTitle.setFont(new Font("Helvetica", 25));
        lblGameTitle.setTextFill(Color.web("#000"));
        lblInstruction.setFont(new Font("Helvetica", 13));
        lblInstruction.setTextFill(Color.web("#000"));
        lblPunctation.setFont(new Font("Helvetica", 13));
        lblPunctation.setTextFill(Color.web("#000"));

        lblScore.setFont(new Font("Helvetica", 20));
        lblScore.setTextFill(Color.web("#000"));
        lblScore.setPadding(new Insets(0, 0, 20, 0));

        lblPlayer.setFont(new Font("Helvetica", 16));
        lblPlayer.setTextFill(Color.web("#000"));
        lblPlayer.setPadding(new Insets(0, 0, 15, 0));
        lblComputer.setFont(new Font("Helvetica", 16));
        lblComputer.setTextFill(Color.web("#000"));
        lblComputer.setPadding(new Insets(0, 0, 15, 0));

        lblPlayerScore.setFont(new Font("Helvetica", 16));
        lblPlayerScore.setTextFill(Color.web("#000"));
        lblPlayerScore.setPadding(new Insets(0, 20, 15, 50));
        lblComputerScore.setFont(new Font("Helvetica", 16));
        lblComputerScore.setTextFill(Color.web("#000"));
        lblComputerScore.setPadding(new Insets(0, 20, 15, 50));

        lblYourDice.setFont(new Font("Helvetica", 15));
        lblYourDice.setTextFill(Color.web("#FFF"));
        lblYourDice.setPadding(new Insets(90, 0, 0, 0));
        lblComputerDice.setFont(new Font("Helvetica", 15));
        lblComputerDice.setTextFill(Color.web("#FFF"));
        lblComputerDice.setPadding(new Insets(-90, 0, 0, 0));

        lblWin.setFont(new Font("Helvetica", 25));
        lblWin.setTextFill(Color.web("#FFF"));
        lblLose.setFont(new Font("Helvetica", 25));
        lblLose.setTextFill(Color.web("#FFF"));

        grid.add(lblYourDice, 0,3,1,1);
        grid.add(lblComputerDice, 0, 1, 1,1);
        grid.add(lblGameTitle, 5, 0,3,3);
        grid.add(lblInstruction, 5,0,3,3);
        grid.add(lblPunctation, 5,2,3,3);
        lblGameTitle.setPadding(new Insets(-150, 0, 0, -50));
        lblInstruction.setPadding(new Insets(70, 0, 0, -50));
        lblPunctation.setPadding(new Insets(-100, 0, 0, -50));
        lblYourDice.setVisible(false);
        lblComputerDice.setVisible(false);
    }
    public void drawScoreTable() {
        grid.add(lblScore, 6, 4, 3, 1);
        grid.add(lblPlayer, 6, 6, 1, 1);
        grid.add(lblPlayerScore, 7, 6, 1, 1);
        grid.add(lblComputer, 6, 5, 1, 1);
        grid.add(lblComputerScore, 7, 5, 1, 1);
    }
    //FLOW PANES
    public void drawRollResult(GameStatus status) {
        playerDicePanel.getChildren().clear();
        computerDicePanel.getChildren().clear();
        for(int i = 0; i < 4; i++) {
            playerDicePanel.getChildren().add(new ImageView(status.getPlayerPool().get(i)));
            computerDicePanel.getChildren().add(new ImageView(status.getComputerPool().get(i)));
        }
        lblYourDice.setVisible(true);
        lblComputerDice.setVisible(true);
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
            lblYourDice.setVisible(false);
            lblComputerDice.setVisible(false);
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
