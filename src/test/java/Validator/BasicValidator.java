package Validator;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.Login;

import utils.TestBase;
/***
 * 
 * @author pkapse
 *
 */
public class BasicValidator  extends TestBase
{
	Login lp;
	
	public String activePage = "";
	
	public void pageValidationPageTitle(WebDriver driver, String pageName, String userName)
	{		
		lp = new Login();		
		
		//tb = new TestBase();
		//wc = new WelcomePage();
		String pageCurrentTitle = driver.getTitle();		
		switch(pageName)
		{
			case "LoginPage":
			Assert.assertTrue(lp.verifyPageTitle(pageCurrentTitle));	
			MessageLog="";
			MessageLog= "\n"+ LocalDateTime.now()+": pageValidationPageTitle is PASS";
			writeFile(prop.getProperty("GeneralLogPath"),MessageLog);
			activePage="LoginPage";
			break;	
		}
	}
	public void pageValidationMendatoryFields(WebDriver driver, String pageName) throws InterruptedException
	{
		boolean returnStatus = false;
		lp = new Login();
		
		switch(pageName)
		{			
			case "LoginPage":
				Assert.assertTrue(lp.verifyMendatoryFields(driver));
			activePage="LoginPage";
			break;				
		}
		
	}

	

}
