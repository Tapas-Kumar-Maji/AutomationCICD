package udemy.rahulshettycourse.fromsection11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//print no of rows, columns ,entire 2nd row of table.
public class Assignment8 {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//		scroll into view.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//table[@class = 'table-display']")));

//		rows, col, 2nd row.
		System.out.println("Rows :" + driver.findElements(By.xpath("//table[@class = 'table-display'] //tr")).size());
		System.out.println(
				"Columns :" + driver.findElements(By.xpath("//table[@class = 'table-display'] //tr/th")).size());
		List<WebElement> secondRowList = driver.findElements(By.xpath("//table[@class = 'table-display'] //tr[3]/td"));
		for(int i=0; i< secondRowList.size(); i++) {
			System.out.println(secondRowList.get(i).getText());
		}
	}
}
