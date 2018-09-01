package com.dt.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Hello world!
 *
 */
public class CoreConfig 
{
	private String configFilePath=System.getProperty("user.dir")+"/src/main/resouces/config/config.properties";
	private String browserName;
	ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	private String url;
	private WebDriver driver;
	public WebDriver getWebDriver()
	{
		return this.driver;
	}
    public  WebDriver setConfig()
    {
    	int fileFlag=0;
    	try{
    		File f = new File(configFilePath);
    	
    	if(f.exists() && !f.isDirectory()) { 
    	    fileFlag=1;
    	}
    	}
    	catch(Exception e )
    	{
    		e.printStackTrace();
    	}
    	if(fileFlag==1)
    	{
    		try {
    			BufferedReader br = new BufferedReader(new FileReader(configFilePath));
    		    String line;
    		    while ((line=br.readLine()) != null) 
    		    {
    		    	if(line.contains("browser"))
    		    				browserName=line.split("=")[1];
    		    	else if(line.contains("URL"))
    		    			url=line.split("=")[1];
    		    
    		    }
    		}
    		catch (Exception e)
		    {
    			e.printStackTrace();
		    }
    		if(browserName.contains("chrome")){
    		 DesiredCapabilities caps = DesiredCapabilities.chrome();
    		 System.setProperty("webdriver.chrome.driver", "/Users/flowerchild/Documents/DTAutomation/drivers/chromedriver");
    		driver = new ChromeDriver(caps);}
    		else if(browserName.contains("safari"))
    		{
    			DesiredCapabilities caps = DesiredCapabilities.firefox();
    			System.setProperty("webdriver.safari.noinstall", "true");
       		driver = new SafariDriver(caps);
    		}
    	}
    	else
    	{
    		
    	}
    	return driver;
    }
    public String getURL()
    {
    	return "http://"+url;
    }
    	
}
