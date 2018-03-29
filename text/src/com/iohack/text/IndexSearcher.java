package com.iohack.text;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to search all indexes of a substring in a string.
 * 
 * @author iohack
 * @version 1.0.0
 * @since JDK1.6
 */
public class IndexSearcher {

	/**
	 * Get substring indexes from source string<br>
	 * Returned indexes are starting from 0.
	 * 
	 * @param source
	 *            Source string.
	 * @param pattern
	 *            Pattern searched.
	 * 
	 * @return Index list.
	 */
	public static List<Integer> search(final String source, final String pattern) {
		if( pattern.isEmpty() ){
			throw new IllegalArgumentException("Pattern can not be empty string.");
		}
		List<Integer> indexes = new ArrayList<Integer>();
		if(! source.isEmpty() ){
			int sourceLength = source.length();
			int patternLength = pattern.length();
			int i = 0;
			int idx;
			while (i < sourceLength) {
				idx = source.indexOf(pattern, i);
				if (idx == -1) {
					break;
				}
				indexes.add(idx);
				i = idx + patternLength;
			}
		}
		return indexes;
	}

	/**
	 * Get substring indexes from source string<br>
	 * Returned indexes are starting from 0.
	 * 
	 * @param source
	 *            Source string.
	 * @param pattern
	 *            Pattern searched.
	 * 
	 * @return Index list.
	 */
	public static List<Integer> search(final char[] source, final char[] pattern) {
		if( pattern.length == 0){
			throw new IllegalArgumentException("Pattern can not be empty char array.");
		}
		List<Integer> indexes = new ArrayList<Integer>();
		
		int sIdx = 0;
		int pIdx = 0;
		while( sIdx < source.length ){
			pIdx = 0;
			boolean found = true;
			while( pIdx < pattern.length && (sIdx + pIdx) < source.length ){
				if(source[sIdx + pIdx] != pattern[pIdx]){
					found = false;
					break;
				}
				pIdx++;
			}
			if(found){
				indexes.add(sIdx);
				sIdx += pattern.length;
			}
			sIdx++;
		}		
		return indexes;
	}
}
