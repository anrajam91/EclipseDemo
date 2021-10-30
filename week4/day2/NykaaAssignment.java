package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {
	/*
	 * 1) Go to https://www.nykaa.com/ 2) Mouseover on Brands and Search L'Oreal
	 * Paris 3) Click L'Oreal Paris 4) Check the title contains L'Oreal
	 * Paris(Hint-GetTitle) 5) Click sort By and select customer top rated 6) Click
	 * Category and click Hair->Click haircare->Shampoo 7) Click->Concern->Color
	 * Protection 8)check whether the Filter is applied with Shampoo 9) Click on
	 * L'Oreal Paris Colour Protect Shampoo 10) GO to the new window and select size
	 * as 175ml 11) Print the MRP of the product 12) Click on ADD to BAG 13) Go to
	 * Shopping Bag 14) Print the Grand Total amount 15) Click Proceed 16) Click on
	 * Continue as Guest 17) Check if this grand total is the same in step 14 18)
	 * Close all windows
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		WebElement brandsEle = driver.findElement(By.xpath("//a[text()='brands']"));
		action.moveToElement(brandsEle).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains("L'Oreal Paris"));

		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("L'Oreal Paris page displayed sucessfully");
		} else {
			System.out.println("L'Oreal Paris page NOT displayed");
		}

		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

		String text = driver.findElement(By.xpath("//span[text()='Filters Applied']/following::span[1]")).getText();

		if (text.contains("Shampoo")) {
			System.out.println("Filter is applied correctly with Shampoo");
		} else {
			System.out.println("Filter NOT applied correctly");
		}

		driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
		Set<String> totalWindows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(totalWindows);

		driver.switchTo().window(windowsList.get(1));

		WebElement mlSelect = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd1 = new Select(mlSelect);
		dd1.selectByVisibleText("360ml");

		String price = driver
				.findElement(By.xpath("(//div[text()='inclusive of all taxes']/preceding-sibling::span)[2]")).getText();
		System.out.println("Price of the product is: " + price);

		driver.findElement(By.xpath("//span[text()='ADD TO BAG'][1]")).click();

		wait.until(ExpectedConditions
				.invisibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Product Added to Cart!')]"))));

		driver.findElement(By.xpath("//span[text()='Account']/following::button")).click();

		WebElement shoppingFrame = driver.findElement(By.className("css-acpm4k"));
		driver.switchTo().frame(shoppingFrame);
		String grandTotal1 = driver.findElement(By.xpath("//span[text()='Grand Total']/following::div[@class='value']"))
				.getText();
		String grandTotal = grandTotal1.replaceAll("\\D", "");
		System.out.println("Grand Total is: " + grandTotal);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
		WebElement guestBtn = driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']"));
		wait.until(ExpectedConditions.visibilityOf(guestBtn));
		guestBtn.click();

		String finalTotal1 = driver
				.findElement(By.xpath("//div[text()='Grand Total']/following::div[@class='value']/span")).getText();
		String finalTotal = finalTotal1.trim();
		if (finalTotal.equals(grandTotal)) {
			System.out.println("Total match with the Grand total in shopping Cart " + finalTotal);
		} else {
			System.out.println("Total doesn't match" + finalTotal);
		}

		driver.quit();
	}

}
