package com.test.ohrm.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.ohrm.base.TestBase;

public class MyInfoPage extends TestBase{
	
	@FindBy(xpath="//h6[text()='Personal Details']")
	WebElement personalDetailsText;
	
	
//	@FindBy(xpath="//input[@name='firstName']")
//	WebElement firstNameInput;
	@FindBy(name = "firstName")
	WebElement firstNameInput;
	
	@FindBy(xpath="//span[text()='Single']")
	WebElement singleDD;
	
	@FindBy(xpath="//input[@name='lastName']") 
	WebElement lastNameInput;
	@CacheLookup
	@FindBy(xpath="(//button[text()=' Save '])[1]")
	WebElement saveButton;
	
	@FindBy(xpath="//label[normalize-space()='Marital Status']"
			+ "/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
	WebElement maritalStatusDropd;
	

	public MyInfoPage() {
		
		PageFactory.initElements(driver, this);
	}
	 
	
	public void updateMyInfo(String firstName, String lastName) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement firstName1 = wait.until(
		    ExpectedConditions.elementToBeClickable(By.name("firstName")));
		
		firstName1.click();
		firstName1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		firstName1.sendKeys(Keys.DELETE);
		firstName1.sendKeys(firstName); 
		
		
		WebElement lastName1= wait.until(ExpectedConditions.elementToBeClickable(By.name("lastName")));
		
		lastName1.click();
		lastName1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		lastName1.sendKeys(Keys.DELETE);
		lastName1.sendKeys(lastName); 
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait1.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.className("oxd-form-loader")));
		
		
		maritalStatusDropd.click();
		singleDD.click();
		
		saveButton.click();
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.className("oxd-form-loader")));
		
	}
	
	public String validateInfoUpdate() {
		String postInfoUpdate= firstNameInput.getAttribute("value");
		return postInfoUpdate;

		
	}
	
	
	
	
	
	
	
	
	
	
	

}
