package com.kodilla;

import java.util.Random;

public class GameEngine {
    UserInterface ui = new UserInterface();
    Random rollGen = new Random();
    int x;

    public void roll(GameStatus status, Display window) {
        for(int i = 0; i < 4; i++) {
            x = rollGen.nextInt(6);
			  	status.getPlayerPool().replace(i, window.getDiceSides().get(x));
            x = rollGen.nextInt(6);
			  	status.getComputerPool().replace(i, window.getDiceSides().get(x));
        }
    }
    public void reroll(Display window, GameStatus status, int diceId) {
    	int rerollResult = rollGen.nextInt(6);
    	status.getPlayerPool().replace(diceId, window.getDiceSides().get(rerollResult));
    	window.drawReroll(status);
    }
    public void countScore(Display window, GameStatus status) {
    	for(int i = 0; i < 4; i++) {
    		if(status.getPlayerPool().get(i) == window.getDiceSides().get(0)) {
    			status.playerRollResult.replace(0, status.getPlayerRollResult().get(0) + 1);
			} else if(status.getPlayerPool().get(i) == window.getDiceSides().get(1)) {
				status.playerRollResult.replace(1, status.getPlayerRollResult().get(1) + 1);
			} else if(status.getPlayerPool().get(i) == window.getDiceSides().get(2)) {
				status.playerRollResult.replace(2, status.getPlayerRollResult().get(2) + 1);
    		} else if(status.getPlayerPool().get(i) == window.getDiceSides().get(3)) {
				status.playerRollResult.replace(3, status.getPlayerRollResult().get(3) + 1);
			} else if(status.getPlayerPool().get(i) == window.getDiceSides().get(4)) {
				status.playerRollResult.replace(4, status.getPlayerRollResult().get(4) + 1);
			} else {
				status.playerRollResult.replace(5, status.getPlayerRollResult().get(5) + 1);
			}
			if(status.getComputerPool().get(i) == window.getDiceSides().get(0)) {
				status.computerRollResult.replace(0, status.getComputerRollResult().get(0) + 1);
			} else if(status.getComputerPool().get(i) == window.getDiceSides().get(1)) {
				status.computerRollResult.replace(1, status.getComputerRollResult().get(1) + 1);
			} else if(status.getComputerPool().get(i) == window.getDiceSides().get(2)) {
				status.computerRollResult.replace(2, status.getComputerRollResult().get(2) + 1);
			} else if(status.getComputerPool().get(i) == window.getDiceSides().get(3)) {
				status.computerRollResult.replace(3, status.getComputerRollResult().get(3) + 1);
			} else if(status.getComputerPool().get(i) == window.getDiceSides().get(4)) {
				status.computerRollResult.replace(4, status.getComputerRollResult().get(4) + 1);
			} else {
				status.computerRollResult.replace(5, status.getComputerRollResult().get(5) + 1);
			}
		}

    	for(int j = 0; j < 6; j++) {
    		if(status.getPlayerRollResult().get(j) == 4) {
    			status.setPlayerScore(status.playerScore + 100);
			}
    		if(status.getPlayerRollResult().get(j) == 3) {
				status.setPlayerScore(status.playerScore + ((j + 1) * 10));
			}
    		if(status.getPlayerRollResult().get(j) == 2) {
    			status.setPlayerScore(status.playerScore + ((j + 1) * 5));
			}
    		if(status.getPlayerRollResult().get(j) == 1) {
    			status.setPlayerScore(status.playerScore + (j + 1));
			}

			if(status.getComputerRollResult().get(j) == 4) {
				status.setComputerScore(status.computerScore + 100);
			}
			if(status.getComputerRollResult().get(j) == 3) {
				status.setComputerScore(status.computerScore + ((j + 1) * 10));
			}
			if(status.getComputerRollResult().get(j) == 2) {
				status.setComputerScore(status.computerScore + ((j + 1) * 5));
			}
			if(status.getComputerRollResult().get(j) == 1) {
				status.setComputerScore(status.computerScore + (j + 1));
			}
		}
    	window.drawScores(status);
	 }
	 public void updateStatus(GameStatus status, Display window) {
    	for(int i = 0; i < 6; i++) {
    		status.getPlayerRollResult().replace(i, 0);
    		status.getComputerRollResult().replace(i,0);
		}
    	if(status.getPlayerScore() == status.getPointsToWin() || status.getComputerScore() == status.getPointsToWin()) {
    		status.setGameRunning(false);
    		window.endGame();
		}
	 }
}
