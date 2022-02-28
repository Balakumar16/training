package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HMS.Utility.commonutil;
import HMS.base.testbase;

public class Vistorpage extends testbase {
	
	@FindBy(xpath="//h3[text()='Visitor List']")WebElement vistortitle;
	@FindBy(css="div.box-tools>a")WebElement addvistor;
	@FindBy(xpath="//h4[text()='Add Visitor']")WebElement visscreentitle;
	@FindBy(css="form#formaddselect[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement phno;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement idpro;
	@FindBy(css="form#formadd input[name='pepples']")WebElement noper;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	@FindBy(css="form#formadd input[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	@FindBy(css="button.close")WebElement btnclose;
	public Vistorpage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyvistitle()
	{
		return vistortitle.isDisplayed() ;
}
     public void clickonaddvistor()
     {
    	 addvistor.click();
     }
public boolean checkforscreentitle()
{
	return visscreentitle.isDisplayed();
	
}
public void addvistordetails(String data[] )
{
	//Explictwait(purpose);
	Select drp=new Select(purpose);
	drp.selectByVisibleText(data[0]);
	pname.sendKeys(data[1]);
	phno.sendKeys(data[2]);
	idpro.sendKeys(data[3]);
	noper.sendKeys(data[5]);
	datepicker.click();
	dat.datpicker(data[4]);
	note.sendKeys(data[6]);
	commonutil.mouseclick(upfile);
	commonutil.fileupload(data[7]);
	//btnclose.click();
	
}
}