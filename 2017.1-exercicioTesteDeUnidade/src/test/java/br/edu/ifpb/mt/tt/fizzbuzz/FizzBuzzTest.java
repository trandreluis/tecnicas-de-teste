package br.edu.ifpb.mt.tt.fizzbuzz;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class FizzBuzzTest {
	
	// TODO Criar casos de testes para a classe FizzBuzz com JUnit e Hamcrest
	
	private FizzBuzz fb = new FizzBuzz();
	
	@Test
	public void testeRetornoIgualParametro(){
		String retorno = fb.calculate(11);
		assertThat(retorno, is("11"));
	}
	
	@Test
	public void testeRetornoFizz(){
		String retorno = fb.calculate(9);
		assertThat(retorno, is(FizzBuzz.FIZZ));	
	}
	
	@Test
	public void testeRetornoBuzz(){
		String retorno = fb.calculate(50);
		assertThat(retorno, is(FizzBuzz.BUZZ));
	}
	
	@Test
	public void testeRetornoFizzBuzz(){
		String retorno = fb.calculate(75);
		assertThat(retorno, is(FizzBuzz.FIZZ_BUZZ));
	}
	
}