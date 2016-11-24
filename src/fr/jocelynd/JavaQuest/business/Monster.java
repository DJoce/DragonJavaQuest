package fr.jocelynd.JavaQuest.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.jocelynd.JavaQuest.utils.Utils;

@SuppressWarnings("resource")
public class Monster extends Character {

	private int indFrc;


	public Monster() {
	}

	
	public Monster(String nom, int pdv, int pdvMax, int frc, int dfs, int xp, int gold, int indFrc) {
		super(nom, pdv, pdvMax, frc, dfs, xp, gold);
		this.indFrc = indFrc;
	}




	public int getIndFrc() {
		return indFrc;
	}

	public void setIndFrc(int indFrc) {
		this.indFrc = indFrc;
	}
}