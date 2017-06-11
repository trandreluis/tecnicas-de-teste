package br.edu.ifpb.mt.tt.matcher;

import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HasSizeMatcher extends TypeSafeMatcher<Collection<? extends Object>> {

	private Matcher<Integer> matcher;
	
	public HasSizeMatcher(Matcher<Integer> matcher) {
		this.matcher = matcher;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("a collection with size ");
		matcher.describeTo(description);
	}

	@Override
	protected boolean matchesSafely(Collection<? extends Object> collection) {
		return matcher.matches(collection.size());
	}
	
	protected void describeMismatchSafely(Collection<? extends Object> collection, Description mismatchDescription) {
		mismatchDescription.appendValue(collection.size());
	}
	
}
