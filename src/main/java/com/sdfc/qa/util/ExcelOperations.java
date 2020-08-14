package com.sdfc.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;

import com.sdfc.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class ExcelOperations  extends TestBase{
    
	
	
	     String FilePath ;
	     Sheet sh ;
	   
	 
	     
	   public ExcelOperations(String sheetName){   
	     
		  try { 
		 FilePath = "C:\\Users\\calci\\eclipse-workspace\\SFDC\\src\\main\\java\\java\\com\\project\\qa\\testdata\\juve.xlsx"; 
		  }catch(Exception e ) {
			  
			  e.printStackTrace();
		  }
		 
		 File testDataFile = new File(FilePath);
	     Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		  
	       sh = wb.getSheet(sheetName);
	     
	   }
	   
	  
	    public HashMap<String, String> getDataInMap(int rowNum) throws  Exception {
	    	
	    	HashMap<String, String> hm = new HashMap<String,String>();
	    	
	    	 for (int i =0; i < sh.getRow(0).getLastCellNum();i++) {
	    		 sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
	    	hm.put(sh.getRow(0).getCell(i).toString(),sh.getRow(rowNum).getCell(i).toString());
	    	
	    	 }
	    	 return hm;
	    }
	    
	    public int  getRowCount() {
	    	
        return sh.getLastRowNum();
	        
	        
			
		}
	      
	    public  int getColCount() {
	    	 
	    	return sh.getRow(0).getLastCellNum();
		
		}
}        
