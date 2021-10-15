package week2.Day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxLeafGround {
	/* LeafGround Assignments ------Interact with Checkboxes */

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[text()='Java']/input")).click();
		driver.findElement(By.xpath("//div[text()='VB']/input")).click();
		driver.findElement(By.xpath("//div[text()='C']/input")).click();

		if (driver.findElement(By.xpath("//div[text()='Selenium']/input")).isSelected()) {
			System.out.println(driver.findElement(By.xpath("//div[text()='Selenium']")).getText()
					+ " check box is already checked");
		} else {
			System.out.println(
					driver.findElement(By.xpath("//div[text()='Selenium']")).getText() + " check box is NOT checked");
		}

		if (driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[1]"))
				.isSelected()) {

			driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[1]")).click();
		}

		else if (driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]"))
				.isSelected()) {

			driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();
		} else {
			System.out.println("All the options are unchecked");
		}

		driver.findElement(By.xpath("//div[text()='Option 1']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 2']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 3']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 4']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 5']/input")).click();
	}

}
