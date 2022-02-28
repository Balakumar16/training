package HMS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HMS.Utility.Activitycapture;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testbase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event;
	public static Activitycapture actcap;
	
	
	
	public testbase()
	{
		try {
			FileInputStream ipf=new FileInputStream("./src/main/java/HMS/config/Appconfig.properties");
			prop=new Properties();
			prop.load(ipf);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initilization()
	{
		String runbrowser=prop.getProperty("Browser");
		if(runbrowser.equals("chrome"))
		{
			
		
		
		String headless=prop.getProperty("Headless");
		
		if(headless.equals("true"))
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--headless");
			
			driver=new ChromeDriver(opt);
			
			
			
			
		}else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		}else if(runbrowser.equals("Firefox"))
		 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}else if(runbrowser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		//basic method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		
		event=new EventFiringWebDriver(driver);
		actcap=new Activitycapture();
		event.register(actcap);
		driver=event;
		
	}

	public static void Explicitwait(WebElement el)
	{
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(30));
		wt.until(ExpectedConditions.invisibilityOf(el));
		
	}
	
	

}
