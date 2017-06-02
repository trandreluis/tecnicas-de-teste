package br.edu.ifpb.mt.tt.testExecutionOrder;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMethodOrder {
	
	@Test
	public void testC() {
		System.out.println("third");
	}
	
	@Test
	public void testB() {
		System.out.println("second");
	}

	@Test
	public void testA() {
		System.out.println("first");
	}
	
}
