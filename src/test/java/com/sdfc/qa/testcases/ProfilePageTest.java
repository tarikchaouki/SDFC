package com.sdfc.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.pages.HomePage;
import com.sdfc.qa.pages.LoginPage;
import com.sdfc.qa.pages.ProfilePage;
import com.sdfc.qa.util.TestUtil;

public class ProfilePageTest extends TestBase{
	
	
	 LoginPage loginPage;
	 HomePage  homePage;
	 TestUtil testUtil;
	 ProfilePage profilePage ;
	
	
	public ProfilePageTest() {
		
		 super();
		
	}
    @BeforeTest
	public void SetUp()  {
		
		initialization ();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		profilePage = new ProfilePage();
		homePage = new HomePage();
		loginPage.ClickonLoginlink();
		homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		profilePage = homePage.ClickOnMyProfile();
		
		}
	
	@Test
	 public void UploadChosenFile() {
	  
    	 profilePage.UploadFile();
		
      }
	 
	 @Test
	 public void EditPf() throws InterruptedException {
		 
		 profilePage.ClickEditPf();
		 profilePage.EditMyInfo();
		 
	 }
	 @AfterTest
	 public void TearDown() {
	    	
	    	driver.close();
	    	
	  }
	
}
