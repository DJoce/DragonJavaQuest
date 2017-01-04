import java.sql.Connection;
import java.sql.SQLException;

import fr.jocelynd.JavaQuest.serviceImpl.WorldService;
import fr.jocelynd.JavaQuest.utils.DataConnect;

public class App {

	public static void main(String[] args) {
		try (Connection conn = DataConnect.getConnection()) {
			Display dsp = new Display();
			dsp.printTitle();
			dsp.printRules();
			WorldService wd = new WorldService(conn);
			wd.game();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Game Over");

	}

}
