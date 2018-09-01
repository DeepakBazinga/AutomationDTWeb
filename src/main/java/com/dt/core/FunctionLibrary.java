package com.dt.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary extends CoreConfig implements LoggingMethods
{
	WebDriver driver;
	ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public WebDriver startBrowserNormal()
	{
		threadLocalDriver.set(setConfig());
		threadLocalDriver.get().get(getURL());
		return threadLocalDriver.get(); 
	}
	public WebDriver getWebDriver()
	{
		return threadLocalDriver.get();
	}
	public void waitUntilElementPresent(WebDriver driver,String locator)
	{
		try{
			WebDriverWait waitobj=new WebDriverWait(driver,20);
			waitobj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))); 
			log(true,"Wait until Element Present located by :"+locator.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log(false,"Wait Failed for elemet located by :"+locator.toString());
		}
	}
	public void verifyElementPresent(WebDriver driver,String locator)
	{
			try {
			if(driver.findElement(By.xpath(locator)).isDisplayed())
			log(true, "Verify Element :"+locator.toString());
			}
			catch(Exception e){
				log(false, "Verification Failed for Element :"+locator.toString());}	
	}
	public void click(WebDriver driver,String locator)
	{
			try{driver.findElement(By.xpath(locator)).click();
			log(true,"Click Element: "+locator);}
			catch(Exception e )
			{
				e.printStackTrace();
				log(null, "Click Failed for Element :"+locator.toString());
			}
	}
	public void clearAndSendKeys(WebDriver driver,String locator, String text)
	{
			try{
			driver.findElement(By.xpath(locator)).clear();
			driver.findElement(By.xpath(locator)).sendKeys(text);
			log(true,"Clear Element: "+locator+" Send Keys :"+text);}
			catch(Exception e )
			{
				e.printStackTrace();
				log(null, "ClearAndSendKeys Failed for Element :"+locator.toString());
			}
	}
	public void verifyTextExistsOnElement(WebDriver driver,String locator, String text)
	{
		try{
			if(driver.findElement(By.xpath(locator)).getText().contains(text))
			log(true,"Verify Text Exists on: "+locator+" Text :"+text);
			else
				log(false,"Verify Text Exists on: "+locator+" Text :"+text);	
			}
			catch(Exception e )
			{
				e.printStackTrace();
				log(null, "verifyTextExistsOnElement Failed for Element :"+locator.toString());
			}
	}
}
