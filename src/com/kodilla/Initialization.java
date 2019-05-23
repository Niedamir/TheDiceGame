package com.kodilla;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Initialization {

	public void initializeRollResultHashMaps(GameStatus status) {
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
	}
	public void initializeGame(Stage primaryStage, Display window, GameStatus status) {
		window.drawWindow(primaryStage);
		initializeRollResultHashMaps(status);
	}
}
