package hw14;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_click_method {

	WebDriver driver;

	@BeforeTest

	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "./driver1/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver1/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		

		driver.get("https://www.facebook.com/");
//		driver.navigate().to("https://www.facebook.com");

	}

	@Test(enabled=false, priority=1)
	public void loginInfo() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xyz@yahoo.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abcdefr");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		Thread.sleep(5000);
	}
	
	@Test(enabled=true, priority=2)
	public void amazonPage() {
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.linkText("Best Sellers")).click();
		
	}

	@AfterTest

	public void tearUp() {

//		driver.quit();

	}

}
