package week3.day2;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	/**
	 * @throws InterruptedException
	 * 1. Launch the URL https://www.ajio.com/ 2. In the search box, type as "bags"
	 * and press enter 3. To the left of the screen under " Gender" click the "Men"
	 * 4. Under "Category" click "Fashion Bags" 5. Print the count of the items
	 * Found. 6. Get the list of brand of the products displayed in the page and
	 * print the list. 7. Get the list of names of the bags and print it
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags", Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='Men']/following::label[contains(text(),'Men')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(2000);
		String attribute = driver.findElement(By.xpath("//div[@class='length']")).getText();
		String replaceAll = attribute.replaceAll("[\\D]", "");
		System.out.println("Number of items found is: " + replaceAll);

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='brand']"));
		Set<String> brandName = new LinkedHashSet<String>();
		for (WebElement brandEle : findElements) {

			brandName.add(brandEle.getText());
		}

		System.out.println("Printing Unique Brand Names: " + brandName);
		List<WebElement> findElements1 = driver.findElements(By.xpath("//div[@class='name']"));
		Set<String> productName = new LinkedHashSet<String>();

		for (WebElement NameEle : findElements1) {

			productName.add(NameEle.getText());
		}

		System.out.println("Printing Unique Product Names: " + productName);
	}

}
