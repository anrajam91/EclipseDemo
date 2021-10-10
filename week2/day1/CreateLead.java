package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();

driver.get("http://leaftaps.com/opentaps");

driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.linkText("Leads")).click();
driver.findElement(By.linkText("Create Lead")).click();
driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Anu");
driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Anu");
driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Test Engineer");
driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Engineer");
driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("400000");
driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("0202");
driver.findElement(By.id("createLeadForm_description")).sendKeys("Sample creation");
driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Sample");
driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Raja");
driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Raja");
driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("12/19/19");
driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("20");
driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("20122");
driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("02");
driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("1212");
driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("anu@123.com");
driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("1234567890");
driver.findElement(By.name("primaryPhoneAskForName")).sendKeys("Anude");
driver.findElement(By.name("primaryWebUrl")).sendKeys("http:\\www.abc.com");
driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Anu");
driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Anude");
driver.findElement(By.name("generalAddress1")).sendKeys("12,6th street");
driver.findElement(By.name("generalAddress2")).sendKeys("velachery, chennai");
driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")).sendKeys("Alaska");
driver.findElement(By.name("generalCity")).sendKeys("chennai");
driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("232323");
driver.findElement(By.name("generalPostalCodeExt")).sendKeys("1234");
driver.findElement(By.className("smallSubmit")).click();
String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
System.out.println("First Name is "+ text);
//String text2 = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
//System.out.println(text2);
String title = driver.getTitle();
//System.out.println("Title of the page is "+ title);
if(title.contains("View Lead"))
{
	System.out.println("Title of the page is "+title);
}
}

}
