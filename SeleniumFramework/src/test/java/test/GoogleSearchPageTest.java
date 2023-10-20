package test;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

import org.openqa.selenium.WebDriver;

public class GoogleSearchPageTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearchTest();
	
	}
	
	public static void googleSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://www.google.com");
		
		// Maximize current window
		driver.manage().window().maximize();
		
		searchPageObj.setTextInSearchBox("A B C D");
		
		searchPageObj.clickSearchButton();
		
		// Close the driver
		driver.close();
		driver.quit();
				
		// Print test completed
		System.out.println("Test Completed Successfully");
	}
}
