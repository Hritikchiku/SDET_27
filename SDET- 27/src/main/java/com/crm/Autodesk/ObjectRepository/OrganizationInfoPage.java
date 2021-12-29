package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {//creating separate class for OrganizationInfoPage

	//Decleartions
	@FindBy (xpath= "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	//intialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//busisnes library
	public String getOrgInfo () {
		return (orgHeaderText.getText());
	}
}
