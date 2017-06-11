package br.edu.ifpb.mt.tt.imc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IndiceMassaCorporalGetClassificacaoTest {
	
	// TODO Criar casos de testes para o método IndiceMassaCorporal#getClassificacao 
	// com JUnit e Hamcrest utilizando os testes parametrizados:
	// https://github.com/junit-team/junit/wiki/Parameterized-tests
	
	private Double valorIMC;
	private ClassificacaoIMC resultadoEsperado;

	private IndiceMassaCorporal imc = new IndiceMassaCorporal();

	public IndiceMassaCorporalGetClassificacaoTest(Double parametroPeso, ClassificacaoIMC resultadoEsperado) {
		this.valorIMC = parametroPeso;
		this.resultadoEsperado = resultadoEsperado;
	}

	@Parameters
	public static Collection<Object[]> getParametros() {
		return Arrays.asList(new Object[][] {
			{ 18.4, ClassificacaoIMC.ABAIXO },
			{ 15.0, ClassificacaoIMC.ABAIXO },
			{ 18.5, ClassificacaoIMC.NORMAL },
			{ 23.0, ClassificacaoIMC.NORMAL },
			{ 25.0, ClassificacaoIMC.SOBREPESO },
			{ 28.0, ClassificacaoIMC.SOBREPESO },
			{ 30.0, ClassificacaoIMC.OBESIDADE_GRAU_I },
			{ 34.9, ClassificacaoIMC.OBESIDADE_GRAU_I },
			{ 36.3, ClassificacaoIMC.OBESIDADE_GRAU_II },
			{ 39.0, ClassificacaoIMC.OBESIDADE_GRAU_II },
			{ 40.6, ClassificacaoIMC.OBESIDADE_GRAU_III},
			{ 58.0, ClassificacaoIMC.OBESIDADE_GRAU_III}
		});
	}
	
	@Test
	public void testeClassificacao() {
		ClassificacaoIMC retorno = imc.getClassificacao(this.valorIMC);
		assertThat(retorno, is(this.resultadoEsperado));
	}
	
}