package JavaQuest;

import java.util.Scanner;

import fr.jocelynd.JavaQuest.business.Player;
import fr.jocelynd.JavaQuest.business.Monster;

import java.util.Random;

public class Combat {

	public static int attaquer(int force, int defense) {
		int degats = 0;
		Random randomGenerator = new Random();
		degats = force + randomGenerator.nextInt(force / 5) - defense;
		if (degats <= 1) {
			System.out.println("L'attaque est inéficace et ne fait qu'1 dégât.");
			return 1;
		} else {
			System.out.println(degats + " dégâts infligés !");
			return degats;
		}
	}

	public static int augmenterForce() {
		int bonus = 0;
		Random randomGenerator = new Random();
		bonus = randomGenerator.nextInt(3) + 1;
		System.out.println("Bonus de force : " + bonus);
		return bonus;
	}

	public static int seSoigner(int vie, int vieMax, int force) {
		int soin = 0;
		Random randomGenerator = new Random();
		soin = randomGenerator.nextInt(force*2)+force;
		System.out.println("Le héros récupère " + soin + " points de vie.");
		vie += soin;
		if (vie > vieMax) {
			vie = vieMax;
		}
		return vie;
	}

	public static int seSuicider() {
		System.out.println("Le héros se plante son épée dans le ventre, mais que fait-il ????");
		System.out.println("Il est au bord de l'agonie !!!!");
		return 1;
	}

	public static boolean fight(Player heros, Monster monstre) {

		int tour = 0;
		int bonusfrc = 0;
		int action;

		Action act = new Action();

		do {
			tour++;
			
			System.out.println("\n\nTour n° " + tour);
			System.out
					.println("Santé de " + monstre.getNom() + " " + 100 * monstre.getPdv() / monstre.getPdvMax() + "%");
			System.out.println("\nStats de " + heros.getNom());
			System.out.println("Vie actuelle " + heros.getPdv() + "/" + heros.getPdvMax());
			System.out.println("Force " + heros.getFrc() + "+" + bonusfrc + " // Défense " + heros.getDfs());
			System.out.println("\nChoisissez votre action");
			System.out.println("1) Attaquer le montre");
			System.out.println("2) Augmenter sa force");
			System.out.println("3) Se soigner");
			System.out.println("4) Se suicider (perdre)");
			System.out.println("\n\nChoisissez votre action");
			action = act.scanIntBetween(1, 4);

			switch (action) {
			case 1:
				System.out.println("\nLe héros attaque !");
				monstre.setPdv(monstre.getPdv() - attaquer(heros.getFrc() + bonusfrc, monstre.getDfs()));
				break;
			case 2:
				bonusfrc += augmenterForce();
				break;
			case 3:
				heros.setPdv(seSoigner(heros.getPdv(), heros.getPdvMax(), heros.getFrc()));
				break;
			case 4:
				heros.setPdv(seSuicider());

				break;
			default:
				System.out.println("\nAction loupée...");
				break;

			}
			if (heros.getPdv() > 0) {
				System.out.println("\nLe monstre réplique !");
				heros.setPdv(heros.getPdv() - attaquer(monstre.getFrc() + tour, heros.getDfs()));
			}
		} while ((heros.getPdv() > 0) && (monstre.getPdv() > 0));
		if (monstre.getPdv() <= 0 && heros.getPdv() > 0) {
			System.out.println("\n\nLe monstre est vaincu, vous avez gagné !!!");
			System.out.println("vous remportez " + monstre.getXp() + " Points d'expérience.");
			System.out.println("vous remportez " + monstre.getGold() + " pièces d'or.");

			heros.setXp(heros.getXp() + monstre.getXp());
			heros.setGold(heros.getGold() + monstre.getGold());
			if (heros.getXp() >= 100)
			{
				heros.levelUp();
			}
			return true;

		} else {
			System.out.println("\n\nVous avez péri au combat...");
			return false;
		}

	}
}
