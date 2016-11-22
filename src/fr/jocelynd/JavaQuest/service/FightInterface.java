package fr.jocelynd.JavaQuest.service;

import fr.jocelynd.JavaQuest.business.Monster;
import fr.jocelynd.JavaQuest.business.Player;

public interface FightInterface {

	
	public int attaquer(int force, int defense);
	public  int augmenterForce();
	public  int seSoigner(int vie, int vieMax, int force);
	public  int seSuicider();
	public boolean fight(Player heros, Monster monstre);


	
	

}
