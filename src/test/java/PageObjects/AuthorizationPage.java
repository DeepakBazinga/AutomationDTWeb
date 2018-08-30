package PageObjects;

import org.openqa.selenium.WebDriver;

import com.dt.core.AutomationElement;

public class AuthorizationPage
{
	public AutomationElement wwwLabel = new AutomationElement("xpath=//p[contains(text(),'SQ')]");
	public AutomationElement wwwLink = new AutomationElement("xpath=//a[contains(@class,'ui-link-inherit') and contains(text(),'SQ')]");
	public AutomationElement oDLogo = new AutomationElement("xpath=//img[@data-auid='head_image_brandLogo']");

}
