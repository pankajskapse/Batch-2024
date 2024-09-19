package pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Interface.Page;
import utils.TestBase;

public class Login extends TestBase implements Page
{
	@FindBy(xpath="//div[@class='scroll-sidebar']/nav/ul/li")
	WebElement userMenus;
	
	private String pageTitle = "Login";
	private WebElement userIDTxtBox;
	private WebElement passwordTxtBox;
	private WebElement submitBtn;
	private WebElement errorMessage;
	
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(WebElement errorMessage) {
		this.errorMessage = errorMessage;
	}

	public WebElement getUserIDTxtBox() {
		return userIDTxtBox;
	}

	public void setUserIDTxtBox(WebElement userIDTxtBox) {
		this.userIDTxtBox = userIDTxtBox;
	}

	public WebElement getPasswordTxtBox() {
		return passwordTxtBox;
	}

	public void setPasswordTxtBox(WebElement passwordTxtBox) {
		this.passwordTxtBox = passwordTxtBox;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}

	public Login()
	{
		userIDTxtBox = driver.findElement(By.xpath("//input[@id='txtUserID']"));
		passwordTxtBox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		submitBtn = driver.findElement(By.cssSelector("input[id='btnLogin']"));
		errorMessage = driver.findElement(By.xpath("//span[@id='lblErrorMessage']"));		
	}

	public boolean loginWithValidCredentials(WebDriver driver, String UserID, String Password) throws AWTException
	{
		userIDTxtBox.sendKeys(UserID);
		passwordTxtBox.sendKeys(Password);
		submitBtn.click();
		
		if(pageTitle.equals(driver.getTitle()))
		{
			//passwordTxtBox.sendKeys(Password);
			pressKey("Tab");
			pressKey("Enter");
			//System.out.println("I am still in Login page");
		}
		
		
		return true;
	}
	
	@Override
	public boolean verifyPageTitle(String... page) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyMendatoryFields(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
