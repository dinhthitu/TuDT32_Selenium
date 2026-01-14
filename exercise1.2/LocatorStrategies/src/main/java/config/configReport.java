package config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class configReport {
    public static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/TestReport.html");

            reporter.config().setReportName("Locator Strategies Report");
            reporter.config().setDocumentTitle("Selenium Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
