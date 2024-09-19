package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import com.coeuraj.actiondriver.Action;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

//import java.io.FileReader;
import java.util.Iterator;
import java.util.List;


public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	String path ="C:\\Users\\Acer\\eclipse-workspace\\MiniERP-Edu\\src\\test\\java\\TestData\\Images\\";
	String UploadImage = "C:\\Users\\Acer\\eclipse-workspace\\MiniERP-Edu\\src\\test\\java\\TestData\\Images\\ProfileImage.png";
	String ScreenshotFilePath = "C:\\Users\\Acer\\eclipse-workspace\\MiniERP-Edu\\src\\test\\java\\TestData\\Screenshots"; //prop.getProperty("ScreenshotFilePath"); //
	
	public String MessageLog ="";
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Acer\\eclipse-workspace\\MiniERP-Edu\\src\\test\\java\\config\\config.properties");										
			prop.load(fis);
			//initialization();
		}
		catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	
	public static void initialization() 
	{
		String browserName = prop.getProperty("browser");
		  if (browserName.equals("Chrome")) {
			  
			  System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\01Drivers\\chromedriver-win64_128\\chromedriver.exe");
			  //driver= new ChromeDriver();
			  
//			  ChromeOptions chromeOptions = new ChromeOptions();
//			  chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
//			  driver = new ChromeDriver(chromeOptions);
//			  
			  ChromeOptions chromeOptions = new ChromeOptions();
			  chromeOptions.addArguments("--remote-allow-origins=*");
			 // chromeOptions.addArguments("user-data-dir=C:/path/to/your/custom/profile");
			  driver = new ChromeDriver(chromeOptions);
			  
			    
		  } 
		  else if (browserName.equals("FireFox")) {
			 System.setProperty("webdriver.gecko.driver", "C:\\TestAutomation\\01Drivers\\geckodriver.exe");
			  driver = new FirefoxDriver();
		  }
		  else  if (browserName.equals("IE")) {
			  System.setProperty("webdriver.ie.driver", "C:\\TestAutomation\\01Drivers\\IEDriverServer.exe");
			  driver= new InternetExplorerDriver();
		  }
		 driver.manage().window().maximize();		  
	     driver.manage().deleteAllCookies();
		  
		  Action.implicitWait(driver, 20);
		  Action.pageLoadTimeOut(driver, 15);
		  driver.get(prop.getProperty("url"));
		  JavascriptExecutor js = (JavascriptExecutor) driver;  
		  js.executeScript("localStorage.setItem(arguments[0],arguments[1])", "[49]lastVisitedProjectPage", "/projects/101");
		
	}
	public void scrollDown(WebElement element) // Method added by Pankaj Kapse
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);			
	}
	public void getScreenShotPath(String tastCaseName) throws IOException // Method added by Pankaj Kapse
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = ScreenshotFilePath + tastCaseName + ".png";
		File DestFile=new File(destinationFile);
		FileUtils.copyFile(source, DestFile);
	}
	public void clickByJavaScript(WebElement element) // Method added by Pankaj Kapse
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver; 
		executor.executeScript("arguments[0].click();", element);
	}
	
	 /***************Start****************
	 * getReportConfigPath method
	 * To get extent report xml path from config file by Pankaj Kapse on 10th of Oct 2021 * */
	
	public String getReportConfigPath(){
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	public String getWebElementIdentifier(String element) throws IOException, CsvException // Method added by Pankaj Kapse
	{
		String FileReaderPath="";
		CSVReader reader;
		if(element.startsWith("Error")) // Added by Pankaj Kapse on 09-Jun-2022
		{
			FileReaderPath = "C:\\TestAutomation\\coeuraj\\src\\test\\java\\TestData\\ErrorMessages.csv";
		}		
		else if(element.startsWith("TestData")) // Changes made by Pankaj Kapse on 10-Aug-2022
		{
			FileReaderPath="C:\\TestAutomation\\coeuraj\\src\\test\\java\\TestData\\TestData.csv";
		}
		else if(element.startsWith("Xpath")) // Changes made by Pankaj Kapse on 09-Jun-2022
		{
			FileReaderPath="C:\\TestAutomation\\coeuraj\\src\\test\\java\\TestData\\WebElementIdentifiers.csv";
		}
		
		reader = new CSVReader(new FileReader(FileReaderPath));
		
		  List<String[]> li=reader.readAll();
		  System.out.println("Total rows which we have is "+li.size());
		            
		 // create Iterator reference
		  Iterator<String[]>i1= li.iterator();
		    
		 // Iterate all values 
		 while(i1.hasNext())
		 {
			 String[] str=i1.next();		   
			// System.out.print(" Values are ");
		 
			 if(str[0].equals(element))
			 {				
					return str[1];								 
			 }
		 }	
		 return "-1";
	}
	public String getApplicationMessage(String element) throws IOException, CsvException // Method added by Pankaj Kapse on 09-Jun-2022
	{
		String message = getWebElementIdentifier(element);
		return message;		
	}
	
	public String getTestData(String field) throws IOException, CsvException
	{
		String fieldTestData = getWebElementIdentifier(field);
		return fieldTestData;
	}
	public void writeFile(String filePath, String newString) // Method added by Pankaj Kapse
	{
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter(filePath, true));
		      //FileWriter myWriter = new FileWriter(filePath);
		      myWriter.write(newString);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);           
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources                 
                reader.close();                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
	/**************END****************/
	public void FileUpload(String imageName) throws AWTException 
	{
		//"image.jpg"
		Robot robot=new Robot();
		robot.setAutoDelay(2000);		
		StringSelection stringselection=new StringSelection(path+imageName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void pressKey(String action) throws AWTException
	{
		Robot robot=new Robot();
		if(action == "Enter")
			robot.keyPress(KeyEvent.VK_ENTER);
		if(action == "Tab")
			robot.keyPress(KeyEvent.VK_TAB);
	}
	public void FileUpload() throws AWTException {
		Robot robot=new Robot();
		robot.setAutoDelay(2000);		
			
		StringSelection stringselection=new StringSelection(UploadImage+"\\img.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	
	public void methodTocopyRequiredContent(String str) {
		
		//String string = "";

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(str);
		clipboard.setContents(strSel, null);
		
	}
}
