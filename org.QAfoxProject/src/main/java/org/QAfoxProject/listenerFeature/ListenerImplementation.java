package org.QAfoxProject.listenerFeature;

import org.QAfoxProject.genericUtility.BaseConfiguration;
import org.QAfoxProject.genericUtility.TakeScreenshotLibrary;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation extends BaseConfiguration implements ITestListener, IRetryAnalyzer {

	/**
	 * 
	 */
	private int count = 0;

	public ListenerImplementation() {
		super.initObjects();
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName() + " onTestStart ..!!", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName() + " onTestSuccess ..!!", true);

		// Initialize the Extent Test
//		test = report.createTest(result.getName());
//		test.log(Status.PASS, "Test Case Passed is: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName() + " onTestFailure ..!!", true);

		// Get the failed test method name
		String methodName = result.getName();

		// Get the current timestamp
		String timestamp = javaUtilityObj.getCurrentTime();

		// Get the Random number
		int randomNo = javaUtilityObj.getRandom(1000);

		// Call the screenshot library to take a screenshot
		String screenshotPath = TakeScreenshotLibrary.takeScreenshot(methodName, timestamp, randomNo);

		// Log the screenshot path
		Reporter.log("Screenshot saved at: " + screenshotPath, true);

		// Initialize the Extent Test
//		test = report.createTest(result.getName());
//		test.log(Status.FAIL, "Test Case Failed Is: " + result.getName());
//		test.log(Status.FAIL, "Test Case Failing Reason Is: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName() + " onTestSkipped ..!!", true);

		// Initialize the Extent Test
//		test = report.createTest(result.getName());
//		test.log(Status.SKIP, "Test Case Skipped is: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log(result.getName() + " onTestFailedButWithinSuccessPercentage ..!!", true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log(result.getName() + " onTestFailedWithTimeout ..!!", true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log(context.getName() + " onStart ..............!!", true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName() + " onFinish ..!!", true);
	}

	@Override
	public boolean retry(ITestResult result) {

		int retryUntil = 5;

		// Increment count and check if retries are needed
		if (count < retryUntil) {
			count++;
			Reporter.log(result.getName() + " Retry ..!! Attempt: " + count, true);
			return true; // Retry the test
		}

		return false; // No more retries allowed

	}

}