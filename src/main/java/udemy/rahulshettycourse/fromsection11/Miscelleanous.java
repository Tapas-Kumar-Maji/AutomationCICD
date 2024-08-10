package udemy.rahulshettycourse.fromsection11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {
	public static void main(String[] args) throws IOException {

//		setup.
		System.setProperty("wbedriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");

//		driver.manage().deleteCookieNamed("cookieName");   deletes specific cookie.
//		driver.manage().getCookies()	gets all cookies.

//		taking a screenshot.
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//		using users home directory to avoid permission issues.
		String userHome = System.getProperty("user.home");
		File destinationFile = new File(userHome, "screenshot.png"); // file to be copied to.
		FileUtils.copyFile(screenShot, destinationFile);
		
		System.out.println("File saved to :"+ destinationFile.getAbsolutePath());
	}
}
