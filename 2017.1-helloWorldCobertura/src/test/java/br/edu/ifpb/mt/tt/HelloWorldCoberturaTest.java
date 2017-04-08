package br.edu.ifpb.mt.tt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldCoberturaTest {
	
	private HelloWorldCobertura hwc;
	
	@Before
	public void init() {
		hwc = new HelloWorldCobertura();
	}

	/**
	 * A = -1, B = -1, X = -1
	 */
	@Test
	public void cenario01() {
		int res = hwc.foo(-1, -1, -1);

		assertEquals("A = -1, B = -1, X = -1", -1, res);
	}
	
	/**
	 * A = 3, B = -1, X = 2
	 */
	@Test
	public void cenario02() {
		int res = hwc.foo(3, -1, 2);
		
		assertEquals("A = 3, B = -1, X = 2", 3, res);
	}
	
	/**
	 * A = 2, B = 0, X = 4
	 */
	@Test
	public void cenario03() {
		int res = hwc.foo(2, 0, 4);
		
		assertEquals("A = 2, B = 0, X = 4", 3, res);
	}
	
	/**
	 * A = 2, B = 0, X = 1
	 */
	@Test
	public void cenario04() {
		int res = hwc.foo(2, 0, 1);
		
		assertEquals("A = 2, B = 0, X = 1", 1, res);
	}
	
}
