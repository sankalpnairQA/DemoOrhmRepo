package com.test.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.ohrm.base.TestBase;
import com.test.ohrm.pages.HomePage;
import com.test.ohrm.pages.LoginPage;

public class loginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	public loginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initBrowser();
		loginPage = new LoginPage();
		
	}
	
	@Test (priority=1)
	public void loginPageTitleTest() {
		String LoginPagetitle = loginPage.validateHomePageTitle();
		Assert.assertEquals(LoginPagetitle, "OrangeHRM");
		}
	
	@Test (priority=2)
	public void ohrmLogoTest() {
		boolean flag = loginPage.validateOhrmLogo();
		Assert.assertTrue(flag);		
	}
		
	@Test (priority=3)
	public void loginTest() {
		homePage =  loginPage.loginProcess(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	
	
	

}
