package week5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public ChromeDriver driver;
	public String excelFileName;
	public String sheetName;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void precondition(String url, String username, String pwd) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Leads")));
		driver.findElement(By.linkText("Leads")).click();
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
				return ExcelClassRoom.readData(excelFileName,sheetName);
	}

}
