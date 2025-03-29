package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	
	private static void loadProperties() {
		
		if(properties == null) {			
			properties = new Properties();			
		}		
		try  {			
			FileInputStream file =	new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\PreparationAgain\\Resources\\Config.properties");
			properties.load(file);			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static String getProperty(String key) {
		loadProperties();
		return System.getProperty(key, properties.getProperty(key));
	}
	
}
