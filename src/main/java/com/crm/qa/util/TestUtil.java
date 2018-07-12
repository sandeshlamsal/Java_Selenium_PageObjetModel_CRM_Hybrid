package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public void switchToFrame(){
		System.out.println("switching frame started//");
		driver.switchTo().frame("mainpanel"); //driver comes from TestBase
		System.out.println("switching frame sucess");
	}
}
