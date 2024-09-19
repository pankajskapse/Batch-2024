package Validator;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.Login;

import utils.TestBase;
/**
 * 
 * @author pkapse
 *
 */
public class FieldValidator extends TestBase
{
	Login lp;

	
	public void fieldValidationBlankValues(WebDriver driver, String value)
	{		
		if(value.isBlank())
		{
			
		}
		else
		{
		
		}
	}
}
