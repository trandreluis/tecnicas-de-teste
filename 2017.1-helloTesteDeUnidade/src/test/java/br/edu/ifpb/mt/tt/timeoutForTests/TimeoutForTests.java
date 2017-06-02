package br.edu.ifpb.mt.tt.timeoutForTests;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TimeoutForTests {

	@Test(timeout=1000)
	public void testWithTimeout() {
	  //...
	}

	@Test(timeout=1000)
	public void otherTestWithTimeout() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(2000);
	}
}
