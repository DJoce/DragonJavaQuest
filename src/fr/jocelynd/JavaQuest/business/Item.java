package fr.jocelynd.JavaQuest.business;

public class Item {
	
	private String name;
	private int bonusFrc;
	private int bonusDfs;
	private int bonusPdv;
	private int goldBuy;
	private int goldSell;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBonusFrc() {
		return bonusFrc;
	}
	public void setBonusFrc(int bonusFrc) {
		this.bonusFrc = bonusFrc;
	}
	public int getBonusDfs() {
		return bonusDfs;
	}
	public void setBonusDfs(int bonusDfs) {
		this.bonusDfs = bonusDfs;
	}
	public int getBonusPdv() {
		return bonusPdv;
	}
	public void setBonusPdv(int bonusPdv) {
		this.bonusPdv = bonusPdv;
	}
	public int getGoldBuy() {
		return goldBuy;
	}
	public void setGoldBuy(int goldBuy) {
		this.goldBuy = goldBuy;
	}
	public int getGoldSell() {
		return goldSell;
	}
	public void setGoldSell(int goldSell) {
		this.goldSell = goldSell;
	}
	@Override
	public String toString() {
		return "Items [name=" + name + ", bonusFrc=" + bonusFrc + ", bonusDfs=" + bonusDfs + ", bonusPdv=" + bonusPdv
				+ ", coinBuy=" + goldBuy + ", coinSell=" + goldSell + "]";
	}
	public Item(String name, int bonusFrc, int bonusDfs, int bonusPdv, int goldBuy, int goldSell) {
		super();
		this.name = name;
		this.bonusFrc = bonusFrc;
		this.bonusDfs = bonusDfs;
		this.bonusPdv = bonusPdv;
		this.goldBuy = goldBuy;
		this.goldSell = goldSell;
	}
	
	
	

}
