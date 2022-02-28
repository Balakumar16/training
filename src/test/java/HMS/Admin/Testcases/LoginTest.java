package HMS.Admin.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.Loginpage;

public class LoginTest extends testbase {
	
	Loginpage objlog;
	
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initilization();
		objlog=new Loginpage();
		
	}
	
	@Test
	public void loginpagetest()
	{
		Assert.assertTrue(objlog.logocheck());
		String expectedtitle="Admin Login";
		Assert.assertEquals(expectedtitle,objlog.admintxt() );
		objlog.login(prop.getProperty("Username"),prop.getProperty("Password"));
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	

}
