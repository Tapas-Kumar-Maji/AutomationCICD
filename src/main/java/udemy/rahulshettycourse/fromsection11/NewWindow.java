package udemy.rahulshettycourse.fromsection11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {
	public static void main(String[] args) throws IOException {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String parentWindowHandle = driver.getWindowHandle();

//		child window operations.
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/");
		String text = driver
				.findElement(By.xpath("//div[@class = 'courses-block col-lg-3 col-md-4 col-sm-6 col-xs-12'][1] //h2/a"))
				.getText();
		System.out.println(text);
		driver.close();

//		back to parent window.
		driver.switchTo().window(parentWindowHandle);
		WebElement name = driver.findElement(By.xpath("//div[@class= 'form-group'] //input[@name = 'name']"));
		name.sendKeys(text);

//		web element screebshot.
		File tempFile = name.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("screenshot.png");
		FileUtils.copyFile(tempFile, destinationFile);
		System.out.println(destinationFile.getAbsolutePath());

//		get height and width of webelement.
		System.out.println("Height :" + name.getRect().getDimension().getHeight());
		System.out.println("Width :" + name.getRect().getDimension().getWidth());
	}
}
