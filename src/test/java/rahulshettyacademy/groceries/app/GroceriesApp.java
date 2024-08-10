package rahulshettyacademy.groceries.app;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.MyCart;
import rahulshettyacademy.pageobjects.OrderConfirmation;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.PaymentMethod;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class GroceriesApp extends BaseTest {

	@Test(groups = { "Purchase" }, dataProvider = "getData")
	public void orderPlaced(HashMap<String, String> map) throws InterruptedException {

//		Login page.
		LandingPage login = new LandingPage(super.getDriver());
		login.login(map.get("email"), map.get("password"));

//		Product Catalogue page. 
		ProductCatalogue pc = new ProductCatalogue(super.getDriver());
		pc.addToCart(map.get("product"));
		pc.goToCart();

//		MyCart page.
		MyCart cart = new MyCart(super.getDriver());
		Assert.assertTrue(cart.isProductAdded(map.get("product")));
		cart.goToCheckoutPage();

//		Payment Method Page / Checkout page.	
		PaymentMethod pm = new PaymentMethod(super.getDriver());
		pm.setCountry("Ind");
		pm.clickPlaceOrder();

//		Order Confirmation Page.
		OrderConfirmation oc = new OrderConfirmation(super.getDriver());
		Assert.assertTrue(oc.isOrderPlaced());
	}

	@DataProvider
	public Object[][] getData() {
		String jsonFilePath = System.getProperty("user.dir")
				+ "/src/test/java/rahulshettyacademy/data/OrderPlaced.json";
		List<HashMap<String, String>> jsonData = super.getDataReader().getJsonData(jsonFilePath);
		return new Object[][] { { jsonData.get(0) }, { jsonData.get(1) } };
	}

	@Test(dependsOnMethods = { "orderPlaced" }, dataProvider = "getData")
	public void isProductOrdered(HashMap<String, String> map) {

//		Login page.
		LandingPage login = new LandingPage(super.getDriver());
		login.login(map.get("email"), map.get("password"));

//		Orders page.
		OrdersPage op = new OrdersPage(super.getDriver());
		op.goToOrdersPage();
		Assert.assertTrue(op.isProductOrdered(map.get("product")));
		System.out.println(this.getClass().getSimpleName() + " : " + map.get("product") + " is ordered.");
	}

}
