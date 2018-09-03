package com.dt.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary extends CoreConfig implements LoggingMethods 
{
	WebDriver driver;
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public void startBrowserNormal()
	{
		threadLocalDriver.set(setConfig());
		threadLocalDriver.get().get(getURL());
	}
	public WebDriver getWebDriver()
	{
		return threadLocalDriver.get();
	}
	public void quitWebSession()
	{
		try{
			getWebDriver().close();
				log(true,"quitWebSession()");
			}
			catch(Exception e )
			{
				e.printStackTrace();
				log(null, "quitWebSession() Failed");
			}
	}
}
