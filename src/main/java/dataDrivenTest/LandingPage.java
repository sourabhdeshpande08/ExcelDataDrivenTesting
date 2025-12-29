package dataDrivenTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage extends AbstractClass{
	
	 WebDriver driver;
	
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="(//div[contains(@class,\"inline\")]/label/span/following-sibling::span)[2]")
	WebElement radioButton;
	
	@FindBy(css="div select")
	WebElement dropdown;
	
	@FindBy(id="terms")
	WebElement checkbox;
	
	@FindBy(id="signInBtn")
	WebElement signInButton;
	
	@FindBy(css=".modal-content")
	WebElement popUp;
	
	@FindBy(id="okayBtn")
	WebElement okay;
	
	
	
	
	
	
	
	public void goToURL(String URL)
	{
		
		driver.get(URL);
		driver.manage().deleteAllCookies();
		
		
	}
	
	public productsList login(String user, String pass) throws InterruptedException
	{
		
		userName.sendKeys(user);
		password.sendKeys(pass);
		radioButton.click();
		visibleElement(popUp);
		okay.click();
		
		Thread.sleep(1000);
		visibleElement(dropdown);
		
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Consultant");
		
		checkbox.click();
		signInButton.click();
		return new productsList(driver);
		
		
		
		
	}
	
	
	

}
