package com.dt.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FunctionLibrary extends CoreConfig 
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
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void verifyElementPresent(WebDriver driver,String locator)
	{
			if(driver.findElement(By.xpath(locator)).isDisplayed())
			System.out.println("VerifyElement : "+locator);
	}
	public void click(WebDriver driver,String locator)
	{
			driver.findElement(By.xpath(locator)).click();
			System.out.println("Cick : "+locator);
	}
}
