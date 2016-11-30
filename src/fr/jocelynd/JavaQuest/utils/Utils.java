package fr.jocelynd.JavaQuest.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**.
 * m�thode contenant divers utilitaires utilisabble sur tous les projets
 * @author Jocelyn
 *
 */
public class Utils {
	Scanner sc = new Scanner(System.in);

	
	public Utils() {}
	/**.
	 * m�thode r�cup�rant un int entre deux valeurs pass�es en param�tres
	 * @param min le minimum que devra renvoyer la m�thode
	 * @param max le maximum que devra renvoyer la m�thode 
	 * @return int la valeur saisie
	 */
	public int scanIntBetween(final int min, final int max) {
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
	
	public String getStringFromScanner(int max, int min) {
	boolean stay;
	String name;
	do {
		name = sc.nextLine();
		if (name.length() > max || name.length() < min) {
			System.out.println("Invalide");
			stay = true;
		} else {
			stay = false;
		}
	} while (stay);
	return name;
	}
	
	
	public char getYesOrNo() {
	String choice;
	char res;
	boolean stay;
	do {
		System.out.println("(Y / N)");
		choice = sc.nextLine();
		res = choice.toUpperCase().charAt(0);
		
		if (res != 'Y' && res != 'N') {
			System.out.println("Invalide");
			stay = true;
		} else {
			stay = false;
		}
	} while (stay);
	return res;
	}
	
}
