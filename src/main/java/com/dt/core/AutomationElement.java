package com.dt.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

;
public class AutomationElement extends FunctionLibrary {
	String locatorString=new String();
	String locatoR=new String();
	public AutomationElement(String locator)
	{
		locatorString=locator;
	}
	public String getLocatorValue()
	{
		if(locatorString.contains("xpath"))
		{
			 locatoR=locatorString.split("path=")[1];
		}
		else
		{
			locatoR="";
		}
		return locatoR;
	}
//	public void verifyElementPresent()
//	{
//		String LocatorValue=getLocatorValue();
//		Assert.assertTrue(driver.findElement(By.xpath(LocatorValue)).isDisplayed());
//	}
	public void waitUntilElementPresent(WebDriver driver)
	{
		super.waitUntilElementPresent(driver,getLocatorValue());
	}
	public void verifyElementPresent(WebDriver driver)
	{
		super.verifyElementPresent(driver,getLocatorValue());
	}
	public void click(WebDriver driver)
	{
			super.click(driver, getLocatorValue());
	}
}
