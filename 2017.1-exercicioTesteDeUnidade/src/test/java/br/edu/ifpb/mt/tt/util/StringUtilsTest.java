package br.edu.ifpb.mt.tt.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class StringUtilsTest {
	
	// TODO Criar casos de testes para a classe StringUtils com JUnit e Hamcrest

	private StringUtils stringUtil = new StringUtils();
	
	@Test
	public void inverterOvo() {
		String retorno = stringUtil.reverse("ovo");
		assertThat(retorno, is("ovo"));
	}
	
	@Test
	public void inverterBPFI() {
		String retorno = stringUtil.reverse("bpfi");
		assertThat(retorno, is("ifpb"));
	}
	
}
