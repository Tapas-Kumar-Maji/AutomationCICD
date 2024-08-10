package org.udemy.com.rahulshettycourse;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	private static WebDriver driver;

	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1L));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5L));

//		add to cart array items.
		String[] vegetables = { "Cucumber", "Brinjal", "Carrot", "Brocolli" };
		Base.addToCart(vegetables);

		driver.findElement(By.cssSelector("a.cart-icon img")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active'] //button")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		org.testng.Assert.assertEquals("Code applied ..!",
				driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	private static void addToCart(String[] vegetables) {
		List<WebElement> vegList = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> vegies = Arrays.asList(vegetables);

		int iteration = 0;
		for (int i = 0; i < vegList.size(); i++) {
			String vegName = vegList.get(i).getText().split(" ")[0];

			if (vegies.contains(vegName)) {
				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
				System.out.println("Added to cart :" + vegName);
				iteration++;
			}

			if (iteration >= vegies.size()) {
				break;
			}
		}
	}
}
