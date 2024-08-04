package runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.Base;

/**
 * @author 
 * 
 */

public class TestNGListener extends Base implements ITestListener {

    
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("On test Sucess");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test failure");
        String methodName = iTestResult.getName();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/" + methodName + ".png"));
            System.out.println("Screenshot saved for failed test: " + methodName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");
    }


    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
    }
}
