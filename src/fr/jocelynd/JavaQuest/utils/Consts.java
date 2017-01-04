package fr.jocelynd.JavaQuest.utils;

public class Consts {

	public final static String GET_PLAYER = "SELECT * FROM player WHERE id = ?";
	public final static String GET_FILES = "SELECT id, nom, nv FROM player";
	public final static String SAVE_PLAYER = "UPDATE player SET pdv = ?, pdvMax = ?, frc = ?, dfs = ?, nv = ?, xp = ?, gold = ?, nom = ? WHERE id = ?";

	
}
