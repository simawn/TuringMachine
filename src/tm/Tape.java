package tm;
import java.util.HashMap;

class Tape {
	
	HashMap<Integer, Character> tapeRoll;
	private int headPos = 0;
	
	Tape(String input) {
		this.tapeRoll = new HashMap<Integer, Character>();
		createInput(input);
	}
	
	void moveLeft() {
		this.headPos -= 1;
	}
	
	void moveRight() {
		this.headPos += 1;
	}
	
	void resetHead() {
		this.headPos = 0; 
	}
	
	void write(char c) {
		this.tapeRoll.put(this.headPos, c);
	}
	
	char read() {
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
	
	void displayTape() {
		System.out.println(this.tapeRoll.entrySet());
	}
}
