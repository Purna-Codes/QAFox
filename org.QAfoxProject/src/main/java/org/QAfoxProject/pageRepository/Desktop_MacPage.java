package org.QAfoxProject.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class Desktop_MacPage {

	// Declaration of Web Element
	@FindBy(xpath = "//div[@class='product-thumb']//img")
	private WebElement produtImage;

	@FindBy(xpath = "//div[@class='col-sm-4']/h1")
	private WebElement productText;

	@FindBy(xpath = "//div[@class='col-sm-4']/descendant::a[contains(@href,'manufacturer')]")
	private WebElement productBrand;

	@FindBy(xpath = "//div[@class='col-sm-4']/descendant::li[contains(text(),'Code')]")
	private WebElement productCode;

	@FindBy(xpath = "//div[@class='col-sm-4']/descendant::h2")
	private WebElement productPrice;

	@FindBy(xpath = "//div[@class='col-sm-4']/descendant::li[contains(text(),'Ex')]")
	private WebElement productExPrice;
	
	@FindBy(css = "div#tab-description")
	private WebElement productDescription;

	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement quantityTextfield;

	@FindBy(css = "button#button-cart")
	private WebElement addToCartButton;

	// Initialization of WebElement Using Constructor
	public Desktop_MacPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the produtImage
	 */
	public WebElement getProdutImage() {
		return produtImage;
	}

	/**
	 * @return the productText
	 */
	public WebElement getProductText() {
		return productText;
	}

	/**
	 * @return the productBrand
	 */
	public WebElement getProductBrand() {
		return productBrand;
	}

	/**
	 * @return the productCode
	 */
	public WebElement getProductCode() {
		return productCode;
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

	/**
	 * @return the productDescription
	 */
	public WebElement getProductDescription() {
		return productDescription;
	}

	/**
	 * @return the quantityTextfield
	 */
	public WebElement getQuantityTextfield() {
		return quantityTextfield;
	}

	/**
	 * @return the addToCartButton
	 */
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	// Utilization of Web Element

}