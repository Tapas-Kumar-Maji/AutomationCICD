package udemy.rahulshettycourse.fromsection11;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");

		List<WebElement> linkList = driver.findElements(By.tagName("a"));

//		Soft Assertion.
		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < linkList.size(); i++) {
			String link = linkList.get(i).getAttribute("href");
			softAssert.assertTrue(!BrokenLinks.brokenURL(link), linkList.get(i).getText() + " is very broken");
		}
		softAssert.assertAll();
	}

//	checks if url is broken.
	static boolean brokenURL(String link) {
		try {
			URL url = new URL(link);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("HEAD");
			httpURLConnection.connect();
			int responseCode = 0;
			responseCode = httpURLConnection.getResponseCode();
			System.out.println(responseCode);

			return responseCode >= 400;

		} catch (Exception e) {
			return true;
		}

	}
}
