package com.eurotech.tests.day18_extentReports_screenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportsDemo {
    // This object will be used for starting and building reports
    ExtentReports report;

    // This object will the used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    // This object will define a test, enable adding logs, authors and test steps.
    ExtentTest extentlogger;

    @BeforeMethod
    public void setUp() {
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

    @Test
    public void test1() {
        // Let's give
        extentlogger= report.createTest("TC001 Loggin Test");
        //
        extentlogger.info("Open The Browser");
        extentlogger.info("Go To URL "+ ConfigurationReader.get("url"));
        extentlogger.info("Click I Understand Button");
        extentlogger.info("Enter Teacher Username");
        extentlogger.info("Enter Teacher Password");
        extentlogger.info("Click Button");
        extentlogger.info("Verify Logged In");
    }

    @AfterMethod
    public void tearDown() {
        //This is when the report is actually created
        report.flush();
    }
}