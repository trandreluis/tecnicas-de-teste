package br.edu.ifpb.mt.tt.util;

public class Largest {

	public int getMaior(int[] numeros) {
		
		if (numeros == null || numeros.length == 0) {
			throw new IllegalArgumentException(
					"Parâmetro inválido! Deve ser um array de inteiros com pelo menos um valor!");
		}

		int maior = Integer.MIN_VALUE;
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > maior) {
				maior = numeros[i];
			}
		}
		
		return maior;
	}

}