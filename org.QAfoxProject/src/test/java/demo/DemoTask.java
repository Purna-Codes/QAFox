package demo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoTask {

	@Test
	public void demoTest() {

		// Step 1: Create the SparkReport latest
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// Step 2.1: Set the Document Title
		spark.config().setDocumentTitle("Functionality Test || QAFox");
		// Step 2.2: Set the Report Name
		spark.config().setReportName("FunctionalitySuite || Verifiy User Able To Add Desktop-Mac-Product");
		// Step 2.3: Set the Theme
		spark.config().setTheme(Theme.STANDARD);

		// Step 3: Create Extent Report
		ExtentReports report = new ExtentReports();
		
		// Step 4: Attach Spark Report With Extent Report
		report.attachReporter(spark);

		// Step 5: Configure The System Information And Extent Report
		report.setSystemInfo("DeviceName:", "Purna");
		report.setSystemInfo("OperatingSystem:", "WINDOWS 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion:", "chrome-131.0.6778.265");

		// Step 6: Create The Test Information
		ExtentTest test = report.createTest("FunctionalityTest");

		// Step 7: Create The Test Information
		test.log(Status.INFO, "Step 1: Launching The Browser Successful");
		
		test.log(Status.INFO, "Step 2: Navigating To The Application Via URL Successful Successful");
		
		test.log(Status.PASS, "Step 3: Verified The WebPage Successful");

		// Step 8: Provide The Test Log
		if ("Purna".equals("Purna")) {
			test.log(Status.PASS, "Step 4: Verified the WebElement is displayed");
		} else {
			test.log(Status.FAIL, "Step 4: Verified the WebElement is not displayed");
		}

//		test.log(Status.SKIP,  "Step 5: Element is hidden");

		// Step 8: Flush the Report Information
		report.flush();

		System.out.println("Execution Completed");

	}
}