package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DateTimePicker {

	public static void main(String[] args) {

		WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		demoqa(driver);

	}

	private static void demoqa(WebDriver driver) {
		// TODO Auto-generated method stub

		driver.get("http://demo.guru99.com/test/");

		// Find the date time picker control

		WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

		// Fill date as mm/dd/yyyy as 09/25/2013

		dateBox.sendKeys("09252013");

		// Press tab to shift focus to time field

		dateBox.sendKeys(Keys.TAB);

		// Fill time as 02:45 PM

		dateBox.sendKeys("0245PM");
		System.out.println("----end----date---");
		driver.quit();

	}
}