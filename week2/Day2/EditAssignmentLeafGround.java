package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditAssignmentLeafGround {
	/* LeafGround Assignments ------Work with Edit Fields */

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//input[@id='email']/following::input")).sendKeys("Anu");
		driver.findElement(By.xpath("//input[@id='email']/following::input")).sendKeys(Keys.TAB);
		System.out.println("Tab is pressed");
		String attribute = driver
				.findElement(By.xpath("//label[text()='Get default text entered']/following-sibling::input"))
				.getAttribute("value");
		System.out.println("Default text is: " + attribute);
		driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();
		boolean enabled = driver
				.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input"))
				.isEnabled();
		// System.out.println(enabled);
		if (enabled == true) {
			System.out.println("The Edit field is enabled");
		} else {
			System.out.println("The Edit field is disabled");
		}

		// driver.close();
	}
}
