package SeleniumQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NonHeadlessBrowserExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        runChromeBrowser();

        WebDriverManager.firefoxdriver().setup();
        runFirefoxBrowser();
        
        WebDriverManager.edgedriver().setup();
        runEdgeBrowser();
    }

    private static void runChromeBrowser() {
        // Initialize ChromeDriver without headless mode
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.google.com");
        String chromePageTitle = chromeDriver.getTitle();
        System.out.println("Chrome - Page Title: " + chromePageTitle);

        chromeDriver.quit();
    }

    private static void runFirefoxBrowser() {
        // Initialize FirefoxDriver without headless mode
        WebDriver firefoxDriver = new FirefoxDriver();

        firefoxDriver.get("https://www.google.com");
        String firefoxPageTitle = firefoxDriver.getTitle();
        System.out.println("Firefox - Page Title: " + firefoxPageTitle);

        firefoxDriver.quit();
    }
    
    private static void runEdgeBrowser() {
        // Initialize EdgeDriver
        WebDriver edgeDriver = new EdgeDriver();

        edgeDriver.get("https://www.google.com");
        String edgePageTitle = edgeDriver.getTitle();
        System.out.println("Edge Browser - Page Title: " + edgePageTitle);

        edgeDriver.quit();
    }
}
