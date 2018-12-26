package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tm.TuringMachine;

public class nanbncTest {

	@Test
	public void test() {
		TuringMachine nanbnc = new TuringMachine("nanbnc.txt", false);
		assertTrue(nanbnc.runInput("cba"));
		assertTrue(nanbnc.runInput("bacabc"));
		assertTrue(nanbnc.runInput("accabbacabbc"));
		assertTrue(nanbnc.runInput(""));
		assertTrue(nanbnc.runInput("accbacabbcbcbaa"));
	}
}
