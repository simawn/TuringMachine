import java.util.ArrayList;

public class Tape {
	/*
	 * Although we are mapping all negative integers to positives,
	 * assume all operations involving index to be done "normally" as we would on paper.
	 * For example, we can check the left character of index 0 which is index -1
	 * The conversion will be done behind the scenes.
	 */
	private ArrayList<Character> tapeRoll;
	private int head = 0; //Not normal head
	
	public Tape() {
		this.tapeRoll = new ArrayList<Character>();
	}
	
	private char read(int index) {
		return this.tapeRoll.get(mapToPositiveIndex(index));
	}
	
	private void write(int index, char content) {
		this.tapeRoll.add(mapToPositiveIndex(index), content);
	}
	
	private void moveLeft() {
		this.head = mapToPositiveIndex(mapToNormalIndex(this.head)-1);
	}
	
	private void moveRight() {
		this.head = mapToPositiveIndex(mapToNormalIndex(this.head)+1);
	}
	
	public void newInput(String input) {
		for(int i = 0; i < input.length(); i++) {
			this.write(i, input.charAt(i));
		}
		this.head = 0;
	}
	
	public void readTape() {
		//TODO
		this.head = 0; //Resets head
		while(true) {
			read(this.head);
			moveRight();
		}
	}
	
	public int mapToPositiveIndex(int index) {
		/**
		 * Maps negative integers to positive odd integers. 
		 * All positive integers are mapped to even positive integers.
		 * Simulates an infinite tape on both directions.
		 * ..., -3:5, -2:3, -1:1, 0:0, 1:2, 2:4, 3:6, ...
		 */
		if(index >= 0) return 2*index;
		else return -2*index-1;
	}
	
	public int mapToNormalIndex(int pIndex) {
		/**
		 * Converts the positive representation from mapToPositiveIndex into its normal form.
		 * (As if we were allowed to have negative indices for array)
		 * This can return a negative integer.
		 */
		if(pIndex % 2 == 0) return pIndex/2;
		else return (-pIndex-1)/2;
	}
}
