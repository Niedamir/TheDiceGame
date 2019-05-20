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
	Button btnReRoll = new Button();
	boolean isPlayerTurn = false;



	public void roll(GridPane grid, FlowPane playerDicePanel, FlowPane computerDicePanel, ArrayList<Image> dicePointsList, boolean[] playerSetToRoll, boolean[] computerSetToRoll, ArrayList<Button> setters) {
		grid.add(btnRoll, 10, 10, 1, 1);
		btnRoll.setText("Rzuć kośćmi");
		btnRoll.setOnAction((e) -> {
			playerPool.rollPool(playerSetToRoll);
			playerPool.displayPool(playerDicePanel, dicePointsList);
			computerPool.rollPool(computerSetToRoll);
			computerPool.displayPool(computerDicePanel, dicePointsList);
			isPlayerTurn = true;
			grid.getChildren().remove(btnRoll);
			grid.add(btnReRoll, 10,10,1,1);
			for(Button btn : setters) {
				btn.setText("Dodaj do puli");
				grid.add(btn, setters.indexOf(btn), 12, 1, 1);
			}
		});
	}
	public void reroll(GridPane grid, FlowPane playerDicePanel, FlowPane computerDicePanel, ArrayList<Image> dicePointsList, boolean[] playerSetToRoll, boolean[] computerSetToRoll, ArrayList<Button> setters) {
		playerSetToRoll = playerPool.getPool(grid, playerSetToRoll, setters);

		btnReRoll.setText("Przerzuć kości");
		btnReRoll.setOnAction((e) -> {

		});
	}
}
