package com.dt.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FunctionLibrary extends CoreConfig  
{
	public void startBrowserNormal()
	{
		super.getWebDriver().get(super.getURL());
	}
}
