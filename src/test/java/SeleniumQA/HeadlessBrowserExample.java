package SeleniumQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowserExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        chromeBrowserHeadless();

        WebDriverManager.firefoxdriver().setup();
        firefoxBrowserHeadless();
        
//        WebDriverManager.edgedriver().setup();
//        edgeBrowserHeadless();//not supported
    }
    
 
    private static void chromeBrowserHeadless() {
        // Create ChromeOptions and enable headless mode
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless"); // Enable headless mode
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);

        chromeDriver.get("https://www.google.com");
        String chromePageTitle = chromeDriver.getTitle();
        System.out.println("Chrome Headless Mode - Page Title: " + chromePageTitle);

        chromeDriver.quit();
    }

    private static void firefoxBrowserHeadless() {
        // Create FirefoxOptions and enable headless mode
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless"); // Enable headless mode
        WebDriver firefoxDriver = new FirefoxDriver(firefoxOptions);

        firefoxDriver.get("https://www.google.com");
        String firefoxPageTitle = firefoxDriver.getTitle();
        System.out.println("Firefox Headless Mode - Page Title: " + firefoxPageTitle);

        firefoxDriver.quit();
    }
}
