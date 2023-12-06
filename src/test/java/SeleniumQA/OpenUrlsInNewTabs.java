package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OpenUrlsInNewTabs {
	public static void main(String[] args) throws Exception {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		jsExecutorer(driver); //working fine
//		robotClass(driver);  //Creating new tab
//		actionClass(driver);//opening same 
	}

	private static void actionClass(WebDriver driver) throws Exception {
		driver.get("https://google.com/");
		// TODO Auto-generated method stub
		Actions actions = new Actions(driver);
		// Simulate opening a new tab (Ctrl + t)
		actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
		Thread.sleep(10000);
		// Switch to the new tab
		actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();

		// Navigate to the URL in the new tab
		driver.get("https://www.wikipedia.org/");

	}

	private static void robotClass(WebDriver driver) throws Exception {
		driver.get("https://google.com/");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		driver.get("https://www.wikipedia.org/");

		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wndHandle = new ArrayList<>(windowHandles);
		String stackOver = wndHandle.get(1);
		System.out.println("stackOver=----> " + stackOver);
		driver.switchTo().window(stackOver);

		System.out.println("windowHandles---->  " + windowHandles);
		// Close the original tab (optional)
		Thread.sleep(10000);
		driver.quit();
	}

	private static void jsExecutorer(WebDriver driver) throws Exception {
//		 List of URLs to open
		List<String> urls = new ArrayList<>();
		urls.add("https://google.com/");
		urls.add("https://stackoverflow.com/");
		urls.add("https://example3.com/");
		urls.add("https://www.wikipedia.org/");
		urls.add("https://google.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Open each URL in a new tab
		for (String url : urls) {
			js.executeScript("window.open('" + url + "','_blank');");
		}

		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wndHandle = new ArrayList<>(windowHandles);
		String stackOver = wndHandle.get(2);
		System.out.println("stackOver=----> " + stackOver);
		driver.switchTo().window(stackOver);

		System.out.println("windowHandles---->  " + windowHandles);
		// Close the original tab (optional)
		Thread.sleep(10000);
		driver.quit();
	}
}
