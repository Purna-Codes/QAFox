package org.QAfoxProject.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *  
 */
public class RegisterAccountPage {

	// Declaration of Web Element
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTextField;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastNameTextField;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailTextField;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement telephoneTextField;

	@FindBy(xpath = "//input[contains(@id,'password')]")
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[contains(@name,'confirm')]")
	private WebElement confirmPasswordTextField;

	@FindBy(xpath = "//label[text()='Yes']/input")
	private WebElement yesRadioButton;

	@FindBy(xpath = "//label[text()='No']/input")
	private WebElement noRadioButton;

	@FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
	private WebElement termsConditionCheckBox;

	@FindBy(css = ".btn.btn-primary")
	private WebElement continueButton;

	/**
	 * @param driver
	 */
	// Initialization of WebElement Using Constructor
	public RegisterAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Utilization of Web Element

	/**
	 * @return the firstNameTextField
	 */
	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	/**
	 * @return the lastNameTextField
	 */
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	/**
	 * @return the emailTextField
	 */
	public WebElement getEmailTextField() {
		return emailTextField;
	}

	/**
	 * @return the telephoneTextField
	 */
	public WebElement getTelephoneTextField() {
		return telephoneTextField;
	}

	/**
	 * @return the passwordTextField
	 */
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	/**
	 * @return the confirmPasswordTextField
	 */
	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	/**
	 * @return the yesRadioButton
	 */
	public WebElement getYesRadioButton() {
		return yesRadioButton;
	}

	/**
	 * @return the noRadioButton
	 */
	public WebElement getNoRadioButton() {
		return noRadioButton;
	}

	/**
	 * @return the termsConditionCheckBox
	 */
	public WebElement getTermsConditionCheckBox() {
		return termsConditionCheckBox;
	}

	/**
	 * @return the continueButton
	 */
	public WebElement getContinueButton() {
		return continueButton;
	}

}