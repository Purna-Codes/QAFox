package org.QAfoxProject.genericUtility;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.QAfoxProject.pageRepository.AccountLoginPage;
import org.QAfoxProject.pageRepository.HomePage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This Class Describes The Configuration For TestScript This class is used to
 * configure all the Pre-Condition and Post-Condition for Test Script And also
 * initializing all the library/utility classes
 * 
 * @author Purna
 */
public class BaseConfiguration {

	public WebDriverLibrary webDriverObj;
	public ExcelFileLibrary excelUtilityObj;
	public PropertyFileLibrary propertyFileObj;
	public JavaLibrary javaUtilityObj;
	public JavaScriptLibrary jsUlitityObj;
	public TakeScreenshotLibrary tsUtilityObj;

	// To Generate The Extent Report
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	/**
	 * This Method Used To Configure The Browser Setup
	 * 
	 * @param
	 */
	@BeforeClass
	public void browserSetup() {

		// Initialize All The Libraries
		initObjects();

		String browser = "chrome";
		webDriverObj.launchBrowser(browser);
		
		// PreCondition 1: Launch The Browser
		Reporter.log("Browser Launched Successfully", true);

		// Step 3: Create Extent Report
		report = new ExtentReports();

		// Step 4: Attach Spark Report With Extent Report
		report.attachReporter(spark);

		// Step 5: Configure The System Information And Extent Report

		// Step 5.1: Set Device Name --> Using LocalHost
		try {
			report.setSystemInfo("DeviceName:", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		// Step 5.2: Set OS Name & Version --> Using System.getPropert()
		report.setSystemInfo("OperatingSystem:",
				System.getProperty("os.name") + " " + System.getProperty("os.version"));

		// Step 5.2: Set OS Name & Version --> Using System.getPropert()
		report.setSystemInfo("Java Version: ", System.getProperty("java.version"));

		// Fetch Browser and OS Info
		Capabilities capabilities = ((RemoteWebDriver) (webDriverObj.driver)).getCapabilities();

		// Step 5.3: Set OS Name & Version --> Using System.getBrowserName()
		report.setSystemInfo("Browser:", capabilities.getBrowserName());

		// Step 5.4: Set Browser Version --> Using System.getBrowserVersion()
		report.setSystemInfo("BrowserVersion:", capabilities.getBrowserVersion());

		String url = "https://tutorialsninja.com/demo/";

		// PreCondition 2: Navigate To The Application
		Reporter.log("Navigate To the Application Successful", true);
		webDriverObj.navigateToApp(url);

		// PreCondition 3: Maximize The Browser
		Reporter.log("Maximize the Browser Successful", true);
		webDriverObj.maximizeBrowser();

		HomePage homeObj = new HomePage(webDriverObj.driver);

		// Click on "My Account" Header_Link
		homeObj.getMyAccount_headerlink().click();
		Reporter.log("Click on My Account Header_Link Successful", true);

		// Click on "Login" Header_Link
		homeObj.getLogin_headerlink().click();
		Reporter.log("Click on Login Header_Link Successful", true);

		// Click on "Register" Header_Link
		// homeObj.getRegister_headerlink().click();
		// Reporter.log("Click on Register Header_Link Successful", true);

	}

	/**
	 * This Method Used To Configure The Browser Termination
	 * 
	 */
	@AfterClass
	public void browserTerminate() {

		// PostCondition 1: Close the Browser
		webDriverObj.closeAllBrowser();

		// Test Log
		Reporter.log("Browser Terminated Successfully", true);
	}

	/**
	 * This Method Used To Perform Login Activity
	 * 
	 */
	@BeforeMethod(enabled = true)
	public void login() {

		// Provide Implicit Wait Statement
		webDriverObj.waitUntilElementFound();

		String userName = "purnachsahu96@gmail.com", password = "Purna@123";

		// Create an Instance
		AccountLoginPage loginObj = new AccountLoginPage(webDriverObj.driver);

		// Enter UserName
		loginObj.getEmailAdd_TextField().sendKeys(userName);

		// Enter Password
		loginObj.getPassword_TextField().sendKeys(password);

		// Click Login
		loginObj.getLoginButton().click();

		// Test Log
		Reporter.log("Login Successful", true);
	}

	/**
	 * This Method Used To Perform Logout Activity
	 * 
	 */
	@AfterMethod(enabled = true)
	public void logout() {

		HomePage homeObj = new HomePage(webDriverObj.driver);

		// Click on My Account Header Link
		homeObj.getMyAccount_headerlink().click();

		// Explicit Wait Statement
		webDriverObj.waitUntilElementFound(homeObj.getLogout_headerlink());

		// Click LogOut
		homeObj.getLogout_headerlink().click();

		// Test Log
		Reporter.log("Logout Successful", true);
	}

	/**
	 * This Method Used To Get/Configure The TestRunner Level Connection
	 * 
	 */
	@BeforeTest
	public void getTestRunnerConnection() {

		// Test Log
		Reporter.log("Getting TestRunnerConnection Successful", true);
	}

	/**
	 * This Method Used To Terminate The TestRunner Level Connection
	 * 
	 */
	@AfterTest
	public void terminateTestRunnerConnection() {
		// Test Log
		Reporter.log("Terminating TestRunnerConnection Successful", true);
	}

	/**
	 * This Method Used To Get/Configure The Database or Advance Report Connection
	 * 
	 */
	@BeforeSuite
	public void getReportConnection() {

		initObjects();
		// Step 1: Create the SparkReport
		spark = new ExtentSparkReporter("./AdvanceReports/" + "report_" + javaUtilityObj.getCurrentTime() + "_"
				+ javaUtilityObj.getRandom(1000) + ".html");
		// Step 2.1: Set the Document Title
		spark.config().setDocumentTitle("Functionality Test || QAFox");
		// Step 2.2: Set the Report Name
		spark.config().setReportName("FunctionalitySuite || Verifiy User Able To Add Desktop-Mac-Product");
		// Step 2.3: Set the Theme
		spark.config().setTheme(Theme.DARK);

		// Test Log
		Reporter.log("Getting ReportConnection Successful", true);

	}

	/**
	 * This Method Used To Terminate The Database or Advance Report Connection
	 * 
	 */
	@AfterSuite
	public void terminateReportConnection() {

		// Flush the Report Information
		report.flush();

		// Test Log
		Reporter.log("Terminating ReportConnection Successful", true);
	}

	/**
	 * This Method Is Used To Initialize All the Utilities
	 */
	public void initObjects() {
		webDriverObj = new WebDriverLibrary();
		excelUtilityObj = new ExcelFileLibrary();
		propertyFileObj = new PropertyFileLibrary();
		javaUtilityObj = new JavaLibrary();
		jsUlitityObj = new JavaScriptLibrary();
		tsUtilityObj = new TakeScreenshotLibrary();

	}
}
