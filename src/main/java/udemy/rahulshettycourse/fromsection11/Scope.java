package udemy.rahulshettycourse.fromsection11;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
	public static void main(String[] args) throws InterruptedException {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println("total nunber of links in webpage:" + driver.findElements(By.xpath("//a")).size());
		System.out.println("links in fotter :" + driver.findElements(By.xpath("//div[@id = 'gf-BIG'] //a")).size());

//		limiting driver scope.
		WebElement footer = driver.findElement(By.cssSelector("div#gf-BIG"));
		System.out.println("Footer links :" + footer.findElements(By.tagName("a")).size());

//		cannot understand this.(wrong result)
//		WebElement td = footer.findElement(By.xpath("//td[1]/ul"));
//		System.out.println("1st section of footer links :"+ td.findElements(By.xpath("//a")).size());

//		right result.
		System.out.println("1st section of footer links :" + footer.findElements(By.xpath("//td[1] //a")).size());

//		click on all the above links and check if the pages are opening.
		List<WebElement> footerFirstSectionLinks = footer.findElements(By.xpath("//td[1] //a"));

		for (WebElement element : footerFirstSectionLinks) {
			String ctrEnter = Keys.chord(Keys.CONTROL, Keys.ENTER);
			element.sendKeys(ctrEnter);
		}

//		print the Title of every webpage.
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {

			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				System.out.println("Title :" + driver.getTitle());
			}
		}
	}

}
