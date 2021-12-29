package com.crm.Autodesk.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developing using Apache POI libraries , which is use to handle Microsoft Excel Sheet
 * @author HRITIK
 *
 */
public class ExcelUtility {
	/**
	 * It is used to read data from Excel based on below Argument.
	 * @param sheetName
	 * @param rowName
	 * @param cellNum
	 * @param Data
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum , int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data=row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * used to get the last used row number on specified sheet
	 * @param sheetName
	 * @throws Throwable 
	 */
		public int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis = new FileInputStream("./data/testData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			wb.close();
			return sh.getLastRowNum();
		}
		
		public void setDataExcel(String sheetName, int rowNum, int cellNum,String data) throws Throwable {
			FileInputStream fis = new FileInputStream("./data/testData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream("./data/testData.xlsx");
			wb.write(fos);
			wb.close();
			
	}

}
