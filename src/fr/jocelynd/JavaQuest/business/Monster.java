package fr.jocelynd.JavaQuest.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import JavaQuest.Action;

@SuppressWarnings("resource")
public class Monster extends Character {

	private int indFrc;

	public Monster(String nom, int pdv, int pdvMax, int frc, int dfs, int xp, int gold) {
		super(nom, pdv, pdvMax, frc, dfs, xp, gold);
		// TODO Auto-generated constructor stub
	}

	public Monster() {
	}

	public Monster createGoblin() {
		Monster goblin = new Monster();
		Random rng = new Random();

		goblin.nom = "Gobelin noir";
		goblin.pdvMax = rng.nextInt(30) + 100;
		goblin.pdv = goblin.pdvMax;
		goblin.frc = rng.nextInt(6) + 10;
		goblin.dfs = rng.nextInt(6) + 10;
		goblin.xp = goblin.frc + goblin.dfs + rng.nextInt(10) + 5;
		goblin.gold = rng.nextInt(12) + 5;
		goblin.indFrc = 1;

		return goblin;
	}

	public Monster createMommy() {
		Monster mommy = new Monster();
		Random rng = new Random();

		mommy.nom = "Momie sanglante";
		mommy.pdvMax = rng.nextInt(200) + 150;
		mommy.pdv = mommy.pdvMax;
		mommy.frc = rng.nextInt(8) + 12;
		mommy.dfs = rng.nextInt(6) + 4;
		mommy.xp = mommy.frc + mommy.dfs + rng.nextInt(10) + 5;
		mommy.gold = rng.nextInt(20) + 5;
		mommy.indFrc = 1;

		return mommy;
	}

	public Monster createGhoul() {
		Monster ghoul = new Monster();
		Random rng = new Random();

		ghoul.nom = "Goule maléfique";
		ghoul.pdvMax = rng.nextInt(50) + 200;
		ghoul.pdv = ghoul.pdvMax;
		ghoul.frc = rng.nextInt(10) + 15;
		ghoul.dfs = rng.nextInt(5) + 5;
		ghoul.xp = ghoul.frc + ghoul.dfs + rng.nextInt(10) + 5;
		ghoul.gold = rng.nextInt(30) + 5;
		ghoul.indFrc = 2;

		return ghoul;
	}

	public Monster createWolf() {
		Monster wolf = new Monster();
		Random rng = new Random();

		wolf.nom = "Loup sauvage";
		wolf.pdvMax = rng.nextInt(150) + 200;
		wolf.pdv = wolf.pdvMax;
		wolf.frc = rng.nextInt(15) + 8;
		wolf.dfs = rng.nextInt(8) + 12;
		wolf.xp = wolf.frc + wolf.dfs + rng.nextInt(10) + 5;
		wolf.gold = rng.nextInt(45) + 5;
		wolf.indFrc = 2;

		return wolf;
	}

	public Monster createDragon() {
		Monster dragon = new Monster();
		Random rng = new Random();

		dragon.nom = "Dragon maléfique";
		dragon.pdvMax = rng.nextInt(200) + 300;
		dragon.pdv = dragon.pdvMax;
		dragon.frc = rng.nextInt(15) + 20;
		dragon.dfs = rng.nextInt(15) + 0;
		dragon.xp = dragon.frc + dragon.dfs + rng.nextInt(10) + 5;
		dragon.gold = rng.nextInt(100) + 20;
		dragon.indFrc = 3;

		return dragon;
	}

	public Monster listOfMonster() {
		Action act = new Action();

		List<Monster> lsMon = new ArrayList<Monster>();
		lsMon.add(createGoblin());
		lsMon.add(createMommy());
		lsMon.add(createGhoul());
		lsMon.add(createWolf());
		lsMon.add(createDragon());

		System.out.println("\n\nChoisissez le monstre à affronter :");
		for (int i = 0; i < lsMon.size(); i++) {
			System.out.print("\n" + (i + 1) + ") Affronter " + lsMon.get(i).nom + " ||| Force : ");
			for (int j = 0; j < lsMon.get(i).indFrc; j++) {
				System.out.print("*");
			}
		}
		System.out.println("\nEntrez le numéro de votre cible :");

		int choix;
		choix = act.scanIntBetween(1, lsMon.size() + 1);
		return lsMon.get(choix - 1);

	}

	public int getIndFrc() {
		return indFrc;
	}

	public void setIndFrc(int indFrc) {
		this.indFrc = indFrc;
	}
}