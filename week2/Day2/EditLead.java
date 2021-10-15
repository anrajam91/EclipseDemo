package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	/*
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * 1 Launch the browser 2 Enter the username 3 Enter the password 4 Click Login
	 * 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8 Enter first name
	 * 9 Click Find leads button 10 Click on first resulting lead 11 Verify title of
	 * the page 12 Click Edit 13 Change the company name 14 Click Update 15 Confirm
	 * the changed name appears 16 Close the browser (Do not log out)
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//label[text()='Last name:']/preceding::input[@name='firstName'])[3]"))
				.sendKeys("Anu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		WebElement firstLead = driver
				.findElement(By.xpath("(//div[text()='Lead ID']/following::a[@class='linktext'])[1]"));
		// String leadId=firstLead.getText();
		// System.out.println("Captured Lead ID is "+leadId);
		firstLead.click();
		Thread.sleep(1000);
		String title = driver.getTitle();
		if (title.contains("View Lead")) {
			System.out.println("We are now in correct page: " + title);
		} else {
			System.out.println("Incorrect page " + title);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Test Leaf Ltd");
		String newCompName = driver.findElement(By.id("updateLeadForm_companyName")).getAttribute("value");
		driver.findElement(By.name("submitButton")).click();

		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String replacedText = text.replaceAll("[\\d]", "").replaceAll("[(]", "").replaceAll("[)]", "");

		if (newCompName.equals(replacedText.trim())) {
			System.out.println("Company name is updated successfully: " + replacedText);
			driver.quit();
		}
	}

}
