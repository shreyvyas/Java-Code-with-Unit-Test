package testJSONData;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJSONData {
	
	@Test(description="Validate Country Name")
	public void testCountryName() {
		
		try {
			String actualResult = JSONRead.getCountry();
			System.out.println(actualResult);
			String expectedResult = "USA";
			Assert.assertEquals(actualResult, expectedResult, "Country is not matched");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	@Test(description="Validate Second Employee Name")
	public void getSecondEmployeeName() {
		
		try {
			String actualResult = JSONRead.getSecondEmployee();
			System.out.println(actualResult);
			String expectedResult = "Bob";
			Assert.assertEquals(actualResult, expectedResult, "Name is not matched");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	@Test(description="Get Skills")
	public void getSkill() throws IOException {
		
		JSONRead.getSkills();
		
	}
	
	@Test(description="Get Project Budget")
	public void getBudget() {
		
		long actualResult;
		
		try {
			actualResult = JSONRead.getProjectBudget("Project Beta");
			long expectedResult = 200000;
			Assert.assertEquals(actualResult, expectedResult);
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
