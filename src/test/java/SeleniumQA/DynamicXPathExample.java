package SeleniumQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXPathExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        // Dynamic part of the ID (you can get this from your application logic or data)
        String dynamicId = "123";

        // Build dynamic XPath using string concatenation
        String dynamicXpath = "//button[@id='dynamicButton_" + dynamicId + "']";
        
        System.out.println("dynamicXpath --- > "+dynamicXpath);

        driver.quit();
    }
}
