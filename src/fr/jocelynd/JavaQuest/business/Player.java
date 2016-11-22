package fr.jocelynd.JavaQuest.business;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Player extends Character {

	private int nv;
	private Date gameStartTime = new Date();

	public Player(String nom, int pdv, int pdvMax, int frc, int dfs, int xp, int gold) {
		super(nom, pdv, pdvMax, frc, dfs, xp, gold);
		// TODO Auto-generated constructor stub
	}

	public Player() {
		// TODO Auto-generated constructor stub
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


}