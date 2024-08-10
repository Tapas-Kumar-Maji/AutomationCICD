package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//		checkbox.
		WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
		checkbox1.click();
		Assert.assertTrue(checkbox1.isSelected());
		checkbox1.click();
		Assert.assertFalse(checkbox1.isSelected());

//		count checkboxes
		System.out.println(driver.findElements(By.xpath("//input[@type= 'checkbox']")).size())	;
	}
}
