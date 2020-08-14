package com.sdfc.qa.testcases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.pages.HomePage;
import com.sdfc.qa.pages.LoginPage;
import com.sdfc.qa.pages.ProfilePage;
import com.sdfc.qa.pages.SettingPage;
import com.sdfc.qa.util.TestListenerUtil;
import com.sdfc.qa.util.TestUtil;

//@Listeners(TestListenerUtil.class)
public class SettingPageTest  extends TestBase{
	
	
	 LoginPage loginPage;
	 HomePage  homePage;
	 TestUtil testUtil;
	 SettingPage settingPage;
	
	
	public SettingPageTest (){
		  
		super();
	}
      
	
	@BeforeClass
	public void SetUp() throws InterruptedException  {
		
		initialization ();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		settingPage = new SettingPage();
		homePage = new HomePage();
		loginPage.ClickonLoginlink();
		homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		settingPage = homePage.ClickOnMySetting();
		
		
		}
	@Test()
	
	public void Select_Display_Layout() throws Exception {
		
		  settingPage.DisplayLayout();
		  
	   }
	
    @AfterClass
    public void TearDown() {
    	
    	driver.close();
    	
    	
    }
}
