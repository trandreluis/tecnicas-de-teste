package br.edu.ifpb.mt.tt.categories;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.experimental.categories.Category;

public class A {

	@Test
	public void a() {
		fail();
	}

	@Category(SlowTests.class)
	@Test
	public void b() {
	}
}
