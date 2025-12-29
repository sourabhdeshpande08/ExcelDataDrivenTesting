package dataDrivenTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalPage extends AbstractClass {

	WebDriver driver;

	public FinalPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "country")
	WebElement country;

	@FindBy(xpath = "//div[@class='suggestions'] //ul/li")
	List<WebElement> countries;
	
	@FindBy(xpath="//label[@for='checkbox2']")
	WebElement checkbox;
	
	@FindBy(css=".btn-success")
	WebElement purchaseBtn;
	
	@FindBy(css=".alert-success")
	WebElement ConfirmationMessage;

	public void destination() throws InterruptedException {
		
		country.click();
		country.sendKeys("in");
		visibleElement(countries);
		
		
		countries.stream().filter(x -> x.getText().equalsIgnoreCase("india")).findFirst().ifPresent(WebElement::click);
		
		
	}
	
	public void purchase() throws InterruptedException
	{
		
		visibleElement(checkbox);
		checkbox.click();
		purchaseBtn.click();
		visibleElement(ConfirmationMessage);
		
		System.out.println(ConfirmationMessage.getText());
		
		
		
		
		
		
	}

}
