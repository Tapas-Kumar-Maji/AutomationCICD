package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

//		filling the form.
		driver.findElement(By.xpath("//label[contains(text(), 'Name')]/following-sibling::input"))
				.sendKeys("Julia Vega");
		driver.findElement(By.xpath("//label[text() = 'Email']/following-sibling::input"))
				.sendKeys("julia90@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("pass@123");
		driver.findElement(By.id("exampleCheck1")).click();

//		Static dropdown.
		Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dropdown.selectByVisibleText("Male");

		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("03/16/2020");
		driver.findElement(By.xpath("//input[@value = 'Submit']")).click();
		driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.print(driver.findElement(By.xpath("//div/strong/parent::div")).getText());
	}
}
