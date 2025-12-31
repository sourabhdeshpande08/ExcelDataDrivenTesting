package dataDrivenTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener {
	
	ListenersNG listen = new ListenersNG();
	ExtentReports extent = listen.getExtentReports();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal();
	WebDriver driver;
	String destinationFilePath;
	
	@Test
	public void onTestStart(ITestResult result) {
		
		test =  extent.createTest(result.getMethod().getMethodName());
		thread.set(test);
		
	   }
	
	
	public void onTestSuccess(ITestResult result) {
	    
		thread.get().log(Status.PASS, "The test case named "+result.getMethod().getMethodName()+" is passed.");
		
		}
	
	public void onTestFailure(ITestResult result) {
	    
		thread.get().fail(result.getThrowable());
		
		try {
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		
		try {
		destinationFilePath = getScreenshot(result.getMethod().getMethodName());
		} catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		thread.get().addScreenCaptureFromPath(destinationFilePath);
		
	  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  
		}
	
	

}
