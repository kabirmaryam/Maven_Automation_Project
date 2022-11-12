package Practice;

import ReusableLibrary.ReusableActions;
import ReusableLibrary.ReusableActionsLoggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class practiceAI06 extends ReusableAnnotations {

    @BeforeSuite
    public void setDriver() {
        driver = ReusableActions.setUpDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html", true);
    }

    @AfterSuite
    public void quitSession() {
        driver.quit();
        //writing the logs back to the report
        reports.flush();
    }

    @Test(priority = 1)
    public void tc001_calculateRateAndPaymentPart1() throws InterruptedException {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc001_calculateRateAndPaymentPart1");

        //navigate to pnc homepage
        driver.navigate().to("https://www.pnc.com/en/personal-banking.html");

        Thread.sleep(2000);

        //click on Products & Services
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'cmp-listpro__item-text']", 1, logger, "Products & Services");
        //click on Student Loans Refinancing
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'cmp-listpro__item-text']", 19, logger, "Student Loans Refinancing");
        //click on Calculate Rate & Payment
        //ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'description large']", 2, logger, "Calculate Rate & Payment");
        Thread.sleep(2000);
        //define JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down to 800 pixels
        jse.executeScript("scroll(0,3600)");
        Thread.sleep(5000);
        //ReusableActionsLoggers.mouseHoverByIndex(driver, "//*[@class = 'lf-step-field-box-label ng-binding']", 1, logger, "hover");
        //ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'lf-step-field-box-label ng-binding']", 1, logger, "Undergraduate Degree");
        ReusableActionsLoggers.clickAction(driver, "//*[@id = 'lf_HighestDegree__4']", logger, "grad");
        Thread.sleep(5000);
    }
}
