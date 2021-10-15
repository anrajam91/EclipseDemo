package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageAssignmentLeafGround {
	/* LeafGround Assignments ------Interact with Images */

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//label[@for='home']/following-sibling::img[@src='../images/home.png']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='images/image.png']")).click();
		String width = driver
				.findElement(By.xpath("//label[@for='position']/following-sibling::img[@src	='../images/abcd.jpg']"))
				.getAttribute("naturalWidth");

		if (width.equals("0")) {
			System.out.println("This image is broken");
		} else {
			System.out.println("Image is not broken");
		}

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"))).click().perform();

	}

}
