package com.kodilla;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Initialization {

	public void initializeRollResultHashMaps(GameStatus status, Display window) {
		status.getPlayerRollResult().put(0, 0);
		status.getPlayerRollResult().put(1, 0);
		status.getPlayerRollResult().put(2, 0);
		status.getPlayerRollResult().put(3, 0);
		status.getPlayerRollResult().put(4, 0);
		status.getPlayerRollResult().put(5, 0);
		status.getComputerRollResult().put(0, 0);
		status.getComputerRollResult().put(1, 0);
		status.getComputerRollResult().put(2, 0);
		status.getComputerRollResult().put(3, 0);
		status.getComputerRollResult().put(4, 0);
		status.getComputerRollResult().put(5, 0);
		status.getPlayerPool().put(0, window.getDiceSides().get(0));
		status.getPlayerPool().put(1, window.getDiceSides().get(0));
		status.getPlayerPool().put(2, window.getDiceSides().get(0));
		status.getPlayerPool().put(3, window.getDiceSides().get(0));
		status.getComputerPool().put(0, window.getDiceSides().get(0));
		status.getComputerPool().put(1, window.getDiceSides().get(0));
		status.getComputerPool().put(2, window.getDiceSides().get(0));
		status.getComputerPool().put(3, window.getDiceSides().get(0));
	}
	public void initializeGame(Stage primaryStage, Display window, GameStatus status) {
		window.drawWindow(primaryStage);
		initializeRollResultHashMaps(status, window);
		window.drawScoreTable();
	}
}
