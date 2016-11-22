import fr.jocelynd.JavaQuest.serviceImpl.WorldService;

public class App {

	public static void main(String[] args) {
		WorldService wd = new WorldService();
		wd.game();
		System.out.println("Game Over");

	}
	
}
