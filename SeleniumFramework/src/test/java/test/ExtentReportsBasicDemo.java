package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Google Search Test One", "This is to validate google search functionality");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com");
		test1.pass("Navigated to google.com");

		// Maximize current window
		driver.manage().window().maximize();
		test1.pass("Windows is maximised.");

		// Enter the keywords
		driver.findElement(By.name("q")).sendKeys("Joncis Gella");
		test1.pass("Populated Joncis Gella in the google search box.");

		// Click Google Image (to remove the search suggestion)
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/img[1]")).click();
		test1.pass("Click search button.");

		// Close the driver
		driver.close();
		driver.quit();
		test1.pass("Closed the browser.");

		test1.info("Test Completed Successfully");
		
		// calling flush writes everything to the log file
		extent.flush();
	}
}
