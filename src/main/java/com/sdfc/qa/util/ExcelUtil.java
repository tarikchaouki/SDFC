package com.sdfc.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;

import com.sdfc.qa.base.TestBase;


public class ExcelUtil extends TestBase {
	
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet  ;
	
	
	
	public ExcelUtil() {
		
		 
	     this.driver = driver ;
  	     PageFactory.initElements(driver,this);
	}

  public ExcelUtil(String excelpath, String sheetName) {
	
       try {  
    	  
			  workbook =  new XSSFWorkbook(excelpath);
			  sheet = workbook.getSheet(sheetName);
					
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
         this.driver = driver ;
	     PageFactory.initElements(driver,this);
	}
	
public static  int getRowCount() {
	
	int rowCount = 0 ;
		
		try {
		rowCount = sheet.getPhysicalNumberOfRows();
		  System.out.println(rowCount);
			
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		return rowCount;
	}
	
public static int  getColCount() {
		
	int colCount=0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		return colCount;
	}

public static  String  getCellDataString(int rowNum, int colNum) {
		
	String cellData =null;
		try {
			
		    cellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		catch(Exception e) {
		       e.printStackTrace();
		}
		return cellData;
	}
	
public static  void getCellDataNumber(int rowNum, int colNum ) {
			
			try {
				
			    double cellData= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			}
			catch(Exception e) {
			       e.printStackTrace();
			}
			
}
			public static   Object [][] testData(String excelPath ,String sheetName) {
				  
				//ExcelUtil excel = new ExcelUtil(excelPath, sheetName);
				
				int r= getRowCount();
				int colCount = getColCount();
			    Object da[][] = new Object [r-1][colCount];
				
				for (int i =1 ;i<r; i++) {
					
					for(int j =0 ; j <colCount;j++) {
						
						String cellData = getCellDataString(i, j);
						da[i-1][j]= cellData;
					}
				}
					return da;
}


	
	
	
		

}		
		
	


