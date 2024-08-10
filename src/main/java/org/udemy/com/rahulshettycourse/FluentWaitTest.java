package org.udemy.com.rahulshettycourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);

		driver.findElement(By.cssSelector("div#start button")).click();
		String text = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish")))
				.getText();
		System.out.println(text);
	}

}
