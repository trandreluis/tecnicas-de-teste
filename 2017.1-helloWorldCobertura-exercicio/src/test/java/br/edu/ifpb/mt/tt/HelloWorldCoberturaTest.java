package br.edu.ifpb.mt.tt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldCoberturaTest {
	
	private Exercicio6 ex6;
	
	@Before
	public void init() {
		ex6 = new Exercicio6();
	}

	/**
	 * A = 31, B = 12, X = 3
	 */
	@Test
	public void cenario01() {
		int res = ex6.exercicio6(-1, -1, -1);

		assertEquals("A = 31, B = 12, X = 3", -1, res);
	}
	
	/**
	 * A = 3, B = -1, X = 2
	 */
	@Test
	public void cenario02() {
		int res = ex6.exercicio6(3, -1, 2);
		
		assertEquals("A = 3, B = -1, X = 2", 3, res);
	}
	
	/**
	 * A = 2, B = 0, X = 4
	 */
	@Test
	public void cenario03() {
		int res = ex6.exercicio6(2, 0, 4);
		
		assertEquals("A = 2, B = 0, X = 4", 3, res);
	}
	
	/**
	 * A = 2, B = 0, X = 1
	 */
	@Test
	public void cenario04() {
		int res = ex6.exercicio6(2, 0, 1);
		
		assertEquals("A = 2, B = 0, X = 1", 1, res);
	}
	
}
