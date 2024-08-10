package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		Actions action = new Actions(driver);
//		hovering action.
		action.moveToElement(driver.findElement(By.cssSelector(".nav-line-1-container"))).build().perform();

//		search action.
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("dishwasher accessories").keyDown(Keys.ENTER).build().perform();
	}
}
