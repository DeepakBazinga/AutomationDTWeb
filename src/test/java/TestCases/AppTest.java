package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dt.core.FunctionLibrary;

import PageObjects.AuthorizationPage;
import PageObjects.HomePage;
import PageObjects.SKUDetailPage;

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
		HomePage home=new HomePage();
		SKUDetailPage SKU=new SKUDetailPage();
		auth.wwwLabel.waitUntilElementPresent(driver).verifyElementPresent(driver,auth.wwwLabel.getLocatorValue());
		auth.wwwLink.waitUntilElementPresent(driver).click(driver, auth.wwwLink.getLocatorValue());
		auth.oDLogo.waitUntilElementPresent(driver).verifyElementPresent(driver,auth.oDLogo.getLocatorValue());	
		home.fieldSearchMain.waitUntilElementPresent(driver).verifyElementPresent(driver,home.fieldSearchMain.getLocatorValue());
		home.fieldSearchMain.clearAndSendKeys(driver, "315515").click(driver,home.buttonSearch.getLocatorValue());
		SKU.labelSKUID.waitUntilElementPresent(driver);
		SKU.labelSKUID.verifyTextExistsOnElement(driver, "315515");
	}
	@AfterTest
	public void tearDown()
	{
		quitWebSession(driver);
	}
}
