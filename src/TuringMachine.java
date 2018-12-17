import tm.Head;
import tm.Tape;

public class TuringMachine {
	
	private int state = 0;
	private Head head;
	
	public TuringMachine(String input) {
		this.head = new Head(input);
	}
	
	public void displayTape() {
		this.head.displayTape();
	}
}
