package SeleniumQA;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RefreshExample {
	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://stackoverflow.com/");
		driver.manage().window().maximize();

		// Method 1: Using WebDriver's navigate().refresh()
		driver.navigate().refresh();
		Thread.sleep(10000);
		// Method 2: Using JavascriptExecutor to refresh
		((JavascriptExecutor) driver).executeScript("location.reload(true);");
		Thread.sleep(10000);
		// Method 3: Using SendKeys to action class pressing F5 key
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.F5).build().perform();
		Thread.sleep(10000);
		System.out.println("--end test ---");
		driver.quit();
	}
}
