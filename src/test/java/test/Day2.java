package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	@Test(groups = { "smoke" })
	public void printBye() {
		System.out.println("bye");
	}

	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("Before Test Executions");
	}

	@AfterTest
	public void afterTestMethod() {
		System.out.println("After Test Executions");
	}
}
