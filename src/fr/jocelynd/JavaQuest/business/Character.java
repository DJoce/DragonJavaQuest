package fr.jocelynd.JavaQuest.business;

abstract class Character {

	protected String nom;
	protected int pdv, pdvMax, frc, dfs, xp, gold;

	public String toString() {
		return "Personnage [nom=" + nom + ", pdv=" + pdv + ", pdvMax=" + pdvMax + ", frc=" + frc + ", dfs=" + dfs
				+ ", xp=" + xp + ", gold=" + gold + "]";
	}

	public Character(String nom, int pdv, int pdvMax, int frc, int dfs, int xp, int gold) {
		super();
		this.nom = nom;
		this.pdv = pdv;
		this.pdvMax = pdvMax;
		this.frc = frc;
		this.dfs = dfs;
		this.xp = xp;
		this.gold = gold;
	}


	public Character() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	public int getPdv() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public int getPdvMax() {
		return pdvMax;
	}

	public void setPdvMax(int pdvMax) {
		this.pdvMax = pdvMax;
	}

	public int getFrc() {
		return frc;
	}

	public void setFrc(int frc) {
		this.frc = frc;
	}

	public int getDfs() {
		return dfs;
	}

	public void setDfs(int dfs) {
		this.dfs = dfs;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

}
