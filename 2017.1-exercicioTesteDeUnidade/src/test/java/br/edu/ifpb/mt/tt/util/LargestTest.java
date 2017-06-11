package br.edu.ifpb.mt.tt.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class LargestTest {
	
	// TODO Criar casos de testes para a classe Largest com JUnit e Hamcrest

	private Largest largest = new Largest();
	
	@Test
	public void getMaiorVinteECinco() {
		int [] numeros = new int []{21, 12, 19, 4, 6, 7, 3, 9, 25, 0, 11, 2, 15, 24, 17};
		int retorno = largest.getMaior(numeros);
		assertThat(retorno, is(25));
	}
	
	@Test
	public void getMaiorCinquentaEDois() {
		int [] numeros = new int []{21, 12, 19, 4, 6, 7, 3, 9, 25, 0, 11, 2, 52, 15, 24, 17};
		int retorno = largest.getMaior(numeros);
		assertThat(retorno, is(52));
	}
	
}
