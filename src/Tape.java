import java.util.HashMap;

public class Tape {
	private HashMap<Integer, Character> tapeRoll;
	private static final int START_INDEX = 0;
	private int head = START_INDEX;
	private int state = 0;
	private int initialState;
	private int[] finalState;
	
	public Tape() {
		this.tapeRoll = new HashMap<Integer, Character>();
	}
	
	private char read() {
		return tapeRoll.get(this.head);
	}
	
	private void write(char content) {
		this.tapeRoll.put(this.head, content);
	}
	
	private void moveLeft() {
		this.head -= 1;
	}
	
	private void moveRight() {
		this.head += 1;
	}
	
	private void resetHead() {
		this.head = START_INDEX;
	}
	
	private void setInitialState(int initialState) {
		this.state = this.initialState = initialState;
	}
	
	private void setFinalState(int[] finalState) {
		this.finalState = new int[finalState.length];
		for(int i = 0; i < finalState.length; i++) {
			this.finalState[i] = finalState[i];
		}
	}
	
	private void transition(int startState, char read, char write, char move, int endState) {
		if(this.state == startState && this.read() == read) {
			this.write(write);
			if(move == 'L') {
				this.moveLeft();
			} else if (move == 'R') {
				this.moveRight();
			} else {
				System.out.println("Error: Invalid move. Expecting L or R, got: " + move);
				System.exit(1);
			}
			this.state = endState;
		}
	}
	
	/* TODO: 
	 * Have a seperate TM processing class?
	 * Halt and accept the moment it enters a final state
	 * Halt and reject if invalid transition
	 * Handle possible infinite loop
	 */
	
	public void start(int initialState, String[] instruction, int[] finalState) {
		this.setInitialState(initialState);
		this.setFinalState(finalState);
		for(int i = 0; i < instruction.length; i++) {
			//Decompose instructions into startState, read, write, move, endState
			//Plug those variables into transition()
		}
	}
	
	public void createInput(String input) {
		for(int i = 0; i < input.length(); i++) {
			this.tapeRoll.put(this.head, input.charAt(i));
			this.moveRight();
		}
		this.resetHead();
	}
	
	public void displayTape() {
		System.out.println(this.tapeRoll.entrySet());
	}
}
