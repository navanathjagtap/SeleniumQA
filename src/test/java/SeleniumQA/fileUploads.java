package SeleniumQA;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fileUploads {
	public static void main(String[] args) throws Exception {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		fileUploadUsingSendKey(driver);
		UploadFileUsingAutoIT(driver);
		driver.quit();
	}

	private static void UploadFileUsingAutoIT(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub

		driver.get("https://resume.naukri.com/resume-quality-score?fftid=101003");

		driver.findElement(By.xpath("//span[@class='browse']")).click();

		Thread.sleep(5000);

		Runtime.getRuntime().exec("C:\\Users\\Pravin Patil\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		System.out.println("-----end----file");
	}

	private static void fileUploadUsingSendKey(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(
				"C:\\Users\\Pravin Patil\\eclipse-workspace\\SeleniumQ&A\\src\\test\\resources\\ScreenShot\\screensho.png");
		System.out.println("----00---");
		driver.findElement(By.xpath("//span[text()='Start upload']")).click();
		System.out.println("---end---");

	}

}
