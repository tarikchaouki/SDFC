package com.sdfc.qa.pages;



import org.apache.poi.POIDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Up;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Factory;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.util.TestUtil;
           
      

public class HomePage extends TestBase{
	
	      
	      Actions action = new Actions(driver);
	      TestUtil testUtil =  new TestUtil();
	    
public HomePage () {
   	     
	     this.driver = driver ;
   	     PageFactory.initElements(driver,this);
        
      }
	
	
	@FindBy(id="userNavButton") WebElement dropdownName;
	@FindBy(xpath = "//h1[contains(@class,'currentStatusUserName')]//a[contains(text(),'Tarik chaouki')]")WebElement usernameLabel;
	@FindBy(className = "mbrMenuItems")WebElement list;
	@FindBy(linkText ="Developer Console")WebElement DevelopConsole;
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")WebElement MyProfileLabel;
	@FindBy(xpath = "//a[contains(text(),'My Settings')]")WebElement MySettingLabel;
	@FindBy(id = "Contact_Tab")WebElement ContactsTab;
	 

	public String validateHomePageTitle() {
			
	return driver.getTitle();
	
        }
    
	
public void verifyUserName() {
		 
	usernameLabel.isDisplayed();
	
		
	    }
	 
public void DropDownName() throws InterruptedException {
		 
		 
		 action.moveToElement(dropdownName).build().perform();
		 Thread.sleep(2000);
		  
	 }
	 
	 
public void CheckDropDown() throws InterruptedException  {
		 
		   testUtil.VerifyElementClick(dropdownName);
		   testUtil.VerifyElementClick(DevelopConsole);
		   testUtil.WindowHandler();
		   Thread.sleep(5000);
}
	  
	  
	  
public ProfilePage  ClickOnMyProfile() {
		  
		     dropdownName.click();
		     MyProfileLabel.click();
		     return new ProfilePage();
		
		
	  }


public SettingPage  ClickOnMySetting() throws InterruptedException {
	  
	  
            dropdownName.click();
            MySettingLabel.click();
            Thread.sleep(2000);
             return new SettingPage();


}


public ContactsPage  ClickOnContacts() throws InterruptedException {
	  
	  
          ContactsTab.click();
          Thread.sleep(2000);
          return new ContactsPage();


}


	 
}
