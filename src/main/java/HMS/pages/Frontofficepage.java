package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.testbase;

public class Frontofficepage extends testbase{
	@FindBy(xpath="//h3[text()='Appointment Details']")WebElement fftitle;
    @FindBy(css="div.box-tools>a:nth-child(2)")WebElement vistorbook;
    
    public Frontofficepage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public Boolean verifytabletitle()
    {
		return fftitle.isDisplayed();
    	
    }
    public Vistorpage clickonvistorbook()
    {
    	vistorbook.click();
		return new Vistorpage();
    }
}
