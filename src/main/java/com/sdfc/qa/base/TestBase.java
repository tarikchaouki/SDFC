package com.sdfc.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sdfc.qa.util.TestUtil;
//import com.sdfc.qa.util.WebEventListener;



public class TestBase {
	
	
	public static Properties prop = null;
	public static WebDriver driver = null ;
	
	//...... Extent report classes.......//
	
	public static ExtentReports extent ;
	public static ExtentTest test;
	
	//...................................//
	
	TestUtil testUtil ; 

	
	 public TestBase() {
	    	
	    	try {
				prop = new Properties ();
				FileInputStream lp = new FileInputStream("C:\\Users\\calci\\eclipse-workspace\\SFDC\\src\\main\\java\\com\\sdfc\\qa\\config\\config.properties");
				prop.load(lp);
			} catch (FileNotFoundException e) {
				e.printStackTrace();			
	        }catch(Exception e) {
	    	
	    	   e.printStackTrace();
	    }
	    }
	    
	 public static void initialization () {
		 
		 String browsername = prop.getProperty("browser");
		 
		 if(browsername.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\calci\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
				driver= new FirefoxDriver();
				}
					
	    else if(browsername.equals("chrome")) {
					  System.setProperty("webdriver.chrome.driver", "C:\\Users\\calci\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
						driver = new  ChromeDriver();
						}	
		 
				   driver.manage().window().maximize();
				   driver.manage().deleteAllCookies();
				   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
				   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				   driver.get(prop.getProperty("url")); 
	 }   
	 
	 public static void GetScreenshotAtEndTest(String MethodName) {
		 
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			try {
			FileUtils.copyFile(scrFile, new File("C:\\Users\\calci\\eclipse-workspace\\SFDC\\Screenshots\\"+ MethodName +"_"+".png"));
				 }
			catch(IOException e) {
				e.printStackTrace();
			     }
			}
			
	
}
 