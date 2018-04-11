package com.iohack.text.tests;

import java.util.List;

import org.junit.Test;

import com.iohack.text.Borderer;

/**
 * Test cases for class {@link com.iohack.text.Borderer}
 * @author Iohack
 * version 1.0.0
 * @since JDK1.2
 */
public class BordererTest {

	/**
	 * Test method for {@link com.iohack.text.Borderer#border()}.
	 */
	@Test
	public void testBorder() {
		System.out.println("Test defaut borderer...");
		Borderer borderer = new Borderer();
		
		System.out.println("Empty text : ");
		List<String> lines = borderer.border();
		for(String line : lines){
			System.out.println(line);
		}
		
		System.out.println("Some text :");
		borderer.setText("Some text");
		lines = borderer.border();
		for(String line : lines){
			System.out.println(line);
		}
	}
	/**
	 * Test method for {@link com.iohack.text.Borderer#border()}.
	 */
	@Test
	public void testBorder2() {
		System.out.println("Testing char border...");
		Borderer borderer = new Borderer();
		borderer.setBorderChar('*');		
		System.out.println("Some text :");
		borderer.setText("Some text");
		List<String> lines = borderer.border();
		for(String line : lines){
			System.out.println(line);
		}
	}
}
