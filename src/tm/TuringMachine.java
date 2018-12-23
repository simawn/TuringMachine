package tm;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

import tm.TDiagram;
import tm.Tape;

public class TuringMachine {
	
	private int curState = 0;
	private int iniState;
	private HashSet<Integer> finState = new HashSet<Integer>();
	private Tape tape;
	private TDiagram tDiagram;
	private static final int MAX_STEPS = 10000; //In case of infinite loops...
	private int curStep = 0;
	private boolean displayTape = true;
	
	public TuringMachine(String filePath, boolean displayTape) {
		this.displayTape = displayTape;
		this.tDiagram = new TDiagram();
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
				
				if(line == 0) { //Set initial State
					this.curState = this.iniState = Integer.parseInt(lContent);
				} else if(line == 1) { //Set final state(s)
					String[] tempArr = lContent.split(" ");
					for(int i = 0; i < tempArr.length; i++) {
						this.finState.add(Integer.parseInt(tempArr[i]));
					}
				} else { //Create transition diagram
					if(!lContent.isEmpty()) {
						String tData[] = lContent.split(" "); //Split transition data
						this.tDiagram.addData(Integer.parseInt(tData[0]), tData[1].charAt(0), Integer.parseInt(tData[2]), tData[3].charAt(0), tData[4].charAt(0));
					}
				}
				line++;
			}
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
		while(this.curStep < TuringMachine.MAX_STEPS) { //While the max number of steps is not reached.
			if(this.finState.contains(this.curState)) { //When it enters a final state
				System.out.println("Input " + input + " is accepted! Done in " + this.curStep + " step(s).");
				break;
			}
			//Getting data from transition diagram
			char reading = this.tape.read();
			//Checking if there are outer transitions for that particular character (reading) at the current state.
			//If not (NullPointerException), no transition exists, tm halts.
			char write = '#';
			try {
				write = this.tDiagram.getAdjList().get(this.curState).getEdgeList().get(reading).getWrite();
			} catch (NullPointerException e) {
				System.out.println("Input " + input + " is rejected! Done in " + this.curStep + " step(s).");
				break;
			}
			char move = this.tDiagram.getAdjList().get(this.curState).getEdgeList().get(reading).getMove();
			int nextState = this.tDiagram.getAdjList().get(this.curState).getEdgeList().get(reading).getTo();
			
			//Modifying the tape
			this.tape.write(write);
			if(move == 'l') {
				this.tape.moveLeft();
			} else if (move == 'r') {
				this.tape.moveRight();
			} else {
				System.out.println("Move error");
				System.exit(3);
			}
			
			if (this.displayTape) {
				this.tape.displayTape();
			}
			
			this.curState = nextState;
			this.curStep++;
		}
		if(this.curStep > TuringMachine.MAX_STEPS) {
			System.out.println("Max number of steps reached.");
		}
		//Reset
		this.curState = this.iniState;
		this.curStep = 0;
	}
}
