package br.edu.ifpb.mt.tt.util;

public class CharacterCounter {

	public int contar(String frase, char caractere) {
		
		int cont = 0;
		char[] fraseChar = frase.toCharArray();
		for (char c : fraseChar) {
			if (c == caractere) {
				cont++;
			}
		}
		
		return cont;
	}
	
}
