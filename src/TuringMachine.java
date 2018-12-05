import java.util.Map;

public class TuringMachine {

	public static void main(String[] args) {
		Tape tm1 = new Tape();
		tm1.createInput("00010101010111");
		tm1.displayTape();
	}
}
