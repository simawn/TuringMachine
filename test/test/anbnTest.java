package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tm.TuringMachine;

public class anbnTest {

	@Test
	public void testTrue() {
		TuringMachine anbn = new TuringMachine("a^nb^n.txt", false);
		int numCases = 50;
		StringBuilder sA = new StringBuilder("a");
		StringBuilder sB = new StringBuilder("b");
		for(int i = 0; i < numCases; i++) {
			StringBuilder ab = new StringBuilder(sA).append(sB);
			assertTrue(anbn.runInput(ab.toString()));
			sA.append("a");
			sB.append("b");
		}
	}

}
