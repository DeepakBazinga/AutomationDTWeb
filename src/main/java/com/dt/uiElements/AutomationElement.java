package com.dt.uiElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dt.core.DriverFactory;

;
public class AutomationElement extends DriverFactory {
	String locatorString=new String();
	String locatoR=new String();
	String actualLocatorStringXpath;
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
		actualLocatorStringXpath=locatoR;
		return locatoR;
	}
	private WebDriver getDriverIntance()
	{
		if(DriverFactory.class.isAssignableFrom(this.getClass()))
		{
			return getWebDriver();
		}
		else
		{
		return null;
		}
	} 
	private By getElement(String locator)
	{
		if(locatorString.contains("xpath"))
		{
			return By.xpath(locator);
		}
		else 
		{
			return null;
		}
	}
	public AutomationElement waitUntilElementPresent()
	{
		try{
			WebDriverWait waitobj=new WebDriverWait(getDriverIntance(),20);
			waitobj.until(ExpectedConditions.visibilityOfElementLocated(getElement(getLocatorValue()))); 
			log(true,"Wait until Element Present located by :"+getLocatorValue().toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log(false,"Wait Failed for elemet located by :"+getLocatorValue().toString());
		}
		return new AutomationElement(actualLocatorStringXpath);
	}
	public AutomationElement verifyElementPresent()
	{
		try {
			if(getDriverIntance().findElement(getElement(getLocatorValue())).isDisplayed())
			log(true, "Verify Element :"+getLocatorValue().toString());
			}
			catch(Exception e){
				log(false, "Verification Failed for Element :"+getLocatorValue().toString());}	
		return new AutomationElement(actualLocatorStringXpath);
	}
	public AutomationElement click()
	{
		try{getDriverIntance().findElement(getElement(getLocatorValue())).click();
		log(true,"Click Element: "+getLocatorValue());}
		catch(Exception e )
		{
			e.printStackTrace();
			log(null, "Click Failed for Element :"+getLocatorValue().toString());
		}
		return new AutomationElement(actualLocatorStringXpath);
	}
	public AutomationElement clearAndSendKeys(String text)
	{
		try{
			getDriverIntance().findElement(getElement(getLocatorValue())).clear();
			getDriverIntance().findElement(getElement(getLocatorValue())).sendKeys(text);
			log(true,"Clear Element: "+getLocatorValue()+" Send Keys :"+text);}
			catch(Exception e )
			{
				e.printStackTrace();
				log(null, "ClearAndSendKeys Failed for Element :"+getLocatorValue().toString());
			}
		String locator=getLocatorValue();
		return new AutomationElement(locator);
	}
	public AutomationElement verifyTextExistsOnElement(String text)
	{
		try{
			if(getDriverIntance().findElement(getElement(getLocatorValue())).getText().contains(text))
			log(true,"Verify Text Exists on: "+getLocatorValue()+" Text :"+text);
			else
				log(false,"Verify Text Exists on: "+getLocatorValue()+" Text :"+text);	
			}
			catch(Exception e )
			{
				e.printStackTrace();
				log(null, "verifyTextExistsOnElement Failed for Element :"+getLocatorValue().toString());
			}
		String locator=getLocatorValue();
		return new AutomationElement(locator);
	}
}
