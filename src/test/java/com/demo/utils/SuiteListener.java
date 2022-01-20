package com.demo.utils;

import com.demo.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

/**
 * this class contains listeners for tests
 */
public class SuiteListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    /**
     *
     * @param result
     */
    @Override
    public void onTestFailure(ITestResult result) {
        String fileName="screenshots" + File.separator + result.getMethod().getMethodName();
       File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);

       try{
           FileUtils.copyFile(f, new File(fileName + ".png"));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
