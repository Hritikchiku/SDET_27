package com.crm.Autodesk.ObjectRepository;

import org.apache.xmlbeans.impl.common.SniffedXmlInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {    //creating separate class for homepage

	//step 1: identifing all webElement and Declearing them as private
	@FindBy (linkText = "Organizations")
	private WebElement orglnk;
	
	@FindBy (linkText = "Contacts")
	private WebElement contactslnk;
	
	@FindBy (linkText = "Products" )
	private WebElement productlnk;
	
	@FindBy (linkText = "Documents")
	private WebElement documentslnk;
	
	@FindBy (linkText = "More")
	private WebElement morelnk;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signoutlnk;
	
	//intialization 
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrglnk() {
		return orglnk;
	}

	public WebElement getContactslnk() {
		return contactslnk;
	}

	public WebElement getProductlnk() {
		return productlnk;
	}

	public WebElement getDocuments() {
		return documentslnk;
	}

	public WebElement getMorelnk() {
		return morelnk;
	}
	
	public WebElement getAdministrator() {
		return administratorImg;
	}
	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	
	//business library for org
	public void clickOnOrganizationsLnk() {
		orglnk.click();
	}
	//business library for contacts
	public void clickOnContactslnk() {
		contactslnk.click();
	}
	//business library for Product
	public void clickOnProductlnk() {
		productlnk.click();
	}
	//business library for Documents
	public void clickOnDocumentslnk()
	{
		documentslnk.click();
	}
	//business library for More
	public void clickOnMorelnk() {
		morelnk.click();
	}
	//business library for Administrator
	public void clickOnAdministratorAndSingOut(WebDriver driver) {
		
		mouseOverOnElemnet(driver , administratorImg);
		signoutlnk.click();
	}


}
