/**
 * 
 */
package com.iohack.text;

import java.util.List;

/**
 * Functional interface for text object who need to
 * be rendered with a surrounding border.
 * @author iohack
 * version 1.0.0
 */
public interface ITextBorderer {
	
	/**
	 * Render text as list of lines with a surrounding border.
	 * @param text Text to be surrounded with a border.
	 * @return Lines list.
	 */
	public List<String> render(final List<String> text);
}
