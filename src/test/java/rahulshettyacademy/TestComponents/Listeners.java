package rahulshettyacademy.TestComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners implements ITestListener {

//	ExtentTest test;
	WebDriver driver;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		threadLocal.get().fail(result.getThrowable());

		System.out.println(result.getMethod().getMethodName() + " : FAILED");
//		get driver from result.
//		try {
//			this.driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Screenshot not working.
//		AbstractComponent ac = new AbstractComponent(new BaseTest().getDriver()); // new BaseTest().getDriver()
//		String screenShotPath = new BaseTest().takeScreenShot("Screenshot1");
//		threadLocal.get().addScreenCaptureFromPath(screenShotPath, result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
