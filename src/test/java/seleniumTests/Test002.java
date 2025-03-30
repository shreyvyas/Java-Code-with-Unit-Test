package seleniumTests;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import testJSONData.CompareJSON;

public class Test002 {
	
	@Test(description="Validate before and after counters")
	public void validateCounters() throws IOException {
		
		try {
			boolean result = CompareJSON.readCounters();
			Assert.assertTrue(result);
			
		}
		catch(Exception e) {
			System.out.println("Failed " +e.getMessage());
		}	
		
	}
	
	@Test(description="read node")
	public void readValue() {
		
		try {
			
			List<String> values = CompareJSON.readValues();
			System.out.println(values);
			
			List<String> expectedValues = Arrays.asList("New", "Open", "Close");
			
			Assert.assertEquals(values, expectedValues);
			
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
