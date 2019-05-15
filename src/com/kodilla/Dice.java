package com.kodilla;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Random;

public class Dice {
	Random rollGen = new Random();
	int rollResult;
	Image result;

	public Image roll(ArrayList<Image> dicePoints) {
		return dicePoints.get(rollGen.nextInt(6));
	}
}
