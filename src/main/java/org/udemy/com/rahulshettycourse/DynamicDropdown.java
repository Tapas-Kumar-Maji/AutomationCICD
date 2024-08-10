package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
	public static void main(String[] args) throws InterruptedException {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//		dropdown.
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(500);
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By
				.xpath("//div[@id= 'ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(text(), 'Chennai')]"))
				.click();

//		current date in calendar
		driver.findElement(By.className("ui-state-highlight")).click();
	}
}
