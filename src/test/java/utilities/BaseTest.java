package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;	
	
	@BeforeTest
	public void createDriver() {
		
		String browser = ConfigReader.getProperty("browser").toLowerCase();
		
		switch (browser) {
		
		case "chrome":
			ChromeOptions chromeoption = new ChromeOptions();
			chromeoption.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeoption);
			break;
			
		case "firefox":
			FirefoxOptions ffoption = new FirefoxOptions();
			//ffoption.addArguments("--start-maximized");
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium-Jars\\geckodriver.exe");
			driver = new FirefoxDriver(ffoption);
			driver.manage().window().maximize();
			break;
			
        default:
            throw new IllegalArgumentException("Invalid browser: " + browser);
		
		}
		
		driver.get(ConfigReader.getProperty("url"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
