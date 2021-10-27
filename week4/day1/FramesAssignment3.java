package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Not a Friendly Topic");
		System.out.println("Inside Frame1");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		System.out.println("Inside Frame3");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		System.out.println("Inside Frame2");
		WebElement animalsSelect = driver.findElement(By.id("animals"));
		Select dd1=new Select(animalsSelect);
		dd1.selectByVisibleText("Baby Cat");
			
		
	}

}
