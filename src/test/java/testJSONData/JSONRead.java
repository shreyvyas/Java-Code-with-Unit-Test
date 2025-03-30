package testJSONData;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utilities.Constants;

public class JSONRead {
	
	static ObjectMapper objectmapper;
	static JsonNode jsonNode;
	
	public static String getCountry() throws IOException {
		
		objectmapper = new ObjectMapper();
		
		jsonNode = objectmapper.readTree(new File(Constants.testdata2));
		
		String countryName = jsonNode.path("company").path("location").path("country").asText();
		
		return countryName;
		
	}
	
	public static String getSecondEmployee() throws IOException {
		
		objectmapper = new ObjectMapper();
		
		jsonNode = objectmapper.readTree(new File(Constants.testdata2));
		
		JsonNode departments = jsonNode.path("company").path("departments");
		
		for(JsonNode jn : departments) {
			
			if(jn.path("name").asText().equals("Engineering")) {
				
				return jn.path("employees").get(1).path("name").asText();
				
			}			
		}
		return "Not Found";		
	}
	
	public static void getSkills() throws IOException {
		
		objectmapper = new ObjectMapper();
		
		jsonNode = objectmapper.readTree(new File(Constants.testdata2));
		
		JsonNode departments = jsonNode.path("company").path("departments");
		
		List<String> list = new ArrayList<>();
		
		for(JsonNode department : departments) {
			
			if(department.path("name").asText().equals("Engineering")) {
				
				JsonNode skills = department.path("employees").get(0).path("skills");
				
				for(JsonNode skill : skills) {
					
					list.add(skill.asText());
					
				}				
			}			
		}
		System.out.println(list);
		
	}
	
	public static long getProjectBudget(String projectName) throws IOException {
		
		objectmapper = new ObjectMapper();
		
		jsonNode = objectmapper.readTree(new File(Constants.testdata2));
		
		JsonNode department = jsonNode.path("company").path("departments");
		
		for(JsonNode dep : department) {
			
			if(dep.path("name").asText().equals("Engineering")) {
				
				JsonNode projectPath = dep.path("employees").path("projects"); //this is wrong. projects is an array, can't access directly
				
				for(JsonNode project : projectPath) {
					
					if(project.asText().equals(projectName)) {
						
						long budget = project.path("projects").path("budget").asLong();
						
						return budget;
					}					
				}	
			}			
		}
		return 0;		
	}

}






//1️⃣ Get the country where the company is located.
//2️⃣ Get the name of the second employee in the Engineering department.
//3️⃣ Get all the skills of Alice.
//4️⃣ Get the budget of "Project Beta".
//5️⃣ Get the role of the employee with id = 201.