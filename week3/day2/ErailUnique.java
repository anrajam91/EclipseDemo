package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {
	/**
	 * Set the system property and Launch the URL Click the 'sort on date' checkbox
	 * clear and type in the from station text field clear and type in the to
	 * station text field Add a java sleep for 2 seconds Store all the train names
	 * in a list Get the size of it Add the list into a new Set And print the size
	 * of it.
	 * 
	 * @param args
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
		driver.findElement(By.id("txtStationTo")).sendKeys("BNC", Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> findElements = driver
				.findElements(By.xpath("//div[@id='divTrainsList']/table[1]//tr//td[2]/a"));
		List<String> trainNames = new ArrayList<String>();

		for (WebElement webElement : findElements) {
			trainNames.add(webElement.getText());
		}
		System.out.println("Total Number of trains Names in List is (With Duplicates): " + trainNames.size());

		Set<String> trainNamesSet = new TreeSet<String>();
		for (String eachName : trainNames) {
			trainNamesSet.add(eachName);
		}

		System.out.println("Total Number of trains Names in Set is (Without Duplicates): " + trainNamesSet.size());
	}

}
