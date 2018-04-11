package com.iohack.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A text borderer.<br> 
 * @author Iohack
 * version 1.1.1
 * @since JDK1.2
 */
public class Borderer implements Serializable {
	
	/**
	 * ID
	 */
	private static final long serialVersionUID = -4944177973450851952L;
	
	/**
	 * Internal string.
	 */
	private String str;
	
	/**
	 * Border char.
	 */
	private char borderChar;
	
	/**
	 * Unique constructor.
	 */
	public Borderer(){
		str = "";
		borderChar = '#';
	}
	
	/**
	 * Render bordered text as string line list.
	 * @return Bordered text.
	 */
	public List<String> border(){
		List<String> rendering = new ArrayList<String>(3);
		char [] chars = new char[str.length() + 2];
		Arrays.fill(chars, borderChar);
		String strH = String.valueOf(chars);
		rendering.add(strH);
		rendering.add(borderChar + str + borderChar);
		rendering.add(strH);		
		return rendering;
	}

	/**
	 * @return Text
	 */
	public String getText() {
		return str;
	}
	
	/**
	 * @param text Text.
	 */
	public void setText(final String text) {
		str = text;
	}

	public char getBorderChar() {
		return borderChar;
	}

	public void setBorderChar(char borderChar) {
		this.borderChar = borderChar;
	}
	
	
}
