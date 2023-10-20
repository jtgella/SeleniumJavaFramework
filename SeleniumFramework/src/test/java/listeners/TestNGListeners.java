package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("*** Test started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Test is successful: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test failed: " + result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test skipped: " + result.getName());
	}
	
	public void onFinish(ITestResult context) {
		System.out.println("*** Test completed: " + context.getName());
	}

}
