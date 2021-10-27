package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(0);
		WebElement buttonEle = driver.findElement(By.xpath("//button[@id='Click']"));
		
		File screenShot = buttonEle.getScreenshotAs(OutputType.FILE);
		File dstn = new File("./snaps/pic1.png");
		FileUtils.copyFile(screenShot, dstn);
		System.out.println("Captured Screen Successfully");
		
		driver.switchTo().defaultContent();
		List<WebElement> framesList = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of Frames in the screen is: "+framesList.size());
		
	}

}
