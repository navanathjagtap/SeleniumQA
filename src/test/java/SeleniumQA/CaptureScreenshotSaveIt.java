package SeleniumQA;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshotSaveIt {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		// Capture screenshot dynamic and save it to a file
//		File screenshotFile = new File("src/test/resources/ScreenShot", "screenshot_" + System.currentTimeMillis() + ".png");
//		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), screenshotFile);

		// Capture screenshot and save it to a file
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("src/test/resources/ScreenShot/screensho.png"));

		// Get the current window size (for verification)

		Thread.sleep(5000);
		driver.quit();
		System.out.println("----Closed browser-----");
	}
}
