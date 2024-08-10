package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator3 {
	public static void main(String[] args) {

//		setting up
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//		traversing from sibling to sibling webelement.
		String loginText = driver
				.findElement(By.xpath(
						"//header/div/button[contains(normalize-space(), 'Practice')]/following-sibling::button[1]"))
				.getText();
		System.out.println(loginText);

//		traversing from child to parent webelement.
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}
}
