package HMS.Admin.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.Frontofficepage;
import HMS.pages.Loginpage;

public class Frontofficetest extends testbase {
	Loginpage objlog;
	Dashboardpage objdash;
	Frontofficepage objff;
	
	public Frontofficetest()
	{
		super();
	}
	public void setup()
	{
		initilization();
		objlog=new Loginpage();
		objlog.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
		objff=objdash.clickonfrontoffice();
		
	}
   @Test
   public void ffvistor()
   {
	  Assert.assertTrue(objff.verifytabletitle());
	  objff.clickonvistorbook();
   }
   @AfterClass
   public void teardown()
   {
	  driver.close(); 
   }
}
