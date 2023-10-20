import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilities_Demo {

	private static WebDriver driver = null;
	
	/** NOT DONE, NEED HELP **/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Joncis Gella");
		
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/img[1]")).click();
		
		driver.close();
		driver.quit();

		// Print test completed
		System.out.println("Test Completed Successfully");
		
	}

}
