package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeyAlternative {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://stackoverflow.com/users/login");

//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Hiiii");

//		Actions actions = new Actions(driver);
//		actions.sendKeys(driver.findElement(By.xpath("//input[@id='email']")), "your text").perform();

		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('email').value = 'Without sendkkey method';");

		Thread.sleep(10000);
		System.out.println("Test case ended");
		driver.quit();
	}
}
