package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.utilities.AbstractComponent;

public class MyCart extends AbstractComponent {

	@FindBy(xpath = "//div[@class = 'cart']/ul //h3")
	public List<WebElement> cartProducts;

	@FindBy(xpath = "//li[@class = 'totalRow']/button")
	private WebElement checkout;

	public MyCart(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isProductAdded(String productName) {
		return this.cartProducts.stream().anyMatch(p -> p.getText().contains(productName));
	}

	public void goToCheckoutPage() {
		this.checkout.click();
	}
}
