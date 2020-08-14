package com.sdfc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.pages.HomePage;
import com.sdfc.qa.pages.LoginPage;
import com.sdfc.qa.util.TestListenerUtil;

@Listeners(TestListenerUtil.class)
public class LoginPageTest extends TestBase {
	
    
	  LoginPage loginPage;
	  HomePage  homePage;
	   
	   LoginPageTest(){
		     super();
	   }
	
	
	@BeforeClass
	public void INIT() {
		
		initialization ();  
		loginPage = new LoginPage();
	
	    String title = loginPage.ValidateloginPageTitle();
		Assert.assertEquals(title,"Salesforce: We Bring Companies and Customers Together");
		System.out.println(title);
		loginPage.ClickonLoginlink();
		
	}
	@Test
	public void LoginToSDFC() {
		
		homePage =loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
         
	}
	
	
	@AfterClass
     public void TearDown() {
		 
		 driver.close();
	 }

}
