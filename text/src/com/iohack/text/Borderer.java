package com.iohack.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Text borderer.<br>
 * 
 * @author Iohack 
 * @version 1.3.0
 * @since JDK1.2
 */
public class Borderer implements Serializable {
	/**
	 * Top padding.
	 */
	public static final int PADDING_TOP = 0;

	/**
	 * Bottom padding.
	 */
	public static final int PADDING_BOTTOM = 1;

	/**
	 * Left padding.
	 */
	public static final int PADDING_LEFT = 2;

	/**
	 * Right padding.
	 */
	public static final int PADDING_RIGHT = 3;

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
	 * Padding configuration.
	 */
	private int[] padding;

	/**
	 * Build a basic text borderer with default configuration.
	 */
	public Borderer() {
		lines = new ArrayList<String>(3);
		borderChar = '#';
		maxLineLength = 0;
		padding = new int[4];
	}

	/**
	 * Render bordered text as string line list.
	 * 
	 * @return Bordered text.
	 */
	public List<String> border() {
		// Rendered lines
		List<String> rendering = new ArrayList<String>(lines.size() + 2
				+ padding[0] + padding[1]);

		// Horizontal (top and bottom) borders
		char[] chars = new char[maxLineLength + 2 + padding[2] + padding[3]];
		Arrays.fill(chars, borderChar);
		String strH = String.valueOf(chars);

		// Top border
		rendering.add(strH);

		// Horizontal padding (top and bottom)
		char[] charsPaddedH = new char[maxLineLength + 2 + padding[2]
				+ padding[3]];
		Arrays.fill(charsPaddedH, ' ');
		charsPaddedH[0] = borderChar;
		charsPaddedH[charsPaddedH.length - 1] = borderChar;

		// Top padding
		for (int i = 0; i < padding[0]; i++) {
			rendering.add(String.valueOf(charsPaddedH));
		}

		// Text
		for (String line : lines) {
			char[] leftBlanks = new char[padding[2]];
			char[] rightBlanks = new char[maxLineLength - line.length()
					+ padding[3]];
			Arrays.fill(leftBlanks, ' ');
			Arrays.fill(rightBlanks, ' ');

			rendering.add(borderChar + String.valueOf(leftBlanks) + line
					+ String.valueOf(rightBlanks) + borderChar);
		}

		// Bottom padding
		// Top padding
		for (int i = 0; i < padding[1]; i++) {
			rendering.add(String.valueOf(charsPaddedH));
		}

		// Bottom border
		rendering.add(strH);

		return rendering;
	}

	/**
	 * Get the max line length.
	 * 
	 * @return Max line length.
	 */
	public int getMaxLineLength() {
		return maxLineLength;
	}

	/**
	 * Get the border character.
	 * 
	 * @return The border character.
	 */
	public char getBorderChar() {
		return borderChar;
	}

	/**
	 * Set the border character.
	 * 
	 * @param borderChar
	 *            Border character.
	 */
	public void setBorderChar(char borderChar) {
		this.borderChar = borderChar;
	}

	/**
	 * Set the lines to be bordered.
	 * 
	 * @param pLines
	 *            Line list.
	 */
	public void setLines(final List<String> pLines) {
		lines = new ArrayList<String>(pLines.size());
		for (String line : pLines) {
			lines.add(line);
		}
		updateMaxLineLength();
	}

	/**
	 * Set text from a single line string.
	 * 
	 * @param text
	 *            Text.
	 */
	public void setText(final String text) {
		lines = new ArrayList<String>(1);
		lines.add(text);
		updateMaxLineLength();
	}

	/**
	 * Update the max line length attribute.
	 */
	private void updateMaxLineLength() {
		maxLineLength = 0;
		for (String line : lines) {
			if (line.length() > maxLineLength) {
				maxLineLength = line.length();
			}
		}
	}

	/**
	 * Get padding configuration.<br>
	 * Padding type can be :<br>
	 * <ol>
	 * <li>PADDING_TOP</li>
	 * <li>PADDING_BOTTOM</li>
	 * <li>PADDING_LEFT</li>
	 * <li>PADDING_RIGHT</li>
	 * </ol>
	 * 
	 * @param paddingType
	 *            Padding type.
	 * @return Padding configuration.
	 */
	public int getPadding(int paddingType) {
		if (paddingType < 0 || paddingType > 3) {
			throw new IllegalArgumentException(
					"Padding type unknown. Use PADDING_TOP, PADDING_BOTTOM, PADDING_LEFT or PADDING_RIGHT.");
		}
		return padding[paddingType];
	}

	/**
	 * Set padding configuration.<br>
	 * Padding type can be :<br>
	 * <ol>
	 * <li>PADDING_TOP</li>
	 * <li>PADDING_BOTTOM</li>
	 * <li>PADDING_LEFT</li>
	 * <li>PADDING_RIGHT</li>
	 * </ol>
	 * 
	 * @param paddingType
	 *            Padding type.
	 * @param value
	 *            Value
	 */
	public void setPadding(int paddingType, int value) {
		if (paddingType < 0 || paddingType > 3) {
			throw new IllegalArgumentException(
					"Padding type unknown. Use PADDING_TOP, PADDING_BOTTOM, PADDING_LEFT or PADDING_RIGHT.");
		}
		padding[paddingType] = value;
	}
}
