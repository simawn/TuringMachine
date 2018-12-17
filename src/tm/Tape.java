package tm;
import java.util.HashMap;

public class Tape {
	private HashMap<Integer, Character> tapeRoll;

	public Tape() {
		this.tapeRoll = new HashMap<Integer, Character>();
	}
	
	protected void write(int i, char c) {
		this.tapeRoll.put(i, c);
	}
	
	protected char read(int i) {
		return this.tapeRoll.get(i);
	}
	
	protected void displayTape() {
		System.out.println(this.tapeRoll.entrySet());
	}
}
