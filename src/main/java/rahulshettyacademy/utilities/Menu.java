package rahulshettyacademy.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

	@FindBy(xpath = "//button[@routerlink ='/dashboard/cart']")
	public WebElement cartButton;

	@FindBy(xpath = "//button[@routerlink ='/dashboard/myorders']")
	public WebElement ordersButton;

	public Menu(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void cartPage() {
		this.cartButton.click();
	}

	public void ordersPage() {
		this.ordersButton.click();
	}
}
