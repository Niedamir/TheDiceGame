package com.kodilla;

import javafx.scene.control.Button;

public class UserInterface {
    public void startGameButton(GameEngine processor, Display window, GameStatus status) {
        Button btnStartGame = new Button();
        btnStartGame.setText("Rozpocznij grę");
        btnStartGame.setOnAction((e) -> {
            status.isGameRunning = true;
            status.setTurnPhase(1);
            window.deleteButton(btnStartGame);
            processor.theGame(window, status);
        });
        window.drawBtnStartGame(btnStartGame);
    }

    public void checkDiceButtons(GameEngine processor, Display window, GameStatus status) {
        Button btnCheckDice1 = new Button();
        btnCheckDice1.setText("Przerzuć");
        btnCheckDice1.setOnAction((e) -> {
            processor.reroll(window, status);
        });
    }
}
