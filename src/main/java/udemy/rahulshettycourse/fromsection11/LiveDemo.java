package udemy.rahulshettycourse.fromsection11;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class LiveDemo {
	static WebDriver driver = null;

	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

//		prerequisites.
		driver.findElement(By.xpath("//a[@href = '#/offers']")).click();
		String childWindowHandle = (String) driver.getWindowHandles().stream().toArray()[1];
		driver.switchTo().window(childWindowHandle);
		driver.findElement(By.xpath("//th[contains(@aria-label ,'Veg/fruit')]")).click();

//		check veg names are in sorted order.
		List<String> originalNames = driver.findElements(By.xpath("//td[1]")).stream().map(s -> s.getText())
				.collect(Collectors.toList());
		List<String> sortedNames = originalNames.stream().sorted().collect(Collectors.toList());
//		another way to sort list.  : Collections.sort(originalNames);

		if (sortedNames.equals(originalNames)) {
			System.out.println(originalNames + " :List is sorted");
		} else {
			System.out.println(originalNames + " :List is not sorted");
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(sortedNames.equals(originalNames), "List is not sorted");

//		Getting Price of veg.
		List<String> vegNames = driver.findElements(By.xpath("//td[1]")).stream().map(s -> s.getText())
				.collect(Collectors.toList());
		vegNames.stream().filter(s -> s.equals("Rice")).map(s -> LiveDemo.getPriceOfVeg(s))
				.forEach(s -> System.out.println(s));

//		Pagination
		while (true) {
			List<WebElement> vegList = driver.findElements(By.xpath("//td[1]")).stream()
					.filter(s -> s.getText().equals("Mango")).collect(Collectors.toList());
			if (vegList.size() > 0) {
				System.out.println(
						"Price : " + vegList.get(0).findElement(By.xpath("following-sibling::td[1]")).getText());
				break;
			}

			if (driver.findElement(By.xpath("//a[@aria-label = 'Next']")).getAttribute("aria-disabled")
					.equalsIgnoreCase("true")) {
				break;
			}
			driver.findElement(By.xpath("//a[@aria-label = 'Next']")).click();

		}
	}

//	method to get price of veg.
	static String getPriceOfVeg(String name) {
		return driver.findElement(By.xpath("//*[text() = '" + name + "']/following-sibling::td[1]")).getText();
	}
}
