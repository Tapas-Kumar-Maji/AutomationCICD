package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import rahulshettyacademy.utilities.AbstractComponent;

//	Login page.
public class LandingPage extends AbstractComponent {

	@FindBy(id = "userEmail")
	private WebElement email;

	@FindBy(id = "userPassword")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement login;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public void login(String emailId, String password) {
		this.email.sendKeys(emailId);
		this.password.sendKeys(password);
		this.login.click();
//		super.getStatus().printLoginStatus();
	}

}
