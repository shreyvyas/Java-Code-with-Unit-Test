package testJavaPrograms;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javaPrograms.IsPalindrome;

public class Palindrome_TestNG_Test {
	
	IsPalindrome palindrome = new IsPalindrome();
	
	@DataProvider(name = "dataprovider")
	public Object[][] testData(){
		
		return new Object[][] {
			
			{"madam"},
			{"MADAM"},
			{"MADam"},
			{"m@d@m"}
			
		};		
	}
	
	@Test(dataProvider = "dataprovider")
	public void test_IsPalindrome(String input) {
		
		boolean result = palindrome.isPalindrome(input);
		
		Assert.assertTrue(result);
		
	}

}
