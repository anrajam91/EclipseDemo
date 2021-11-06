package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends BaseClassServiceNow {
	@Test
	public void assignIncidents() {
		// TODO Auto-generated method stub

		driver.findElement(By.xpath("//div[text()='Resolved']/preceding::div[text()='Open']")).click();
		driver.switchTo().frame("gsft_main");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='Search']/following-sibling::input")));
		WebElement searchInput = driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input"));
		searchInput.sendKeys("INC0010001" + Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'INC0010001')]")));
		List<WebElement> incidentResults = driver.findElements(By.xpath("//a[contains(text(),'INC0010001')]"));
		for (WebElement eachIncident : incidentResults) {
			if (eachIncident.getText().contains("INC0010001")) {
				eachIncident.click();
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sysverb_update")));
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstWindow.get(1));

		driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input"))
				.sendKeys("Software" + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Software')]")));
		WebElement fullTable = driver.findElement(By.xpath("//table[@id='sys_user_group_table']"));
		List<WebElement> rowTable = fullTable.findElements(By.tagName("tr"));

		for (WebElement eachRow : rowTable) {
			String text = eachRow.findElement(By.xpath("//td[3]/a")).getText();

			if (text.contains("Software")) {
				eachRow.findElement(By.xpath("//td[3]/a")).click();
				break;
			}
		}

		driver.switchTo().window(lstWindow.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']"))
				.sendKeys("Assigned the software groups");
		driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'INC0010001')]")));

		driver.findElement(By.xpath("//a[contains(text(),'INC0010001')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='sysverb_update']")));

		String assignmentGrp = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"))
				.getAttribute("value");
		String workNotes = driver
				.findElement(By.xpath("(//ul[@class='h-card-wrapper activities-form']//div[3]//span)[1]")).getText();

		if ((assignmentGrp.contains("Software")) && (!workNotes.isEmpty())) {
			System.out.println("Assigned to Group: " + assignmentGrp + " and added the worknotes: " + workNotes);
		}
	}

}
