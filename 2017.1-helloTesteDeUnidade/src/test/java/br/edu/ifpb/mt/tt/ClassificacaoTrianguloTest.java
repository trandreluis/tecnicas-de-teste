package br.edu.ifpb.mt.tt;

import static br.edu.ifpb.mt.tt.ClassificacaoTriangulo.EQUILATERO;
import static br.edu.ifpb.mt.tt.ClassificacaoTriangulo.ESCALENO;
import static br.edu.ifpb.mt.tt.ClassificacaoTriangulo.INVALIDO;
import static br.edu.ifpb.mt.tt.ClassificacaoTriangulo.ISOCELES;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ClassificacaoTrianguloTest {

	private ClassificacaoTriangulo ct;

	@Before
	public void setUp() throws Exception {
		ct = new ClassificacaoTriangulo();
	}

	/**
	 * Caso de teste que representa um triângulo escaleno válido (Obs: Casos de
	 * teste como 1, 2, 3 não conta, pois não é um triângulo válido).
	 */
	@Test
	public void trianguloEscalenoValido() {
		// Preparação
		
		// Executar
		int res = ct.getClassificacaoTriangulo(2, 4, 5);
		
		// Asserções
		assertEquals("Era esperado um triângulo escaleno válido.", ESCALENO,
				res);
	}

	/**
	 * Caso de teste que representa um triângulo equilátero válido;
	 */
	@Test
	public void trianguloEquilateroValido() {
		int res = ct.getClassificacaoTriangulo(5, 5, 5);
		assertEquals("Era esperado um triângulo equilátero válido.",
				EQUILATERO, res);
	}

	/**
	 * Caso de teste que representa um triângulo isóceles (Obs: Casos de teste
	 * como 2, 2, 4 não conta, pois não é um triângulo válido);
	 */
	@Test
	public void trianguloIsocelesValido() {
		int res = ct.getClassificacaoTriangulo(5, 5, 8);
		assertEquals("Era esperado um triângulo isóceles válido.", ISOCELES,
				res);
	}

	/**
	 * Pelo menos três casos de teste que representa um triângulo isóceles
	 * válido, de modo que tenhas testado todas as permutações com dois lados
	 * iguais (por exemplo, 3, 3, 4; 3, 4, 3; e 4, 3, 3);
	 */
	@Test
	public void trianguloIsocelesValidoPerm1() {
		int res = ct.getClassificacaoTriangulo(3, 3, 4);
		assertEquals("Era esperado um triângulo isóceles válido.", ISOCELES,
				res);

	}

	/**
	 * Pelo menos três casos de teste que representa um triângulo isóceles
	 * válido, de modo que tenhas testado todas as permutações com dois lados
	 * iguais (por exemplo, 3, 3, 4; 3, 4, 3; e 4, 3, 3);
	 */
	@Test
	public void trianguloIsocelesValidoPerm2() {
		int res = ct.getClassificacaoTriangulo(3, 4, 3);
		assertEquals("Era esperado um triângulo isóceles válido.", ISOCELES,
				res);

	}

	/**
	 * Pelo menos três casos de teste que representa um triângulo isóceles
	 * válido, de modo que tenhas testado todas as permutações com dois lados
	 * iguais (por exemplo, 3, 3, 4; 3, 4, 3; e 4, 3, 3);
	 */
	@Test
	public void trianguloIsocelesValidoPerm3() {
		int res = ct.getClassificacaoTriangulo(4, 3, 3);
		assertEquals("Era esperado um triângulo isóceles válido.", ISOCELES,
				res);

	}

	/**
	 * Caso de teste onde um dos lados é zero;
	 */
	@Test
	public void trianguloInvalidoLadoZeroPerm1() {
		int res = ct.getClassificacaoTriangulo(0, 4, 5);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste onde um dos lados é zero;
	 */
	@Test
	public void trianguloInvalidoLadoZeroPerm2() {
		int res = ct.getClassificacaoTriangulo(4, 0, 5);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste onde um dos lados é zero;
	 */
	@Test
	public void trianguloInvalidoLadoZeroPerm3() {
		int res = ct.getClassificacaoTriangulo(4, 5, 0);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste onde um dos lados é negativo;
	 */
	@Test
	public void trianguloInvalidoLadoNegativoPerm1() {
		int res = ct.getClassificacaoTriangulo(-1, 4, 5);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste onde um dos lados é negativo;
	 */
	@Test
	public void trianguloInvalidoLadoNegativoPerm2() {
		int res = ct.getClassificacaoTriangulo(4, -1, 5);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste onde um dos lados é negativo;
	 */
	@Test
	public void trianguloInvalidoLadoNegativoPerm3() {
		int res = ct.getClassificacaoTriangulo(4, 5, -1);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste com três números maiores que zero, de modo que a soma de
	 * dois deles seja exatamente igual ao terceiro (Ou seja, se o programa
	 * disser que 1, 2 e 3 é um triângulo escaleno, este teria um bug);
	 */
	@Test
	public void trianguloInvalidoSomaDoisLadosIgualAoOutroLado() {
		int res = ct.getClassificacaoTriangulo(1, 2, 3);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Pelo menos três casos de teste da categoria 7, de modo que sejam testadas
	 * todas as três permutações onde o tamanho de um lado é igual a soma dos
	 * outros dois (por exemplo, 1, 2, 3; 1, 3, 2; e 3, 1, 2);
	 */
	@Test
	public void trianguloInvalidoSomaDoisLadosIgualAoOutroLadoPerm1() {
		int res = ct.getClassificacaoTriangulo(1, 2, 3);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Pelo menos três casos de teste da categoria 7, de modo que sejam testadas
	 * todas as três permutações onde o tamanho de um lado é igual a soma dos
	 * outros dois (por exemplo, 1, 2, 3; 1, 3, 2; e 3, 1, 2);
	 */
	@Test
	public void trianguloInvalidoSomaDoisLadosIgualAoOutroLadoPerm2() {
		int res = ct.getClassificacaoTriangulo(1, 3, 2);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Pelo menos três casos de teste da categoria 7, de modo que sejam testadas
	 * todas as três permutações onde o tamanho de um lado é igual a soma dos
	 * outros dois (por exemplo, 1, 2, 3; 1, 3, 2; e 3, 1, 2);
	 */
	@Test
	public void trianguloInvalidoSomaDoisLadosIgualAoOutroLadoPerm3() {
		int res = ct.getClassificacaoTriangulo(3, 1, 2);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste com três números maiores que zero, de modo que a soma de
	 * dois deles é menor que o terceiro (por exemplo, 1, 2, 4 ou 12, 15, 30);
	 */
	@Test
	public void trianguloInvalidoSomaDoisLadosMenorQueOutroLado() {
		int res = ct.getClassificacaoTriangulo(12, 15, 30);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste com três números maiores que zero, de modo que a soma de
	 * dois deles é menor que o terceiro (por exemplo, 1, 2, 4 ou 12, 15, 30);
	 */
	@Test
	public void trianguloInvalidoSomaDoisLadosMenorQueOutroLadoPerm1() {
		int res = ct.getClassificacaoTriangulo(12, 15, 30);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste com três números maiores que zero, de modo que a soma de
	 * dois deles é menor que o terceiro (por exemplo, 1, 2, 4 ou 12, 15, 30);
	 */
	@Test
	public void trianguloInvalidoSomaDoisLadosMenorQueOutroLadoPerm2() {
		int res = ct.getClassificacaoTriangulo(15, 12, 30);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}

	/**
	 * Caso de teste com três números maiores que zero, de modo que a soma de
	 * dois deles é menor que o terceiro (por exemplo, 1, 2, 4 ou 12, 15, 30);
	 */
	@Test
	public void trianguloInvalidoSomaDoisLadosMenorQueOutroLadoPerm3() {
		int res = ct.getClassificacaoTriangulo(15, 30, 12);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}
	
	/**
	 * Caso de teste onde todos os lados são iguais a zero (i.e. 0, 0, 0);
	 */
	@Test
	public void trianguloInvalidoTodosLadosIguaisAZero() {
		int res = ct.getClassificacaoTriangulo(0, 0, 0);
		assertEquals("Era esperado um triângulo inválido.", INVALIDO, res);
	}
	
	@Test
	public void trianguloValidoTodosLadosComMaiorIntegerPossivel() {
		int res = ct.getClassificacaoTriangulo(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		assertEquals("Era esperado um triângulo equilátero.", EQUILATERO, res);
	}
}
