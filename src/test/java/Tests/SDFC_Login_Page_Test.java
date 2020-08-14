package Tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.annotations.TestAnnotation;



import PAGES.Driver;
import PAGES.ReusableMethods;
import PAGES.SDFC_Login_Page;


public  class SDFC_Login_Page_Test extends TestBase  {

	   public SDFC_Login_Page_Test(){
    	 
    	 super();
    	 
           }
	
  @Test
public static  void LoginToSDFC() throws Exception  {
	  
	  
	    
	      initialization ();
		
	        SDFC_Login_Page lp = new SDFC_Login_Page(driver);	
		    lp.enterUserName();
			lp.enterPassword();
			lp.click();	
  }
  
  
	public void Tear() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("close the browser");
		driver.quit();
	}	
}

  
		
		

   

