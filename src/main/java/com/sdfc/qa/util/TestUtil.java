package com.sdfc.qa.util;

import java.util.List;
import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sdfc.qa.base.TestBase;


public class TestUtil extends TestBase {
	  
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 10;
	Select select ;
	

	public TestUtil () {
		
       
   	     this.driver = driver ;
   	     PageFactory.initElements(driver,this);
   }
	
	
	public void VerifyElementClick(WebElement obj) {
		
		System.out.println( "the element " +   obj  +  " is it displayed :" +  obj.isDisplayed());
		obj.click();
		
	}       
	   
	public void WindowHandler() throws InterruptedException {
		
		  Set<String> handler = driver.getWindowHandles();
	      Iterator<String> it = handler.iterator();
		  String parentwindowId = it.next();
		  System.out.println("window id "+ parentwindowId);
		  String childwindowId = it.next();
		  System.out.println("window id "+ childwindowId);
		  driver.switchTo().window(childwindowId);
		  Thread.sleep(2000);
		  System.out.println("child window pop up " + driver.getTitle());
		  driver.close();
		  driver.switchTo().window(parentwindowId);
		  Thread.sleep(2000);
		  System.out.println("parent window appears " + driver.getTitle());
		
	}
	
	public void SwitchToFrame() {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		System.out.println("new Frame");
		//driver.switchTo().parentFrame();
		
		
	}
		
	public void SwitchToFrame2() {
		
		driver.switchTo().frame(0);
	    System.out.println("new Frame");
		
		
	}
	
	public void SelectElement (WebElement obj,String text) {
		
	   Select select = new Select(obj);
	   select.selectByVisibleText(text);
	   //select.selectByValue(text);
	
	}
	
	public void SelecAllOptions(WebElement obj) {
		
		 Select select = new Select(obj);
		 //System.out.println(" the list , is it  multiple : " + select.isMultiple());
		 List<WebElement> listOptions = select.getOptions();
		 System.out.println("the size of the list is : " + listOptions.size());
		
		  for( WebElement e :listOptions) {
			System.out.println(e.getText());
			
		}
	}
	


}

	
