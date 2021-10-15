package week2.Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceAssignment {
	/*
	 * Assignment:2 ================================================== SalesForce:
	 * // Step 1: Download and set the path // Step 2: Launch the chromebrowser //
	 * Step 3: Load the URL
	 * https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk
	 * // Step 4: Maximise the window // Step 5: Add implicit wait // Step 6: Fill
	 * in all the text boxes // Step 7: Handle all the dropdowns // Step 8: Click
	 * the check box // Step 9: Close the browser Note: No need click Start my
	 * freeTrial
	 */

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("UserFirstName")).sendKeys("Anudeepika");
		driver.findElement(By.name("UserLastName")).sendKeys("Raja");
		driver.findElement(By.name("UserEmail")).sendKeys("anu@gmail.com");
		driver.findElement(By.name("CompanyName")).sendKeys("TestLeaf");
		driver.findElement(By.name("UserPhone")).sendKeys("1234567890");

		WebElement selectJob = driver.findElement(By.name("UserTitle"));
		Select dd1 = new Select(selectJob);
		dd1.selectByVisibleText("Developer / Software Engineer / Analyst");

		WebElement selectEmp = driver.findElement(By.name("CompanyEmployees"));
		Select dd2 = new Select(selectEmp);

		List<WebElement> options = dd2.getOptions();
		int length = options.size();
		dd2.selectByIndex(length - 1);

		WebElement selectComp = driver.findElement(By.name("CompanyCountry"));
		Select dd3 = new Select(selectComp);
		dd3.selectByValue("AU");

		driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div")).click();
		driver.quit();

	}
}