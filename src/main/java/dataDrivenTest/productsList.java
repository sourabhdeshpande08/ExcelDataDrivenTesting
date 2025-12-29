package dataDrivenTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productsList extends AbstractClass {

	WebDriver driver;

	public productsList(WebDriver driver) {

		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".card")
	List<WebElement> products;

	@FindBy(css = ".btn-primary")
	WebElement checkout;

	public Checkout addProductToCart() {

		
		
		visibleElement(products);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000)");

		products.stream().filter(x -> prods.contains(x.findElement(By.cssSelector("div h4")).getText()))
				.forEach(x -> {

					x.findElement(By.cssSelector("div button")).click();

				});

		js.executeScript("window.scrollBy(0,-1000)");
		checkout.click();
		
		return new Checkout(driver);
		
		

	}

}
