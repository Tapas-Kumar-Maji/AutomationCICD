package udemy.rahulshettycourse.fromsection11;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCalendar {
	public static void main(String[] args) throws InterruptedException {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

//		given
		String month = "6";
		String date = "15";
		String year = "2027";
		String[] dateGiven = { month, date, year };

//		swtiching window handle.
		driver.findElement(By.xpath("//a[@class = 'cart-header-navlink'][1]")).click();
		Iterator<String> itr = driver.getWindowHandles().iterator();
		itr.next();
		driver.switchTo().window(itr.next());

		driver.findElement(By.cssSelector("button.react-date-picker__button:nth-child(3) svg ")).click();
		driver.findElement(By.xpath("//button[@class = 'react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[@class = 'react-calendar__navigation__label']")).click();

//		Entering year, month, date
		driver.findElement(By.xpath("//button[contains(text() ,'" + year + "')]")).click();
		driver.findElements(
				By.xpath("//button[@class = 'react-calendar__tile react-calendar__year-view__months__month']"))
				.get(Integer.valueOf(month) - 1).click();
		driver.findElement(By.xpath("//abbr[text() = '" + date + "']")).click();

//		Assertion with TestNG.
		List<WebElement> calendarList = driver
				.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));
		for (int i = 0; i < calendarList.size(); i++) {
			Assert.assertEquals(dateGiven[i], calendarList.get(i).getAttribute("value"));
		}

	}
}
