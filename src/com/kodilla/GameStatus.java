package com.kodilla;

import java.util.HashMap;

public class GameStatus {
    boolean isPlayerTurn;
    boolean isGameRunning;
    int playerScore = 0;
    int computerScore = 0;
    Integer turnPhase = 0;

    HashMap<Integer, Integer> playerRollResult = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> computerRollResult = new HashMap<Integer, Integer>();

    public int getRoundPhase() {
        return turnPhase;
    }
    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }
    public boolean isGameRunning() {
        return isGameRunning;
    }
    public int getPlayerScore() {
        return playerScore;
    }
    public int getComputerScore() {
        return computerScore;
    }
    public HashMap<Integer, Integer> getPlayerRollResult() {
        return playerRollResult;
    }
    public HashMap<Integer, Integer> getComputerRollResult() {
        return computerRollResult;
    }
}
