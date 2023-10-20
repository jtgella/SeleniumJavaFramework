package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1_GoogleSearch {
	
	public static void main(String[] args) throws InterruptedException {
		
		googleSearch();
	}

	public static void googleSearch() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
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
		
		// Close the driver
		driver.close();
		driver.quit();
		
		// Print test completed
		System.out.println("Test Completed Successfully");
		
	}
}
