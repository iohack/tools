package com.iohack.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A text borderer.<br> 
 * @author Iohack
 * version 1.2.0
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
	private List<String> lines;
	
	/**
	 * Max line length.
	 */
	private int maxLineLength;
	
	/**
	 * Border char.
	 */
	private char borderChar;
	
	/**
	 * Unique constructor.
	 */
	public Borderer(){
		lines = new ArrayList<String>(3);
		borderChar = '#';
		maxLineLength = 0;
	}
	
	/**
	 * Render bordered text as string line list.
	 * @return Bordered text.
	 */
	public List<String> border(){
		List<String> rendering = new ArrayList<String>(maxLineLength + 2);
		char [] chars = new char[maxLineLength + 2];
		Arrays.fill(chars, borderChar);
		String strH = String.valueOf(chars);
		rendering.add(strH);
		for(String line : lines){
			char [] blanks = new char[ maxLineLength - line.length() ];
			Arrays.fill(blanks, ' ');
			rendering.add(borderChar + line + String.valueOf(blanks) + borderChar);
		}
		rendering.add(strH);		
		return rendering;
	}

	/**
	 * Get the max line length.
	 * @return Max line length.
	 */
	public int getMaxLineLength(){
		return maxLineLength;
	}

	/**
	 * Get the border character.
	 * @return The border character.
	 */
	public char getBorderChar() {
		return borderChar;
	}

	/**
	 * Set the border character.
	 * @param borderChar Border character.
	 */
	public void setBorderChar(char borderChar) {
		this.borderChar = borderChar;
	}
	
	/**
	 * Set the lines to be bordered.
	 * @param pLines Line list.
	 */
	public void setLines(final List<String> pLines){
		lines = new ArrayList<String>(pLines.size());
		for(String line : pLines){
			lines.add(line);
		}
		updateMaxLineLength();
	}
	
	/**
	 * Set lines (1) from a single string. 
	 * @param text Text.
	 */
	public void setText(final String text){
		lines = new ArrayList<String>(1);
		lines.add(text);
		updateMaxLineLength();
	}
	
	/**
	 * Update the max line length attribute.
	 */
	private void updateMaxLineLength(){
		maxLineLength = 0;
		for(String line : lines){
			if( line.length() > maxLineLength ){
				maxLineLength = line.length();
			}
		}
	}
}
