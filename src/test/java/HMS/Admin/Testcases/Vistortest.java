package HMS.Admin.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HMS.Utility.ReadExcel;
import HMS.base.testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.Frontofficepage;
import HMS.pages.Loginpage;
import HMS.pages.Vistorpage;

public class Vistortest extends testbase {
	Loginpage objlog;
	Dashboardpage objdash;
	Frontofficepage objff;
	Vistorpage objvis;
	
	public Vistortest()
	{
		super();
	}
	@BeforeMethod 
	public void setup()
	{
		initilization();
		objlog=new Loginpage();
		objdash=objlog.login(prop.getProperty("Username"), prop.getProperty("Password"));
		objff=objdash.clickonfrontoffice();
		objvis=objff.clickonvistorbook();
	}
	@DataProvider
	public Object[][] visdata()
	{
		Object[][] data=ReadExcel.getTestData("testdata");)
		return data;
		
	}
	@Test(dataProvider="visdata")
	public void addvistordetails(String vis[])
	{
		Assert.assertTrue(objvis.verifyvistitle());
		objvis.clickonaddvistor();
		//Assert.assertTrue(objvis.checkforscreentitle());
		objvis.addvistordetails(vis);
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
