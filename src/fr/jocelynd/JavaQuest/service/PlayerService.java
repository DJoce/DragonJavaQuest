package fr.jocelynd.JavaQuest.service;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import fr.jocelynd.JavaQuest.business.Player;

public class PlayerService {

	private final int PRICE = 30;

	public void getCaracteristiques(Player pl) {
		System.out.println("Voici vos caract�ristiques :");
		System.out.println(pl.getNom() + " || Niveau " + pl.getNv() + " Exp�rience " + pl.getXp());
		System.out.println("Vie : " + pl.getPdv() + "/" + pl.getPdvMax() + " | Force : " + pl.getFrc() + " | D�fence : " + pl.getDfs());
		System.out.println("Pi�ces d'or : " + pl.getGold());
		Date time = new Date();
		int nowTime = (int) time.getTime();
		int startTime = (int) pl.getGameStartTime().getTime();
		int totalTime = (nowTime - startTime) / 1000;
		int hours = totalTime / 3600;
		int minutes = (totalTime - (hours * 3600)) / 60;
		int seconds = totalTime % 60;
		System.out.println("temps �coul� : " + hours + ":" + minutes + ":" + seconds);

	}

	public void levelUp(Player pl) {
		Random rng = new Random();
		System.out.println("\n\nVous avez gagn� un niveau !");
		pl.setNv(pl.getNv() +1 );;
		pl.setPdvMax(pl.getPdvMax() + rng.nextInt(10) + 15);
		pl.setPdv(pl.getPdvMax());
		pl.setFrc(pl.getFrc() + rng.nextInt(5)+1);
		pl.setDfs(pl.getDfs() + rng.nextInt(5)+1);
		System.out.println("Niveau " + pl.getNv());
		System.out.println("Vie " + pl.getPdvMax());
		System.out.println("Force : " + pl.getFrc() + " D�fense : " + pl.getDfs());
		pl.setXp(pl.getXp() - 100);

	}

	public void goToHotel(Player pl) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Une nuit � l'h�tel co�te " + PRICE + " pi�ce d'or.");
		System.out.println("Rester pour la nuit ? (O / N)");
		String choix =  sc.nextLine();
		if (choix.equals("O") || choix.equals("o")) {

			if (pl.getGold() >= PRICE) {
				pl.setGold(pl.getGold() - PRICE);;
				pl.setPdv(pl.getPdvMax());
				System.out.println("Vous passez une nuit confortable � l'h�tel, votre sant� est totalement restaur�e.");
			} else {
				System.out.println("Vous n'avez pas assez d'argent...");

			}
		} else {
			System.out.println("Vous quittez l'h�tel.");

		}

	}

}
