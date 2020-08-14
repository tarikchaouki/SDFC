package com.sdfc.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.util.TestUtil;


public class LoginPage extends TestBase{
	

	
	   TestUtil testUtil =  new TestUtil();

	 public LoginPage () {
		 
    	 this.driver = driver;
    	PageFactory.initElements(driver,this);
    }
	 
	@FindBy (xpath= "//div[@class='dropdown']") WebElement loginlink ;
	@FindBy(name="username")  WebElement username ;
	@FindBy(id="password")   WebElement password ;
	@FindBy(id="Login")  WebElement loginbutton ;
	//@FindBy(linkText = "I Don't Want to Register My Phone")WebElement Ignore;
	@FindBy(id = "tryLexDialogX")WebElement ignore;
	
    
    
    
   public String ValidateloginPageTitle() {
	return driver.getTitle();
		}
	
   
	
	
	public void ClickonLoginlink() {
		
		testUtil.VerifyElementClick(loginlink);
		
	}
	
   public HomePage  Login(String un ,String pwd ) {
	   
	   username.sendKeys(un);
	   password.sendKeys(pwd);
	   loginbutton.click();
	   ignore.click();
	  
	   
	   
	   return  new HomePage();
	   
   }
		
		
		
	
}
