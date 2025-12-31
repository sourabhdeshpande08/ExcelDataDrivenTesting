package dataDrivenTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenersNG {
	
	@Test
	public ExtentReports getExtentReports()
	{
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport/report.html");
		spark.config().setDocumentTitle("Excel Data Driven Testing");
		spark.config().setReportName("Web Automation Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("QA Automation Tester", "Sourabh Deshpande");
		return extent;
		
		
		
		
		
	}

}
