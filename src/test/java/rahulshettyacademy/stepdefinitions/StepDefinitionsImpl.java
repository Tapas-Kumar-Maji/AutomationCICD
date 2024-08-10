package rahulshettyacademy.stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.MyCart;
import rahulshettyacademy.pageobjects.OrderConfirmation;
import rahulshettyacademy.pageobjects.PaymentMethod;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.utilities.AbstractComponent;

public class StepDefinitionsImpl extends BaseTest {

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() {
		super.beforeMethod();
	}

	@Given("^Logged in with (.+) and (.+)$")
	public void Logged_in_with_email_and_password(String email, String password) {
		LandingPage login = new LandingPage(super.getDriver());
		login.login(email, password);
	}

	@When("^I add (.+) to cart$")
	public void I_add_product_to_cart(String product) {
		ProductCatalogue pc = new ProductCatalogue(super.getDriver());
		pc.addToCart(product);
		pc.goToCart();

		MyCart cart = new MyCart(super.getDriver());
		Assert.assertTrue(cart.isProductAdded(product));
		cart.goToCheckoutPage();
	}

	@And("I proceed to checkout and place order")
	public void I_place_order() {
		PaymentMethod pm = new PaymentMethod(super.getDriver());
		pm.setCountry("Ind");
		pm.clickPlaceOrder();
	}

	@Then("Verify {string} is displayed in confirmation page")
	public void verify_order_confirmation(String string) {
		OrderConfirmation oc = new OrderConfirmation(super.getDriver());
		Assert.assertTrue(oc.isOrderPlaced());
	}

	@And("Close the browser")
	public void close_the_browser() throws InterruptedException {
		super.afterMethod();
	}

//	ERROR VALIDATIONS

	// @Given already present

	@When("^I login with (.+) and (.+)$")
	public void I_login_with_email_and_password(String email, String password) {
		LandingPage login = new LandingPage(super.getDriver());
		login.login(email, password);
	}

	@Then("toast message is {string}")
	public void toast_message_is(String string) {
		AbstractComponent ac = new AbstractComponent(super.getDriver());
		String toastMessage = ac.waitUntil_ElementIsVisible(ac.toast, 2L).getText();
		System.out.println(this.getClass().getSimpleName() + ", toast message : " + toastMessage);
		Assert.assertTrue(toastMessage.equals(string));
	}
}
