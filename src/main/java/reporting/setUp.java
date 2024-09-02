package reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class setUp implements ITestListener {

    private static ExtentReports extentReport;
    public static ThreadLocal<ExtentTest> extentTest  = new ThreadLocal<>();

    public void onStart(ITestContext context) {
        String reportName = ExtentReportUtils.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "/reports/" + reportName;
        extentReport = ExtentReportUtils.createInstance(fullReportPath,reportName, "Test Execution Results");
    }


    public void onFinish(ITestContext context) {
        if(extentReport!=null){
            extentReport.flush();
        }

    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtils.logFailureDetails(result.getThrowable().getMessage());
    }

}
