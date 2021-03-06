package br.edu.ifpb.mt.tt.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@SuiteClasses({ A.class, B.class }) // Note that Categories is a kind of Suite
public class SlowTestSuite {
	// Will run A.b and B.c, but not A.a
}
