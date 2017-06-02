package br.edu.ifpb.mt.tt;

import org.junit.Test;

public class ParallelTest {

	private void busyLooping() {
		for (long i = 0; i < 5000000000L; i++) {
			
		}
	}

	@Test
	public void test1() {
		busyLooping();
	}

	@Test
	public void test2() {
		busyLooping();
	}

	@Test
	public void test3() {
		busyLooping();
	}

	@Test
	public void test4() {
		busyLooping();
	}

	@Test
	public void test5() {
		busyLooping();
	}

	@Test
	public void test6() {
		busyLooping();
	}

	@Test
	public void test7() {
		busyLooping();
	}

	@Test
	public void test8() {
		busyLooping();
	}

	@Test
	public void test9() {
		busyLooping();
	}

	@Test
	public void test10() {
		busyLooping();
	}

}
