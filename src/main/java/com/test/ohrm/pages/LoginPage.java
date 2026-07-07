package com.test.ohrm.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.ohrm.base.TestBase;

public class LoginPage extends TestBase {

	
	//object repo
	
	@FindBy(name="username")
	WebElement usernameInput;
	
	@FindBy(name="password")
	WebElement passwordInput;
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	WebElement loginButton;
	
	@FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
	WebElement loginText;
	
	 @FindBy(xpath="//img[@src='/web/images/ohrm_branding.png?v=1763650546848']")
	 WebElement loginLogo;
	 
	 //constructor to initialise the objec reps
	
	 
	 public LoginPage() {
		 PageFactory.initElements(driver, this);
		 
		 }
	 //Methods
	public String validateHomePageTitle() {
		
		String title = driver.getTitle();
		return title;
		}
	 
	public boolean validateOhrmLogo() {
		return loginLogo.isDisplayed();
	}
	 
	 
	public HomePage loginProcess(String un, String pw) {
		
		usernameInput.sendKeys(un);
		passwordInput.sendKeys(pw);
		loginButton.click();
		return new HomePage();  	
	}
	
	

}

