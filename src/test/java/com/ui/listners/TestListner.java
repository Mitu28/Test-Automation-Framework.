package com.ui.listners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListner implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {

		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");

	}

	public void onTestFailure(ITestResult result) {
	    logger.error(result.getMethod().getMethodName() + " FAILED");
	    logger.error(result.getThrowable().getMessage());

	    ExtentTest test = ExtentReporterUtility.getTest();
	    if (test != null) {
	        test.log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
	        test.log(Status.FAIL, result.getThrowable().getMessage());

	        Object testclass = result.getInstance();
	        logger.info("Capturing screenshot for failed tests");

	        BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
	        String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());

	        if (screenshotPath != null) {
	            logger.info("Attaching screenshot to the HTML report");
	            test.addScreenCaptureFromPath(screenshotPath);
	        } else {
	            logger.error("Screenshot capture failed!");
	        }
	    } else {
	        logger.error("ExtentTest instance is null!");
	    }

	    ExtentReporterUtility.flushReport();  // Ensure report updates immediately
	}

	
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

	}

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReporterUtility.setupExtentReports("report.html");
		
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReporterUtility.flushReport();
	}
}
