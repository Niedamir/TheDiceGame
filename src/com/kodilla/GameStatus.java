package com.kodilla;

import java.util.HashMap;

public class GameStatus {
    boolean isPlayerTurn;
    boolean isGameRunning;
    int playerScore = 0;
    int computerScore = 0;

    HashMap<Integer, Integer> playerRollResult = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> computerRollResult = new HashMap<Integer, Integer>();

}
