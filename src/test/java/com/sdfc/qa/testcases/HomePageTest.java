package com.sdfc.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.pages.HomePage;
import com.sdfc.qa.pages.LoginPage;
import com.sdfc.qa.util.TestListenerUtil;
import com.sdfc.qa.util.TestUtil;

import bsh.util.Util;


//@Listeners(TestListenerUtil.class)
public class HomePageTest extends TestBase {
		
		
		 LoginPage loginPage;
		 HomePage  homePage;
		 TestUtil testUtil;
		
		
		public HomePageTest (){
			  
			   super();
		}
		
		 @BeforeClass 
		public void SDFC_HomePage() {
		
		initialization ();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		loginPage.ClickonLoginlink();
		homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
		}
		 
		@Test
		public void validateHomePageTitleTest() {
		 
			String title = homePage.validateHomePageTitle();
			Assert.assertEquals(title,"Salesforce - Essentials Edition");
			System.out.println(title);
			
		 }
		 
		@Test
		public void ValidateUserName() {
			 
			 homePage.verifyUserName();
			
		 }
		
		@Test
		public void VerifyDropDown() throws InterruptedException  {
			
			homePage.CheckDropDown();
			
			
		}
		
	     @AfterClass
	     public void TearDown() {
		     driver.close();
			
	     }			 
			 
	}

