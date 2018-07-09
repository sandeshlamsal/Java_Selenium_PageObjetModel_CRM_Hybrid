package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
public class LoginPage extends TestBase{
	//define Object Repo for LoginPage- PageFactory
	//use @FindBy()
	//ATTRIBUTES
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")  //custom submit button
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign up')]") //see
	WebElement signUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	//METHODS (initilize and other operations)
	public LoginPage(){  //initialize every web elements, driver is comming from base class
		PageFactory.initElements(driver,this);  //this, is current class object ref. this=LoginPage.CLASS
	}
	
	//validate title
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un, String pwd){  //will return homepage
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		//after sucess login page, it should open Homepage, which is a class so
		return new HomePage();
		
	}	
}


