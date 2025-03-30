package testJSONData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import utilities.Constants;

public class CompareJSON {
	
	public static boolean readCounters() throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();    //read, write and convert JsonData
		
		JsonNode jsonnode1 = objectMapper.readTree(new File(Constants.counterfilepath1));   //Json Tree Structure
		JsonNode jsonnode2 = objectMapper.readTree(new File(Constants.counterfilepath2));
		
		int value1 = jsonnode1.get("counters").asInt();
		int value2 = jsonnode2.get("counters").asInt();
		
		System.out.println(value1==value2);
		
		return jsonnode1.equals(jsonnode2);
		
	}
	
	public static List<String> readValues() throws IOException {
		
		ObjectMapper objectmapper = new ObjectMapper();
		
		JsonNode jsonNode = objectmapper.readTree(new File(Constants.testdata));
		
		JsonNode menuItems = jsonNode.path("menu").path("popup").path("menuitem");
		
		List<String> values = new ArrayList<>();
		
		if(menuItems.isArray()) {
			
			for(JsonNode elem : menuItems) {
				
				values.add(elem.path("value").asText().trim());
				
			}
			
		}
		return values;	
		
	}
	
	public static String valueJsonPath() throws IOException {
		
		String jsonData = new String(Files.readAllBytes(Paths.get(Constants.testdata)));
		
		JsonPath js = new JsonPath(jsonData);
		
		String value = js.get("menu.popup.menuitem[0].value");
		
		return value;
		
	}

}



//Recommended Way to Read JSON Data in Java
//The best way to read JSON data depends on your use case:
//
//For structured JSON → Use POJOs with readValue()
//
//For dynamic JSON → Use Map or JsonNode (readTree())
//
//For large JSON files → Use Streaming API (JsonParser)