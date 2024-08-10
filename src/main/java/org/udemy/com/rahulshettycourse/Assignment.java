package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//		alerts.
		driver.findElement(By.id("name")).sendKeys("Tapas");
		driver.findElement(By.cssSelector("#alertbtn.btn-style")).click();

		Alert alertObj = driver.switchTo().alert();
		System.out.println(alertObj.getText());
		alertObj.accept();

		driver.findElement(By.id("confirmbtn")).click();
		alertObj = driver.switchTo().alert();
		System.out.println(alertObj.getText());
		alertObj.dismiss();

	}
}
