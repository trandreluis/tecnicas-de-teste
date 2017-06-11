package br.edu.ifpb.mt.tt.imc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IndiceMassaCorporalCalcularTest {

	// TODO Criar casos de testes para o método IndiceMassaCorporal#calcular
	// com JUnit e Hamcrest utilizando os testes parametrizados:
	// https://github.com/junit-team/junit/wiki/Parameterized-tests

	private Double parametroPeso;
	private Integer parametroAltura;
	private Double resultadoEsperado;

	private IndiceMassaCorporal imc = new IndiceMassaCorporal();

	public IndiceMassaCorporalCalcularTest(Double parametroPeso, Integer parametroAltura, Double resultadoEsperado) {
		this.parametroPeso = parametroPeso;
		this.parametroAltura = parametroAltura;
		this.resultadoEsperado = resultadoEsperado;
	}

	@Parameters
	public static Collection<Object[]> getParametros() {
		return Arrays.asList(new Object[][] {
			{ 69.0, 186, 19.94 },
			{ 70.0, 190, 19.39 },
			{ 80.0, 170, 27.68 },
			{ 86.0, 165, 31.59 },
			{ 53.0, 158, 21.23 }
		});
	}

	@Test
	public void calcularIMCParametrizado() {
		Double retorno = imc.calcular(this.parametroPeso, this.parametroAltura);
		assertEquals(retorno, this.resultadoEsperado, 0.01);
	}

}
