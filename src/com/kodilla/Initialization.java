package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;

public class Initialization {
	Image imgDice1Point = new Image("file:resources/dice1.png");
	Image imgDice2Point = new Image("file:resources/dice2.png");
	Image imgDice3Point = new Image("file:resources/dice3.png");
	Image imgDice4Point = new Image("file:resources/dice4.png");
	Image imgDice5Point = new Image("file:resources/dice5.png");
	Image imgDice6Point = new Image("file:resources/dice6.png");

	public void initializeDice(boolean[] iniDice, FlowPane iniDicePanel) {
		for(int i = 0; i < 4; i++) {
			iniDice[i] = true;
			iniDicePanel.getChildren().add(new ImageView(imgDice6Point));
		}
	}
	public ArrayList<Image> initializeDicePointsList() {
		ArrayList<Image> dicePointsList = new ArrayList<Image>();
		dicePointsList.add(imgDice1Point);
		dicePointsList.add(imgDice2Point);
		dicePointsList.add(imgDice3Point);
		dicePointsList.add(imgDice4Point);
		dicePointsList.add(imgDice5Point);
		dicePointsList.add(imgDice6Point);
		return dicePointsList;
	}
}
