package org.udemy.com.rahulshettycourse;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");

		driver.navigate().to("https://rahulshettyacademy.com/");
		driver.navigate().back();
		driver.navigate().forward();
	}

}
