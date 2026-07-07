package com.test.ohrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.ohrm.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(css="span.oxd-topbar-header-breadcrumb")
	WebElement homePageDashboardIcon;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement AdminButton;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchInput;
	
	@FindBy(xpath="//span[text()='My Info']")
	WebElement myProfilebutton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	 public String validateHomePageTile() {
		 String title= driver.getTitle();
		 return title;
	}
	 
	 public boolean validateHomePageDashboardIcon() {
		 return homePageDashboardIcon.isDisplayed();
	 }
	 
	 public boolean validateAdminButton() {
		 return AdminButton.isDisplayed();
	 }
	 
	 public MyInfoPage inputSearchTextAndVerify() {
		 searchInput.sendKeys("My info");
		 myProfilebutton.click();
		 return new  MyInfoPage();
	 }
	  
	
	
	//public void validateHomePageDashboardIcon
	
	
	
	

}
