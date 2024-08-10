package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "rahulshettyacademy.stepdefinitions", tags = "@Regression", plugin = {
		"html:reports/cucumberReport.html" }) // monochrome = true
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
