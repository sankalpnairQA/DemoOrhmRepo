package com.test.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.ohrm.base.TestBase;
import com.test.ohrm.pages.HomePage;
import com.test.ohrm.pages.LoginPage;
import com.test.ohrm.pages.MyInfoPage;
import com.test.ohrm.utils.testUtil;

public class myInfoTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	MyInfoPage myInfoPage;
	String sheetName = "myInfo";
	
	
	public myInfoTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initBrowser();
		loginPage = new LoginPage();
		homePage = new HomePage();
		myInfoPage = new MyInfoPage();
	
		homePage = loginPage.loginProcess(prop.getProperty("username"),prop.getProperty("password"));
			
	}
	@DataProvider
	public Object[][] getTestData() {
	 Object data [][] = testUtil.getTestData(sheetName);
	 return data;
		
	}
	
	@Test (dataProvider="getTestData")
	public void enterInfo(String firstName, String lastName) {
		homePage.inputSearchTextAndVerify();
		myInfoPage.updateMyInfo(firstName,lastName);
		String postUpdatetest = myInfoPage.validateInfoUpdate();
		Assert.assertEquals(firstName, postUpdatetest);
		System.out.println(postUpdatetest);
		
	}
	
	
	@AfterMethod
	 public void teardown() {
		driver.quit();
	}

	
	
	
	
	
	
}
