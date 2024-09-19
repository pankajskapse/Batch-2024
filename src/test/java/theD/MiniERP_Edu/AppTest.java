package theD.MiniERP_Edu;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.sql.SQLException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @throws AWTException 
     */
    @Test
    public void shouldAnswerWithTrue() throws ClassNotFoundException, SQLException, AWTException
    {
        String S1= "Java,TestNG,etc";
        String SplitM[] = S1.split(",");
        
        for(int i=0; i<SplitM.length ;i++)
        System.out.println(SplitM[i]);
        
        String  s1 = "ABC" , s2="XYZ" , s3 = "PQR";
       // s1 = s1.concat(s2.concat(s3));
        System.out.println(s1.concat(s2.concat(s3)));
        
        loginAndUserRightsTest a = new loginAndUserRightsTest();
       a.veryUserRights();
        
    }
}
