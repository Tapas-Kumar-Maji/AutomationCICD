package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import rahulshettyacademy.utilities.AbstractComponent;

public class OrdersPage extends AbstractComponent {

	@FindBy(xpath = "//tbody/tr/td[2]")
	private List<WebElement> allProductNames;

	public OrdersPage(WebDriver driver) {
		super(driver);
	}

	public void goToOrdersPage() {
		super.getMenu().ordersPage();
	}

	public boolean isProductOrdered(String productName) {
		return this.allProductNames.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
	}
}
