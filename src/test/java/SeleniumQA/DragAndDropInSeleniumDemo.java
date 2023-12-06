package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropInSeleniumDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://demoqa.com/droppable/";

		driver.get(URL);

		// It is always advisable to Maximize the window before performing DragNDrop
		// action
		driver.manage().window().maximize();

		// Actions class method to drag and drop
		Actions action = new Actions(driver);

		WebElement from = driver.findElement(By.id("draggable"));

		WebElement to = driver.findElement(By.id("droppable"));
		// Perform drag and drop
		action.dragAndDrop(from, to).perform();

		// verify text changed in to 'Drop here' box
		String textTo = to.getText();

		if (textTo.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		} else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}

		driver.quit();
		;

	}

}