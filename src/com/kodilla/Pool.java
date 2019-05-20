package com.kodilla;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Pool {
	Random rollGen = new Random();
	HashMap<Integer, Integer> thePool;
	Button btnSetDice = new Button();

	//CONSTRUCTOR
	public Pool(HashMap thePool) {
		this.thePool = thePool;
		thePool.put(0, 0);
		thePool.put(1, 0);
		thePool.put(2, 0);
		thePool.put(3, 0);
	}

	//CODE
	public boolean[] getPool(GridPane grid, boolean isPlayerTurn) {
		boolean[] result = new boolean[4];
		if(isPlayerTurn == true) {
			grid.add(btnSetDice, 0,0,1, 1);
			btnSetDice.setText("Dodaj do puli");
			btnSetDice.setOnAction((e) -> {
				result[0] = true;
			});
		}
		return result;
	}

	public void rollPool(boolean[] setToRoll) {
		thePool.forEach((k, v) -> {
			if (setToRoll[k] == true) {
				thePool.replace(k, rollGen.nextInt(6));
				setToRoll[k] = false;
			}
		});
	}
	public void displayPool(FlowPane theDicePanel, ArrayList<Image> dicePoints) {
		for(int i = 0; i < 4; i++) {
			theDicePanel.getChildren().remove(i);
			ImageView imgDice = new ImageView(dicePoints.get(thePool.get(i)));
			theDicePanel.getChildren().add(imgDice);
		}
	}

}
