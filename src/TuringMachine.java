
public class TuringMachine {

	public static void main(String[] args) {
		Tape tape = new Tape();
		for(int i = -5; i <= 5; i++) {
			System.out.println(i + ":" + tape.mapToNormalIndex(tape.mapToPositiveIndex(i)));
		}
	}

}
