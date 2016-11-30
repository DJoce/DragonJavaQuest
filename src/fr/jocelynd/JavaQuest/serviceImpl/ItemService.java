package fr.jocelynd.JavaQuest.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import fr.jocelynd.JavaQuest.business.Item;
import fr.jocelynd.JavaQuest.business.Player;
import fr.jocelynd.JavaQuest.service.ItemInterface;
import fr.jocelynd.JavaQuest.utils.Utils;

public class ItemService implements ItemInterface {

	Utils ut = new Utils();

	public ArrayList<Item> createItemList() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Ep�e de bois          ", 5, 0, 0, 100, 25));
		items.add(new Item("Armure de papier      ", 0, 5, 0, 100, 25));
		items.add(new Item("Pendantif de papier   ", 0, 0, 20, 100, 25));
		items.add(new Item("Ep�e de bronze        ", 15, 0, 0, 200, 50));
		items.add(new Item("Armure de bronze      ", 0, 15, 0, 200, 50));
		items.add(new Item("Pendantif de bronze   ", 0, 0, 50, 200, 50));

		return items;
	}

	public void buyItem(Player pl) {
		ArrayList<Item> items = createItemList();
		int i = 0;
		System.out.println(
				"Bienvenue dans mon humble �chope jeune guerrier, regardez donc ce que j'ai en magasin...");
		for (Item item : items) {
			i++;
			System.out.print("\n" + i + ") " + item.getName() + "||" + item.getGoldBuy() + " pi�ces ");
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
		System.out.println(
				"\n\nQuel item vous int�resse le plus ?");

		int choice = ut.scanIntBetween(1, items.size());
		System.out.println("Voulez-vous acheter " + items.get(choice).getName() + " pour "
				+ items.get(choice).getGoldBuy() + " pi�ces ?");
		System.out.println("Votre bourse contient " + pl.getGold());
		char res = ut.getYesOrNo();
		if (res == 'Y') {
			if (pl.getGold() > items.get(choice).getGoldBuy()) {
				pl.setGold(pl.getGold() - items.get(choice).getGoldBuy());
				pl.setItemOn(items.get(choice));
				System.out.println("Merci beaucoup !");

			} else {
				System.out.println("Tu n'as pas assez d'argent...");
			}
		} else {
			System.out.println("Tr�s bien, au revoir...");

		}
	}

}
