package com.kodilla;

import java.util.Random;

public class GameEngine {
    UserInterface ui = new UserInterface();
    Random rollGen = new Random();
    int x;

    public void roll(GameStatus status) {
        for(int i = 0; i < 4; i++) {
            x = rollGen.nextInt(6);
            status.getPlayerRollResult().replace(x, status.getPlayerRollResult().get(x) + 1);
            x = rollGen.nextInt(6);
            status.getComputerRollResult().replace(x, status.getComputerRollResult().get(x) + 1);
        }
    }
    public void reroll(Display window, GameStatus status) {
        int rerollResult = rollGen.nextInt(6);

    }
    public void countScore() {}
    public void updateGameStatus() {}

    public void theGame(Display window, GameStatus status) {
        while(status.isGameRunning() == true) {
            if(status.getTurnPhase() == 1) {
                roll(status);
                window.drawRollResult(status);
                status.setTurnPhase(2);
            }
            if(status.getTurnPhase() == 2) {
                window.draw

                reroll();
                status.setTurnPhase(3);
            }
            if(status.getTurnPhase() == 3) {
                countScore();
                updateGameStatus();
                status.setTurnPhase(1);
            }
            status.isGameRunning = false; //for test only
        }
    }
}
