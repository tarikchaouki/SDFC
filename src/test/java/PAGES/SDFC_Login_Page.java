package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SDFC_Login_Page extends ReusableMethods{
	
 
	static WebDriver driver= null;
	
	public SDFC_Login_Page(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	 public static void  enterUserName(){
		
		WebElement UN = driver.findElement(By.xpath("//input[@id='email']"));
		 enterText(UN,"tarikchaouki10@gmail.com", "Username");
		
		
	}
    
	public static void enterPassword() {
		
		WebElement pwd  = driver.findElement(By.xpath("//input[@id='password']"));
		 enterText(pwd,"Raja1949=", "Password");
		
	}
	
	public static void click() {
		
		WebElement cl = driver.findElement(By.id("submitButton"));
		 ClickButton(cl,"login button");
		
	}
}