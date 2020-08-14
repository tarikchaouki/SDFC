package com.sdfc.qa.pages;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdfc.qa.base.TestBase;
import com.sdfc.qa.util.TestUtil;

public class SettingPage extends TestBase {
	
	
	
	   TestUtil testUtil =  new TestUtil();

public SettingPage() {
		
		 this.driver = driver ;
   	     PageFactory.initElements(driver,this);
        }
		
		
	@FindBy(id="DisplayAndLayout")WebElement Display_Layout;
	@FindBy(linkText="Customize My Tabs" )WebElement CustomizeMyTabs;
	@FindBy(xpath = "//select[@id='p4']")WebElement DropDownTAB ;
	@FindBy(xpath ="//select[@id='duel_select_0']")WebElement DropDrownCustom;
	@FindBy(className = "rightArrowIcon")WebElement AddButton;
	@FindBy(name = "save")WebElement SaveButton;
	 
	
	public void DisplayLayout() throws Exception{
		
		testUtil.VerifyElementClick(Display_Layout);
		testUtil.VerifyElementClick(CustomizeMyTabs);
		testUtil.SelecAllOptions(DropDownTAB);
		testUtil.SelectElement(DropDownTAB,"Salesforce Chatter");
		testUtil.SelectElement(DropDrownCustom,"Campaigns");
	    testUtil.VerifyElementClick(AddButton);
	    testUtil.VerifyElementClick(SaveButton);
	}

}
