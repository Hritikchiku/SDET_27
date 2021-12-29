package com.crm.Autodesk.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.LoginPage;

public class BaseClass {
	public DataBaseUtility dlib = new DataBaseUtility();
	public ExcelUtility elib = new ExcelUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver;
	
	//@BeforeSuite is use for Connect the DataBase.
	@BeforeSuite
	public void dbConnection() {
		dlib.conectToDB();
		System.out.println("======Database is Connected=====");
	}
	
	//@BeforeClass is use for launching the Browser 
	@BeforeClass 
	public void launchBrowser () throws Throwable 
	{
		String BROWSER = flib.getPropertykeyValue("browser");
		String URL = flib.getPropertykeyValue("url");
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		wlib.waitForPageToLoad(driver);
		wlib.maximizeWindow(driver);
		driver.get(URL);
	}
	
	//@BeforeMethod is method is use to login the application.
	@BeforeMethod
	public void loginToApp() throws Throwable {
		String USERNAME = flib.getPropertykeyValue("username");
		String PASSWORD = flib.getPropertykeyValue("password");
		
		LoginPage lp= new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("=====Login SuccessFull=====");
	}
	
	//@AfterMethod is used to logout the application.
	@AfterMethod
	public void logoutfOfApp() {
		HomePage hp = new HomePage (driver);
		hp.clickOnAdministratorAndSingOut(driver);
		System.out.println("=====LogOut SuccessFull=====");
	}
	
	//@AfterClass is use to close or quit.
	@AfterClass
	public void closeBrowser () {
		driver.close();
		System.out.println("=====Browser Closed=====");
	}
	
	//@AfterSuite is use to closed the DB connection.
	@AfterSuite
	public void closeDBconnection() {
		dlib.closeDB();
		System.out.println("=====Data Base Connnection is Closed=====");
	}
	
		
	}
	

