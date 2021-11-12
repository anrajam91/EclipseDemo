package week5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {
	@BeforeTest(groups= {"functional"})
	public void setValue() {
		// TODO Auto-generated method stub
		excelFileName = "LeadTestData";
		sheetName = "Sheet1";
	}

	@Test(dataProvider = "getData", groups= {"functional"}, priority=0)
	public void runCreateLead(String comp, String name, String lastname, String num) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(comp);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(name);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(num);
		driver.findElement(By.name("submitButton")).click();
	}

}
