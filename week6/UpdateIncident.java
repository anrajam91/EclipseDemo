package week5.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClassServiceNow {
	
	@BeforeTest(groups={"sanity"})
	public void setValue() {
		// TODO Auto-generated method stub
		excelFileName="ServiceNowData";
		sheetNum="Sheet2";
	}
	@Test(dataProvider="fetchData",groups={"sanity"})
	public void updIncident(String incNum) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//div[text()='Resolved']/following::div[text()='All']")).click();
		driver.switchTo().frame("gsft_main");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='Search']/following-sibling::input")));
		WebElement searchInput = driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input"));
		searchInput.sendKeys(incNum);
		searchInput.sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'"+incNum+"')]")));
		List<WebElement> incidentResults = driver.findElements(By.xpath("//a[contains(text(),'"+incNum+"')]"));
		for (WebElement eachIncident : incidentResults) {
			if (eachIncident.getText().contains(incNum)) {
				eachIncident.click();
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sysverb_update")));
		WebElement eleUrgency = driver.findElement(By.id("incident.urgency"));
		Select selectUrgency = new Select(eleUrgency);
		selectUrgency.selectByValue("1");

		WebElement eleState = driver.findElement(By.id("incident.state"));
		Select selectState = new Select(eleState);
		selectState.selectByVisibleText("In Progress");

		driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+incNum+"')]")));

		driver.findElement(By.xpath("//a[contains(text(),'"+incNum+"')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='sysverb_update']")));

		WebElement eleUrgency1 = driver.findElement(By.id("incident.urgency"));
		Select selectUrgency1 = new Select(eleUrgency1);
		String urgencyValue = selectUrgency1.getFirstSelectedOption().getText();
		WebElement eleState1 = driver.findElement(By.id("incident.state"));
		Select selectState1 = new Select(eleState1);
		String urgencyState = selectState1.getFirstSelectedOption().getText();
		if ((urgencyValue.contains("High")) && (urgencyState.contains("Progress"))) {
			System.out.println("Urgency: " + urgencyValue + " and state: " + urgencyState + " are updated sucessfully");
		}

	}

}
