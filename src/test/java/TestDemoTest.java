import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {

	/*
	 * In TestDemoTest.java, add a private instance variable of type TestDemo named
	 * testDemo.
	 * 
	 * In the setUp method, create the TestDemo object. This will ensure that a new
	 * TestDemo object is created before each test.
	 * 
	 */

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	/*
	 * Change "@Test" to "@ParameterizedTest". Add the import statement for
	 * org.junit.jupiter.params.ParameterizedTest.
	 * 
	 * Change the name of method "test" to
	 * "assertThatTwoPositiveNumbersAreAddedCorrectly".
	 * 
	 * Add four parameters to assertThatTwoPositiveNumbersAreAddedCorrectly
	 * 
	 * Write the test. Remove the "fail" line. Test the value of expectException. If
	 * it is false, assert that when TestDemo.addPositive is called with values a
	 * and b, that the result is the same as the parameter expected.
	 * 
	 * Add the test for the thrown exception in an else clause. Use
	 * assertThatThrownBy for this. Add the static import
	 * org.assertj.core.api.Assertions.assertThatThrownBy;
	 * 
	 * As a parameter to assertThatThrownBy, add a Lambda expression with no
	 * parameters. The Lambda body should be the method call to
	 * testDemo.addPositive.
	 * 
	 * Use the assertion isInstanceOf(IllegalArgumentException.class) to ensure that
	 * the correct exception is thrown.
	 * 
	 * If this is too confusing, you can "cheat" and copy this:
	 * assertThatThrownBy(() -> testDemo.addPositive(a, b))
	 * .isInstanceOf(IllegalArgumentException.class);
	 * 
	 * Just below the @ParameterizedTest annotation, add the
	 * annotation @MethodSource.
	 * 
	 * Pass a single parameter to @MethodSource. It must be the fully-qualified
	 * (includes package) class name of the test followed by a # sign followed by
	 * the name of the method that supplies the parameters. Since the test is in the
	 * default package, there is no package in the fully-qualified class name. So,
	 * 
	 * @MethodSource("TestDemoTest#argumentsForAddPositive")
	 * 
	 */

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
//			throw new Exception(isInstanceOf(IllegalArgumentException.class));

		}
	}

	/*
	 * Create a static method named argumentsForAddPositive. It should not have any
	 * parameters and it should return a Stream of Arguments. The imports are:
	 * java.util.stream.Stream and org.junit.jupiter.params.provider.Arguments.
	 * 
	 * The method should return a Stream as in Stream.of();
	 * 
	 * Each parameter set should be wrapped in an arguments() method call. Add the
	 * static import for arguments:
	 * org.junit.jupiter.params.provider.Arguments.arguments.
	 * 
	 * So, if you are adding 2 and 4 to get the value of 6 and are not expecting an
	 * exception, you need to do: arguments(2, 4, 6, false)
	 * 
	 * Add as many arguments lines as needed to test the addPositive method
	 * thoroughly. Make sure to add some zero or negative arguments
	 * 
	 */

	static Stream<Arguments> argumentsForAddPositive() {
		
		//@formatter:off
		return Stream.of(
				arguments(2, 4, 6, false), 
				arguments(2, -4, 2, true), 
				arguments(0, 0, 0, true));
		//@formatter:on
	}
	
	/*
	 * Create a method annotated with @Test named assertThatNumberSquaredIsCorrect. 
	 * The method must have package visibility (not public!) or JUnit won't find it. 
	 * The annotation @Test is in the org.junit.jupiter.api package.
	 * 
	 * To mock the TestDemo class, use Mockito.spy. The spy method can be imported 
	 * with a static import of org.mockito.Mockito.spy.
	 * TestDemo mockDemo = spy(testDemo);
	 * 
	 * Program the mocked TestDemo object to return 5 when the getRandomInt method is 
	 * called. Remember to use the form: 
	 * doReturn(aValue).when(mockedObject).methodCall(). 
	 * 
	 * You can use a static import for doReturn: import 
	 * static org.mockito.Mockito.doReturn; 
	 * 
	 * doReturn(5).when(mockDemo).getRandomInt();
	 *
	 * Call the method randomNumberSquared on the mocked TestDemo object. This will 
	 * call the stubbed out (mocked) method getRandomInt, which now should return the 
	 * value 5.
	 * 
	 * int fiveSquared = mockDemo.randomNumberSquared();
	 *
	 * Use assertThat to test that the value returned from randomNumberSquared is 
	 * equal to 5 squared.
	 *
	 *assertThat(fiveSquared).isEqualTo(25);
	 *
	 * */
	
	@Test
	private void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}
