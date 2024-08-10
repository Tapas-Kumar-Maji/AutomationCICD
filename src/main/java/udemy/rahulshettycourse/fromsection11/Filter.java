package udemy.rahulshettycourse.fromsection11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Check if filter is working fine.
public class Filter {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

//		Setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		String searchTerm = "g";
		driver.findElement(By.xpath("//input[@id ='search-field']")).sendKeys(searchTerm);

		List<WebElement> entireList = new ArrayList<>();
//		pagination to get entire List
		while (true) {
			entireList.addAll(driver.findElements(By.xpath("//tr/td[1]")));
			if (driver.findElement(By.xpath("//a[@aria-label = 'Next']")).getAttribute("aria-disabled")
					.equals("true")) {
				break;
			}
			driver.findElement(By.xpath("//a[@aria-label = 'Next']")).click();
		}

		List<String> searchListRequired = new ArrayList<>();
		for (int i = 0; i < entireList.size(); i++) {
			if (entireList.get(i).getText().toLowerCase().contains(searchTerm.toLowerCase())) {
				searchListRequired.add(entireList.get(i).getText());
			}
		}
		System.out.println("searchListRequired : " + searchListRequired);

		List<WebElement> searchListActual = new ArrayList<>();
//		pagination
		while (true) {
			List<WebElement> searchedList = driver.findElements(By.xpath("//tr/td[1]"));
			searchListActual.addAll(Filter.getSearchElements(searchedList, searchTerm));

			if (driver.findElement(By.xpath("//a[@aria-label = 'Next']")).getAttribute("aria-disabled")
					.equals("true")) {
				break;
			}
			driver.findElement(By.xpath("//a[@aria-label = 'Next']")).click();
		}

		List<String> searchListActual1 = searchListActual.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println("searchListActual : " + searchListActual1);

		if (searchListRequired.equals(searchListActual1)) {
			System.out.println("Filter is working. Good!!");
		} else {
			System.out.println("Filter is not working");
		}

	}

	static List<WebElement> getSearchElements(List<WebElement> ls, String name) {
		List<WebElement> toReturn = new ArrayList<>();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getText().toLowerCase().contains(name.toLowerCase())) {
				toReturn.add(ls.get(i));
			}
		}

		return toReturn;
	}
}
