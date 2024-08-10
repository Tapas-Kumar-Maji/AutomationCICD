package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {
	public static void main(String[] args) throws InterruptedException {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//		dropdown.
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(500);
		driver.findElement(By
				.xpath("//div[@id= 'ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(text(), 'Chennai')]"))
				.click();

//		current date in calendar
		driver.findElement(By.className("ui-state-highlight")).click();

//		calendar assertion.
		WebElement calendar = driver.findElement(By.xpath("//div[@id='Div1']"));
		if (calendar.getAttribute("style").contains("0.5")) {
			System.out.println("Return date calendar is disabled");
			org.testng.Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

//		checkbox.
		driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]")).click();

//		passengers dropdown.
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(500L);
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click(); // Done button
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

//		currency dropdown.
		Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		dropdown.selectByVisibleText("USD");

		driver.findElement(By.xpath("//div[@id= 'Div6'] //input[@type='submit']")).click();
	}
}
