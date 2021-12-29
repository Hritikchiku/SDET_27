package com.crm.AutoDesk.ContactsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.Autodesk.GenericUtility.BaseClass;
import com.crm.Autodesk.ObjectRepository.HomePage;
//
//public class createContacts_Test extends BaseClass{
//	@Test
//	public void createContacts_Test() {
/*
		int ranDom = jlib.getRandomNumber();
		String orgName = elib.getDataFromExcel("Sheet1", 4, 2)+ranDom;

		HomePage hp  = new HomePage(driver);
		hp.clickOnContactslnk();
		Reporter.log("click on contact link");
		
		WebDriver driver;
		if(BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome")){
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("ie")){
			driver= new InternetExplorerDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("SubmitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actSuc_msg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actSuc_msg.contains(orgName)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
	}

}
*/
