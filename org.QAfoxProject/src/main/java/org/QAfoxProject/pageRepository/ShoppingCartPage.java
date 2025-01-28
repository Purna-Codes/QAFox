package org.QAfoxProject.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class ShoppingCartPage {

	// Declaration of Web Element
	@FindBy(xpath = "//form[@method=\"post\"]//td[@class=\"text-left\"]//a")
	private WebElement productName;

	@FindBy(xpath = "//div[@class=\"table-responsive\"]/descendant::tr[2]/td[3]")
	private WebElement productModel;

	@FindBy(xpath = "//input[contains(@name,'quantity')]")
	private WebElement productQty;

	@FindBy(xpath = "//div[@class=\"table-responsive\"]//tbody//td[5]")
	private WebElement productPrice;
	
	@FindBy(xpath = "//div[@class=\"table-responsive\"]//tbody//td[6]")
	private WebElement productExPrice;

	/**
	 * @return the productName
	 */
	public WebElement getProductName() {
		return productName;
	}

	/**
	 * @return the productModel
	 */
	public WebElement getProductModel() {
		return productModel;
	}

	/**
	 * @return the productQty
	 */
	public WebElement getProductQty() {
		return productQty;
	}

	/**
	 * @return the productPrice
	 */
	public WebElement getProductPrice() {
		return productPrice;
	}

	/**
	 * @return the productExPrice
	 */
	public WebElement getProductExPrice() {
		return productExPrice;
	}

	// Initialization of WebElement Using Constructor
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization of Web Element
	
}