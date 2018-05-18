package com.iohack.text.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.iohack.text.Borderer;

/**
 * Test cases for class {@link com.iohack.text.Borderer}
 * @author Iohack
 * @version 1.4.0
 * @since JDK1.2
 */
public class BordererTest {

	/**
	 * Test method for {@link com.iohack.text.Borderer#border()}.
	 */
	@Test
	public void testBorder() {
		System.out.println("\nTesting borderer with empty text :");
		Borderer borderer = new Borderer();
		List<String> lines = borderer.border();
		for(String line : lines){
			System.out.println(line);
		}	
	}
	/**
	 * Test method for {@link com.iohack.text.Borderer#border()}.
	 */
	@Test
	public void testBorder2() {
		System.out.println("\nTesting char border...");
		Borderer borderer = new Borderer();
		borderer.setBorderChar('*');		
		System.out.println("Some text :");
		borderer.setText("Some text");
		List<String> lines = borderer.border();
		for(String line : lines){
			System.out.println(line);
		}
	}
	/**
	 * Test method for {@link com.iohack.text.Borderer#border()}.
	 */
	@Test
	public void testBorder3() {
		System.out.println("\nTesting borderer with some lines :");
		Borderer borderer = new Borderer();
		List<String> inLines = new ArrayList<String>(3);
		inLines.add("a line");
		inLines.add("a second line");
		inLines.add("a third very very long line !");		
		borderer.setLines(inLines);
		List<String> lines = borderer.border();
		for(String line : lines){
			System.out.println(line);
		}
	}
	
	/**
	 * Test method for {@link com.iohack.text.Borderer#border()}.
	 */
	@Test
	public void testBorder4() {
		System.out.println("\nTesting borderer with padding :");
		Borderer borderer = new Borderer();
		List<String> inLines = new ArrayList<String>(3);
		inLines.add("a line");
		inLines.add("a second line");
		inLines.add("a third very very long line !");		
		borderer.setLines(inLines);
		borderer.setPadding(Borderer.PADDING_TOP, 0);
		borderer.setPadding(Borderer.PADDING_BOTTOM, 1);
		borderer.setPadding(Borderer.PADDING_LEFT, 2);
		borderer.setPadding(Borderer.PADDING_RIGHT, 3);
		List<String> lines = borderer.border();
		for(String line : lines){
			System.out.println(line);
		}
	}
	
	/**
	 * Test method for {@link com.iohack.text.Borderer#border()}.
	 */
	@Test
	public void testPerformande() {
		System.out.println("\nTesting borderer performances :");
		Borderer borderer = new Borderer();
		List<String> inLines = new ArrayList<String>(3);
		inLines.add("a line");
		inLines.add("a second line");
		inLines.add("a third very very long line !");		
		borderer.setLines(inLines);
		borderer.setPadding(Borderer.PADDING_TOP, 0);
		borderer.setPadding(Borderer.PADDING_BOTTOM, 1);
		borderer.setPadding(Borderer.PADDING_LEFT, 2);
		borderer.setPadding(Borderer.PADDING_RIGHT, 3);
		long t1 = System.currentTimeMillis();
		for(int i=0; i<100000000;i++){
			borderer.border();
		}
		System.out.println("Performance result : " + (System.currentTimeMillis() - t1));
	}	
}
