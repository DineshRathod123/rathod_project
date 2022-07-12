package KiteTest;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import KiteBase.BaseNew;
import KitePOM.KiteHomePage;
import KitePOM.KiteLoginPage;
import KitePOM.KitePinPage;
import KiteUtility.UtilityProp;



@Listeners(KiteUtility.UtilityListener.class)
public class ValidateKiteUserIDByListener extends BaseNew
{

    KiteHomePage home;
    KiteLoginPage login;
	KitePinPage pin;
	//String TCID="333";
	
	@BeforeClass
	public void launchBrowser() throws IOException 
	  {
		  openBrowser();
		  
		  login=new KiteLoginPage(driver);
		  pin=new KitePinPage(driver);
		  home=new KiteHomePage(driver);	  
		  
	  }
	  
	  @BeforeMethod
	  public void loginToKiteApp() throws IOException
	  {
		  login.sendUserName(UtilityProp.getDataFromPropertyFile("UN"));
		  login.sendPassword(UtilityProp.getDataFromPropertyFile("PWD"));;
		  login.clickOnLoginButton();
		  Reporter.log("click on login button",true);
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		  
		  pin.sendPin(UtilityProp.getDataFromPropertyFile("PIN"));
		  pin.clickOncontinueButton();
		  Reporter.log("click on continue button",true);
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		  	  
	  }
	  
	  @Test
	  public void validateUserID() throws IOException
	  {
		  
		  Assert.assertEquals(home.getActualUserName(),UtilityProp.getDataFromPropertyFile("UN"));
		  Assert.fail();
		 // UtilityProp.captureScreenshot(driver,TCID);
		  	  
	  }
	  
	  @AfterMethod
	  public void logOutFromKite() throws InterruptedException
	  {
		  home.logOut();
		  Reporter.log("logging out",true);
	  }
	  
	  @AfterClass
	  public void closeBrowser() throws InterruptedException
	  {
		  Thread.sleep(1000);
		  Reporter.log("closing browser",true);
		  driver.close();
	  }
	
}
