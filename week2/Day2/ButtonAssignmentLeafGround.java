package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonAssignmentLeafGround {
	/* LeafGround Assignments ------Bond with Buttons */

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("Position: " + location);
		String cssValue = driver.findElement(By.xpath("//label[text()='Find button color']/following-sibling::button"))
				.getCssValue("color");
		System.out.println("Color is: " + cssValue);
		Dimension size = driver
				.findElement(By.xpath("//label[text()='Find the height and width']/following-sibling::button"))
				.getSize();
		System.out.println("Size is: " + size);

	}

}
