package week2.Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownsAssignmentLeafGround {
	/* LeafGround Assignments ------Learn Listboxes */

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement selectIndex = driver.findElement(By.id("dropdown1"));
		Select dd1 = new Select(selectIndex);
		dd1.selectByIndex(3);

		WebElement selectText = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(selectText);
		dd2.selectByVisibleText("UFT/QTP");

		WebElement selectValue = driver.findElement(By.id("dropdown3"));
		Select dd3 = new Select(selectValue);
		dd3.selectByValue("3");

		WebElement selectCount = driver.findElement(By.className("dropdown"));
		Select dd4 = new Select(selectCount);
		List<WebElement> options = dd4.getOptions();
		System.out.println("Number of options in the dropdown is: " + options.size());

		WebElement selectAction = driver.findElement(By.xpath("//select[@class='dropdown']/following::select[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(selectAction).click().perform();
		action.sendKeys(selectAction, Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

		WebElement selectList = driver.findElement(By.xpath("//select[@class='dropdown']/following::select[2]"));
		Select dd5 = new Select(selectList);
		dd5.selectByVisibleText("UFT/QTP");
	}

}
