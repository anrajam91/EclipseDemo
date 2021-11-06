package week5.day2;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowAssignment extends BaseClassServiceNow {
	@Test
	public void createIncident() throws IOException {
		// TODO Auto-generated method stub

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Resolved']/following::div[text()='All']")));
		driver.findElement(By.xpath("//div[text()='Resolved']/following::div[text()='All']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();

		driver.findElement(By.name("lookup.incident.caller_id")).click();
		driver.switchTo().defaultContent();
		Set<String> windows = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windows);
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.linkText("System Administrator")).click();
		driver.switchTo().window(winList.get(0));
		driver.switchTo().frame("gsft_main");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("incident.short_description")));
		driver.findElement(By.name("incident.short_description")).sendKeys("Creating Test incident");
		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_insert")).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Search']/following-sibling::input")));
		WebElement searchInput = driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input"));
		searchInput.sendKeys(incidentNum);
		searchInput.sendKeys(Keys.ENTER);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='list_row list_odd']/td/a[contains(text(),'INC')]")));
		String incidentResult = driver.findElement(By.xpath("//tr[@class='list_row list_odd']/td/a[contains(text(),'INC')]")).getText();
		if (incidentNum.contains(incidentResult)) {
			System.out.println("Incident is created Sucessfully");
		} else {
			System.out.println("Incident NOT created");
		}

		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File dstn = new File("./snaps/Capture1.png");
		FileUtils.copyFile(screenshot, dstn);
		System.out.println("Screenshot Captured and Saved Sucessfully !");

	}

}
