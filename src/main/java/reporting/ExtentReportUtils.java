package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportUtils extends  setUp{

    public static ExtentReports extentReports;
    public static ExtentReports createInstance(String filePath,String reportName, String documentTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }
    
    public static String getReportNameWithTimeStamp() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatTime = dateTimeFormatter.format(localDateTime);
        return "TestReport" + formatTime+ ".html";

    }

    public static void logPassDetails(String logs){
        extentTest.get().pass(MarkupHelper.createLabel(logs, ExtentColor.GREEN));
    }

    public static void logFailureDetails(String logs){
        extentTest.get().fail(MarkupHelper.createLabel(logs, ExtentColor.RED));
    }

    public static void logInfoDetails(String logs){
        extentTest.get().info(MarkupHelper.createLabel(logs, ExtentColor.TEAL));
    }

    public static void logNewAPICALLDetails(String logs){
        extentTest.get().info(MarkupHelper.createLabel(logs, ExtentColor.PURPLE));
    }

    public static void logErrorDetails(String logs){
        extentTest.get().info(MarkupHelper.createLabel("Exception Found",ExtentColor.RED));
        extentTest.get().info(new RuntimeException(logs));
    }
 
    public static void logWarningDetails(String logs){
        extentTest.get().warning(MarkupHelper.createLabel(logs, ExtentColor.YELLOW));
    }

    public static void logJSON(String json){
        extentTest.get().info(MarkupHelper.createCodeBlock(json,CodeLanguage.JSON));
    }

    public static void logHeader(List<Header> headerList) {
        String[][] arrayOfHeaders = headerList.stream().map(header-> new String[] {header.getName(), header.getValue()}).toArray(String[][] :: new);
        extentTest.get().info(MarkupHelper.createTable(arrayOfHeaders));
    }
}

