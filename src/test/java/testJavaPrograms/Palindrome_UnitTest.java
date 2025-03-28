package testJavaPrograms;

import static org.testng.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javaPrograms.IsPalindrome;

public class Palindrome_UnitTest {
	
	IsPalindrome palindrome = new IsPalindrome();
	
	@ParameterizedTest(name = "Test Case {index}: Input = {0}")
	@CsvSource({
		
		"'madam', true",
		"'MADAM', true",
		"'MADam', true",
		"'m@d@m', true"
		
	})
	
	void testIsPalindrome(String input, boolean expected) {
		
		boolean result = palindrome.isPalindrome(input);
		assertEquals(expected, result);
		
		System.out.println("Test Case Passed: Input = " + input + ", Expected = " + expected + ", Actual = " + result);
		
	}
	
	

}
