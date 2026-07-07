package com.test.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.ohrm.base.TestBase;
import com.test.ohrm.pages.HomePage;
import com.test.ohrm.pages.LoginPage;

public class homePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public homePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initBrowser();
		loginPage = new LoginPage();
		homePage = new HomePage();
	
		homePage = loginPage.loginProcess(prop.getProperty("username"),prop.getProperty("password"));
			
	}
	
	@Test (priority=0)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTile();
		Assert.assertEquals(homePageTitle,"OrangeHRM");	
	}

	@Test (priority=1)
	public void validateHomePageDashboardIconTest() {
		Boolean flag = homePage.validateHomePageDashboardIcon();
		Assert.assertTrue(flag);
	}
	
	@Test (priority=2)
	public void validateAdminButtonTest() {
		Boolean flag = homePage.validateAdminButton();
		Assert.assertTrue(flag);
		}
	@Test (priority=3)
	public void inputSearchTextAndVerifyTest() {
		homePage.inputSearchTextAndVerify();
		}
	
	@AfterMethod
	 public void teardown() {
		driver.quit();
	}

}
