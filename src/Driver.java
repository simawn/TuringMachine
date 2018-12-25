import java.util.Scanner;

import tm.TuringMachine;

public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter transition diagram path:");
		String path = sc.nextLine();
		
		TuringMachine tm = new TuringMachine(path, false); //(input file path, display tape after each step?)
		
		boolean done = false;
		while(!done) {
			System.out.println("Input to test:");
			String input = sc.nextLine();	
			tm.runInput(input);
			System.out.println("Try with another input? (y/n)");
			char ans = sc.nextLine().toLowerCase().charAt(0);
			if(ans == 'n') {
				done = true;
			}
		}
		sc.close();
	}
}
