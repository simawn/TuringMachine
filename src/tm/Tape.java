package tm;

import java.util.Arrays;
import java.util.TreeMap; //Using tree map so tape display is sorted


class Tape {
	
	TreeMap<Integer, Character> tapeRoll;
	TreeMap<Integer, Character> headTrack; //used for display
	private int headPos = 0;
	
	Tape(String input) {
		this.tapeRoll = new TreeMap<Integer, Character>();
		this.headTrack = new TreeMap<Integer, Character>();
		createInput(input);
	}
	
	void moveLeft() {
		this.headUpdate(-1);
	}
	
	void moveRight() {
		this.headUpdate(1);
	}
	
	void resetHead() {
		this.headUpdate(0);
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
	
	private void headUpdate(int direction) {
		if(direction == 0) {
			this.headPos = 0; 
			this.headTrack.clear();
		} else {
			this.headTrack.put(this.headPos, ' ');
			this.headPos += direction;
		} 
		this.headTrack.put(this.headPos, '^');
		if(!this.tapeRoll.containsKey(this.headPos)) { //If current head position does not have any key assigned on tape
			this.tapeRoll.put(this.headPos, '#');
		}
	}
	
	void displayTape() {
		for(int i = 0; i < 20; i++) { //Hacky way to clear the console
			System.out.println();
		}
		System.out.println(Arrays.toString(this.tapeRoll.values().toArray()));
		System.out.println(Arrays.toString(this.headTrack.values().toArray()));
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
