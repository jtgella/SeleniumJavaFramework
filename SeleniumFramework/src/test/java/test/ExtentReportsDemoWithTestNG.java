package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {

	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	
	WebDriver driver = null;
	
	@BeforeSuite
	public void setUp() {

		sparkReporter = new ExtentSparkReporter("extentReportswithTestNG.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		
	}
	
	@Test
	public void test1() {
		
		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("Sample Test One", "This is to validate extent report with TestNG failed scenario.");
		
		// log(Status, details)
		test.log(Status.INFO, "This setp shows usage of log(status, details)");
		
		// info(details)
		test.info("This step shows usage of info");
		
		// info(details)
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@Test
	public void test2() {
		
		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("Sample Test Two", "This is to validate extent report with TestNG passed scenario.");
		
		// log(Status, details)
		test.log(Status.INFO, "This setp shows usage of log(status, details)");
		
		// info(details)
		test.info("This step shows usage of info");
		
		// info(details)
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@Test
	public void test3() {
		
		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("Google Search Test Three", "This is to validate google search functionality.");
		
		test.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com");
		test.pass("Navigated to google.com");

		// Maximize current window
		driver.manage().window().maximize();
		test.pass("Windows is maximised.");

		// Enter the keywords
		driver.findElement(By.name("q")).sendKeys("Joncis Gella");
		test.pass("Populated Joncis Gella in the google search box.");

		// Click Google Image (to remove the search suggestion)
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/img[1]")).click();
		test.pass("Click search button.");

		// info(details)
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
		// Close the driver
		driver.close();
		driver.quit();
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		// calling flush writes everything to the log file
		extent.flush();
		
	}
}
