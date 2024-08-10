package udemy.rahulshettycourse.fromsection11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//		checkbox.
		driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']")).click();
		String checkBoxText = driver.findElement(By.xpath("//label[@for = 'bmw']")).getText();
		System.out.println(checkBoxText);

//		static Dropdown
		Select staticDropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
		staticDropDown.selectByVisibleText(checkBoxText);

//		alert.
		driver.findElement(By.xpath("//input[ @id = 'name']")).sendKeys(checkBoxText);
		driver.findElement(By.xpath("//input[ @id = 'alertbtn']")).click();
		Assert.assertTrue(driver.switchTo().alert().getText().contains(checkBoxText));
	}
}
