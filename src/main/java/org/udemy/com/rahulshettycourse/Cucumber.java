package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cucumber {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.findElement(
				By.xpath("//*[contains(text(), 'Cucumber')]/following-sibling::*[@class= 'product-action']/child::*"))
				.click();
		
	}
}
