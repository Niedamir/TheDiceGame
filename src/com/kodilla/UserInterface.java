package com.kodilla;

import javafx.scene.control.Button;

public class UserInterface {
    Button btnStartGame = new Button();
    Button btnRerollDice0 = new Button();
    Button btnRerollDice1 = new Button();
    Button btnRerollDice2 = new Button();
    Button btnRerollDice3 = new Button();
    Button btnEndReroll = new Button();
    Button btnNextRound = new Button();

    public void startGameButton(GameEngine processor, Display window, GameStatus status) {
        btnStartGame.setText("Rozpocznij grę");
        btnStartGame.setOnAction((e) -> {
            processor.clearMaps(status, window);
            window.grid.getChildren().remove(window.lblWin);
            window.grid.getChildren().remove(window.lblLose);
            status.isGameRunning = true;
            window.grid.getChildren().remove(btnStartGame);
            processor.roll(status, window);
            window.drawRollResult(status);
            rerollDiceButtons(processor, window, status);
        });
        window.grid.add(btnStartGame, 1, 1, 1, 1);
        window.grid.add(btnRerollDice0, 0, 2, 1, 1);
        window.grid.add(btnRerollDice1, 1, 2, 1, 1);
        window.grid.add(btnRerollDice2, 2, 2, 1, 1);
        window.grid.add(btnRerollDice3, 3, 2, 1, 1);
        window.grid.add(btnEndReroll, 0,3,1,1);
        btnRerollDice0.setVisible(false);
        btnRerollDice1.setVisible(false);
        btnRerollDice2.setVisible(false);
        btnRerollDice3.setVisible(false);
        btnEndReroll.setVisible(false);
    }

    public void rerollDiceButtons(GameEngine processor, Display window, GameStatus status) {
        btnRerollDice0.setVisible(true);
        btnRerollDice1.setVisible(true);
        btnRerollDice2.setVisible(true);
        btnRerollDice3.setVisible(true);
        btnEndReroll.setVisible(true);

        btnRerollDice0.setText("Przerzuć");
        btnRerollDice0.setOnAction((e) -> {
            processor.reroll(window, status, 0);
            btnRerollDice0.setVisible(false);
        });
        btnRerollDice1.setText("Przerzuć");
        btnRerollDice1.setOnAction((e) -> {
            processor.reroll(window, status, 1);
            btnRerollDice1.setVisible(false);
        });
        btnRerollDice2.setText("Przerzuć");
        btnRerollDice2.setOnAction((e) -> {
            processor.reroll(window, status, 2);
            btnRerollDice2.setVisible(false);
        });
        btnRerollDice3.setText("Przerzuć");
        btnRerollDice3.setOnAction((e) -> {
            processor.reroll(window, status, 3);
            btnRerollDice3.setVisible(false);
        });
        btnEndReroll.setText("Podlicz punkty");
        btnEndReroll.setOnAction((e) -> {
            processor.countScore(window, status);
            btnEndReroll.setVisible(false);
            btnRerollDice0.setVisible(false);
            btnRerollDice1.setVisible(false);
            btnRerollDice2.setVisible(false);
            btnRerollDice3.setVisible(false);
            processor.updateStatus(status, window);
            if(status.isGameRunning() == true) { nextRoundButton(processor, window, status); }
        });
    }

    public void nextRoundButton(GameEngine processor, Display window, GameStatus status) {
        btnNextRound.setText("Graj dalej");
        btnNextRound.setOnAction((e) -> {
            window.grid.getChildren().remove(btnNextRound);
            processor.roll(status, window);
            window.drawRollResult(status);
            rerollDiceButtons(processor, window, status);
        });
        if(status.isGameRunning() == true) {
            window.grid.add(btnNextRound, 0, 3, 1, 1);
        } else {
            startGameButton(processor, window, status);
        }
    }
}
