package fr.jocelynd.JavaQuest.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.jocelynd.JavaQuest.business.Monster;
import fr.jocelynd.JavaQuest.service.MonsterInterface;
import fr.jocelynd.JavaQuest.utils.Utils;

public class MonsterService implements MonsterInterface {
	Random rng = new Random();

	public Monster listOfMonster() {
		Utils ut = new Utils();



		List<Monster> lsMon = new ArrayList<Monster>();
		lsMon.add(new Monster("Gobelin noir      ", 0, rng.nextInt(30) + 100, rng.nextInt(6) + 10, rng.nextInt(6) + 10,
				0, rng.nextInt(12) + 5, 1));
		lsMon.add(new Monster("Momie sanglante   ", 0, rng.nextInt(200) + 150, rng.nextInt(8) + 12, rng.nextInt(6) + 4,
				0, rng.nextInt(20) + 5, 1));
		lsMon.add(new Monster("Goule maléfique   ", 0, rng.nextInt(50) + 200, rng.nextInt(10) + 15, rng.nextInt(5) + 5,
				0, rng.nextInt(30) + 5, 2));
		lsMon.add(new Monster("Loup sauvage      ", 0, rng.nextInt(150) + 200, rng.nextInt(15) + 8, rng.nextInt(8) + 12,
				0, rng.nextInt(45) + 5, 2));
		lsMon.add(new Monster("Dragon maléfique  ", 0, rng.nextInt(200) + 300, rng.nextInt(15) + 20,
				rng.nextInt(15) + 0, 0, rng.nextInt(100) + 20, 1));

		System.out.println("\n\nChoisissez le monstre à affronter :");
		for (int i = 0; i < lsMon.size(); i++) {
			System.out.print("\n" + (i + 1) + ") Affronter " + lsMon.get(i).getNom()+ " ||| Force : ");
			for (int j = 0; j < lsMon.get(i).getIndFrc(); j++) {
				System.out.print("*");
			}
		}
		System.out.println("\nEntrez le numéro de votre cible :");

		int choix;
		choix = ut.scanIntBetween(1, lsMon.size() + 1);
		Monster monFight = lsMon.get(choix - 1);
		monFight.setPdv(monFight.getPdvMax());
		monFight.setXp(monFight.getFrc() + monFight.getDfs() + rng.nextInt(10) + 5);
		
		return lsMon.get(choix - 1);

	}
}
