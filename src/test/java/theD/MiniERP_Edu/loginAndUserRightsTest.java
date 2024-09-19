package theD.MiniERP_Edu;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.mysql.cj.xdevapi.Statement;

import pages.Login;
import stepDefinations.loginWelcome_SD;
import utils.TestBase;

public class loginAndUserRightsTest extends TestBase 
{
	String employeeRights[]= new String[20];
	int dbMenuCount=0;
	String user = "#99";
	String password ="99";
	
	@BeforeClass()
	public void verifyLoginPage() throws ClassNotFoundException, SQLException
	{
		initialization();
		//veryUserRights();
		//int a = 0;
	}
	
	@Test(priority = 1)	
	public void veryUserRights() throws ClassNotFoundException, SQLException, AWTException
	{
		
		loginWelcome_SD lw= new loginWelcome_SD();
		lw.login(user, password);	
		
		databaseConnection();
		
		List<WebElement> userMenu = driver.findElements(By.xpath("//div[@class='scroll-sidebar']/nav/ul/li"));
		if(dbMenuCount != userMenu.size())
		{
			System.out.println("Menu Count missmatch");
		}
	
		int i= 0;
		int jc=dbMenuCount;
		int isPresent = 0;
		while(userMenu.size()>i)
		{			
			//j=employeeRights.length;
			for(int j=jc;j>0;j--)
			{
				
				if(userMenu.get(i).getText().equalsIgnoreCase(employeeRights[j]))
				//if(employeeRights[j].equalsIgnoreCase(userMenu.get(i).getText()))
				{
					isPresent++;
				}
				
			}
			if (isPresent ==0)
			{
				System.out.println(userMenu.get(i).getText() + " is Not Presect");
				
			}
			
			isPresent = 0;
			i++;
		}
	}
	
	//@BeforeClass()
	public void databaseConnection() throws SQLException, ClassNotFoundException
	{		
		String UserName="#99";
		String Password="99";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String DB_URL ="jdbc:sqlserver://Pankaj:1433;Database=GBS_BlankDatabase;integratedSecurity=false;trustServerCertificate=true";

		String Query = "Select e.employeeName, m.menuname, er.erview, er.eradd, er.eredit, er.erdelete from m_emprights er \r\n"
				+ "Inner join m_menu m ON er.menukey = m.menukey\r\n"
				+ "Inner Join m_employee e ON er.employeekey = e.employeeKey\r\n"
				+ "where e.EmployeeID = '"+user+"' AND er.erview = 1";
		
		Connection con = DriverManager.getConnection(DB_URL, UserName, Password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(Query);
		int i=0;
		while(rs.next())
		{			
			employeeRights[i] =rs.getString("menuname");
			
			//System.out.println(employeeRights[i]);
			i++;
		}
		dbMenuCount = i;
	}
	
}
