package org.QAfoxProject.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *  
 */

public class HomePage {

	@FindBy(xpath = "//i[@class='fa fa-phone']")
	private WebElement contactUsButton;

	@FindBy(css = "#wishlist-total")
	private WebElement wishListIcon;

	@FindBy(xpath = "//a[contains(@title,'Cart')]")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//a[@title='Checkout']")
	private WebElement checkoutsButton;

	@FindBy(xpath = "//li/a[contains(text(),'Mac ')]")
	private WebElement desktop_mac_headerText;

	@FindBy(xpath = "//li/a[contains(text(),'PC')]")
	private WebElement desktop_pc_headerText;

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccount_headerlink;

	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//a[text()='Register']")
	private WebElement register_headerlink;

	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//a[text()='Login']")
	private WebElement login_headerlink;

	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//a[text()='Logout']")
	private WebElement logout_headerlink;

	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//a[text()='Downloads']")
	private WebElement download_headerlink;

	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//a[text()='Transactions']")
	private WebElement transactions_headerlink;

	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//a[text()='Order History']")
	private WebElement orderHistory_headerlink;

	@FindBy(xpath = "//div[@id='search']/input")
	private WebElement searchTextField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	@FindBy(linkText = "Desktops")
	private WebElement desktop_headerText;

	@FindBy(partialLinkText = "Laptops")
	private WebElement laptopsAndNoteBooks;

	@FindBy(linkText = "Components")
	private WebElement components;

	@FindBy(linkText = "Tablets")
	private WebElement tablets;

	@FindBy(linkText = "Software")
	private WebElement software;

	@FindBy(partialLinkText = "Phone")
	private WebElement phonesAndPDAs;

	@FindBy(linkText = "Cameras")
	private WebElement cameras;

	@FindBy(partialLinkText = "MP3")
	private WebElement mp3Players;

	@FindBy(xpath = "//div[@id='cart']/button")
	private WebElement cartButton;
	
	
	@FindBy(xpath = "//div[@id='cart']/ul/descendant::p/a[contains(@href,'cart')]")
	private WebElement viewCartButton;

	/**
	 * @return the viewCartButton
	 */
	public WebElement getViewCartButton() {
		return viewCartButton;
	}

	/**
	 * @return the wishListIcon
	 */
	public WebElement getWishListIcon() {
		return wishListIcon;
	}

	/**
	 * @return the shoppingCartIcon
	 */
	public WebElement getShoppingCartIcon() {
		return shoppingCartIcon;
	}

	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement alertText;

	@FindBy(xpath = "//div[@class=\"pull-right\"]/a")
	private WebElement finalCheckoutButton;

	/**
	 * @return the finalCheckoutButton
	 */
	public WebElement getFinalCheckoutButton() {
		return finalCheckoutButton;
	}

	/**
	 * 
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the contactUsButton
	 */
	public WebElement getContactUsButton() {
		return contactUsButton;
	}

	/**
	 * @return the myAccount_leaderlink
	 */
	public WebElement getMyAccount_headerlink() {
		return myAccount_headerlink;
	}

	/**
	 * @return the register_headerlink
	 */
	public WebElement getRegister_headerlink() {
		return register_headerlink;
	}

	/**
	 * @return the login_link
	 */
	public WebElement getLogin_headerlink() {
		return login_headerlink;
	}

	/**
	 * @return the logout_headerlink
	 */
	public WebElement getLogout_headerlink() {
		return logout_headerlink;
	}

	/**
	 * @return the download_headerlink
	 */
	public WebElement getDownload_headerlink() {
		return download_headerlink;
	}

	/**
	 * @return the transactions_headerlink
	 */
	public WebElement getTransactions_headerlink() {
		return transactions_headerlink;
	}

	/**
	 * @return the orderHistory_headerlink
	 */
	public WebElement getOrderHistory_headerlink() {
		return orderHistory_headerlink;
	}

	/**
	 * @return the checkoutsButton
	 */
	public WebElement getCheckoutsButton() {
		return checkoutsButton;
	}

	/**
	 * @return the searchTextField
	 */
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	/**
	 * @return the searchButton
	 */
	public WebElement getSearchButton() {
		return searchButton;
	}

	@FindBy(css = "#cart-total")
	private WebElement addToCartButton;

	/**
	 * @return the addToCartButton
	 */
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	/**
	 * @return the desktop_headerText
	 */
	public WebElement getDesktop_headerText() {
		return desktop_headerText;
	}

	/**
	 * @return the laptopsAndNoteBooks
	 */
	public WebElement getLaptopsAndNoteBooks() {
		return laptopsAndNoteBooks;
	}

	/**
	 * @return the components
	 */
	public WebElement getComponents() {
		return components;
	}

	/**
	 * @return the tablets
	 */
	public WebElement getTablets() {
		return tablets;
	}

	/**
	 * @return the software
	 */
	public WebElement getSoftware() {
		return software;
	}

	/**
	 * @return the phonesAndPDAs
	 */
	public WebElement getPhonesAndPDAs() {
		return phonesAndPDAs;
	}

	/**
	 * @return the cameras
	 */
	public WebElement getCameras() {
		return cameras;
	}

	/**
	 * @return the mp3Players
	 */
	public WebElement getMp3Players() {
		return mp3Players;
	}

	/**
	 * @return the desktop_mac_headerText
	 */
	public WebElement getDesktop_mac_headerText() {
		return desktop_mac_headerText;
	}

	/**
	 * @return the desktop_pc_headerText
	 */
	public WebElement getDesktop_pc_headerText() {
		return desktop_pc_headerText;
	}



	/**
	 * @return the cartButton
	 */
	public WebElement getCartButton() {
		return cartButton;
	}

	/**
	 * @return the alertText
	 */
	public WebElement getAlertText() {
		return alertText;
	}

}