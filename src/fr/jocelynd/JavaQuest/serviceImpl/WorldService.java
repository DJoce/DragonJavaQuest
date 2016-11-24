package fr.jocelynd.JavaQuest.serviceImpl;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import fr.jocelynd.JavaQuest.business.Player;
import fr.jocelynd.JavaQuest.service.FightInterface;
import fr.jocelynd.JavaQuest.service.ItemInterface;
import fr.jocelynd.JavaQuest.service.MonsterInterface;
import fr.jocelynd.JavaQuest.service.PlayerInterface;
import fr.jocelynd.JavaQuest.service.WorldInterface;
import fr.jocelynd.JavaQuest.utils.Utils;
import fr.jocelynd.JavaQuest.business.Monster;

public class WorldService implements WorldInterface {
	PlayerInterface pl = new PlayerService();
	MonsterInterface mi = new MonsterService();
	FightInterface fi = new FightService();
	ItemInterface ii = new ItemService();
	Random rng = new Random();
	Utils act = new Utils();
	Player heros = new Player();
	Date time = new Date();

	public void createHero() {
		time.getTime();
		heros.setGameStartTime(time);
		String name;

		System.out.println("Bonjour valeureux héros, pouvez-vous indiquer votre nom ? (2 à 12 caractères)");
		name = act.getStringFromScanner(12, 2);

		name = name.trim();
		heros.setNom(name);
		heros.setPdv(200 + rng.nextInt(50));
		heros.setPdvMax(heros.getPdv());
		heros.setFrc(15 + rng.nextInt(10));
		heros.setDfs(10 + rng.nextInt(5));
		heros.setNv(1);
		heros.setXp(0);
		heros.setGold(50);

		System.out.println("Bonjour " + heros.getNom() + ", bienvenue dans le monde de Hitozolt");
		pl.getCaracteristiques(heros);

	}

	public void game() {

		boolean stay = true;
		createHero();

		stay = true;
		int choix;
		do {
			System.out.println("\n\nQue voulez-vous faire, héros ?");
			System.out.println("1) Affronter un monstre");
			System.out.println("2) Consulter caractéristiques");
			System.out.println("3) Se reposer à l'Hôtel (30 pièces d'or)");
			System.out.println("4) Visiter la boutique");
			System.out.println("0) Quitter");
			choix = act.scanIntBetween(0, 4);

			switch (choix) {

			case 1: {
				Monster monstre = new Monster();
				monstre = mi.listOfMonster();
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

			case 4: {
				ii.buyItem(heros);
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
