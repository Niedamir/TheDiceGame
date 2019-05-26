package com.kodilla;

import javafx.scene.control.Button;

public class UserInterface {
    public void startGameButton(GameEngine processor, Display window, GameStatus status) {
        Button btnStartGame = new Button();
        btnStartGame.setText("Rozpocznij grę");
        btnStartGame.setOnAction((e) -> {
            processor.theGame(window, status);
            window.deleteButton(btnStartGame);
        });
        window.drawBtnStartGame(btnStartGame);
    }
}
