package rahulshettyacademy.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	private WebDriver driver;

	@FindBy(id = "toast-container")
	public WebElement toast;

	@FindBy(xpath = "//div[contains(@class, 'ngx-spinner-overlay')]")
	public WebElement overlay;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement waitUntil_ElementIsClickable(WebElement element, long seconds) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitUntil_ElementIsVisible(WebElement element, long seconds) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

//	/*
//	 * String screenShotName = test method name, returns absolute path of
//	 * screenshot.png file.
//	 */
//	public String takeScreenShot(String screenShotName) {
//		TakesScreenshot ts = (TakesScreenshot) this.driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File destination = new File(System.getProperty("user.dir") + "//reports//" + screenShotName + ".png");
//		try {
//			FileUtils.copyFile(source, destination);
//		} catch (IOException e) {
//			System.out.println(this.getClass().getSimpleName() + " : couldn't copy file");
//			e.printStackTrace();
//		}
//		return destination.getAbsolutePath();
//	}

	public Menu getMenu() {
		return new Menu(this.driver);
	}

	public Status getStatus() {
		return new Status(this.driver);
	}
}
