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
	static ThreadLocal<String> actualLocatorStringXpath=new ThreadLocal<String>();
	static ThreadLocal<WebDriver> instance = new ThreadLocal<WebDriver>();
	public AutomationElement(String locator)
	{
		locatorString=locator;
	}
	public AutomationElement()
	{
		
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
		actualLocatorStringXpath.set(locatoR);
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
	private By getElementXpath(String locator)
	{
		
			return By.xpath(locator);
		
	}
	public AutomationElement waitUntilElementPresent()
	{
		try{
			WebDriverWait waitobj=new WebDriverWait(getDriverIntance(),20);
			waitobj.until(ExpectedConditions.visibilityOfElementLocated(getElementXpath(getLocatorValue()))); 
			log(true,"Wait until Element Present located by :"+getLocatorValue().toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log(false,"Wait Failed for elemet located by :"+getLocatorValue().toString());
		}
		instance.set(getDriverIntance());
		return new AutomationElement(actualLocatorStringXpath.get());
	}
	public AutomationElement verifyElementPresent()
	{
		try {
			if(instance.get().findElement(getElementXpath(actualLocatorStringXpath.get())).isDisplayed())
			log(true, "Verify Element :"+actualLocatorStringXpath.get());
			}
			catch(Exception e){
				log(false, "Verification Failed for Element :"+actualLocatorStringXpath.get());}	
		instance.set(getDriverIntance());
		return new AutomationElement(actualLocatorStringXpath.get());
	}
	public AutomationElement click()
	{
		try{instance.get().findElement(getElementXpath(actualLocatorStringXpath.get())).click();
		log(true,"Click Element: "+actualLocatorStringXpath.get());}
		catch(Exception e )
		{
			e.printStackTrace();
			log(null, "Click Failed for Element :"+actualLocatorStringXpath.get());
		}
		return new AutomationElement(actualLocatorStringXpath.get());
	}
	public AutomationElement clearAndSendKeys(String text)
	{
		try{
			instance.get().findElement(getElementXpath(actualLocatorStringXpath.get())).clear();
			instance.get().findElement(getElementXpath(actualLocatorStringXpath.get())).sendKeys(text);
			log(true,"Clear Element: "+actualLocatorStringXpath.get()+" Send Keys :"+text);}
			catch(Exception e )
			{
				e.printStackTrace();
				log(null, "ClearAndSendKeys Failed for Element :"+actualLocatorStringXpath.get());
			}
		String locator=actualLocatorStringXpath.get();
		return new AutomationElement(locator);
	}
	public AutomationElement verifyTextExistsOnElement(String text)
	{
		try{
			if(instance.get().findElement(getElementXpath(actualLocatorStringXpath.get())).getText().contains(text))
			log(true,"Verify Text Exists on: "+getLocatorValue()+" Text :"+text);
			else
				log(false,"Verify Text Exists on: "+actualLocatorStringXpath+" Text :"+text);	
			}
			catch(Exception e )
			{
				e.printStackTrace();
				log(null, "verifyTextExistsOnElement Failed for Element :"+actualLocatorStringXpath);
			}
		String locator=getLocatorValue();
		return new AutomationElement(locator);
	}
}
