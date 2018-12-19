package tm;
import java.util.HashMap;

public class Tape {
	
	protected HashMap<Integer, Character> tapeRoll;
	private int headPos = 0;
	
	public Tape(String input) {
		this.tapeRoll = new HashMap<Integer, Character>();
		createInput(input);
	}
	
	private void moveLeft() {
		this.headPos -= 1;
	}
	
	private void moveRight() {
		this.headPos += 1;
	}
	
	private void resetHead() {
		this.headPos = 0; 
	}
	
	private void write(char c) {
		this.tapeRoll.put(this.headPos, c);
	}
	
	private char read() {
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
		this.tapeRoll.entrySet();
	}
}
