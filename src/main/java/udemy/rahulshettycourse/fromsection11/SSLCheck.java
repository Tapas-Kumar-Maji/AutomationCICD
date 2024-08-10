package udemy.rahulshettycourse.fromsection11;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
	public static void main(String[] args) {

//		setting ChromeOptions to accept/ignore insecure SSL certificates.
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--ignore-certificate-errors");

//		setting proxy.
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("IP address: port");
		options.setCapability("proxy", proxy);

//		setting download directory.
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://expired.badssl.com/");

		System.out.println(driver.getTitle());
	}
}
