package stepDefinations;
import java.awt.AWTException;

import org.junit.Assert;

import pages.Login;
import utils.TestBase;

public class loginWelcome_SD extends TestBase
{
	Login ln = new Login();
	public void login(String UserID, String Password) throws AWTException
	{			
		Assert.assertTrue(ln.loginWithValidCredentials(driver, UserID,Password));		
	}
}
