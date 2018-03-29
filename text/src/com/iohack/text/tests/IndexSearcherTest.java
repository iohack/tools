package com.iohack.text.tests;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.iohack.text.IndexSearcher;

/**
 * Test cases for class {@link com.iohack.text.IndexSearcher}
 * @author iohack
 * @version 1.0.0
 * @since JDK1.6
 */
public class IndexSearcherTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.iohack.text.IndexSearcher#search(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSearch() {
		System.out.println("--- testSearch ---");
		String source = "XXOXXOXX - This is an example of source string - XXOXXOXX";
		String pattern = "XX";
		String emptyString = "";
		String patternNotFound = "Pattern not found";

		// Empty source --> empty list.
		assertTrue(IndexSearcher.search(emptyString, pattern).size() == 0);

		// Empty pattern --> illegal argument exception.
		try{
			IndexSearcher.search(source, "");
			fail("Empty pattern : exception not raised.");
		}catch(final Exception exception){
			System.out.println("Empty pattern passed : exception raised.");
		}

		// Pattern not found should return an empty list.
		assertEquals(IndexSearcher.search(source, patternNotFound).size(), 0);
		System.out.println("Pattern not found passed.");

		// Pattern "XX" search should return 6 indexes.
		List<Integer> indexes = IndexSearcher.search(source, pattern);
		assertEquals(indexes.size(), 6);
		System.out.println("Pattern found (size == 6) passed.");

		// Check returned indexes. 
		assertTrue(indexes.get(0) == 0);
		System.out.println("Check index 0 (0) passed");
		assertTrue(indexes.get(1) == 3);
		System.out.println("Check index 1 (3) passed");
		assertTrue(indexes.get(2) == 6);
		System.out.println("Check index 2 (6) passed");
		assertTrue(indexes.get(3) == 49);
		System.out.println("Check index 3 (49) passed");
		assertTrue(indexes.get(4) == 52);
		System.out.println("Check index 4 (52) passed");
		assertTrue(indexes.get(5) == 55);
		System.out.println("Check index 5 (55) passed");

		// Some performance test. 
		Date d1 = new Date();
		for (int i = 0; i < 100000000; i++) {
			IndexSearcher.search(source, pattern);
		}
		Date d2 = new Date();
		System.out.println("Performance test (100 000 000) time (ms) : "
				+ (d2.getTime() - d1.getTime()));
	}

	/**
	 * Test method for
	 * {@link com.iohack.text.IndexSearcher#search(char[], char[])} .
	 */
	@Test
	public void testSearchCharArray() {
		System.out.println("--- testSearchCharArray ---");
		char[] source = { 'X', 'X', 'O', 'X', 'X', 'O', 'X', 'X' };
		char[] pattern = { 'X', 'X' };
		char[] emptyString = {};
		char[] patternNotFound = { 'p', 'n', 'f' };

		// Empty source --> empty list.
		assertTrue(IndexSearcher.search(emptyString, pattern).size() == 0);

		// Empty pattern --> illegal argument exception.
		try{
			IndexSearcher.search(source, new char[] {});
			fail("Empty pattern : exception not raised.");
		}catch(final Exception exception){
			System.out.println("Empty pattern passed : exception raised.");
		}

		// Pattern not found should return an empty list.
		assertEquals(IndexSearcher.search(source, patternNotFound).size(), 0);
		System.out.println("Pattern not found passed.");

		// Pattern "XX" search should return 6 indexes.
		List<Integer> indexes = IndexSearcher.search(source, pattern);
		assertEquals(indexes.size(), 3);
		System.out.println("Pattern found (size == 3) passed.");

		// Check returned indexes. 
		assertTrue(indexes.get(0) == 0);
		System.out.println("Check index 0 (0) passed");
		assertTrue(indexes.get(1) == 3);
		System.out.println("Check index 1 (3) passed");
		assertTrue(indexes.get(2) == 6);
		System.out.println("Check index 2 (6) passed");		

		// Performance test. 
		Date d1 = new Date();
		for (int i = 0; i < 100000000; i++) {
			IndexSearcher.search(source, pattern);
		}
		Date d2 = new Date();
		System.out.println("Performance test (100 000 000) time (ms) : "
				+ (d2.getTime() - d1.getTime()));
	}	
}
