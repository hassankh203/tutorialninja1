package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import testCases.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener {
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	String reportName;

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		String imgPath = takeScreenShot(result.getName());
		test.addScreenCaptureFromPath(imgPath);

	}

	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		reportName = "Test-Report-" + timeStamp + ".html";

		reporter = new ExtentSparkReporter(".\\reports\\" + reportName);// specify the location of report
		reporter.config().setReportName("tutorialsninja report");
		reporter.config().setDocumentTitle("My first report ninja");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Hassan.k");

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

}
