package fr.jocelynd.JavaQuest.business;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Player extends Character {

	private int nv;
	private Date gameStartTime = new Date();
	private Item itemOn;
	private int id;

	
	public Player(String nom, int pdv, int pdvMax, int frc, int dfs, int xp, int gold, int nv) {
		super(nom, pdv, pdvMax, frc, dfs, xp, gold);
		this.nv = nv;
		// TODO Auto-generated constructor stub
	}
	
	public Player(String nom, int pdv, int pdvMax, int frc, int dfs, int xp, int gold) {
		super(nom, pdv, pdvMax, frc, dfs, xp, gold);
		// TODO Auto-generated constructor stub
	}

	public Player() {
		// TODO Auto-generated constructor stub
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getNv() {
		return nv;
	}

	public void setNv(int nv) {
		this.nv = nv;
	}

	public Date getGameStartTime() {
		return gameStartTime;
	}

	public void setGameStartTime(Date l) {
		this.gameStartTime = l;
	}

	public Item getItemOn() {
		return itemOn;
	}

	public void setItemOn(Item itemOn) {
		this.itemOn = itemOn;
	}

}