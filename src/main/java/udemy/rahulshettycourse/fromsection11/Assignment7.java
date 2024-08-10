package udemy.rahulshettycourse.fromsection11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//		JS object to scroll.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//table[@class = 'table-display']")));
		List<WebElement> priceList = driver.findElements(By.xpath("//table[@class = 'table-display'] //td[3]"));
		int sum = 0;
		for (int i = 0; i < priceList.size(); i++) {
			sum += Integer.parseInt(priceList.get(i).getText());
		}
		System.out.println("Sum of all prices :" + sum);
	}
}
