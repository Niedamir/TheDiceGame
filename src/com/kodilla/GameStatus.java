package com.kodilla;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;

public class GameStatus {
    boolean isPlayerTurn;
    boolean isGameRunning;
    int playerScore = 0;
    int computerScore = 0;
    Integer turnPhase = 0;

    HashMap<Integer, Integer> playerRollResult = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> computerRollResult = new HashMap<Integer, Integer>();
    HashMap<Integer, Image> playerPool = new HashMap<Integer, Image>();
    HashMap<Integer, Image> computerPool = new HashMap<Integer, Image>();

    public HashMap<Integer, Image> getComputerPool() {
        return computerPool;
    }
    public void setComputerPool(HashMap<Integer, Image> computerPool) {
        this.computerPool = computerPool;
    }

    public HashMap<Integer, Image> getPlayerPool() {
        return playerPool;
    }
    public void setPlayerPool(HashMap<Integer, Image> playerPool) {
        this.playerPool = playerPool;
    }

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


    public String playerScoreToString() {
        return "" + playerScore;
    }
    public String computerScoreToString() {
        return "" + computerScore;
    }

    @Override
    public String toString() {
        return "GameStatus{" +
           "playerPool=" + playerPool +
           ", computerPool=" + computerPool +
           '}';
    }
}
