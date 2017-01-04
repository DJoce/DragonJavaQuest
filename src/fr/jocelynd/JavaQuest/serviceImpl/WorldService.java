package fr.jocelynd.JavaQuest.serviceImpl;

import java.sql.Connection;
import java.util.Date;
import java.util.Random;

import fr.jocelynd.JavaQuest.business.Player;
import fr.jocelynd.JavaQuest.service.FightInterface;
import fr.jocelynd.JavaQuest.service.ItemInterface;
import fr.jocelynd.JavaQuest.service.MonsterInterface;
import fr.jocelynd.JavaQuest.service.PlayerInterface;
import fr.jocelynd.JavaQuest.service.WorldInterface;
import fr.jocelynd.JavaQuest.utils.Utils;
import fr.jocelynd.JavaQuest.business.Monster;

public class WorldService implements WorldInterface {
	
	private Connection conn;

	public WorldService(Connection conn) {
		this.conn = conn;
	}
	
	public void game() {

		PlayerInterface pi = new PlayerService(conn);
		MonsterInterface mi = new MonsterService();
		FightInterface fi = new FightService();
		ItemInterface ii = new ItemService();
		
		Utils act = new Utils();

		
		boolean stay = true;
		int newGame;
		Player heros = null;
		System.out.println("\n\nQue faire ?");
		System.out.println("1) Nouvelle Partie");
		System.out.println("2) Charger personnage");
		newGame = act.scanIntBetween(1, 2);
		switch (newGame) {

		case 1: {
			heros = pi.createHero();
			break;
		}
		case 2: {
			heros = pi.loadHero();
			break;
		}
		}

	
		

		stay = true;
		int choix;
		do {
			System.out.println("\n\nQue voulez-vous faire, héros ?");
			System.out.println("1) Affronter un monstre");
			System.out.println("2) Consulter caractéristiques / Sauvegarder");
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
				pi.getCaracteristiques(heros);
				break;
			}
			case 3: {
				pi.goToHotel(heros);
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
			
			if (heros.getXp() >= 100) {
				pi.levelUp(heros);
			}
		} while (stay);
	}


}
