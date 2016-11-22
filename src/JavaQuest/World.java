package JavaQuest;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import fr.jocelynd.JavaQuest.business.Player;
import fr.jocelynd.JavaQuest.business.Monster;

public class World {

	public static void main(String[] args) {

		Player heros = new Player();
		Random rng = new Random();
		Scanner sc = new Scanner(System.in);
		Date time = new Date();
		Action act = new Action();
		String name;
		boolean stay = true;

		time.getTime();
		heros.setGameStartTime(time);
		System.out.println("Bonjour valeureux h�ros, pouvez-vous indiquer votre nom ? (2 � 12 caract�res)");
		do {
		name = sc.nextLine();
		if (name.length() > 12 || name.length() < 2) {
			System.out.println("Invalide");
			 stay = true;
		} else {
			 stay = false;
		}
		}while(stay);
		
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
		heros.getCaracteristiques();
		stay = true;
		int choix;
		do {
			System.out.println("\n\nQue voulez-vous faire, h�ros ?");
			System.out.println("1) Affronter un monstre");
			System.out.println("2) Consulter caract�ristiques");
			System.out.println("3) Se reposer � l'H�tel (30 pi�ces d'or)");
			System.out.println("0) Quitter");
			choix = act.scanIntBetween(0, 4);

			switch (choix) {

			case 1: {
				Monster monstre = new Monster();
				monstre = monstre.listOfMonster();
				stay = Combat.fight(heros, monstre);
				break;
			}
			case 2: {
				heros.getCaracteristiques();
				break;
			}
			case 3: {
				heros.goToHotel();
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

		System.out.println("Game Over");
	}
}