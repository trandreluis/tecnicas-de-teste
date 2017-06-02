package br.edu.ifpb.mt.tt.matchersAndAssertThat;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MatchersAndAssertThat {

	@Test
	public void exemplo() {
		int x = 3;
		String responseString = "The color is blue.";
		List<String> myList = new ArrayList<>();
		myList.add("1");
		myList.add("2");
		myList.add("3");

		assertThat(x, is(3));
		assertThat(x, is(not(4)));
		assertThat(responseString, either(containsString("color")).or(containsString("colour")));
		assertThat(myList, hasItem("3"));

		// assertThat([value], [matcher statement]);
	}

}
