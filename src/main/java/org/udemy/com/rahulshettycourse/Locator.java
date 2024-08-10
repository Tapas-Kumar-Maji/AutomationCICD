package org.udemy.com.rahulshettycourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		get Title and URL of webpage
		System.out.println("Webpage Title: " + driver.getTitle());
		System.out.println("Webpage URL: " + driver.getCurrentUrl());

//		input wrong username and password, then click Sign In button, then get error text.
		driver.findElement(By.id("inputUsername")).sendKeys("Tapas");
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		driver.findElement(By.className("signInBtn")).click();
		String errorText = driver.findElement(By.cssSelector("p[class='error']")).getText();
		System.out.println("Error :" + errorText);

//		click forgot password,enter details and print rendered text.
		driver.findElement(By.xpath("//a[normalize-space() = 'Forgot your password?']")).click();
		synchronized (driver) {
			driver.wait(200);
		}
		driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Tapas");
		driver.findElement(By.xpath("//input[@type = 'text'][2]")).clear();
		driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("tapas@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9456231781");
		driver.findElement(By.xpath("//button[@class = 'reset-pwd-btn']")).click();
		String text = driver.findElement(By.xpath("//form/p[@class = 'infoMsg']")).getText();
		System.out.println("Text of forgot password page :" + text);
		driver.findElement(By.xpath("//div[@class = 'forgot-pwd-btn-conainer']/button[1]")).click();
		synchronized (driver) {
			driver.wait(400);
		}

//		back in login page, enter details, check boxes and click sign in
		driver.findElement(By.cssSelector("input[id='inputUsername']")).sendKeys("Tapas");
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//span/input[@id='chkboxOne']")).click();
		driver.findElement(By.name("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(normalize-space(), 'Sign')]")).click();
		
	}

}
