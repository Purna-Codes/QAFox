package org.QAfoxProject.desktops;

import org.QAfoxProject.genericUtility.BaseConfiguration;
import org.QAfoxProject.pageRepository.Desktop_MacPage;
import org.QAfoxProject.pageRepository.HomePage;
import org.QAfoxProject.pageRepository.ShoppingCartPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Desktops_Mac_Test extends BaseConfiguration {
	
	@Test
	public void addProduct_Desktops_Mac() {

		test = report.createTest("Verify-AddProduct_Desktops_Mac");

		HomePage homeObj = new HomePage(webDriverObj.driver);

		// Perform Mouse Hover Action--->DeskTop
		webDriverObj.mouseHoverToElement(homeObj.getDesktop_headerText());
		test.log(Status.PASS, "Step 1: Perform mouse Hover Action-Desktop");

		javaUtilityObj.pause(1500);

		// Perform Mouse Hover Action--->Mac
		webDriverObj.mouseHoverToElement(homeObj.getDesktop_mac_headerText());
		test.log(Status.PASS, "Step 2.1: Perform mouse Hover Action-Mac");

		javaUtilityObj.pause(1500);

		// Perform click Action
		homeObj.getDesktop_mac_headerText().click();
		test.log(Status.PASS, "Step 2.2: Perform Click Action-Mac");

		Desktop_MacPage macPageObj = new Desktop_MacPage(webDriverObj.driver);

		macPageObj.getProdutImage().click();
		test.log(Status.PASS, "Step 3: Perform Click Action-Mac Product");

		String productText = macPageObj.getProductText().getText();
		Reporter.log("Product Name: " + productText,true);
		test.log(Status.PASS, "Step 4: Fetch The Product Text");

		String productBrand = macPageObj.getProductBrand().getText();
		Reporter.log("Product Brand: " + productBrand,true);
		test.log(Status.PASS, "Step 5: Fetch The Product Brand");

		String productCode = macPageObj.getProductCode().getText().split(":")[1];
		Reporter.log("Product Code: " + productCode,true);
		test.log(Status.PASS, "Step 6: Fetch The Product Code");

		String productPrice = macPageObj.getProductPrice().getText();
		Reporter.log("Product Price: " + productPrice,true);
		test.log(Status.PASS, "Step 7: Fetch The Product Price");

		String productExPrice = macPageObj.getProductExPrice().getText().split(":")[1];
		Reporter.log("Product ExPrice: " + productExPrice,true);
		test.log(Status.PASS, "Step 8: Fetch The Product Ex Price");
		
		String productDescription = macPageObj.getProductDescription().getText();
		Reporter.log("Product Description: " + productDescription,true);
		test.log(Status.PASS, "Step 9: Fetch The Product Description");

		macPageObj.getQuantityTextfield().clear();
		test.log(Status.PASS, "Step 10: Clear the Quantity");

		String qty = "10";

		macPageObj.getQuantityTextfield().sendKeys(qty);
		test.log(Status.PASS, "Step 11: Enter The Required Quantity");

		macPageObj.getAddToCartButton().click();
		test.log(Status.PASS, "Step 12: Perform Click Action-Add To Cart Button");

		homeObj.getCartButton().click();
		test.log(Status.PASS, "Step 13: Perform Click Action-Cart Button");

		webDriverObj.waitUntilElementFound(homeObj.getViewCartButton());

		homeObj.getViewCartButton().click();
		test.log(Status.PASS, "Step 14: Perform Click Action-View Cart Button");

		webDriverObj.waitUntilElementFound(homeObj.getAlertText());

		System.out.println(homeObj.getAlertText().getText());
		test.log(Status.PASS, "Step 15: Perform Click Action-View Cart Button");

		ShoppingCartPage cartPageObj = new ShoppingCartPage(webDriverObj.driver);

		Assert.assertEquals(cartPageObj.getProductName().getText(), productText);
		test.log(Status.PASS, "Step 16: Verify Product Name");
		
		Assert.assertEquals(cartPageObj.getProductModel().getText(), productCode);
		test.log(Status.PASS, "Step 17: Verify Product Model");
		
		Assert.assertEquals(cartPageObj.getProductPrice().getText(), productPrice);
		test.log(Status.PASS, "Step 18: Verify Product Unit Price");
		
		Assert.assertEquals(cartPageObj.getProductQty().getDomAttribute("value"), qty);
		test.log(Status.PASS, "Step 19: Verify Product Quantity");

		homeObj.getFinalCheckoutButton().click();
		test.log(Status.PASS, "Step 20: Perform Click Action-CheckOutButton");
		
		String alertText = homeObj.getAlertText().getText();
		Reporter.log("Warning: "+alertText,true);
		test.log(Status.PASS, "Step 21: Fetch The AlertText");

		test.log(Status.INFO, "Desktops_Mac_Product Checked Out Successfully");

	}
}