package com.sdfc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.util.TestUtil;

public class ProfilePage extends TestBase{
	
     
    TestUtil testUtil = new TestUtil();
	
	@FindBy(id = "UserProfile_Tab")WebElement ProfileTab;
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img")WebElement EditProfile;
	@FindBy (linkText= "File")WebElement FileLink;
	@FindBy (xpath= "//a[@id='chatterUploadFileAction']")WebElement UploadLink;
	@FindBy(xpath= "//input[@id='chatterFile']" )WebElement BrowseFile;
	@FindBy(xpath ="//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]") WebElement Postlink;
	@FindBy(xpath = "//html[contains(@class,'chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders placeholder')]") WebElement PostText;
	@FindBy(xpath= "//input[@id='publishersharebutton']")WebElement ShareButton;
	@FindBy(xpath= "//a[contains(text(),'About')]") WebElement AboutTab;
	@FindBy(xpath= "//input[@id='lastName']") WebElement LastName;
	@FindBy(xpath= "//input[@class='zen-btn zen-primaryBtn zen-pas']") WebElement  SaveAllButton ;
	
	 
    public ProfilePage (){
		
		 this.driver = driver ;
 	     PageFactory.initElements(driver,this);
	}
	
	
	
	public void WritePost() {
		  
		  Postlink.click();
		  //testUtil.SwitchToFrame();
		  PostText.sendKeys("hi everyone hope you doind well");
		  ShareButton.click();
		  
		  
		  
	  }
   public void UploadFile() {
		 
		 FileLink.click();
		 UploadLink.click();
		 BrowseFile.sendKeys("C:\\Users\\calci\\OneDrive\\Documents\\Testing browse pop up.docx");
		 
	    }
   
   public void ClickEditPf() throws InterruptedException {
	   
	    EditProfile.click();
	    Thread.sleep(2000);
	    testUtil.SwitchToFrame();
   }
   
  public void EditMyInfo () throws InterruptedException {
        
	    AboutTab.click();
	    LastName.clear();
	    Thread.sleep(2000);
	    LastName.sendKeys("chaouki");
	    SaveAllButton.click();
	  	    
	    
 }  
}
