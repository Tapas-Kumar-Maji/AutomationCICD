package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.data.DataReader;

public class BaseTest {
	private WebDriver driver;

	public void openBrowser() {
		Properties property = new Properties();

//		Reading config.properties file
		try {
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\rahulshettyacademy\\resources\\Config.properties");
			property.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		checking the browser eg: Chrome, FireFox
		String browserName = System.getProperty("browser") == null ? property.getProperty("app.browser")
				: System.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver(options);
			this.driver.manage().window().setSize(new Dimension(1440, 900)); // for headless mode fullscreen.

		} else if (browserName.contains("firefox")) {
			this.driver = new FirefoxDriver();

		} else {
			System.out.println(browserName + " browser not found");
			System.exit(1);
		}

		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2L));
		this.driver.get(property.getProperty("app.url"));
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public DataReader getDataReader() {
		return new DataReader();
	}

	/*
	 * String screenShotName = test method name, returns absolute path of
	 * screenshot.png file.
	 */
	public String takeScreenShot(String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) this.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "//reports//" + screenShotName + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			System.out.println(this.getClass().getSimpleName() + " : couldn't copy file");
			e.printStackTrace();
		}
		return destination.getAbsolutePath();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		this.openBrowser();

		// Log In.
		// LandingPage login = new LandingPage(this.driver);
		// login.login("tapasmaji908@gmail.com", "#1Tapasmaji");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws InterruptedException {
//		Thread.sleep(500);
		this.getDriver().quit();
	}

	/*
	 * For every method a new driver is created.
	 */
}
