package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {

	@Test(groups = { "smoke", "regression" })
	public void WebLoginHomeLoan() {
		System.out.println("Web login home loan"); // Selenium
	}

	@Test
	public void MobileLoginHomeLoan() {
		System.out.println("Mobile login home loan"); // Appium
	}

	@Parameters({ "URL", "APIKEY" })
	@Test
	public void mobileSignIn(String url, String apiKey) {
		System.out.println("Mobile sign in");
		System.out.println(url);
		System.out.println(apiKey);
	}

	@Test(dependsOnMethods = { "MobileLoginHomeLoan", "mobileSignIn" })
	public void mobileSignOut() {
		System.out.println("Mobile sign out");
	}

	@Test(dataProvider = "getData")
	public void RestAPILoginHomeLoan(String userName, String password) {
		System.out.println("Rest API login home loan");
		System.out.println(userName);
		System.out.println(password);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Executes before each method in the class");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Executes after each method in the class");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Executes before every method in class : Day4");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Executes after every method in class : Day4");
	}

	@DataProvider
	public Object[][] getData() {
//		3 combinations, with each containing a key and value.
		Object[][] dataSet = new Object[3][2];
		dataSet[0][0] = "username1";
		dataSet[0][1] = "password1";
		dataSet[1][0] = "username2";
		dataSet[1][1] = "password2";
		dataSet[2][0] = "username3";
		dataSet[2][1] = "password3";
		return dataSet;
	}

}
