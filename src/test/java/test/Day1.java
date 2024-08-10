package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {

	@Test
	public void printHello() {
		System.out.println("hello");
	}

	@Parameters({ "URL" })
	@Test(groups = { "smoke" })
	public void printGood(String url) {
		System.out.println("good");
		System.out.println(url);
	}

	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("I am before suite");
	}

	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("I am after suite");
	}
}
