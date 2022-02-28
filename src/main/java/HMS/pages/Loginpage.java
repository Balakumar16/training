package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.testbase;

public class Loginpage extends testbase{
	@FindBy(tagName="img")WebElement logo;
	@FindBy(css="h3.font-white")WebElement formtxt;
	@FindBy(css="input#email")WebElement usernametxt;
	@FindBy(css="input#password")WebElement passwordtxt;
	@FindBy(css="button.btn")WebElement signinbttn;
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public  boolean logocheck()
	{
		return logo.isDisplayed();
		
	}
	public String admintxt()
	{
		return formtxt.getText();
		
	}
	public void login(String user,String pass)
	{
		usernametxt.sendKeys(user);
		passwordtxt.sendKeys(pass);
		signinbttn.click();
	}
}
