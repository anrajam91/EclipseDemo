package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssignment {
	/*
	 * 1.Load the uRL https://www.amazon.in/ 2.search as oneplus 9 pro 3.Get the
	 * price of the first product 4. Print the number of customer ratings for the
	 * first displayed product 5. Mouse Hover on the stars 6. Get the percentage of
	 * ratings for the 5 star. 7. Click the first text link of the first image 8.
	 * Take a screen shot of the product displayed 9. Click 'Add to Cart' button 10.
	 * Get the cart subtotal and verify if it is correct.
	 */

	public static int ConvertPrice(String total) {
		String totalCount = total.replaceAll(".00", "").replaceAll("\\D", "");
		int parseInt = Integer.parseInt(totalCount);
		return parseInt;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions action = new Actions(driver);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		List<WebElement> productsList = driver.findElements(
				By.xpath("//img[contains(@alt,'OnePlus 9 Pro')]/following::span[@class='a-price-whole']"));

		String firstProdPrice = productsList.get(0).getText();
		int intProdPrice = ConvertPrice(firstProdPrice);
		System.out.println("Price of first Product in the list " + intProdPrice);

		String ratingstr = driver
				.findElement(
						By.xpath("(//img[contains(@alt,'OnePlus 9 Pro')]/following::span[@class='a-size-base'])[1]"))
				.getText();
		System.out.println("Number of Ratings for the first displayed Product is: " + ratingstr);
		WebElement starEle = driver.findElement(By.xpath(
				"//img[contains(@alt,'OnePlus 9 Pro')]/following::a[@class='a-popover-trigger a-declarative'][1]"));
		action.moveToElement(starEle).perform();

		starEle.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='histogramTable']")));
		String ratingPercent = driver.findElement(By.xpath("(//a[contains(@title,'of reviews have 5 stars')])[3]"))
				.getText();
		System.out.println("Rating Percentage for the 5 star rating of first displayed Product is: " + ratingPercent);

		driver.findElement(By.xpath("(//span[contains(text(),'OnePlus 9 Pro')])[1]")).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windows);
		driver.switchTo().window(winList.get(1));

		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File dstn = new File("./snaps/oneplus1.png");
		FileUtils.copyFile(screenShot, dstn);

		driver.findElement(By.id("add-to-cart-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attach-accessory-cart-subtotal")));
		String price = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		// System.out.println("Price of first Product in the list " +price);
		int intFinalPrice = ConvertPrice(price);
		System.out.println("Price of first Product in the list " + intFinalPrice);

		if (intProdPrice == intFinalPrice) {
			System.out.println("Price in Cart is correct " + intFinalPrice);
		}
	}

}
