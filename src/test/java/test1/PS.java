package test1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {

	void car() {
		System.out.println("Hi, I am a car");
	}

	@BeforeMethod
	public void beforeEveryMethod() {
		System.out.println("Before every method");
	}

	@AfterMethod
	public void afterEveryMethod() {
		System.out.println("After every method");
	}
}
