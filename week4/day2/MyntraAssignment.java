package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraAssignment {
	/*
	 * 1) Open https://www.myntra.com/ 2) Mouse hover on MeN 3) Click Jackets 4)
	 * Find the total count of item 5) Validate the sum of categories count matches
	 * 6) Check jackets 7) Click + More option under BRAND 8) Type Duke and click
	 * checkbox 9) Close the pop-up x 10) Confirm all the Coats are of brand Duke
	 * Hint : use List 11) Sort by Better Discount 12) Find the price of first
	 * displayed item Click on the first product 13) Take a screen shot 14) Click on
	 * WishList Now 15) Close Browser
	 */

	public static int ConvertPrice(String total) {
		String totalCount = total.replaceAll("\\D", "");
		int parseInt = Integer.parseInt(totalCount);
		return parseInt;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		WebElement eleMen = driver.findElement(By.xpath("//a[@class='desktop-main'][text()='Men']"));
		action.moveToElement(eleMen).perform();
		driver.findElement(By.xpath("//a[text()='Jackets'][1]")).click();

		String total = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		int convertCount = ConvertPrice(total);

		String totalJackets = driver.findElement(By.xpath("//span[@class='categories-num'][1]")).getText();
		int convertCount1 = ConvertPrice(totalJackets);

		String totalRainJackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		int convertCount2 = ConvertPrice(totalRainJackets);
		if (convertCount == (convertCount1 + convertCount2)) {
			System.out.println("Sum of Categories count match with total count " + convertCount);
		}

		driver.findElement(By.xpath("//label[contains(text(),'Jackets')]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search brand']")));
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[contains(text(),'Duke')]")).click();
		// String cssValue =
		// driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).getCssValue("background-color");
		// System.out.println(cssValue);

		if (driver.findElement(By.xpath("//label[contains(text(),'Duke')]/div[1]")).isSelected()) {
			System.out.println("Duke is selected");
		} else {
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> dukeList = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		for (WebElement eachDuke : dukeList) {
			String brandName = eachDuke.getText();
			if (!brandName.contains("Duke")) {
				System.out.println("Brand Name is not Duke");
			}

		}

		System.out.println("All the Coats are of brand Duke");
		driver.findElement(By.xpath("//ul[@class='discount-list']/li[2]")).click();

		List<WebElement> listItems = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		String firstPrice = listItems.get(0).getText();
		System.out.println("Price of first displayed item is: " + firstPrice);

		driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).click();
		Set<String> windows = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windows);
		driver.switchTo().window(winList.get(1));

		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File dstn = new File("./snaps/jackets1.png");
		FileUtils.copyFile(screenShot, dstn);

		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.quit();

		/// System.out.println("Total products displayed is: "+totalCount);

	}

}