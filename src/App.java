import fr.jocelynd.JavaQuest.serviceImpl.WorldService;

public class App {

	public static void main(String[] args) {
		WorldService wd = new WorldService();
		Display dsp = new Display();
		dsp.printTitle();
		dsp.printRules();
		wd.game();
		System.out.println("Game Over");

	}
	
}
