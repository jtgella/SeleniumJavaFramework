package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitDemo {
	
	public static void main(String[] args) {
		
		seleniumWaits();
	}
	
	//WebDriver driver = null;

	
	public static void seleniumWaits() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Joncis");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
		// //input[@name='btnK']
		
		//old
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));
		
		//new
		//WebElement element = driver.findElement(By.name("abcdef"));
		//Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.name("abcd")).click();
		//wait.until(d->element.isDisplayed());
		
		//driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]")).click();
		//Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
