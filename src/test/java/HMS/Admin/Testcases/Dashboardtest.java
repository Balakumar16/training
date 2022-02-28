package HMS.Admin.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.Loginpage;

public class Dashboardtest extends testbase {
	Loginpage objlog;
	Dashboardpage objdash;
	
	public Dashboardtest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initilization();
		objlog=new Loginpage();
		objlog.login(prop.getProperty("Username"), prop.getProperty("Password"));
		objdash=new Dashboardpage();
	}
  @Test
  public void dashtest()
  {
	  
	  String expectedtitle="Smart Hospital Management System";
	  Assert.assertEquals(expectedtitle, objdash.verifytitle());
	  objdash.clickonprofile();
	  String Expectedtext="Super Admin";
	  
	  Assert.assertEquals(objdash.verifyusername(), Expectedtext);
	  objdash.clickonlogout();
	  
	  
	  
	  
  }
  @AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	
	
}
