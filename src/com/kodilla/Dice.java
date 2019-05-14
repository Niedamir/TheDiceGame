package com.kodilla;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Random;

public class Dice {
	Random rollGen = new Random();
	int rollResult;
	Image result;

	public Image roll(ArrayList<Image> dicePoints) {
		rollResult = rollGen.nextInt(6) + 1;
		for(int i = 1; i <= 6; i++) {
			if(rollResult == i) {
				result = dicePoints.get(i);
			}
		}
		return result;
	}
}
