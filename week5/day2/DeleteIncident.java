package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends BaseClassServiceNow {
	@Parameters({"incidentnum" })
	@Test
	public void deleteIncidents(String num) {
		// TODO Auto-generated method stub

		driver.findElement(By.xpath("//div[text()='Resolved']/preceding::div[text()='Open']")).click();
		driver.switchTo().frame("gsft_main");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='Search']/following-sibling::input")));
		WebElement searchInput = driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input"));
		searchInput.sendKeys(num + Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'INC00100')]")));
		List<WebElement> incidentResults = driver.findElements(By.xpath("//a[contains(text(),'INC00100')]"));
		for (WebElement eachIncident : incidentResults) {
			if (eachIncident.getText().contains(num)) {
				eachIncident.click();
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sysverb_delete")));
		driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();

		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ok_button']"))) != null) {
			driver.findElement(By.xpath("//button[@id='ok_button']")).click();

		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='incident_table']/tbody/tr/td")));
		String text = driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr/td")).getText();
		
		if (text.contains("No records")) {
			System.out.println("Incident deleted Sucessfully");
		} else {
			System.out.println("Incident NOT deleted");
		}

		

		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'INC00100')]")));

		List<WebElement> incidents = driver.findElements(By.xpath("//table[@id='incident_table']/tbody//td[3]/a"));

		for (WebElement eachIncident : incidents) {
			if (eachIncident.getText().contains(num)) {
				System.out.println("Incident NOT deleted");
			} else {
				System.out.println("Incident deleted Sucessfully");
			}

		}*/

	}
}
