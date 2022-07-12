package KiteBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;



import KiteUtility.UtilityProp;

public class BaseNew 
{
	protected static WebDriver driver;
    public void openBrowser() throws IOException
	{
    	
       System.setProperty("webdriver.chrome.driver","C:\\javaselenium\\chromedriver.exe");
       
	    ChromeOptions opt=new ChromeOptions();
        //opt.addArguments("headless");
	    opt.addArguments("disable-notifications");
       // opt.addArguments("incognito");
        driver=new ChromeDriver(opt);
	
	   driver.get("https://Kite.zerodha.com");
	   driver.manage().window().maximize();
	   driver.get(UtilityProp.getDataFromPropertyFile("URL"));
	   Reporter.log("launch Browser",true);
	   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	  
	}
	
}
