package org.udemy.com.rahulshettycourse;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	public static void main(String[] args) {

//		setup.
		System.setProperty("wbedriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");

		driver.findElement(By.xpath("//div[@class = 'example']/a")).click();

//		switch Window handle.
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
			}
		}

		System.out.println(driver.findElement(By.className("example")).getText());
		driver.switchTo().window(parentWindowHandle);
		System.out.println(driver.findElement(By.xpath("//div[@class = 'example']/h3")).getText());

	}
}
