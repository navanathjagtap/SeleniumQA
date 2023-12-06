package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	public static void main(String[] args) {
		WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		promptAlert(driver);
		simpleAlert(driver);
		confirmationAlert(driver);
		driver.quit();
	}

	private static void simpleAlert(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		// This step will result in an alert on screen
		driver.findElement(By.id("alertButton")).click();
		org.openqa.selenium.Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();

		System.out.println("-----nnnd");

	}

	private static void promptAlert(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		// This step will result in an alert on screen
		WebElement element = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		org.openqa.selenium.Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		System.out.println("Alert text is " + alertText);
		// Send some text to the alert
		promptAlert.sendKeys("Test User");
		promptAlert.accept();
		System.out.println("-------end------");
	}

	private static void confirmationAlert(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		// This step will result in an alert on the screen
		WebElement element = driver.findElement(By.id("confirmButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

		// Switch to the alert
		org.openqa.selenium.Alert confirmationAlert = driver.switchTo().alert();

		// Get the text of the alert
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);

		// Accept (OK/Yes) the alert
		confirmationAlert.accept();
	}
}
