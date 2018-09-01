package com.dt.uiElements;

import org.openqa.selenium.WebDriver;

import com.dt.core.FunctionLibrary;

;
public class AutomationElement extends FunctionLibrary {
	String locatorString=new String();
	String locatoR=new String();
	public AutomationElement()
	{
		
	}
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
	public AutomationElement waitUntilElementPresent(WebDriver driver)
	{
		super.waitUntilElementPresent(driver,getLocatorValue());
		return new AutomationElement();
	}
	public AutomationElement verifyElementPresent(WebDriver driver)
	{
		super.verifyElementPresent(driver,getLocatorValue());
		return new AutomationElement();
	}
	public AutomationElement click(WebDriver driver)
	{
			super.click(driver, getLocatorValue());
			return new AutomationElement();
	}
	public AutomationElement clearAndSendKeys(WebDriver driver, String text)
	{
			super.clearAndSendKeys(driver, getLocatorValue(),text);
			return new AutomationElement();
	}
	public AutomationElement verifyTextExistsOnElement(WebDriver driver, String text)
	{
			super.verifyTextExistsOnElement(driver, getLocatorValue(),text);
			return new AutomationElement();
	}
}
