package RailCTC.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportRailCTC {
	
	public static ExtentReports getReportObject() {
		
		//String reportfiles=System.getProperty("user.dir"+"//reportFiles"+"index.html");
		String reportFiles=System.getProperty("user.dir")+"//reportFiles//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportFiles);
		reporter.config().setReportName("IRCTC Test Execution Reports");
		reporter.config().setDocumentTitle("IRCTC Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test", "Shivaling Neralagi");
		return extent;
	}

}
