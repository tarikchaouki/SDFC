package com.sdfc.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.util.ExcelOperations;
import com.sdfc.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	  
	 TestUtil testUtil = new TestUtil();
	
	
public ContactsPage() {
		   
	 
    this.driver = driver ;
	     PageFactory.initElements(driver,this);
		
}
	
      @FindBy(xpath ="//input[contains(@name,'new')]")WebElement NewBTN;
      @FindBy(xpath = "//input[@id='name_lastcon2']")WebElement lastName  ;
      @FindBy(xpath = "//input[@id='name_firstcon2']")WebElement firstName  ; 
      @FindBy(xpath ="//a[@id='con4_lkwgt']")WebElement AccountLookUp;
      @FindBy(xpath="//input[@name='lksrch']")WebElement AccountName ;
      @FindBy(xpath= "//input[@name='go']")WebElement GoBTN; 
      @FindBy(xpath ="//a[contains(@class,'dataCell')]")WebElement lookupLink;
      @FindBy(name = "save")WebElement SaveBTN;
      @FindBy(id="name_salutationcon2") WebElement DropDwonContacts;
     
      
      
public void ClickOnViewBTN () {
	 
	    NewBTN.click();
 }
 
public void  CreateNewContacts (String Title ,String Firstname,String Lastname, String Account)  throws InterruptedException {
	
	
	
	//Select select = new Select(DropDwonContacts);
	//select.selectByValue(testData.get("Title"));
testUtil.SelectElement(DropDwonContacts,Title);
firstName.sendKeys(Firstname);      
lastName.sendKeys(Lastname);
AccountLookUp.click();
testUtil.SwitchToFrame2();
AccountName.sendKeys(Account); 
GoBTN.click();
lookupLink.click();
Thread.sleep(2000);
 
 SaveBTN.click();
 

}

}
