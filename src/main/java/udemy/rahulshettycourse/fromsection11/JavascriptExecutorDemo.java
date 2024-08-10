package udemy.rahulshettycourse.fromsection11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class JavascriptExecutorDemo {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//div[@class = 'tableFixHead']")));

//		scrolling inside table webelement.
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
		List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class = 'tableFixHead'] //tbody/tr"));

//		assertion.
		int sum = 0;
		for (int i = 0; i < tableElements.size(); i++) {
			sum += Integer.parseInt(tableElements.get(i).getText().split(" ")[3]);
		}
		System.out.println(sum);
		String actual = driver.findElement(By.xpath("//div[@class = 'totalAmount']")).getText();
		Assert.assertTrue(actual.contains(Integer.toString(sum)), "Incorrect assertion!! not equal");
		
	}
}
