package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import rahulshettyacademy.utilities.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class = 'card-body'] //b")
	private List<WebElement> productsNames;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void addToCart(String productName) {
		for (int i = 0; i < this.productsNames.size(); i++) {
			if (this.productsNames.get(i).getText().contains(productName)) {
				this.driver.findElement(By.xpath("(//div[@class = 'card-body'])[" + (i + 1)
						+ "] //button[contains(normalize-space(), 'Add To Cart')]")).click();
				break;
			}
		}
		super.getStatus().printAddedToCartStatus();
	}

	public void goToCart() {
		super.waitUntil_ElementIsClickable(super.getMenu().cartButton, 10L).click();
	}
}
