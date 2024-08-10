package org.udemy.com.rahulshettycourse;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
	public static void main(String[] args) {

//		setup.
		System.setProperty("wbedriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		driver.findElement(By.xpath("//a[@target = '_blank' and @class= 'blinkingText']")).click();

//		Window Handles (switching focus).
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
			}
		}

		String emailId = driver.findElement(By.cssSelector("p.im-para.red a")).getText();
		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.cssSelector("input#username")).sendKeys(emailId);
	}
}
