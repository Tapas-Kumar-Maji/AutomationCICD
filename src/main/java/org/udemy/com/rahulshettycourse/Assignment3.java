package org.udemy.com.rahulshettycourse;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {
	public static void main(String[] args) throws InterruptedException {

//		Will only use explicit wait.
//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5L));

//		login.
		String userName = driver.findElement(By.xpath("(//p[@class= 'text-center text-white'] //i)[1]")).getText()
				.trim();
		String password = driver.findElement(By.xpath("(//p[@class= 'text-center text-white'] //i)[2]")).getText()
				.trim();
		driver.findElement(By.cssSelector("#username.form-control")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[contains(text(), 'User')]/following-sibling::span")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))).click();

		Select staticDropDown = new Select(driver.findElement(By.cssSelector("select.form-control")));
		staticDropDown.selectByValue("consult");

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card.h-100")));

//		alert may/may not be present.
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.out.println("No alert there!");
		}

		List<WebElement> productList = driver.findElements(By.cssSelector(".card.h-100"));
		for (int i = 1; i <= productList.size(); i++) {
			driver.findElement(By.xpath("(//div[@class = 'card h-100'] //button)[" + i + "]")).click();
		}

		driver.findElement(By.cssSelector("li.nav-item.active")).click();
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
//		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox2")));
		driver.findElement(By.id("country")).sendKeys("Durgapur", Keys.TAB); 	//, 
//		driver.findElement(By.id("checkbox2")).click();
//		Keys.SPACE;
		driver.findElement(By.cssSelector("input.btn.btn-success.btn-lg")).click();
		System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());

	}
}
