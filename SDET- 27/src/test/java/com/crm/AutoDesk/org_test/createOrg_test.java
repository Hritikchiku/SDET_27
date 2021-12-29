package com.crm.AutoDesk.org_test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.Autodesk.GenericUtility.BaseClass;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.createOrgnizationPage;

public class createOrg_test extends BaseClass{
	@Test
	public void createOrg_Test() throws Throwable {

		int ranDom = jlib.getRandomNumber();

		String orgName = elib.getDataFromExcel("Sheet1", 1, 2)+ranDom;

		HomePage hp  = new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		Reporter.log("click on OrganizationsLnk",true);

		createOrgnizationPage cop = new createOrgnizationPage(driver);
		cop.clickOnCreateOrgLookup();
		cop.orgNamebtn(orgName);
		Reporter.log("create Organizations",true);

		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String actSuc_msg = oip.getOrgInfo();
		System.out.println(actSuc_msg);
		if(actSuc_msg.contains(orgName)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}

		hp.clickOnAdministratorAndSingOut(driver);
	}
}
