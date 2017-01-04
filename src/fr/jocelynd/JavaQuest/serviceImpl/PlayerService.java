package fr.jocelynd.JavaQuest.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import fr.jocelynd.JavaQuest.business.Player;
import fr.jocelynd.JavaQuest.service.PlayerInterface;
import fr.jocelynd.JavaQuest.utils.Consts;
import fr.jocelynd.JavaQuest.utils.Utils;

public class PlayerService implements PlayerInterface{

	Random rng = new Random();
	Utils act = new Utils();
	Date time = new Date();
	
	
	private Connection conn;
	
	public PlayerService(Connection conn) {
		this.conn = conn;
	}
	
	private final int PRICE = 30;

	public void saveGame (Player pl) {
		System.out.println("Choisir un fichier de sauvegarde");
		String query = Consts.GET_FILES;
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				System.out.println("FICHIER " + rs.getLong("id") + "||" + rs.getString("nom") + " niveau " + rs.getInt("nv"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int id = act.scanIntBetween(1, 3);
		
		query = Consts.SAVE_PLAYER; // "UPDATE player SET pdv = ?, pdvMax = ?, frc = ?, dfs = ?, nv = ?, xp = ?, gold = ? WHERE id = ?"
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(9, id);
			pstm.setInt(1, pl.getPdv());
			pstm.setInt(2, pl.getPdvMax());
			pstm.setInt(3, pl.getFrc());
			pstm.setInt(4, pl.getDfs());
			pstm.setInt(5, pl.getNv());
			pstm.setInt(6, pl.getXp());
			pstm.setInt(7, pl.getGold());
			pstm.setString(8, pl.getNom());
			System.out.println(pstm);
			if (pstm.execute()) {
				System.out.println("Sauvegarde terminée !");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Player createHero() {
		Player heros = new Player();
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
		getCaracteristiques(heros);
		
		return heros;
	}
	
	public Player loadHero() {

		System.out.println("Choisissez un personnage à charger\n");
		
		String query = Consts.GET_FILES;
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				System.out.println("FICHIER " + rs.getLong("id") + "||" + rs.getString("nom") + " niveau " + rs.getInt("nv"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int id = act.scanIntBetween(1, 3);
		
		query = Consts.GET_PLAYER;
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			System.out.println(pstm);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return new Player(rs.getString("nom"), rs.getInt("pdv"), rs.getInt("pdvMax"), rs.getInt("frc"), rs.getInt("dfs"), rs.getInt("xp"), rs.getInt("gold"), rs.getInt("nv"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void getCaracteristiques(Player pl) {
		System.out.println("Voici vos caractéristiques :");
		System.out.println(pl.getNom() + " || Niveau " + pl.getNv() + " Expérience " + pl.getXp());
		System.out.println("Vie : " + pl.getPdv() + "/" + pl.getPdvMax() + " | Force : " + pl.getFrc() + " | Défence : " + pl.getDfs());
		System.out.println("Pièces d'or : " + pl.getGold());
		Date time = new Date();
		int nowTime = (int) time.getTime();
		int startTime = (int) pl.getGameStartTime().getTime();
		int totalTime = (nowTime - startTime) / 1000;
		int hours = totalTime / 3600;
		int minutes = (totalTime - (hours * 3600)) / 60;
		int seconds = totalTime % 60;
		System.out.println("temps écoulé : " + hours + ":" + minutes + ":" + seconds);
		System.out.println("Voulez-vous sauvegarder votre partie ? O/N");
		char save = act.getYesOrNo();
		if (save == 'Y') {
			saveGame(pl);
		}
		

	}

	public void levelUp(Player pl) {
		Random rng = new Random();
		System.out.println("\n\nVous avez gagné un niveau !");
		pl.setNv(pl.getNv() +1 );;
		pl.setPdvMax(pl.getPdvMax() + rng.nextInt(10) + 15);
		pl.setPdv(pl.getPdvMax());
		pl.setFrc(pl.getFrc() + rng.nextInt(5)+1);
		pl.setDfs(pl.getDfs() + rng.nextInt(5)+1);
		System.out.println("Niveau " + pl.getNv());
		System.out.println("Vie " + pl.getPdvMax());
		System.out.println("Force : " + pl.getFrc() + " Défense : " + pl.getDfs());
		pl.setXp(pl.getXp() - 100);

	}

	public void goToHotel(Player pl) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Une nuit à l'hôtel coûte " + PRICE + " pièce d'or.");
		System.out.println("Rester pour la nuit ? (O / N)");
		String choix =  sc.nextLine();
		if (choix.equals("O") || choix.equals("o")) {

			if (pl.getGold() >= PRICE) {
				pl.setGold(pl.getGold() - PRICE);;
				pl.setPdv(pl.getPdvMax());
				System.out.println("Vous passez une nuit confortable à l'hôtel, votre santé est totalement restaurée.");
			} else {
				System.out.println("Vous n'avez pas assez d'argent...");

			}
		} else {
			System.out.println("Vous quittez l'hôtel.");

		}

	}

}
