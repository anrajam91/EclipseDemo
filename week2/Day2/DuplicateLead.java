package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	/*
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * 1 Launch the browser 2 Enter the username 3 Enter the password 4 Click Login
	 * 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8 Click on Email 9
	 * Enter Email 10 Click find leads button 11 Capture name of First Resulting
	 * lead 12 Click First Resulting lead 13 Click Duplicate Lead 14 Verify the
	 * title as 'Duplicate Lead' 15 Click Create Lead 16 Confirm the duplicated lead
	 * name is same as captured name 17 Close the browser (Do not log out)
	 * 
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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("anu@123.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		WebElement firstLead = driver
				.findElement(By.xpath("(//div[text()='Lead ID']/following::a[@class='linktext'])[1]"));
		// String leadId=firstLead.getText();
		// System.out.println("Captured Lead ID is "+leadId);
		firstLead.click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String title = driver.getTitle();
		if (title.contains("Duplicate Lead")) {
			System.out.println("We are now in correct page " + title);
		} else {
			System.out.println("Incorrect page " + title);
		}
		Thread.sleep(1000);
		String dupName = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		if (dupName.equals(text)) {
			System.out.println("Duplicated lead name is same as captured name " + text);
		} else {
			System.out.println("Duplicated lead name is NOT same as captured name " + text);
		}

		driver.close();
	}

}
