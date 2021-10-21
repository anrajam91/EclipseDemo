package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {
	/**
	 * Launch the browser Launch the URL - https://erail.in/ Uncheck the check box -
	 * sort on date clear and type in the source station clear and type in the
	 * destination station Find all the train names using xpath and store it in a
	 * list Use Java Collections sort to sort it and then print it
	 * 
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("chkSelectDateOnly")).click();
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MASS", Keys.ENTER);

		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("SA", Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> findElements = driver
				.findElements(By.xpath("//div[@id='divTrainsList']/table[1]//tr//td[2]/a"));
		List<String> trainNames = new ArrayList<String>();

		for (WebElement webElement : findElements) {
			trainNames.add(webElement.getText());
		}

		Collections.sort(trainNames);
		System.out.println("Total Number of trains found in given route is: " + trainNames.size());
		System.out.println("Train Names: " + trainNames);
	}

}
