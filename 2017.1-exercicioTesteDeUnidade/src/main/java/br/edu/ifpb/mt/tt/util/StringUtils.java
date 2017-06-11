package br.edu.ifpb.mt.tt.util;

/**
 * Referência:
 * 
 * <pre>
 * 1) https://github.com/tomekkaczanowski/junit-put-exercises/blob/master/src/main/java/com/practicalunittesting/chp03/StringUtils.java
 * </pre>
 * 
 * @author jaindsonvs
 *
 */
public class StringUtils {

	public String reverse(String string) {
		StringBuilder sb = new StringBuilder(string.length());

		char[] charArray = string.toCharArray();
		for (int i = string.length() - 1; i >= 0; i--) {
			sb.append(charArray[i]);
		}

		return sb.toString();
	}

}
