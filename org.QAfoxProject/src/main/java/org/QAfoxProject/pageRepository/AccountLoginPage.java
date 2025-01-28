package org.QAfoxProject.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class AccountLoginPage {

	// Declaration of Web Element
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAdd_TextField;

	@FindBy(css = "#input-password")
	private WebElement password_TextField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;

	@FindBy(partialLinkText = "Forgotten")
	private WebElement forgotPasswordButton;

	// Initialization of WebElement Using Constructor
	public AccountLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization of Web Element
	/**
	 * @return the emailAdd_TextField
	 */
	public WebElement getEmailAdd_TextField() {
		return emailAdd_TextField;
	}

	/**
	 * @return the password_TextField
	 */
	public WebElement getPassword_TextField() {
		return password_TextField;
	}

	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
		return loginButton;
	}

	/**
	 * @return the forgotPasswordButton
	 */
	public WebElement getForgotPasswordButton() {
		return forgotPasswordButton;
	}

}