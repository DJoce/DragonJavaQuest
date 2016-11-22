package JavaQuest;

public class Aventure {

	public int goNorth(int pos) {
		pos -= 10;
		return pos;
	}

	public int goSouth(int pos) {
		pos += 10;
		return pos;
	}

	public int goEast(int pos) {
		pos -= 1;
		return pos;
	}

	public int goWest(int pos) {
		pos += 1;
		return pos;
	}

}
