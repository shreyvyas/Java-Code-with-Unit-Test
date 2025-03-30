package testJSONData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utilities.Constants;

public class CompareJSON {
	
	public static boolean readCounters() throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonnode1 = objectMapper.readTree(new File(Constants.counterfilepath1));
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

}



//Recommended Way to Read JSON Data in Java
//The best way to read JSON data depends on your use case:
//
//For structured JSON → Use POJOs with readValue()
//
//For dynamic JSON → Use Map or JsonNode (readTree())
//
//For large JSON files → Use Streaming API (JsonParser)