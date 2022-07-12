package KiteUtility;


import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



public class UtilityListener extends UtilityProp implements ITestListener
{
		
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("tc is passed TC name is"+result.getName(),true);
	}
	

	public void onTestFailure(ITestResult result)
	{
		
		Reporter.log("tc is failed TC name is"+result.getName(),true);
		try 
		{
			captureScreenshot();
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	


}
