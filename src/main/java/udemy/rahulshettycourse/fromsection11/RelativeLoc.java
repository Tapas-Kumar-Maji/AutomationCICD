package udemy.rahulshettycourse.fromsection11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLoc {
	public static void main(String[] args) throws InterruptedException {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

//		finding element with relative locator.
		WebElement nameTextBox = driver.findElement(By.xpath("//input[@name ='name']"));
		String text = driver.findElement(RelativeLocator.with(By.xpath("//label")).above(nameTextBox)).getText();
		System.out.println(text);

//		WebElement labelBirthDate = driver.findElement(By.xpath("//label[@for ='dateofBirth']"));
//		This find submit button instead of date
//		driver.findElement(RelativeLocator.with(By.xpath("input")).below(labelBirthDate)).click();

//		checkbox
		WebElement labelCheckbox = driver.findElement(By.xpath("//label[@for= 'exampleCheck1']"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(labelCheckbox)).click();

//		radio button.
		WebElement radioButton = driver.findElement(By.cssSelector("input#inlineRadio1"));
		String radioBtnText = driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(radioButton))
				.getText();
		System.out.println(radioBtnText);
	}
}
