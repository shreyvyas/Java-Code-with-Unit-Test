package testJSONData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import utilities.Constants;

public class IterateJsonObjects {
	
	public static void main(String[] args) throws IOException {
		
		//iterateJson1();
		
		//iterateJson2();
		
		iterateJson3(); 
	}
	
	static void iterateJson1() throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(new File(Constants.testdata1));
		
		String imageName = jsonNode.path("widget").path("image").path("name").asText();
		
		System.out.println(imageName);
		
	}
	
	static void iterateJson2() throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(new File(Constants.testdata1));
		
		JsonNode menu = jsonNode.path("widget");
		
		Iterator<String> keys = menu.fieldNames();
		
		while(keys.hasNext()) {
			System.out.println(keys.next());
		}
		
	}
	
	static void iterateJson3() throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(new File(Constants.testdata1));
		
		JsonNode window = jsonNode.path("widget").path("window");
		
		JsonNode image = jsonNode.path("widget").path("image");
		
		JsonNode text = jsonNode.path("widget").path("text");
		
		System.out.println(window.toPrettyString());
		System.out.println(image.toPrettyString());
		System.out.println(text.toPrettyString());
	}
	

}
