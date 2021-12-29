package com.crm.AutoDesk.ContactsWithOrg_test;

import java.io.FileInputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crm.Autodesk.GenericUtility.BaseClass;
public class ContactwithOrg extends BaseClass{

	
@Test
	public void ContactwithOrg_Test () throws Throwable{
//		WebDriverUtility wlib = new WebDriverUtility();
//		FileInputStream fis =new FileInputStream("./data/commonData.property");
//		Properties p = new Properties();
//		p.load(fis);
//		String URL = p.getProperty("url");
//		String USERNAME = p.getProperty("username");
//		String PASSWORD = p.getProperty("password");
//		String BROWSER = p.getProperty("browser");
		Random ran = new Random();
		int randomNum = ran.nextInt(100);
		FileInputStream fis_e = new FileInputStream("./data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis_e);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).getStringCellValue()+randomNum ;
		String lastNam = row.getCell(3).getStringCellValue()+randomNum;
//		WebDriver driver;
//		if(BROWSER.equals("firefox")) {
//			driver= new FirefoxDriver();
//		}
//		else if(BROWSER.equals("chrome")){
//			driver= new ChromeDriver();
//		}
//		else if(BROWSER.equals("ie")){
//			driver= new InternetExplorerDriver();
//		}
//		else {
//			driver= new ChromeDriver();
//		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("SubmitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//wait for Element to be active
		WebDriverWait wait  = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastNam);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
//		Set<String> set2 = driver.getWindowHandles();
//	    Iterator<String> it = set2.iterator();
//		while(it.hasNext()) {
//			String currid=it.next();
//			driver.switchTo().window(currid);
//			String currPageTitelString = driver.getTitle();
//			if(currPageTitelString.contains("Accounts"));
//			{
//				break;
//			}
//		}
		wlib.swithToWindow(driver, "Accounts");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
//		Set<String> set1 = driver.getWindowHandles();
//	Iterator<String> it1 = set1.iterator();
//		while(it.hasNext()) {
//			String currid=it1.next();
//			driver.switchTo().window(currid);
//			String currPageTitelString = driver.getTitle();
//			if(currPageTitelString.contains("Contacts"));
//			{
//				break;
//			}
//		}
		wlib.swithToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println(orgName+"is succesfull created---------PASS");
		
		//logout;
		WebElement singout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElemnet(driver, singout);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
