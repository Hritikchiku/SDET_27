package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrgnizationPage {//creteating seperate class for create org page
	@FindBy(xpath= "//img[@alt='Create Organization...']")
	private WebElement orglookupImg;
	

	@FindBy (name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveNowBtn;
	
	//initilization
	public createOrgnizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOrglookupImg() {
		return orglookupImg;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveNowBtn() {
		return saveNowBtn;
	}
	
	//busisnes libarary for click on Orglookup
	public void clickOnCreateOrgLookup() {
		orglookupImg.click();
	}
	
	//busisnes libarary for click on Orglookup
	public void orgNamebtn(String orgName) {
	orgNameEdt.sendKeys(orgName);
	saveNowBtn.click();
	}
}
