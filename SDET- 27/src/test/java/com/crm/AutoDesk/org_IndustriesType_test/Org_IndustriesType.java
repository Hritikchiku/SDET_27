package com.crm.AutoDesk.org_IndustriesType_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Org_IndustriesType {

		public static void main(String[] args) throws IOException, Throwable, InvalidFormatException {
			FileInputStream fis =new FileInputStream("./data/commonData.property");
			Properties p = new Properties();
			p.load(fis);
			String URL = p.getProperty("url");
			String USERNAME = p.getProperty("username");
			String PASSWORD = p.getProperty("password");
			String BROWSER = p.getProperty("browser");
			Random ran = new Random();
			int randomNum = ran.nextInt(100);
			FileInputStream fis_e = new FileInputStream("./data/testData.xlsx");
			Workbook wb = WorkbookFactory.create(fis_e);
			Sheet sh = wb.getSheet("Sheet1");
			Row row = sh.getRow(4);
			String orgName = row.getCell(2).getStringCellValue()+randomNum ;
			String industries = row.getCell(3).getStringCellValue()+randomNum ;
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
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			WebElement ind = driver.findElement(By.name("industry"));
			Select s1= new Select(ind);
			s1.selectByVisibleText(industries);
	}

}
