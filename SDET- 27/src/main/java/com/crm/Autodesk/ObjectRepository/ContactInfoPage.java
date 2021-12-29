package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//Decleartions
		@FindBy (xpath= "//span[@class='dvHeaderText']")
		private WebElement conHeaderText;
		
		//intialization
		public ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getConHeaderText() {
			return conHeaderText;
		}
		
		//busisnes library
		public String getOrgInfo () {
			return (conHeaderText.getText());
		}

	
}
