package SeleniumQA;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendWindowSize {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;

		// Set desired window size
		int width = 800;
		int height = 600;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		// Create Dimension object with desired width and height
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);

		// Get the current window size (for verification)
		Dimension currentSize = driver.manage().window().getSize();
		System.out.println(
				"Current window size: width = " + currentSize.getWidth() + ", height = " + currentSize.getHeight());

		Thread.sleep(5000);
		driver.quit();
		System.out.println("----Closed browser-----");
	}
}
