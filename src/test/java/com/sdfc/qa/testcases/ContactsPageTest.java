package com.sdfc.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.pages.ContactsPage;
import com.sdfc.qa.pages.HomePage;
import com.sdfc.qa.pages.LoginPage;
import com.sdfc.qa.util.ExcelOperations;
import com.sdfc.qa.util.ExcelUtil;
import com.sdfc.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	 LoginPage loginPage;
	 HomePage  homePage;
	 TestUtil testUtil;
	 ContactsPage contactsPage ;
	 String  excelPath= "C:\\Users\\calci\\eclipse-workspace\\SFDC\\src\\main\\java\\java\\com\\project\\qa\\testdata\\juve.xlsx";
	 String Sheets = "Sheet1";
	 ExcelUtil excel = new ExcelUtil(excelPath, Sheets);
	 
public ContactsPageTest(){
		
		 super ();
		 
	}

@BeforeTest
public void SetUp() throws InterruptedException {
	                                      
	initialization ();
	loginPage = new LoginPage();
	testUtil = new TestUtil();
	contactsPage = new ContactsPage();
	homePage = new HomePage();
	loginPage.ClickonLoginlink();
	homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
	contactsPage = homePage.ClickOnContacts();
	contactsPage.ClickOnViewBTN();
}

@Test(dataProvider ="getdata")
public void test1 (String Title ,String Firstname,String Lastname, String Account) throws InterruptedException {		
	
	contactsPage.CreateNewContacts(Title, Firstname,Lastname,Account);
 
}


@DataProvider(name = "getdata")
public Object[][] getdata(){

	 Object [] [] data =  ExcelUtil.testData(excelPath, Sheets);

	return data;
}
    	
@AfterTest
public void teardown(){
	
	 driver.quit();
}

	

}
