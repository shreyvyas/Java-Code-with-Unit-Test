package testJavaPrograms;

import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javaPrograms.BasicUnitTest;

public class BasicTest {
	
	@Test
	@DisplayName("Basic Unit Test")
	public void basicTest() {
		
		BasicUnitTest basic = new BasicUnitTest();
		
		String result = basic.printName();
		
		assertEquals(result, "Anagh");
		
		System.out.println("Test Finish");
		
	}

}
