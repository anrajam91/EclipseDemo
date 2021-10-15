package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookAssignment {
	/*
	 * Assignment:1 FaceBook: ================================ // Step 1: Download
	 * and set the path // Step 2: Launch the chromebrowser // Step 3: Load the URL
	 * https://en-gb.facebook.com/ // Step 4: Maximise the window // Step 5: Add
	 * implicit wait // Step 6: Click on Create New Account button // Step 7: Enter
	 * the first name // Step 8: Enter the last name // Step 9: Enter the mobile
	 * number // Step 10: Enterthe password // Step 11: Handle all the three drop
	 * downs // Step 12: Select the radio button "Female" ( A normal click will do
	 * for this step)
	 */

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Anudeepika");
		driver.findElement(By.name("lastname")).sendKeys("Raja");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input"))
				.sendKeys("abc.gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Abcdefeg@01");

		WebElement selectDay = driver.findElement(By.id("day"));
		Select dd1 = new Select(selectDay);
		dd1.selectByValue("17");

		WebElement selectMon = driver.findElement(By.id("month"));
		Select dd2 = new Select(selectMon);
		dd2.selectByVisibleText("Apr");

		WebElement selectYear = driver.findElement(By.id("year"));
		Select dd3 = new Select(selectYear);
		dd3.selectByValue("1991");

		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
