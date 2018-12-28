package test;

import java.util.ArrayList;

public class Permutation {
	
	private ArrayList<String> pArr = new ArrayList<String>();
	
	public Permutation(String seq) {
		generate(seq.length(), seq.toCharArray());
	}
	
	private void generate(int n, char[] a) {
		/*
		 * Heap's Algorithm implementation from: https://en.wikipedia.org/wiki/Heap%27s_algorithm
		 */
		if(n == 1) {
			//Transforms into a string and add to array list.
			StringBuilder arrToStr = new StringBuilder();
			for(int i = 0; i < a.length; i++) {
				arrToStr.append(a[i]);
			}
			if(!this.pArr.contains(arrToStr.toString())){ //Removes duplicates
				this.pArr.add(arrToStr.toString());
			}
		} else {
			for(int i = 0; i < n-1; i++) {
				generate(n-1, a);
				if(n % 2 == 0) {
					char temp = a[n-1];
					a[n-1] = a[i];
					a[i] = temp;
				} else {
					char temp = a[n-1];
					a[n-1] = a[0];
					a[0] = temp;
				}
			}
			generate(n-1, a);
		}
	}
	
	public ArrayList<String> getPArr(){
		return this.pArr;
	}
}
