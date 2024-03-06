package com.obs.generic.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestListnerImplementationClass implements ITestListener
{
	ExtentSparkReporter htmlreport;
	ExtentReports report;
	ExtentTest test;


	public void onTestStart(ITestResult result) 
	{
				String methodName = result.getMethod().getMethodName();
				test = report.createTest(methodName);
				test.log(Status.INFO, "Executiion Starts");
				Reporter.log(methodName+"----> Execution Starts");
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
			test = report.createTest(methodName);
			test.log(Status.SKIP, result.getThrowable());
			test.log(Status.INFO, methodName);
			Reporter.log(methodName+"----> Method Skipped");
			
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
			}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		 htmlreport= new ExtentSparkReporter("./extentReport/report.html");
		 htmlreport.config().setDocumentTitle("OBS Execution Report");
		 htmlreport.config().setTheme(Theme.STANDARD);
		 htmlreport.config().setReportName("OBS part 1");
		 
		 report = new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("Base Platform", "Windows 11");
		 report.setSystemInfo("Base Browser", "Windows 11");
		 report.setSystemInfo("Base Url ", "http://rmgtestingserver/domain/Online_Banking_System/");


	}

	public void onFinish(ITestContext context) {
		report.flush();

	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.PASS, methodName);
		test.log(Status.INFO, methodName);
		Reporter.log(methodName+"  Success");
		
	}

	public void onTestFailure(ITestResult result)
	{
		String path="";
		WebdriverUtils w = new WebdriverUtils();
		String methodName = result.getMethod().getMethodName();
		try {
			 path = w.getScreenShot(BaseClass.driver, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test = report.createTest(methodName);
		test.log(Status.FAIL,methodName);
		test.log(Status.INFO, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
	}

}
