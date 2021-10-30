package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssignment {
	/*
	 * 1. Launch https://www.snapdeal.com/ 2. Go to Mens Fashion 3. Go to Sports
	 * Shoes 4. Get the count of the sports shoes 5. Click Training shoes 6. Sort by
	 * Low to High 7. Check if the items displayed are sorted correctly 8.Select the
	 * price range (900-1200) 9.Filter with color Navy 10 verify the all applied
	 * filters 11. Mouse Hover on first resulting Training shoes 12. click QuickView
	 * button 13. Print the cost and the discount percentage 14. Take the snapshot
	 * of the shoes. 15. Close the current window 16. Close the main window
	 */

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//li[@class='leftHead'][text()='More Categories']/following::span[1]")).click();

		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String sportShoesCount = driver.findElement(By.xpath("//div[text()='Sports Shoes']/following-sibling::div"))
				.getText();
		System.out.println("Total Sports Shoes Count is: " + sportShoesCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sort by:']")));
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='lfloat product-price'][1]")));
		Thread.sleep(1000);
		List<WebElement> allShoesPrice = driver
				.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));
		List<Integer> listShoesPrice = new ArrayList<Integer>();
		// List<String> SortedShoesPrice = new ArrayList<String>();
		for (WebElement eachShoe : allShoesPrice) {

			String eachPrice = eachShoe.getText();
			String strPrice = eachPrice.replaceAll("Rs. ", "").replaceAll(",", "");
			int price = Integer.parseInt(strPrice);
			listShoesPrice.add(price);
		}
		List<Integer> SortedShoesPrice = new ArrayList<Integer>(listShoesPrice);
		// System.out.println(listShoesPrice);
		// System.out.println(SortedShoesPrice);
		Collections.sort(SortedShoesPrice);
		// System.out.println(SortedShoesPrice);
		if (SortedShoesPrice.equals(listShoesPrice)) {
			System.out.println("Items displayed are sorted correctly");
		} else {
			System.out.println("Items displayed are NOT sorted correctly");
		}

		driver.findElement(By.name("fromVal")).sendKeys("600");
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//button[@data-filtername='Color_s']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Color_s-Navy']")));
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='product-image wooble'])[1]")));
		WebElement firstItem = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		action.moveToElement(firstItem).perform();
		wait.until(ExpectedConditions.elementToBeClickable(firstItem));
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-price')]/span[1]")));
		String pricepp = driver.findElement(By.xpath("//div[contains(@class,'product-price')]/span[1]")).getText();
		String discpp = driver.findElement(By.xpath("//div[contains(@class,'product-price')]/span[2]")).getText();
		System.out.println("Total Price is: " + pricepp + " " + "Discount % is " + discpp);
		WebElement imgShoe = driver.findElement(By.xpath("//img[@itemprop='image']"));
		File screenshotAs = imgShoe.getScreenshotAs(OutputType.FILE);
		File dstn = new File("./snaps/shoepic.png");
		FileUtils.copyFile(screenshotAs, dstn);
		System.out.println("Shoe image captured and stored in the path " + dstn);
		driver.close();
		driver.quit();

	}
}
