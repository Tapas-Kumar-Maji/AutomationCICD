package udemy.rahulshettycourse.fromsection11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment9 {
	public static void main(String[] args) throws InterruptedException {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("uni");
		Thread.sleep(2000L);

		driver.findElement(By.xpath("//ul[@id ='ui-id-1'] //div[text() = 'United States (USA)']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id = 'autocomplete']")).getAttribute("value"));
	}
}
