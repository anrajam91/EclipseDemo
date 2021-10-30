package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0);
		WebElement srcEle = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement dstnEle = driver.findElement(By.xpath("//li[text()='Item 5']"));
		Point location = dstnEle.getLocation();
		int x = location.getX();
		int y = location.getY();
		Actions action = new Actions(driver);
		action.dragAndDropBy(srcEle, x, y).perform();
	
		

	}

}
