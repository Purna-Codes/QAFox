package org.QAfoxProject.desktops;

import org.QAfoxProject.genericUtility.BaseConfiguration;
import org.QAfoxProject.pageRepository.HomePage;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Desktops_PC_Test extends BaseConfiguration {

	@Test
	public void addProduct_Desktops_PC() {

		// Create The Test Information
		test = super.report.createTest("Verify-AddProduct_Desktops_PC");

		HomePage homeObj = new HomePage(webDriverObj.driver);

		// Perform Mouse Hover Action--->DeskTop
		webDriverObj.mouseHoverToElement(homeObj.getDesktop_headerText());
		test.log(Status.PASS, "Step 1: Perform mouse Hover Action-Desktop");

		javaUtilityObj.pause(1500);

		// Perform Mouse Hover Action--->PC
		webDriverObj.mouseHoverToElement(homeObj.getDesktop_pc_headerText());
		test.log(Status.PASS, "Step 2.1: Perform mouse Hover Action-PC");

		javaUtilityObj.pause(1500);

		// Perform Click Action
		homeObj.getDesktop_pc_headerText().click();
		test.log(Status.PASS, "Step 2.2: Perform Click Action-PC");

		javaUtilityObj.pause(1500);

//		Assert.fail();

		test.log(Status.INFO, "Desktops_PC_Product Added Successful");
		
	}
}