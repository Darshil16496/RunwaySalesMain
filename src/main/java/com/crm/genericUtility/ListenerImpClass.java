package com.crm.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+" Test Execution Starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" Passed");
		Reporter.log(methodName+" TestScript Passes");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//EventFiringDriver ef = new EventFiringDriver(BaseClass.scd);
//		JavaUtility ju = 
		String failed  = result.getMethod().getMethodName();
		String FailedScript = failed+new JavaUtility().getSystemDateInFormat();
		//String fileName = result.getName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.scd; 
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\ScreenShot\\"+FailedScript+".png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, " Failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(FailedScript+" Fails");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, " Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+" Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReport/report.html");
		reporter.config().setDocumentTitle("RunwaySales");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("V-Tiger");
		
		 report = new ExtentReports();
		 report.attachReporter(reporter);
		 report.setSystemInfo("OS", "Windows");
		 report.setSystemInfo("Base-Browser", "Chrome");
		 report.setSystemInfo("Base-Url", "http://localhost.8888/");
		 report.setSystemInfo("Reporter Name", "Darshil");
		 
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
