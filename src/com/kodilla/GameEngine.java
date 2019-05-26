package com.kodilla;

import java.util.Random;

public class GameEngine {
    UserInterface ui = new UserInterface();
    Random rollGen = new Random();
    int x;

    public void roll(GameStatus status) {
        for(int i = 0; i < 5; i++) {
            x = rollGen.nextInt(6);
            status.getPlayerRollResult().replace(x, status.getPlayerRollResult().get(x) + 1);
            x = rollGen.nextInt(6);
            status.getComputerRollResult().replace(x, status.getComputerRollResult().get(x) + 1);
        }
    }
    public void setRerollPool() {}
    public void reroll() {}
    public void countScore() {}
    public void updateGameStatus() {}

    public void theGame(Display window, GameStatus status) {
        status.turnPhase = 1;
        while(status.isGameRunning() == true) {
            if(status.getRoundPhase() == 1) {
                roll(status);
                window.drawRollResult(status);
                status.turnPhase++;
            }
            window.drawRollResult(status);
            setRerollPool();
            reroll();
            countScore();
            updateGameStatus();
        }
    }
}
