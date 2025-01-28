package org.QAfoxProject.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * This Class Provides the reusable methods to perform javascript related
 * actions
 * 
 * @author Purna
 */
public class JavaScriptLibrary {

	public JavascriptExecutor javascriptobj;

	/**
	 * This Method is used to enter the data in disabled element
	 * 
	 */
	public void enterData_DisabledElement(WebElement element,String data) {
		javascriptobj=(JavascriptExecutor) WebDriverLibrary.staticDriver;
		javascriptobj.executeScript("arguments[0].value='"+data+"';",element);
	}
	
	/**
	 * This Method is used to perform click on Disabled Element
	 * 
	 */
	public void click_DisabledElement(WebElement element) {
		javascriptobj=(JavascriptExecutor) WebDriverLibrary.staticDriver;
		javascriptobj.executeScript("arguments[0].click();",element);
	}
	
	/**
	 * This Method is used to Scroll on WebPage
	 * 
	 */
	public void defaultVerticalScrollBy() {
		javascriptobj=(JavascriptExecutor) WebDriverLibrary.staticDriver;
		javascriptobj.executeScript("window.scrollBy(1000,1000);");
	}
	
	/**
	 * This Method is used to Scroll on WebPage
	 * 
	 */
	public void defaultVerticalScrollTo() {
		javascriptobj=(JavascriptExecutor) WebDriverLibrary.staticDriver;
		javascriptobj.executeScript("window.scrollTo(1000,1000);");
	}
	
	/**
	 * This Method is used to Scroll until the Element is visible
	 * 
	 * @param element
	 * @param value
	 */
	public void scrollUsingView(WebElement element, boolean value) {
		javascriptobj=(JavascriptExecutor) WebDriverLibrary.staticDriver;
		javascriptobj.executeScript("arguments[0].scrollIntoView("+value+");",element);
	}
}