package week2.Day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonLeafGround {
	/* LeafGround Assignments ------Play with Radio Buttons */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='yes']")).click();

		boolean firstRadio = driver.findElement(By.xpath("(//input[@name='news'])[1]")).isSelected();
		boolean secondRadio = driver.findElement(By.xpath("(//input[@name='news'])[2]")).isSelected();

		if (firstRadio == true) {
			System.out.println("First Radio button is default selected. Label is: "
					+ driver.findElement(By.xpath("//label[@for='Unchecked']")).getText());
		} else if (secondRadio == true) {
			System.out.println("Second Radio button is default selected. Label is: "
					+ driver.findElement(By.xpath("//label[@for='Checked']")).getText());
		}

		if (driver.findElement(By.xpath("(//input[@name='age'])[2]")).isSelected() != true) {

			driver.findElement(By.xpath("(//input[@name='age'])[2]")).click();
		} else {
			System.out.println("option already selected");
		}

	}

}
