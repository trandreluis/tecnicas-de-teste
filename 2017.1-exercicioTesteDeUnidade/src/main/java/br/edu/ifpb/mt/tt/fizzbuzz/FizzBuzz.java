package br.edu.ifpb.mt.tt.fizzbuzz;

/**
 * 
 * "Write a program that prints the numbers from 1 to 100. But for multiples of
 * three print 'Fizz' instead of the number and for the multiples of five print
 * 'Buzz'. For numbers which are multiples of both three and five print
 * 'FizzBuzz'".
 * 
 * Referência:
 * http://blog.codeleak.pl/2014/11/unit-testing-exercise-with-fizzbuzz-and.html
 * Acessado em: 02/2015
 * 
 * @author jaindsonvs
 *
 */
public class FizzBuzz {

	private static final int FIVE = 5;

	private static final int THREE = 3;

	public static final String FIZZ = "Fizz";

	public static final String BUZZ = "Buzz";

	public static final String FIZZ_BUZZ = FIZZ + BUZZ;

	public String calculate(int number) {

		if (isDivisibleBy(number, THREE) && isDivisibleBy(number, FIVE)) {
			return FIZZ_BUZZ;
		}

		if (isDivisibleBy(number, THREE)) {
			return FIZZ;
		}

		if (isDivisibleBy(number, FIVE)) {
			return BUZZ;
		}

		return String.valueOf(number);
	}

	private boolean isDivisibleBy(int dividend, int divisor) {
		return dividend % divisor == 0;
	}
	
	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz();
		for (int i = 1; i <= 100; i++) {
			System.out.println(fizzBuzz.calculate(i));
		}
	}
}
