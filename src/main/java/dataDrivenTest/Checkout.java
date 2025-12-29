package dataDrivenTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Checkout extends AbstractClass{
	
	WebDriver driver;
	
	
	public Checkout(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//table/thead/tr/th")
	List<WebElement> tableHeader;
	
	@FindBy(xpath="//table/tbody/tr/td/div/div/h4/a")
	List<WebElement> prodNames;
	
	@FindBy(css="[class*='btn-success']")
	WebElement checkoutBtn;
	
	public FinalPage checkProds()
	{
		
		visibleElement(tableHeader);
		boolean match = prodNames.stream().anyMatch(x -> prods.contains(x.getText()));
		Assert.assertTrue(match);
		
		checkoutBtn.click();
		return new FinalPage(driver);
		
	}
	

}
