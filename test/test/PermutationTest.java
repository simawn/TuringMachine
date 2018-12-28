package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PermutationTest {

	@Test
	public void test() {
		ArrayList<String> perm = new Permutation("abcc").getPArr();
		String[] result = {"abcc", "acbc", "accb", "bacc", "bcac", "bcca", "cabc", "cacb", "cbac", "cbca", "ccab", "ccba"};
		assertEquals(12, perm.size());
		assertEquals(12, result.length);
		for(int i = 0; i < result.length; i++) {
			String test = result[i];
			assertTrue(perm.contains(test));
		}
	}

}
