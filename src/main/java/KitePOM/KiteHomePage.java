package KitePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 

{
	// 1. Data Member
	
	@FindBy (xpath = "//span[@class='user-id']") private WebElement userName;
	@FindBy (xpath = "//a[@target='_self']") private WebElement logOutButton;
	
	// 2. constructor
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// 3. method
	
	public void validateUserName(String expectedUserID)
	{
		String expectedUserName=expectedUserID;
		String actualUserName=userName.getText();
		
		if(expectedUserName.equals(actualUserName))
		{
			System.out.println("Actual and Expected user id are matching TC is passed");
		}
		else
		{
			System.out.println("Actual and Expected user id are not matching TC is failed");
		}
		
	}
	  // to get actual userName
	 
	public String getActualUserName()
	{
		String actualUserName = userName.getText();
		return actualUserName;
		
	}
	 
	public void logOut() throws InterruptedException 
	{
		userName.click();
		Thread.sleep(200);
		logOutButton.click();
	}
  
	
}
