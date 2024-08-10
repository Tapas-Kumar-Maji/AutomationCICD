package rahulshettyacademy.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Status {

	private WebDriverWait explicitWait;
	private WebElement toastMessage;

	public Status(WebDriver driver) {
		this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5L));
		this.toastMessage = driver.findElement(By.id("toast-container"));
	}

	public void printLoginStatus() {
		this.logicOfStatus("Login", "TimeoutException, Login unsuccessful :(");
	}

	public void printAddedToCartStatus() {
		this.logicOfStatus("Cart", "TimeoutException, Item was not added to cart :(");
	}

	public void printOrderPlacedStatus() {
		this.logicOfStatus("Order", "TimeoutException, Order was not placed :(");
	}

	public void printLoginErrorStatus() {
		this.logicOfStatus("Incorrect email or password", "LOGIN ERROR");
	}

	private void logicOfStatus(String textToFindWith, String printOnFailure) {
		try {
			explicitWait.until(ExpectedConditions.textToBePresentInElement(toastMessage, textToFindWith));
			System.out.println("Toast Message : " + toastMessage.getText());
		} catch (TimeoutException e) {
			System.out.println(this.getClass().getSimpleName() + " : " + printOnFailure);
		}
	}
}
