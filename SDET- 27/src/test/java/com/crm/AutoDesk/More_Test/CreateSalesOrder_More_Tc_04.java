package com.crm.AutoDesk.More_Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.Autodesk.GenericUtility.ExcelUtility;
import com.crm.Autodesk.GenericUtility.FileUtility;
import com.crm.Autodesk.GenericUtility.JavaUtility;
import com.crm.Autodesk.GenericUtility.WebDriverUtility;

public class CreateSalesOrder_More_Tc_04 {
	public static void main(String[] args) throws IOException, Throwable, InvalidFormatException {
	ExcelUtility elib = new ExcelUtility ();
	FileUtility flib = new FileUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib= new WebDriverUtility ();
	

	String URL =flib.getPropertykeyValue("url");
	String USERNAME =flib.getPropertykeyValue("username");
	String PASSWORD = flib.getPropertykeyValue("password");
	String BROWSER =flib.getPropertykeyValue("browser");
    int randomNum = jlib.getRandomNumber();
//    Random ran = new Random();
//	int randomNum = ran.nextInt(100);		
	
    String subject = elib.getDataFromExcel("more", 1, 0)+randomNum;
    String billingAdd = elib.getDataFromExcel("more", 1, 2);
    String shipingAdd = elib.getDataFromExcel("more", 1, 3);
    String orgName = elib.getDataFromExcel("Sheet1", 1, 2);
    String SelectStatus = elib.getDataFromExcel("more", 2, 4);
    String InvoiceStatus = elib.getDataFromExcel("more", 1, 5);
//    String Qty = elib.getDataFromExcel("more", 1, 6);
    String Radio= elib.getDataFromExcel("more", 1, 7);
    String Product= elib.getDataFromExcel("more", 1, 8);
    
//    FileInputStream fis_e = new FileInputStream("./data/testData.xlsx");
//	Workbook wb = WorkbookFactory.create(fis_e);
//	Sheet sh = wb.getSheet("more");
//	Row row = sh.getRow(1);
//	String subject = row.getCell(0).getStringCellValue()+randomNum ;
    
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
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.linkText("More"))).perform();
	driver.findElement(By.name("Sales Order")).click();
	driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
	driver.findElement(By.name("subject")).sendKeys(subject);
	
	WebElement status = driver.findElement(By.name("sostatus"));
	wlib.select(status, SelectStatus);
	
//	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
//	wlib.swithToWindow(driver, "Accounts");
//	driver.findElement(By.id("search_txt")).sendKeys(orgName);
//	driver.findElement(By.name("search")).click();
//	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
//	
//	
//	wlib.swithToWindow(driver, "SalesOrder");
	
//driver.findElement(By.name("assigntype")).sendKeys(Radio);
//wlib.select(status, Radio);
	
	
	
	driver.findElement(By.name("bill_street")).sendKeys(billingAdd);
	driver.findElement(By.name("ship_street")).sendKeys(shipingAdd);
	
	WebElement invStatus = driver.findElement(By.name("invoicestatus"));
	wlib.select(invStatus, InvoiceStatus);
	
	
driver.findElement(By.id("searchIcon1")).click();
wlib.swithToWindow(driver, "Products");
driver.findElement(By.id("search_txt")).sendKeys(Product);
driver.findElement(By.name("search")).click();
driver.findElement(By.xpath("//a[text()='"+Product+"']")).click();
wlib.swithToWindow(driver, "SalesOrder");
	
//	driver.findElement(By.id("qty1")).sendKeys(Qty);
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//logout;
		WebElement singout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElemnet(driver, singout);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
}

}



