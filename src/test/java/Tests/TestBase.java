package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	
	public static Properties prop = null ;
	public static WebDriver driver = null;

	    public TestBase() {
	    	
	    	try {
				prop = new Properties ();
				FileInputStream lp = new FileInputStream("C:\\Users\\calci\\eclipse-workspace\\SFDC\\src\\test\\java\\PAGES\\config.properties");
				prop.load(lp);
			} catch (FileNotFoundException e) {
				e.printStackTrace();			
	        }catch(IOException e) {
	    	
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
					   System.setProperty("webdriver.chrome.driver", "C:\\Users\\calci\\eclipse-workspace\\SFDC\\driver\\chromedriver\\chromedriver.exe");
						driver = new  ChromeDriver();
						}	
				   driver = new FirefoxDriver();
				   driver.manage().window().maximize();
				   driver.manage().deleteAllCookies();
				   driver.get(prop.getProperty("url"));;
				   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				   
	 }   
	 
	
}
 