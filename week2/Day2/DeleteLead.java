package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	/*
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * Delete Lead: 1 Launch the browser 2 Enter the username 3 Enter the password 4
	 * Click Login 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8
	 * Click on Phone 9 Enter phone number 10 Click find leads button 11 Capture
	 * lead ID of First Resulting lead 12 Click First Resulting lead 13 Click Delete
	 * 14 Click Find leads 15 Enter captured lead ID 16 Click find leads button 17
	 * Verify message "No records to display" in the Lead List. This message
	 * confirms the successful deletion 18 Close the browser (Do not log out)
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("91");
		
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("02");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234567890");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		WebElement firstLead = driver.findElement(By.xpath("(//div[text()='Lead ID']/following::a[@class='linktext'])[1]"));
		String leadId=firstLead.getText();
		System.out.println("Captured Lead ID is "+leadId);
		firstLead.click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.linkText("Find Leads")).click();	
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String text = driver.findElement(By.xpath("//span[text()='Lead List']/following::div[text()='No records to display']")).getText();
		
		if(text.contains("No records to display"))
		{
			System.out.println("Lead ID "+leadId+" is succesfully deleted");
		}
		else
		{
			System.out.println("Lead ID "+leadId+" is NOT deleted");
		}
		
		driver.close();
	}

}
