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
        driver.navigate().to("https://www.pnc.com/en/personal-banking/borrowing/private-student-loans/refinance-student-loans.html?lnksrc=topnav");

        Thread.sleep(3000);
        //define JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down to 800 pixels
        jse.executeScript("scroll(0,3600)");

        Thread.sleep(6000);

        ReusableActionsLoggers.clearAction(driver, "//*[@class = 'form-control lf-step-field-number ng-valid ng-dirty ng-valid-parse ng-valid-required ng-touched']", logger, "Clear Loan Balance");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@class = 'form-control lf-step-field-number ng-valid ng-dirty ng-valid-parse ng-valid-required ng-touched']", "53400", logger, "Enter Loan Balance");



        /*//click on Products & Services
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
        Thread.sleep(3000);
        //ReusableActionsLoggers.mouseHoverByIndex(driver, "//*[@class = 'lf-step-field-box-label ng-binding']", 1, logger, "hover");
        //ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'lf-step-field-box-label ng-binding']", 1, logger, "Undergraduate Degree");
        //ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'lf-step-field-box']", 1,  logger, "undergrad");

        //ReusableActionsLoggers.clickAction(driver, "((//*[@class='lf-step-field-box-container lf-step-field-box-'])[2])", logger, "Undergrad");
        Thread.sleep(5000);

        //clear and enter total student loan balances
        //ReusableActionsLoggers.clearAction(driver, "//*[@id = 'lf_RefiStudentLoanBalances']", logger, "Clear Loan Balance");
        //ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_RefiStudentLoanBalances']", "53400", logger, "Enter Loan Balance");

        ReusableActionsLoggers.clearAction(driver, "//*[@class = 'form-control lf-step-field-number ng-valid ng-dirty ng-valid-parse ng-valid-required ng-touched']", logger, "Clear Loan Balance");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@class = 'form-control lf-step-field-number ng-valid ng-dirty ng-valid-parse ng-valid-required ng-touched']", "53400", logger, "Enter Loan Balance");

        //clear and enter current monthly payments
        ReusableActionsLoggers.clearAction(driver, "//*[@id = 'lf_TotalStudentLoanPayments']", logger, "Clear Current Monthly Payments");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_RefiStudentLoanBalances']", "1500", logger, "Enter Current Monthly Payments");
        //clear and enter interest rate
        ReusableActionsLoggers.clearAction(driver, "//*[@id = 'lf_EffIntRateStudentLoans']", logger, "Clear Interest Rate");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_EffIntRateStudentLoans']", "5.05", logger, "Enter Interest Rate");
        //click continue
        //ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn btn-primary lf-step-btn ng-binding ng-scope']", logger, "Continue Button");*/



    }//end of test case 1

}


