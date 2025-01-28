package org.QAfoxProject.registerAccount;

import org.QAfoxProject.genericUtility.BaseConfiguration;
import org.QAfoxProject.genericUtility.WebDriverLibrary;
import org.QAfoxProject.pageRepository.RegisterAccountPage;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.QAfoxProject.listenerFeature.ListenerImplementation.class)
public class RegisterAccountTest extends BaseConfiguration {

	@Test(retryAnalyzer = org.QAfoxProject.listenerFeature.ListenerImplementation.class)
	public void verifyWithValidInput() {
		
		RegisterAccountPage registerAccountPage = new RegisterAccountPage(WebDriverLibrary.staticDriver);
		registerAccountPage.getFirstNameTextField().sendKeys("HelloUser1");
		registerAccountPage.getLastNameTextField().sendKeys("Qspiders");
		registerAccountPage.getEmailTextField().sendKeys("qspuser1@gmail.com");
		registerAccountPage.getTelephoneTextField().sendKeys("1234567890");
		registerAccountPage.getPasswordTextField().sendKeys("User@123");
		registerAccountPage.getConfirmPasswordTextField().sendKeys("User@123");
		registerAccountPage.getYesRadioButton().click();
		registerAccountPage.getYesRadioButton().click();
		registerAccountPage.getTermsConditionCheckBox().click();
		registerAccountPage.getContinueButton().click();
		
		// Test Log
		Reporter.log("RegisterAccount Verified With Valid Input", true);
		// Assert.assertTrue(false);
	}

	@Test(retryAnalyzer = org.QAfoxProject.listenerFeature.ListenerImplementation.class)
	public void verifyWithInvalidInput() {
		// Test Log
		Reporter.log("RegisterAccount Verified With Invalid Input", true);
	}
}