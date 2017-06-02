package br.edu.ifpb.mt.tt.ignoringTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;


public class IgnoringTests {

	@Ignore("Test is ignored as a demonstration")
	@Test
	public void testSame() {
	    assertThat(1, is(1));
	}
	
	@Test
	public void testOther() {
	    assertThat(1, is(1));
	}	
}
