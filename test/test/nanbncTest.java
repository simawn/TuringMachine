package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tm.TuringMachine;

public class nanbncTest {

	@Test
	public void test() {
		TuringMachine nanbnc = new TuringMachine("nanbnc.txt", false);
		ArrayList<String> p = new Permutation("aaabbbccc").getPArr();
		for(int i = 0; i < p.size(); i++) {
			assertTrue(nanbnc.runInput(p.get(i)));
		}
	}
}
