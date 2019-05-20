package com.kodilla;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMechanic {
	Pool playerPool = new Pool(new HashMap());
	Pool computerPool = new Pool(new HashMap());
	Button btnRoll = new Button();
	boolean isPlayerTurn = false;

	public void roll(GridPane grid, FlowPane playerDicePanel, FlowPane computerDicePanel, ArrayList<Image> dicePointsList, boolean[] playerSetToRoll, boolean[] computerSetToRoll) {
		grid.add(btnRoll, 10, 10, 1, 1);
		btnRoll.setText("Rzuć kośćmi");
		btnRoll.setOnAction((e) -> {
			playerPool.rollPool(playerSetToRoll);
			playerPool.displayPool(playerDicePanel, dicePointsList);
			computerPool.rollPool(computerSetToRoll);
			computerPool.displayPool(computerDicePanel, dicePointsList);
			isPlayerTurn = true;
		});
	}
	public void reroll(GridPane grid, FlowPane playerDicePanel, FlowPane computerDicePanel, ArrayList<Image> dicePointsList) {
		btnRoll.setText("Przerzuć kości");
		btnRoll.setOnAction((e) -> {
			final boolean[] SetToRoll = playerPool.getPool(grid, isPlayerTurn);
			playerPool.rollPool(SetToRoll);
			playerPool.displayPool(playerDicePanel, dicePointsList);
			isPlayerTurn = false;
		});
	}
}
