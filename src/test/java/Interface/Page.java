package Interface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Page 
{
	//String[] page = new String[3];
	//public boolean verifyPageTitle(String currentTitle, String userName);	
	
	public boolean verifyPageTitle(String... page);	
	public boolean verifyMendatoryFields(WebDriver driver) throws InterruptedException;
}
