package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/frames");
		// Switch to Frame using Index and name
//		driver.switchTo().frame(0);
		driver.switchTo().frame("frame1");
		Thread.sleep(3000);
		WebElement frame1Heading = driver.findElement(By.id("sampleHeading"));

		String frame1Text = frame1Heading.getText();

		System.out.println(frame1Text);

		// closing the driver
		driver.quit();
	}
}