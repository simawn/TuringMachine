package tm;
import java.util.HashMap;

public class Tape {
	
	protected HashMap<Integer, Character> tapeRoll;
	private int headPos = 0;
	
	public Tape(String input) {
		this.tapeRoll = new HashMap<Integer, Character>();
		createInput(input);
	}
	
	protected void moveLeft() {
		this.headPos -= 1;
	}
	
	protected void moveRight() {
		this.headPos += 1;
	}
	
	protected void resetHead() {
		this.headPos = 0; 
	}
	
	protected void write(char c) {
		this.tapeRoll.put(this.headPos, c);
	}
	
	protected char read() {
		if (this.tapeRoll.get(this.headPos) == null) {
			return '#';
		}
		return this.tapeRoll.get(this.headPos);
	}
	
	private void createInput(String input) {
		for(int i = 0; i < input.length(); i++) {
			this.write(input.charAt(i));
			this.moveRight();
		}
		this.resetHead();
	}
	
	public void displayTape() {
		System.out.println(this.tapeRoll.entrySet());
	}
}
