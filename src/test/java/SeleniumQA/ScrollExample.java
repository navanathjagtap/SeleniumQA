package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollExample {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://stackoverflow.com/");
		driver.manage().window().maximize();

		// Create Actions object
		Actions actions = new Actions(driver);

		// Scroll using x and y axis first place x for left to right and second one for
		// up and down so for down positive and for right also positive
		actions.scrollByAmount(575, 2806).perform();
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Take a tour of Teams']"));
		Rectangle rectangle = element.getRect();
		System.out.printf("x: %d, y: %d, width: %d, height: %d\n", rectangle.x, rectangle.y, rectangle.width,
				rectangle.height);
		Thread.sleep(10000);
		scrollByJS(driver, -575, -2806);
		Thread.sleep(10000);
		driver.quit();
	}

	private static void scrollByJS(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
}
