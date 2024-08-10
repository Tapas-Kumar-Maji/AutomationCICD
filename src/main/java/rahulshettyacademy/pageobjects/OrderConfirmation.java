package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.utilities.AbstractComponent;

public class OrderConfirmation extends AbstractComponent {

	@FindBy(css = ".hero-primary")
	private WebElement confirmationText;

	public OrderConfirmation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isOrderPlaced() {
		super.getStatus().printOrderPlacedStatus();
		return this.confirmationText.getText().trim().equalsIgnoreCase("THANKYOU FOR THE ORDER.");
	}
}
