package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.utilities.AbstractComponent;

public class PaymentMethod extends AbstractComponent {

	private WebDriver driver;

	@FindBy(xpath = "//section[contains(@class ,'ta-results')] //button[2]")
	private WebElement byCountry;

	@FindBy(xpath = "//div[@class='form-group']/input")
	private WebElement countryField;

	@FindBy(xpath = "//a[contains(text(), 'Order')]")
	private WebElement submitBtn;

	public PaymentMethod(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setCountry(String countryName) {
		this.countryField.sendKeys(countryName);
		super.waitUntil_ElementIsVisible(byCountry, 0).click();
	}

	public void clickPlaceOrder() {
		Actions action = new Actions(this.driver);
		action.scrollToElement(this.submitBtn).moveToElement(this.submitBtn, 0, -10).click().build().perform();
	}

}
