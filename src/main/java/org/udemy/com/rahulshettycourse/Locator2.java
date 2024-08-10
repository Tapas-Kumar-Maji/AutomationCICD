package org.udemy.com.rahulshettycourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locator2 {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		String password = Locator2.password(driver);

//		Log in with correct password.
		synchronized (driver) {
			driver.wait(200);
		}
		String myName = "Winston";
		driver.findElement(By.cssSelector("input[id='inputUsername']")).sendKeys("Tapas");
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//span/input[@id='chkboxOne']")).click();
		driver.findElement(By.name("chkboxTwo")).click();
//		driver.findElement(By.xpath("//button[contains(normalize-space(), 'Sign')]")).click();
		synchronized (driver) {
			driver.wait(200);
		}
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(),
				"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),
				"Hello " + myName + ",");
		driver.findElement(By.xpath("//button[contains(normalize-space(), 'Log Out')]")).click();
//		driver.close();
	}

	public static String password(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("inputUsername")).sendKeys("Tapas");
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		driver.findElement(By.className("signInBtn")).click();
		driver.findElement(By.xpath("//a[normalize-space() = 'Forgot your password?']")).click();
		synchronized (driver) {
			driver.wait(300);
		}

		driver.findElement(By.xpath("//button[@class = 'reset-pwd-btn']")).click();
		String password = driver.findElement(By.xpath("//form/p[@class = 'infoMsg']")).getText();
		System.out.println(password.split("'")[1]);
		driver.findElement(By.xpath("//button[contains(normalize-space(), 'Go to Login')]")).click();
		return password.split("'")[1];
	}
}
