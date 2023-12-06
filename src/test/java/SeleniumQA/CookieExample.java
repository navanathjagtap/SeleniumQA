package SeleniumQA;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookieExample {
    public static void main(String[] args) {
    	WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

        // Navigate to the Google website
        driver.get("https://www.google.com");

        // Get all cookies and print them
        System.out.println("Cookies before manipulation: " + driver.manage().getCookies());

        // Add a new cookie
        Cookie newCookie = new Cookie("Navanth", "exampleValue");
        driver.manage().addCookie(newCookie);

        // Print the cookies after adding a new one
        System.out.println("Cookies after adding a new cookie: " + driver.manage().getCookies());

        // Delete a specific cookie by name
        driver.manage().deleteCookieNamed("Navanth");

        // Print the cookies after deleting the specific cookie
        System.out.println("Cookies after deleting the specific cookie: " + driver.manage().getCookies());

        // Delete all cookies
        driver.manage().deleteAllCookies();

        // Print the cookies after deleting all cookies
        System.out.println("Cookies after deleting all cookies: " + driver.manage().getCookies());

        // Close the browser
        driver.quit();
    }
}
