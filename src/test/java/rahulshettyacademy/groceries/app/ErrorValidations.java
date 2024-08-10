package rahulshettyacademy.groceries.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.MyCart;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.utilities.AbstractComponent;

public class ErrorValidations extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(retryAnalyzer = Retry.class)
	public void loginErrorValidation() {

		// Login page.
		LandingPage login = new LandingPage(super.getDriver());
		login.login("tapasmaj@gmail.com", "#1Tapasmaji");

		AbstractComponent ac = new AbstractComponent(super.getDriver());
		String toastMessage = ac.waitUntil_ElementIsVisible(ac.toast, 2L).getText();
		System.out.println(this.getClass().getSimpleName() + ", toast message : " + toastMessage);
		Assert.assertTrue(toastMessage.equals("Incorrect email or password."));
	}

	@Test
	public void productAddedToCartValidation() {
		// Login page.
		LandingPage login = new LandingPage(super.getDriver());
		login.login("tapasmaji908@gmail.com", "#1Tapasmaji");

		// Product Catalogue page.
		ProductCatalogue pc = new ProductCatalogue(super.getDriver());
		pc.addToCart(productName);
		pc.goToCart();

		// MyCart page.
		MyCart cart = new MyCart(super.getDriver());
		Assert.assertTrue(cart.isProductAdded(productName));
		cart.goToCheckoutPage();
	}
}
