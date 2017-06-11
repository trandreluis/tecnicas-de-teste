package br.edu.ifpb.mt.tt.matcher;

import static br.edu.ifpb.mt.tt.matcher.MyMatchers.hasSize;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyMatchersTest {

	@Test
	public void test() {
		
		List<String> items = new ArrayList<String>();
		items.add("java");
		items.add("junit");
		items.add("mockito");
		
		assertThat(items, hasSize(equalTo(3)));
	}
	
}
