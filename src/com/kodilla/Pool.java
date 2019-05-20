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

	//CONSTRUCTOR
	public Pool(HashMap thePool) {
		this.thePool = thePool;
		thePool.put(0, 0);
		thePool.put(1, 0);
		thePool.put(2, 0);
		thePool.put(3, 0);
	}

	//CODE
	public boolean[] getPool(GridPane grid, boolean[] diceToRoll, ArrayList<Button> setters) {
		for (int x = 0; x < 4; x++) {
			setters.get(x).setOnAction((e) -> {
				diceToRoll[x] = true;
				grid.getChildren().remove(setters.get(x));
			});
		}
		return diceToRoll;
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
