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

import com.utility.LoggerUtility;


public class TestListner implements ITestListener {
    Logger logger = LoggerUtility.getLogger(getClass());

    //Logger logger = LoggerUtility.getLogger(this.getClass());
    private ExtentSparkReporter extentSparkReporter;
    private ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");

        // Correct setup for ExtentReports 5.1.2
        extentSparkReporter = new ExtentSparkReporter("target/SparkReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        logger.info("ExtentReports initialized successfully");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Starting test: " + result.getMethod().getMethodName());
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " PASSED");
        extentTest.get().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " FAILED");
        logger.error(result.getThrowable().getMessage());

        ExtentTest test = extentTest.get();
        test.log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        test.log(Status.FAIL, result.getThrowable().getMessage());

        Object testClass = result.getInstance();
        logger.info("Capturing screenshot for failed test");

        BrowserUtility browserUtility = ((TestBase) testClass).getInstance();
        String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());

        if (screenshotPath != null) {
            logger.info("Attaching screenshot to the report");
            test.addScreenCaptureFromPath(screenshotPath);
        } else {
            logger.error("Screenshot capture failed!");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " SKIPPED");
        extentTest.get().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        extentReports.flush();
    }
}
