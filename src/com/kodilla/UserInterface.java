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
        Button btnRerollDice0 = new Button();
        btnRerollDice0.setText("Przerzuć");
        btnRerollDice0.setOnAction((e) -> {
            processor.reroll(window, status, 0);
            window.grid.getChildren().remove(btnRerollDice0);
        });
        Button btnRerollDice1 = new Button();
        btnRerollDice1.setText("Przerzuć");
        btnRerollDice1.setOnAction((e) -> {
            processor.reroll(window, status, 1);
            window.grid.getChildren().remove(btnRerollDice1);
        });
        Button btnRerollDice2 = new Button();
        btnRerollDice2.setText("Przerzuć");
        btnRerollDice2.setOnAction((e) -> {
            processor.reroll(window, status, 2);
            window.grid.getChildren().remove(btnRerollDice2);
        });
        Button btnRerollDice3 = new Button();
        btnRerollDice3.setText("Przerzuć");
        btnRerollDice3.setOnAction((e) -> {
            processor.reroll(window, status, 3);
            window.grid.getChildren().remove(btnRerollDice3);
        });
        Button btnEndReroll = new Button();
        btnEndReroll.setText("Podlicz punkty");
        btnEndReroll.setOnAction((e) -> {
            processor.countScore(window, status);
            window.grid.getChildren().remove(btnEndReroll);
            window.grid.getChildren().remove(btnRerollDice0);
            window.grid.getChildren().remove(btnRerollDice1);
            window.grid.getChildren().remove(btnRerollDice2);
            window.grid.getChildren().remove(btnRerollDice3);
        });

        window.grid.add(btnRerollDice0, 0, 2, 1, 1);
        window.grid.add(btnRerollDice1, 1, 2, 1, 1);
        window.grid.add(btnRerollDice2, 2, 2, 1, 1);
        window.grid.add(btnRerollDice3, 3, 2, 1, 1);
        window.grid.add(btnEndReroll, 0,3,1,1);
    }
}
