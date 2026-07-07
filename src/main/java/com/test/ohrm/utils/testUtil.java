package com.test.ohrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.test.ohrm.base.TestBase;

public class testUtil extends TestBase{
	
	public static long Implicit_wait = 10;
	public static String testSheetPath = "C:\\Users\\lenovo\\eclipse-workspace\\MiscLearning\\"
			+ "src\\main\\java\\com\\test\\ohrm\\tesdata\\ohrmtestdata.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public testUtil() {
		
	}
	
	public void handleAlert() {
		
		Alert alert= driver.switchTo().alert(); 
		alert.accept();		
	}
	
	public void takeScreenSnippet() throws IOException {
	
	TakesScreenshot ss = (TakesScreenshot)driver;
	File screensnip = ss.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screensnip, new File("C:\\\\Users\\\\lenovo\\\\eclipse-workspace\\\\MiscLearning\\\\Screenshots\\\\snipper1.jpg"));
	
	}
	
	public static Object[][] getTestData(String sheetName) {
	    FileInputStream file = null;
	    try {
	        file = new FileInputStream(testSheetPath);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	    try {
	        book = WorkbookFactory.create(file);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    sheet = book.getSheet(sheetName);
	    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    // System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());

	    for (int i = 0; i < sheet.getLastRowNum(); i++) {
	        for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	            data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	            // System.out.println(data[i][k]);
	        }
	    }
	    return data;
	}
	
	

}