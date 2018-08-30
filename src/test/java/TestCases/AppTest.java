package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dt.core.FunctionLibrary;

import PageObjects.AuthorizationPage;

/**
 * Unit test for simple App.
 */
public class AppTest extends FunctionLibrary 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		FunctionLibrary lib=new FunctionLibrary();
		driver=lib.startBrowserNormal();

	}
	@Test
	public void runTest()
	{	
		AuthorizationPage auth=new AuthorizationPage();
		auth.wwwLabel.waitUntilElementPresent(driver);
		auth.wwwLabel.verifyElementPresent(driver);
		auth.wwwLink.waitUntilElementPresent(driver);
		auth.wwwLink.click(driver);
		auth.oDLogo.waitUntilElementPresent(driver);
		auth.oDLogo.verifyElementPresent(driver);		
	}
	
}
