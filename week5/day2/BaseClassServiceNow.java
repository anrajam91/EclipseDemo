package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {
	public ChromeDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	@Parameters({ "url", "username", "password" })
	public void preCondition(String url, String username, String pwd) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("filter")));
		driver.findElement(By.id("filter")).sendKeys("incident" + Keys.ENTER);
	}

	@AfterMethod
	public void postCondition() throws IOException {
	//	driver.quit();
	}
}
