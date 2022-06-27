package seleniumMeths;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_get_method1 {

	WebDriver driver;

	@BeforeTest

	public void openBrowser() {

//		System.setProperty("webdriver.chrome.driver", "./driver1/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver1/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.facebook.com/");

	}

	@Test
	public void loginInfo() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xyz@yahoo.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abcdefr");
		Thread.sleep(5000);
	}

	@AfterTest

	public void tearUp() {

		driver.quit();

	}
}
