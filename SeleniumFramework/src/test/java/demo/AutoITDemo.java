package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://smallpdf.com/pdf-to-word");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'Choose Files')]")).click();
		
		Runtime.getRuntime().exec("C:\\Software\\AutoIT\\FileUploadScript.exe");
		
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		
		//driver.close();
		//driver.quit();
		
	}

}
