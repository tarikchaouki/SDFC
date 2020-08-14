package PAGES;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Driver {
	
	
	 static WebDriver driver = null;
	 
	 
	public static void SetUpDriver(WebDriver driver)  
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\calci\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\calci\\eclipse-workspace\\SFDC\\driver\\chromedriver\\chromedriver.exe");
		
		   
		   driver = new FirefoxDriver();
		   driver.manage().window().maximize();
		   driver.get("https://login.xero.com/");
		   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
    
  
	public static void TearDownDriver(WebDriver driver )throws Exception
	{
		Thread.sleep(5000);
		System.out.println("close the browser");
		// Quit all running session
		driver.quit();
	}
	
	
	
}
