package org.QAfoxProject.genericUtility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class Provides Re-Usable Methods To Peform Driver Related Operations
 * 
 * @author Purna
 */
public class WebDriverLibrary {
	public WebDriver driver;
	public static WebDriver staticDriver;
	public Actions action;
	public Select select;

	/**
	 * This Method Launches The Specific Browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Involved browser info");
		}
		return staticDriver = driver;
	}

	/**
	 * This Method Maximizes The Browser
	 * 
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This Method Is Used To Navigate To The Application
	 * 
	 * @param url
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}

	/**
	 * This Method Is Used To Close the browser
	 * 
	 */
	public void closeBrowser() {
		driver.close();
	}

	/**
	 * This Method Is Used To Get The Browser Title
	 * 
	 */
	public void getBrowserTitle() {
		driver.getTitle();
	}
	
	/**
	 * This Method Is Used To Fetch The Current URL of The WebPage
	 * 
	 */
	public void getBrowserUrl() {
		driver.getCurrentUrl();
	}
	
	/**
	 * This Method Is Used To Fetch The Tag Name of The WebElement
	 * 
	 * @return
	 */
	public String getTagName(WebElement element) {
		return element.getTagName();
	}
	
	/**
	 * This Method Is Used To Fetch The Attribute Value of The WebElement
	 * 
	 * @return
	 */
	public String getAttributeValue(WebElement element,String attributeName) {
		return element.getDomAttribute(attributeName);
	}
	
	/**
	 * This Method Is Used To Close All The browser Window/Tab
	 * 
	 */
	public void closeAllBrowser() {
		driver.quit();
	}

	/**
	 * This Method Wait until element or elements is found
	 * 
	 */
	public void waitUntilElementFound() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PathConstant.DURATION));
	}

	/**
	 * This Method Wait until element is visible on the Web Page.
	 * 
	 * @param element
	 */
	public void waitUntilElementFound(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PathConstant.DURATION));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This Method is used to mouse over on an element
	 * 
	 * @param element
	 */
	public void mouseHoverToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This Method is used to double click on an element
	 * 
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * This Method is used to right click on an element
	 * 
	 * @param element
	 */
	public void rightClickOnElement(WebElement element) {
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This Method Its used to drag and drop an element
	 * 
	 * @param source
	 * @param target
	 */
	public void dragAndDropElement(WebElement source, WebElement target) {
		action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	/**
	 * This Method is used to Select an element from drop down based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectFromDropdown(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This Method is used to Select an element from drop down based on attribute
	 * value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectFromDropdown(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This Method is used to Select an element from drop down based on visible text
	 * 
	 * @param element
	 * @param visibletext
	 */
	public void selectFromDropdown(String visibletext, WebElement element) {
		select = new Select(element);
		select.selectByVisibleText(visibletext);
	}

	/**
	 * This Method is used to Switch to frame based on index
	 * 
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This Method is used to Switch to frame based on id or name attribute value
	 * 
	 * @param idOrName
	 */
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	/**
	 * This Method is used to Switch to frame based on frame element
	 * 
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This Method is used to Switch back to the default window
	 * 
	 */
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This Method is used to Switch back to the immidiate parent Window/Frame
	 * 
	 */
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	/**
	 * This Method is used to handle alert pop-up
	 * 
	 */
	public void handleAlert(String status) {
		Alert al = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok")) {
			al.accept();
		} else {
			al.dismiss();
		}
	}

	/**
	 * This Method converts dynamic xpath to Webelement
	 * 
	 * @param commonPath
	 * @param replaceData
	 * @return
	 */
	public WebElement convertDynamicXpathToWebElement(String commonPath, String replaceData) {
		String requiredPath = String.format(commonPath, replaceData);
		return driver.findElement(By.xpath(requiredPath));
	}

}