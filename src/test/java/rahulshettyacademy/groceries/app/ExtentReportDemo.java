package rahulshettyacademy.groceries.app;

import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;

public class ExtentReportDemo extends BaseTest {

	@Test
	public void initialDemo() {
		System.out.println(super.getDriver().getTitle());
	}
}
