package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	//create a global WebDriver and Properties class
	public static WebDriver driver;  //can be used by other pages, 
	public static Properties prop;
	
	public TestBase(){
		try{
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+
					"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(Exception e){
			System.out.println("Exception reading properties file"  + e.getMessage());
		}
		//read proprties file	
	}
	
	
	//initialization of browsers
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//create a TestUtil class to set pageload and implicit wait
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); //10sec
		
		driver.get(prop.getProperty("url"));
		
	}
	//end initialization
		
}
