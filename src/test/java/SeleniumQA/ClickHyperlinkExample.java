package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickHyperlinkExample {

    public static void main(String[] args) {
    	WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

        // Open the Google homepage
        driver.get("https://www.google.com");

        // Find the hyperlink by its link text
        WebElement hyperlink = driver.findElement(By.linkText("Gmail"));

        // Click on the hyperlink
        hyperlink.click();

        // Wait for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
System.out.println("test ende----------");
        // Close the browser window
        driver.quit();
    }
}
