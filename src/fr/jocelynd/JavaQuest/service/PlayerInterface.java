package fr.jocelynd.JavaQuest.service;

import fr.jocelynd.JavaQuest.business.Player;

public interface PlayerInterface {
	
	public void getCaracteristiques(Player pl);
	public void levelUp(Player pl);
	public void goToHotel(Player pl);
	public Player createHero();
	public Player loadHero();



}
