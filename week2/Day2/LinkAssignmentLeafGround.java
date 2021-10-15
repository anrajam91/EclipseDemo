package week2.Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkAssignmentLeafGround {
	/* LeafGround Assignments ------Play with Hyperlinks */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[contains(text(),'Find where am')]/preceding::a[text()='Go to Home Page']"))
				.click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		String hrefAttr = driver.findElement(By.xpath("//a[contains(text(),'Find where am supposed')]"))
				.getAttribute("href");
		System.out.println("Goto link is: " + hrefAttr);

		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		Thread.sleep(1000);
		String title = driver.getTitle();
		if (title.contains("404")) {
			System.out.println("The link is broken ! Title: " + title);
		} else {
			System.out.println("The link is Valid ! Title of the page is: " + title);
		}

		driver.navigate().back();
		driver.findElement(By
				.xpath("//label[contains(text(),'Interact with same')]/preceding-sibling::a[text()='Go to Home Page']"))
				.click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("There are " + links.size() + " links in this page");

	}

}
