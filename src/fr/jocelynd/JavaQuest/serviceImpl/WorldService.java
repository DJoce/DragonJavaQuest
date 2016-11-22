package fr.jocelynd.JavaQuest.serviceImpl;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import fr.jocelynd.JavaQuest.business.Player;
import fr.jocelynd.JavaQuest.service.FightInterface;
import fr.jocelynd.JavaQuest.service.PlayerInterface;
import fr.jocelynd.JavaQuest.service.WorldInterface;
import fr.jocelynd.JavaQuest.utils.Utils;
import fr.jocelynd.JavaQuest.business.Monster;

public class WorldService implements WorldInterface {
	PlayerInterface pl = new PlayerService();
	FightInterface fi = new FightService();

	public void game() {

		Player heros = new Player();
		Random rng = new Random();
		Scanner sc = new Scanner(System.in);
		Date time = new Date();
		Utils act = new Utils();
		String name;
		boolean stay = true;

		time.getTime();
		heros.setGameStartTime(time);
		System.out.println("Bonjour valeureux héros, pouvez-vous indiquer votre nom ? (2 à 12 caractères)");
		do {
			name = sc.nextLine();
			if (name.length() > 12 || name.length() < 2) {
				System.out.println("Invalide");
				stay = true;
			} else {
				stay = false;
			}
		} while (stay);

		name = name.trim();
		heros.setNom(name);
		heros.setPdv(200 + rng.nextInt(50));
		heros.setPdvMax(heros.getPdv());
		heros.setFrc(15 + rng.nextInt(10));
		heros.setDfs(10 + rng.nextInt(5));
		heros.setNv(1);
		heros.setXp(0);
		heros.setGold(50);

		System.out.println("Bonjour " + heros.getNom() + ", bienvenue dans un monde de JavaQuest vers. Pipi !");
		pl.getCaracteristiques(heros);

		stay = true;
		int choix;
		do {
			System.out.println("\n\nQue voulez-vous faire, héros ?");
			System.out.println("1) Affronter un monstre");
			System.out.println("2) Consulter caractéristiques");
			System.out.println("3) Se reposer à l'Hôtel (30 pièces d'or)");
			System.out.println("0) Quitter");
			choix = act.scanIntBetween(0, 4);

			switch (choix) {

			case 1: {
				Monster monstre = new Monster();
				monstre = monstre.listOfMonster();
				stay = fi.fight(heros, monstre);
				break;
			}
			case 2: {
				pl.getCaracteristiques(heros);
				break;
			}
			case 3: {
				pl.goToHotel(heros);
				break;
			}

			case 0: {
				stay = false;
				break;
			}
			default: {
				System.out.println("veuillez indiquer un choix valide");
				break;
			}
			}
		} while (stay);
	}
}
