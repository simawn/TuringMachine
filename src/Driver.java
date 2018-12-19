import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		//System.out.println("Enter transition file path:");
		//TuringMachine tm = new TuringMachine(kb.nextLine());
		TuringMachine tm = new TuringMachine("a^nb^n.txt"); //test
		
		/*
		 * Blank character: #
		 * Move left, move right: L, R
		 * 
		 * Input file:
		 * <Initial state>
		 * <List of final states>
		 * <Current State> <Read> <Next state> <Write> <Move>
		 * ...
		 * 
		 * 
		 * Eg:
		 * 0 //Start state = 0
		 * 0 5 //Final states = {0, 5}
		 * 0 a 1 x R //If on state 0, reading 'a', go to state 1, write 'x', move tape right.
		 * 1 a 1 a R
		 * ...
		 * 
		 */
	}

}
