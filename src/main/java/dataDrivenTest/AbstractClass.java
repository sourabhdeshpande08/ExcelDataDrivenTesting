package dataDrivenTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {
	
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	public AbstractClass(WebDriver driver)
	{
		
		this.driver=driver;
		
		
	}
	
	
	
	public void visibleElement(WebElement Ele)
	{
		
		
		wait.until(ExpectedConditions.visibilityOf(Ele));
		
		
	}
	
	public void invisibleElement(WebElement Ele)
	{
		
		
		wait.until(ExpectedConditions.invisibilityOf(Ele));
		
		
	}
	
	public void visibleElement(List<WebElement> Ele)
	{
		
		
		wait.until(ExpectedConditions.visibilityOfAllElements(Ele));
		
		
	}
	
	

}
