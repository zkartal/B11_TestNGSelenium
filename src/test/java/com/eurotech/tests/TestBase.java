package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    // We added from ExtendReportsDemo Class
   protected ExtentReports report;
   protected  ExtentHtmlReporter htmlReporter;
   protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        //This will initialize the ExtentReports Class
        report = new ExtentReports();

        //Create a report path --> how can we find our project dynamically
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //Initialize the HTML report with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //Attach the HTML Report to the report object
        report.attachReporter(htmlReporter);

        //We need to give a title for report
        htmlReporter.config().setReportName("Batch11 Smoke Test");

        //Set environment information--> Test name, Tester name, Browser, Test Steps, Test Data, Date and Time, Operating System, Result
        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Zafer");

    }
    @AfterTest
    public void tharDownTest(){
        //This is when the report is actually created
        report.flush();
    }
    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
        wait=new WebDriverWait(driver,15);
        actions=new Actions(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //If test is failed
        if (result.getStatus()==ITestResult.FAILURE){
            //Record the name of the failed test
            extentLogger.fail(result.getName());

            //Take the screenshot (evidence) and return its location
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());

            //Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(2000);

        Driver.closeDriver();
    }
}