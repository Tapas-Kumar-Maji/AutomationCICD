package org.udemy.com.rahulshettycourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {
	public static void main(String[] args) {

//		setup.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tapos\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");

//		swtiching to frame.
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")));
		System.out.println(driver.findElement(By.xpath("//div[@id = 'draggable']")).getText());
		
//		performing action.
		Actions actionObj = new Actions(driver);
		actionObj.dragAndDrop(driver.findElement(By.xpath("//div[@id = 'draggable']")),
				driver.findElement(By.xpath("//div[@id = 'droppable']"))).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//li/a[contains(text(), 'Accept')]")).click();
		
	}
}
