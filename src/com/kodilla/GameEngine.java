package com.kodilla;

import java.util.Random;

public class GameEngine {
    Random rollGen = new Random();
    int x;

    public void roll(GameStatus status) {
        for(int i = 0; i < 4; i++) {
            x = rollGen.nextInt(6);
            status.getPlayerRollResult().replace(x, status.getPlayerRollResult().getObject(x) + 1);
        }
    }
    public void setRerollPool() {}
    public void reroll() {}
    public void countScore() {}
    public void updateGameStatus() {}

    public void theGame(Display window, GameStatus status) {
        while(isGameRunning == true) {
            roll(status);
            setRerollPool();
            reroll();
            countScore();
            updateGameStatus();
        }
    }
}
