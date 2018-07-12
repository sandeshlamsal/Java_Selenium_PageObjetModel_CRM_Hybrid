package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super(); //will init pro settings
	}
	
	@BeforeMethod
	public void setUp(){
		initialization(); //driver initialized, diff driver for each page
		// Test case will start from begining, open browser, open page and login page and 
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//testcases will be here
	
	//always import from testng package and add Test at end of Test methods
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Home Page title not matched"); //params (actual,expected,string if assert is failed)
	}
	
	//verify user name session
	@Test(priority=2)
	public void verifyUserNameTest(){
		System.out.println("verify user begin");
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		System.out.println("verify user end");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
