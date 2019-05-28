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

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }
    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }
    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }

    public int getPlayerScore() {
        return playerScore;
    }
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public Integer getTurnPhase() {
        return turnPhase;
    }
    public void setTurnPhase(Integer turnPhase) {
        this.turnPhase = turnPhase;
    }

    public HashMap<Integer, Integer> getPlayerRollResult() {
        return playerRollResult;
    }
    public void setPlayerRollResult(HashMap<Integer, Integer> playerRollResult) {
        this.playerRollResult = playerRollResult;
    }

    public HashMap<Integer, Integer> getComputerRollResult() {
        return computerRollResult;
    }
    public void setComputerRollResult(HashMap<Integer, Integer> computerRollResult) {
        this.computerRollResult = computerRollResult;
    }
}
