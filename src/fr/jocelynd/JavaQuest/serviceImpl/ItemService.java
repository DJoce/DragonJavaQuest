package fr.jocelynd.JavaQuest.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import fr.jocelynd.JavaQuest.business.Item;
import fr.jocelynd.JavaQuest.business.Player;
import fr.jocelynd.JavaQuest.service.ItemInterface;

public class ItemService implements ItemInterface {

	public ArrayList<Item> createItemList() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Epée de bois          ", 5,0,0,100,25));
		items.add(new Item("Armure de papier      ", 0,5,0,100,25));
		items.add(new Item("Pendantif de papier   ", 0,0,20,100,25));
		return items;
	}
	
	public void buyItem(Player pl) {
		ArrayList<Item> items = createItemList();
		int i = 0;
		System.out.println("Bienvenue dans mon humble échope jeune guerrier, n'hésitez pas à sélectionner l'objet que vous souhaitez acheter");
		for (Item item : items) {
			i++;
			System.out.print("\n" + i + ")" + item.getName() + "||" + item.getGoldBuy() + " pièces ");
			if (item.getBonusFrc() > 0) {
				System.out.print("|| FORCE " + item.getBonusFrc());
			}
			if (item.getBonusDfs() > 0) {
				System.out.print("|| DEFENSE " + item.getBonusDfs());
			}
			if (item.getBonusPdv() > 0) {
				System.out.print("|| POINTS DE VIE " + item.getBonusPdv());
			}			
		}
	}
}
