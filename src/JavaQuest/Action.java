package JavaQuest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Action {

	public Action() {}
	
	public int scanIntBetween(int min, int max) {
		Scanner sc = new Scanner(System.in);
		int value = 0;
		boolean stay = true;
		while (stay) {

			try {
				value = Integer.parseInt(sc.nextLine());
				if (value >= min && value <= max) {
					stay = false;
				} else {
					System.out.println("Veuillez saisir un nombre entre " + min + " et " + max);
				}
			} catch (InputMismatchException e) {
				System.out.println("saisie incorrecte");
			} catch (NumberFormatException e) {
				System.out.println("saisie incorrecte");
			}
		}
		return value;

	}
}
