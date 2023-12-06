package SeleniumQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waits {
	public static void main(String[] args) {

		WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// launch Chrome and redirect it to the URL
		driver.get("https://google.com");

		// This element will appear after 5 secs
		System.out.println("---end wait---");

//		customExplicitWait(driver,locator);

		// close browser
		driver.quit();
	}
	
	 private static WebElement customExplicitWait(WebDriver driver, By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
}
