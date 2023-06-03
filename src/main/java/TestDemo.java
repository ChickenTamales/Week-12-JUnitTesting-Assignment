import java.util.Random;
import java.util.random.*;

public class TestDemo {

	/*
	 * Create an instance method (not static) named addPositive. It should take two
	 * int parameters and return an int.
	 * 
	 * If both parameters are positive (greater than zero) return the sum of the
	 * parameters. If either parameter is zero or negative, throw an
	 * IllegalArgumentException with the message
	 * "Both parameters must be positive!".
	 */
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			int sum = a + b;
			return sum;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
	}

	/*
	 * In TestDemo.java, add another method named randomNumberSquared. This method
	 * obtains a random int between 1 and 10 and then returns the square of the
	 * number.
	 * 
	 * randomNumberSquared should return an int and not take any parameters.
	 * 
	 * It should call another method in the same class named getRandomInt. This
	 * method takes no parameters and must be package visibility so that the test
	 * can see it. getRandomInt should look like this: int getRandomInt() { Random
	 * random = new Random(); return random.nextInt(10) + 1; } The Random class is
	 * in the java.util package.
	 * 
	 * randomNumberSquared should return the value obtained from getRandomInt m
	 * multiplied by itself.
	 * 
	 */

	public int randomNumberSquared() {

		int c = getRandomInt();
		int cSquared = c * c;

		return cSquared;
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
