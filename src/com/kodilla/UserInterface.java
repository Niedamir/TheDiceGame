package com.kodilla;

import javafx.scene.control.Button;

public class UserInterface {
    public void startGameButton(GameEngine processor, Display window, GameStatus status) {
        Button btnStartGame = new Button();
        btnStartGame.setText("Rozpocznij grę");
        btnStartGame.setOnAction((e) -> {
            status.isGameRunning = true;
            status.setTurnPhase(1);
            window.grid.getChildren().remove(btnStartGame);
            processor.theGame(window, status);
        });
        window.grid.add(btnStartGame, 0, 0, 1, 1);
    }

    public void rerollDiceButtons(GameEngine processor, Display window, GameStatus status) {
        Button btnRerollDice1 = new Button();
        btnRerollDice1.setText("Przerzuć");
        btnRerollDice1.setOnAction((e) -> {
            processor.reroll(window, status, 0);
//            window.grid.getChildren().remove(btnRerollDice1);
        });
        window.grid.add(btnRerollDice1, 0, 2, 1, 1);

    }
}
