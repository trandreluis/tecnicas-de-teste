package br.edu.ifpb.mt.tt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.SmartNullPointerException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import br.edu.ifpb.mt.tt.helper.Foo;
import br.edu.ifpb.mt.tt.helper.Mock1;
import br.edu.ifpb.mt.tt.helper.Person;
import br.edu.ifpb.mt.tt.helper.Stuff;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

	@Mock
	private List<String> mockedList;

	@Mock
	private Mock1 mock;

	/**
	 * <pre>
	 * 1. Let's verify some behaviour!
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#1
	 * </pre>
	 */
	@Test
	public void cenario01() {
		// mock creation
		List<String> mockedList = mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

	/**
	 * <pre>
	 * 2. How about some stubbing?
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#2
	 * </pre>
	 */
	@Test
	public void cenario02() {
		// You can mock concrete classes, not just interfaces
		LinkedList<String> mockedList = mock(LinkedList.class);

		// stubbing
		when(mockedList.get(0)).thenReturn("first");
		//doReturn("first").when(mockedList).get(0);
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		//doThrow(new RuntimeException()).when(mockedList).get(1);

		// following prints "first"
		assertEquals("first", mockedList.get(0));

		// following throws runtime exception
		try {
			mockedList.get(1);
			fail("Deveria ter sido lançada uma 'RuntimeException'.");
		} catch (RuntimeException e) {
			// OK
		}

		// following returns "null" because get(999) was not stubbed
		assertNull(mockedList.get(999));

		// Although it is possible to verify a stubbed invocation, 
		// usually it's just redundant
		// If your code cares what get(0) returns then something else breaks
		// (often before even verify() gets executed).
		// If your code doesn't care what get(0) returns then it should not be
		// stubbed. Not convinced? See <a href="http://monkeyisland.pl/2008/04/26/asking-and-telling">here</a>.
		verify(mockedList).get(0);
	}

	/**
	 * <pre>
	 * 3. Argument matchers
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#3
	 * </pre>
	 */
	@Test
	public void cenario03() {
		// mock creation
		List<String> mockedList = mock(List.class);

		// stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		// stubbing using custom matcher (let's say isValid() returns 
		// your own matcher implementation):
		// when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		// following returns "element"
		assertEquals("element", mockedList.get(999));

		// you can also verify using an argument matcher
		verify(mockedList).get(anyInt());
		
		//argument matchers can also be written as Java 8 Lambdas
		mockedList.add("another element");
		verify(mockedList).add(argThat(someString -> someString.length() > 5));
	}

	/**
	 * <pre>
	 * 4. Verifying exact number of invocations / at least x / never
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#4
	 * </pre>
	 */
	@Test
	public void cenario04() {
		// mock creation
		List<String> mockedList = mock(List.class);

		// using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		mockedList.add("five times");
		mockedList.add("five times");
		mockedList.add("five times");
		mockedList.add("five times");
		mockedList.add("five times");

		// following two verifications work exactly the same - times(1) is used
		// by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");
		verify(mockedList, times(5)).add("five times");

		// verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		// verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("five times");
		verify(mockedList, atMost(5)).add("three times");
	}

	/**
	 * <pre>
	 * 5. Stubbing void methods with exceptions
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#5
	 * </pre>
	 */
	@Test(expected = RuntimeException.class)
	public void cenario05() {
		// mock creation
		List<String> mockedList = mock(List.class);

		doThrow(new RuntimeException()).when(mockedList).clear();

		// following throws RuntimeException:
		mockedList.clear();
	}

	/**
	 * <pre>
	 * 6. Verification in order
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#6
	 * </pre>
	 */
	@Test
	public void cenario06() {
		// A. Single mock whose methods must be invoked in a particular order
		List<String> singleMock = mock(List.class);

		// using a single mock
		singleMock.add("was added first");
		singleMock.add("was added second");

		// create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(singleMock);

		// following will make sure that add is first called with "was added
		// first", then with "was added second"
		inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");

		// B. Multiple mocks that must be used in a particular order
		List<String> firstMock = mock(List.class);
		List<String> secondMock = mock(List.class);

		// using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");

		// create inOrder object passing any mocks that need to be verified in
		// order
		inOrder = inOrder(firstMock, secondMock);

		// following will make sure that firstMock was called before secondMock
		inOrder.verify(firstMock).add("was called first");
		inOrder.verify(secondMock).add("was called second");

		// Oh, and A + B can be mixed together at will
	}

	/**
	 * <pre>
	 * 7. Making sure interaction(s) never happened on mock
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#7
	 * </pre>
	 */
	@Test
	public void cenario07() {
		// mock creation
		List<String> mockOne = mock(List.class);
		List<String> mockTwo = mock(List.class);
		List<String> mockThree = mock(List.class);

		// using mocks - only mockOne is interacted
		mockOne.add("one");

		// ordinary verification
		verify(mockOne).add("one");

		// verify that method was never called on a mock
		verify(mockOne, never()).add("two");

		// verify that other mocks were not interacted
		verifyZeroInteractions(mockTwo, mockThree);
	}

	/**
	 * <pre>
	 * 8. Finding redundant invocations
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#8
	 * </pre>
	 */
	@Test
	public void cenario08() {
		// mock creation
		List<String> mockedList = mock(List.class);

		// using mocks
		mockedList.add("one");
		mockedList.add("two");

		verify(mockedList).add("one");

		// following verification will fail
		//verifyNoMoreInteractions(mockedList);
	}

	/**
	 * <pre>
	 * 9. Shorthand for mocks creation - @Mock annotation
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#9
	 * </pre>
	 */
	@Test
	public void cenario09() {

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

	/**
	 * <pre>
	 * 10. Stubbing consecutive calls (iterator-style stubbing)
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#10
	 * </pre>
	 */
	@Test
	public void cenario10() {
		when(mock.someMethod("some arg")).thenThrow(new RuntimeException()).thenReturn("foo");
		
		// Alternative, shorter version of consecutive stubbing:
		// when(mock.someMethod("some arg")).thenReturn("one", "two", "three");

		// First call: throws runtime exception:
		try {
			mock.someMethod("some arg");
			fail("Deveria ter lançado exceção na primeira chamada!");
		} catch (RuntimeException re) {
			// OK...
		}

		// Second call: prints "foo"
		assertEquals("foo", mock.someMethod("some arg"));

		// Any consecutive call: prints "foo" as well (last stubbing wins).
		assertEquals("foo", mock.someMethod("some arg"));
		
		// Warning : if instead of chaining .thenReturn() calls, multiple stubbing with 
		// the same matchers or arguments is used, then each stubbing will override 
		// the previous one:
		when(mock.someMethod("some arg")).thenReturn("one");
		when(mock.someMethod("some arg")).thenReturn("two");
		
		assertEquals("two", mock.someMethod("some arg"));
		assertEquals("two", mock.someMethod("some arg"));
	}

	/**
	 * <pre>
	 * 11. Stubbing with callbacks
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#11
	 * </pre>
	 */
	@Test
	public void cenario11() {

		when(mock.someMethod(anyString())).thenAnswer(new Answer<String>() {

			public String answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				Method method = invocation.getMethod();
				//Object mock = invocation.getMock();
				return "called method '" + method.getName() + "' with arguments: " + Arrays.toString(args);
			}
		});

		// Following prints "called with arguments: foo"
		assertEquals("called method 'someMethod' with arguments: [foo]", mock.someMethod("foo"));

	}

	/**
	 * <pre>
	 * 12. doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() family of methods
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#12
	 * </pre>
	 */
	@Test(expected = RuntimeException.class)
	public void cenario12() {
		doThrow(new RuntimeException()).when(mockedList).clear();

		// following throws RuntimeException:
		mockedList.clear();
	}

	/**
	 * <pre>
	 * 13. Spying on real objects
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#13
	 * </pre>
	 */
	@Test
	public void cenario13() {

		List<String> list = new LinkedList<String>();
		List<String> spy = spy(list);

		// optionally, you can stub out some methods:
		when(spy.size()).thenReturn(100);

		// using the spy calls *real* methods
		spy.add("one");
		spy.add("two");

		// prints "one" - the first element of a list
		assertEquals("one", spy.get(0));

		// size() method was stubbed - 100 is printed
		assertEquals(100, spy.size());

		// optionally, you can verify
		verify(spy).add("one");
		verify(spy).add("two");

		// Important gotcha on spying real objects!

		list = new LinkedList<String>();
		spy = spy(list);

		// Impossible: real method is called so spy.get(0) throws
		// IndexOutOfBoundsException (the list is yet empty)
		try {
			when(spy.get(0)).thenReturn("foo");
			fail("Deveria ter sido lançado 'IndexOutOfBoundsException', uma vez que a implementação real é usada.");
		} catch (IndexOutOfBoundsException e) {
			// OK
		}

		// You have to use doReturn() for stubbing
		doReturn("foo").when(spy).get(0);
		
		assertEquals("foo", spy.get(0));

	}

	/**
	 * <pre>
	 * 14. Changing default return values of unstubbed invocations (Since 1.7)
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#14
	 * </pre>
	 */
	@Test
	public void cenario14() {

		// Primeiro cenário: *SEM* a configuração do "smart null"
		Foo mock = mock(Foo.class);
		Stuff stuff = mock.getStuff();

		// calling unstubbed method here:
		try {
			// using object returned by unstubbed call:
			stuff.doSomething();
			fail("Deveria ter sido lançado NPE");
		} catch (NullPointerException npe) {
			// expected
			npe.printStackTrace();
		}

		// Segundo cenário: *COM* a configuração do "smart null"
		mock = mock(Foo.class, Mockito.RETURNS_SMART_NULLS);
		
		// About smart nulls: This implementation can be helpful when working with 
		// legacy code. Unstubbed methods often return null. If your code uses the 
		// object returned by an unstubbed call you get a NullPointerException. 
		// This implementation of Answer returns SmartNull instead of null. SmartNull 
		// gives nicer exception message than NPE because it points out the line where 
		// unstubbed method was called. You just click on the stack trace. 

		// calling unstubbed method here:
		stuff = mock.getStuff();

		// using object returned by unstubbed call:
		try {
			stuff.doSomething();
		} catch (SmartNullPointerException snpe) {
			// expected
			snpe.printStackTrace();
		}

	}

	/**
	 * <pre>
	 * 15. Capturing arguments for further assertions (Since 1.8.0)
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#15
	 * </pre>
	 */
	@Test
	public void cenario15() {
		// Configuração do mock
		Stuff mock = mock(Stuff.class);
		ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);

		// Uso do mock nos testes
		mock.doSomething(new Person("John"));

		// Verificação
		verify(mock).doSomething(argument.capture());
		assertEquals("John", argument.getValue().getName());
	}

	/**
	 * <pre>
	 * 16. Real partial mocks (Since 1.8.0)
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#16
	 * </pre>
	 */
	@Test
	public void cenario16() {
		// Ver cenario13()
	}

	/**
	 * <pre>
	 * 17. Resetting mocks (Since 1.8.0)
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#17
	 * </pre>
	 */
	@Test
	public void cenario17() {
		List<Integer> mock = mock(List.class);
		when(mock.size()).thenReturn(10);
		mock.add(1);

		reset(mock);
		// at this point the mock forgot any interactions & stubbing
		verifyZeroInteractions(mock);
	}
	
	/**
	 * <pre>
	 * 18. Troubleshooting & validating framework usage (Since 1.8.0)
	 * 
	 * http://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#18
	 * </pre>
	 */
	@Test
	public void cenario18() {
		// Tópico sem código prático
	}
	
	// ...
	
}
