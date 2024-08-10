package org.udemy.com.rahulshettycourse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {
	public static void main(String[] args) throws InterruptedException {

//		setup.
		System.setProperty("webdiver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("//div[@id='select-class-example'] //input[@id='autosuggest']")).sendKeys("Ind");
		Thread.sleep(500);
//		driver.findElement(By.xpath("//li[@class= 'ui-menu-item']/a[text()= 'India']")).click();

		List<WebElement> ls = driver.findElements(By.xpath("//li[@class= 'ui-menu-item']/a"));
		for (WebElement element : ls) {
			if (element.getText().equalsIgnoreCase("India")) {
				element.click();
				break;
			}
		}
	}
}
