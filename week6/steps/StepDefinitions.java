package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions extends BaseClass {

	@Given("Open the chrome browser")
	public void open_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("open the leaftaps url {string}")
	public void open_url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Given("Enter username as {string}")
	public void enter_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@Given("Enter password as {string}")
	public void enter_password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);

	}

	@When("Click on login button")
	public void login() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Leaftaps homepage should be displayed")
	public void homepage_displayed() {
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("Leaftaps - TestLeaf Automation Platform")) {
			System.out.println("Homepage should be displayed");
			driver.close();
		} else {
			System.out.println("Login error");
		}
	}

	@But("Error message should be displayed")
	public void error_message() {
		System.out.println("Error message displayed");
		driver.close();
	}

	@Given("Enter username as {string} and password as {string}")
	public void enter_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

	}

	@Given("Click Create Lead button")
	public void create_lead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("Enter user primary details {string},{string},{string},{string}")
	public void enter_primary_details(String compName, String firstName, String lastName, String phnum) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnum);
	}

	@When("Click on Submit button")
	public void submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("View the new lead information {string}")
	public void view_new_lead(String firstName) {
		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (text.equalsIgnoreCase(firstName)) {
			System.out.println("First Name is " + text);
		}

	}

	@Then("Page landed to View Lead page {string}")
	public void view_lead_page(String titleName) {
		String title = driver.getTitle();
		if (title.contains(titleName)) {
			System.out.println("Title of the page is " + title);
		}
	}

	@Given("Enter {string} to find leads")
	public void find_leads(String phoneNum) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Find Leads")));
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNum);
		Thread.sleep(2000);

	}

	@Given("Click on Find Leads")
	public void click_find_leads() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Given("Select a Lead from list")
	public void select_lead() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//table//tr/td/div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")));
		driver.findElement(By.xpath("(//table//tr/td/div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"))
				.click();

	}

	@When("Click on Edit button")
	public void edit_button() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Then("Update the {string} in Edit Lead Page")
	public void update_lead(String companyName) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.name("submitButton")).click();
	}
	@When("Click on Duplicate Lead button")
	public void click_duplicate_lead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();

	}
	@Then("Click Submit on Duplicate Lead page")
	public void submit_duplicate_lead() {
		driver.findElement(By.name("submitButton")).click();
	}
	@When("Click on Delete Lead button")
	public void click_delete_lead() {
		driver.findElement(By.linkText("Delete")).click();
	}
	@Then("Deleted {string} is not present")
	public void deleted_id_not_present(String leadID) {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@Then("No records should be displayed")
	public void no_records() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Sucessfully Deleted");
		} else {
			System.out.println("Lead ID not deleted");
		}
	}
	@Given("Click Merge Leads Link")
	public void click_lead_to_merge() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	
	@Given("Select a leads{string}{string} to merge")
	public void select_lead_to_merge(String leadName, String dstnName) throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(leadName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(dstnName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
		
	}
	@When("Click on merge Lead")
	public void merge_lead() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}
	@Then("First Lead ID should merged and should not be found{string}")
	public void mergedlead(String leadID) {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	
	}

}
