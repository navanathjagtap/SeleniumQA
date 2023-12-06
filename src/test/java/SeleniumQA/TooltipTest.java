package SeleniumQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TooltipTest {
	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/");
		getAttributeValue(driver);
//		actionClass(driver);
		driver.quit();
	}

	private static void getAttributeValue(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		String tooltipText = driver.findElement(By.cssSelector("div[id='subtopnav'] a[title='Java Tutorial']"))
				.getAttribute("title");
		System.out.println("Retrieved tooltip text as :" + tooltipText);
	}

	private static void actionClass(WebDriver driver) {
		WebElement toolTipWeb = driver.findElement(By.xpath("//a[normalize-space()='JAVA']"));
		Actions action = new Actions(driver);
		action.moveToElement(toolTipWeb).perform();
		String toolTipTextValue = toolTipWeb.getAttribute("title");
		System.out.println("Retrieved tooltip text as :" + toolTipTextValue);
	}
}