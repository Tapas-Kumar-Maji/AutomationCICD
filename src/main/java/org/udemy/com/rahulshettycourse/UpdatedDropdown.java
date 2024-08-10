package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {
	public static void main(String[] args) throws InterruptedException {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//		checkbox.
		Assert.assertFalse(
				driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]")).click();
		System.out.println("SeniorCitizen is selected :"
				+ driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]")).isSelected());

//		calendar
		WebElement calendar = driver.findElement(By.xpath("//div[@id='Div1']"));
		System.out.println(calendar.getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(calendar.getAttribute("style"));

		if (calendar.getAttribute("style").contains("1")) {
			System.out.println("Calendar is enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

//		total number of checkboxes in the webpage.
		System.out.println("checkboxes :" + driver.findElements(By.xpath("//input[@type = 'checkbox']")).size());

//		dropdown.
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(500L);
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click(); // Done button
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	}
}
