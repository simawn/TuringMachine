package tm;

public class Head {

	private int headPos = 0;
	private Tape tape;
	
	public Head(String input) {
		this.tape = new Tape();
		this.createInput(input);
	}
	
	private void createInput(String input) {
		for(int i = 0; i < input.length(); i++) {
			this.write(input.charAt(i));
			this.moveRight();
		}
		this.resetHead();
	}
	
	private void resetHead() {
		this.headPos = 0;
	}
	
	private void moveLeft() {
		this.headPos -= 1;
	}
	
	private void moveRight() {
		this.headPos += 1;
	}
	
	private void write(char c) {
		this.tape.write(this.headPos, c);
	}
	
	private char read() {
		return this.tape.read(headPos);
	}
	
	public void displayTape() {
		this.tape.displayTape();
	}
	
}
