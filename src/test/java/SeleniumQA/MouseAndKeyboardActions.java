package SeleniumQA;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseAndKeyboardActions {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		actionClass(driver);
//		javaScriptExecutor(driver);

		System.out.println("--Test case ended----");
		// Close the browser
		driver.quit();
	}

	private static void javaScriptExecutor(WebDriver driver) throws InterruptedException {

		WebElement searchBox = driver.findElement(By.name("q"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Mouse Hover using JavaScriptExecutor
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", searchBox);
		jsExecutor.executeScript("arguments[0].style.border='2px solid red';", searchBox);

		// Double Click using JavaScriptExecutor
		jsExecutor.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('dblclick', true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evt);", searchBox);

		// Right Click using JavaScriptExecutor
		jsExecutor.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('contextmenu', true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 2, null);"
				+ "arguments[0].dispatchEvent(evt);", searchBox);

		// Typing into the search box using JavaScriptExecutor
		jsExecutor.executeScript("arguments[0].value='Selenium WebDriver';", searchBox);

		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

	}

	private static void actionClass(WebDriver driver) {

		// Create Actions object
		Actions actions = new Actions(driver);

		// Example of Mouse Hover
		WebElement searchBox = driver.findElement(By.name("q"));
		actions.moveToElement(searchBox).perform();
		// Note: one element to another element
//		actions.moveToElement(xpath1).moveToElement(xpath2).perform();
		// Double Click Example (on the search box)
		actions.doubleClick(searchBox).perform();
		// Right Click Example (on the search box)
		actions.contextClick(searchBox).perform();
		// Example of Keyboard Action (Typing into the search box)
		actions.sendKeys("Selenium WebDriver").perform();

		// Press Enter using Keyboard
		actions.sendKeys(Keys.RETURN).perform();
//		searchBox.sendKeys(Keys.ENTER);
	}

	private static void robotClass(WebDriver driver) throws Exception {
		// Press Enter using Keyboard
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
