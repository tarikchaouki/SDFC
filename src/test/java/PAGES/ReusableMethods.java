package PAGES;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ReusableMethods extends Driver  {
	
	
	static WebElement obj = null;
	static WebDriver driver =null ;
	
	
	
	public static WebDriver  StartBrowser(String browsername , String url) {
		 

	   if(browsername.equals("FF")) {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\calci\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	driver= new FirefoxDriver();
	}
		
	   else if(browsername.equals("chrome")) {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\calci\\eclipse-workspace\\SFDC\\driver\\chromedriver\\chromedriver.exe");
			driver = new  ChromeDriver();
			}	
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.get(url);
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   return driver;
		
	}
     
	
	


	public static  void enterText(WebElement obj,String input , String ObjName ) {
		  
			if (obj.isDisplayed()) {
				obj.sendKeys(input);
				System.out.println("Pass :" +input + " is entered in " + ObjName + " field");}
				else {
					System.out.println("fail :" + ObjName + " field does not exist,check your application");
				}

}
      
	 
	public static void ClickButton(WebElement obj,String ObjName) {
			
			if (obj.isDisplayed()) {
				obj.click();
				System.out.println("Pass :" + ObjName + " is clicked");}
				else {
					System.out.println("fail :" + ObjName + " Object does not  exist,check your application");}
				}





	
}