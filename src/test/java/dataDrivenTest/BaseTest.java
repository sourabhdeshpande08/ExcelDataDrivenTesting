package dataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
	
	WebDriver driver;
	
	@Test
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/GlobalProperties.properties");
		
		prop.load(fis);
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			Map<String, Boolean> prefs = new HashMap<String, Boolean>();
			prefs.put("credentials-enable-service", false);
			prefs.put("profile.password-manager-enabled", false);
			
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-features=passwordLeakDetection");
			
			
			driver = new ChromeDriver(options);
			
			
		}
		
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			
			driver = new FirefoxDriver(options);
			
			
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.setAcceptInsecureCerts(true);
			
			driver = new EdgeDriver(options);
			
			
		}
		
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	
	
	@BeforeTest
	public void launchApp() throws IOException
	{
		
		driver = initializeDriver();
		
		
		
	}
	
	

}
