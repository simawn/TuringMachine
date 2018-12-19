import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import tm.TDiagram;
import tm.Tape;

public class TuringMachine {
	
	private int curState = 0;
	private int iniState;
	private int[] finState;
	private Tape tape;
	private TDiagram tDiagram;
	
	public TuringMachine(String filePath) {
		processFile(filePath);
	}
	
	private void processFile(String filePath) {
		Path tFilePath = Paths.get(filePath);
		Scanner scTFile;
		
		try {
			scTFile = new Scanner(tFilePath);
			int line = 0;
			
			while(scTFile.hasNextLine()) {
				String lContent = scTFile.nextLine().trim();
				
				if(line == 0) { //Initial State
					this.iniState = Integer.parseInt(lContent);
				} else if(line == 1) { //Final state(s)
					String[] tempArr = lContent.split(" ");
					this.finState = new int[tempArr.length];
					for(int i = 0; i < this.finState.length; i++) {
						this.finState[i] = Integer.parseInt(tempArr[i]);
					}
				} else { //Create transition diagram
					if(!lContent.isEmpty()) {
						System.out.println("T: " + lContent);
					}
				}
				line++;
			}
			System.out.println("Initial State: " + this.iniState);
			System.out.println("Final State(s): " + Arrays.toString(this.finState));
		} catch (IOException e) {
			System.out.println("Error reading file");
			System.exit(1);
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format");
			System.exit(2);
		}
	}
	
	public void runInput(String input) {
		this.tape = new Tape(input);
	}
	
	public void displayTape() {
		this.tape.displayTape();
	}
}
