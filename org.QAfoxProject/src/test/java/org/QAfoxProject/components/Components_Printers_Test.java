package org.QAfoxProject.components;

import org.QAfoxProject.genericUtility.BaseConfiguration;
import org.testng.annotations.Test;

public class Components_Printers_Test extends BaseConfiguration {

	@Test
	public void verify_Components_Printers() {

		// Initialize the Extent Test
		test = report.createTest("Verify-Verify_Components_Printers");

		propertyFileObj.initPropertyFile();
		String browser = propertyFileObj.readProperty("browser");

		System.out.println(browser);

//		propertyFileObj.writeProperty("abc", "def");
		propertyFileObj.closePropertyFile();

		// Create An Instance For Desktop POM Class

		// Verify Components is Displayed Or Not

		// Verify Components is Displayed Or Not

		// Perform Mouse Hover Action--->Component

		// Verify Printer is Displayed Or Not

		// Verify Printer is Enabled Or Not

		// Perform Mouse Hover Action--->Printers

		// Perform click Action

		// Verify Title of the WebPage

		// Verify URL of the WebPage

		// Fetch Header Text of the WebPage

		// Verify Header Text of the WebPage--->Printers

		// Fetch Header Description of the WebPage

		// Fetch The TagName Of the Header Text

		// Fetch The Dimension Of the Header Text

		// Verify Components is Displayed Or Not

		// Verify Components is Displayed Or Not

		// Perform click Action

	}
}
