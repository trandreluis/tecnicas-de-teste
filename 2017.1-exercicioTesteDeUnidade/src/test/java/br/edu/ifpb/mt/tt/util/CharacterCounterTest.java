package br.edu.ifpb.mt.tt.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CharacterCounterTest {
	
	// TODO Criar casos de testes para a classe CharacterCounter com JUnit e Hamcrest

	private CharacterCounter contador = new CharacterCounter();
	
	@Test
	public void testeSeisLetrasIParaNomeCompletoDoIFPB() {
		int retorno = contador.contar("instituto federal de educacao ciencia e tecnologia da paraiba", 'i');
		assertThat(retorno, is(6));
	}
	
	@Test
	public void testeLetrasTParaNomeCompletoDaDisciplina() {
		int retorno = contador.contar("tecnicas de testes", 't');
		assertThat(retorno, is(3));
	}
	
}