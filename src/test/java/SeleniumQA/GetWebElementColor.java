package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetWebElementColor {

	public static void main(String[] args) {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://stackoverflow.com/users/login");
		String buttonColorValue = driver.findElement(By.name("submit-button")).getCssValue("background-color");
		String buttonTextColor = driver.findElement(By.name("submit-button")).getCssValue("color");
		System.out.println("Button color: " + buttonColorValue);
		System.out.println("Text color " + buttonTextColor);
		String buttonColor = Color.fromString(buttonColorValue).asHex();
		String buttonTxtColor = Color.fromString(buttonTextColor).asHex();

		System.out.println(" buttonClr Color value: " + buttonColor);
		System.out.println("buttonClr color value: " + buttonTxtColor);

		driver.quit();
	}
}
