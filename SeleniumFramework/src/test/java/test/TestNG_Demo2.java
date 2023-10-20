package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo2 {
	
	/*public static void main(String[] args) throws InterruptedException {
		
		googleSearch();
	}*/
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		
	}

	@Test
	public void googleSearch2() throws InterruptedException {
			
		driver.get("https://www.google.com");
		
		// Maximize current window
		driver.manage().window().maximize();
		
		// Enter the keywords
		driver.findElement(By.name("q")).sendKeys("Joncis Gella");
		
		// Click Google Image (to remove the search suggestion)
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/img[1]")).click();
		
		// Pause for 3 seconds
		Thread.sleep(3000);
		
		// Click search button
		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]")).click();
			
	}
	
	@Test
	public void googleSearch3() throws InterruptedException {
			
		driver.get("https://www.google.com");
		
		// Maximize current window
		driver.manage().window().maximize();
		
		// Enter the keywords
		driver.findElement(By.name("q")).sendKeys("Joncis Gella");
		
		// Click Google Image (to remove the search suggestion)
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/img[1]")).click();
		
		// Pause for 3 seconds
		Thread.sleep(3000);
		
		// Click search button
		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]")).click();
			
	}
	
	@AfterTest
	public void tearDownTest() {
		
		// Close the driver
		driver.close();
		driver.quit();

		// Print test completed
		System.out.println("Test Completed Successfully");
		
	}
}
