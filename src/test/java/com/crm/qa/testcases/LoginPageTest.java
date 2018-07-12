package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	//
	LoginPage loginPage;
	HomePage homePage;  //
	
	public LoginPageTest(){
		//to initialize .cofig setting
		super(); //calls the super class constuctor, first calls it //
	}
	
	@BeforeMethod  //a testNG attributes
	public void setUP(){
		initialization();  //calling method of TestBase class
		loginPage=new LoginPage(); //
	}
	
	//all tests here, after before method
	//always write Test in below @Test method
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service");
	
	}
	
	//test logo image
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	
	}
	
	//Login (user/password)
	@Test(priority=3)
	public void loginTest(){
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
