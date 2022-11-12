package Action_Items;

import ReusableLibrary.ReusableActions;
import ReusableLibrary.ReusableActionsLoggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static ReusableLibrary.ReusableAnnotations.driver;

public class Automation_AI06_StudentLoans extends ReusableAnnotations {
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

        //define JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down to 800 pixels
        jse.executeScript("scroll(0,3600)");
        Thread.sleep(4000);

        //click Undergraduate Degree
        ReusableActionsLoggers.clickAction(driver, "//*[@id = 'lf_HighestDegree__3']", logger, "Undergraduate Degree");
        //clear and enter total student loan balances
        ReusableActionsLoggers.clearAction(driver, "//*[@id = 'lf_RefiStudentLoanBalances']", logger, "Clear Loan Balance");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_RefiStudentLoanBalances']", "53400", logger, "Enter Loan Balance");
        //clear and enter current monthly payments
        ReusableActionsLoggers.clearAction(driver, "//*[@id = 'lf_TotalStudentLoanPayments']", logger, "Clear Current Monthly Payments");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_RefiStudentLoanBalances']", "1500", logger, "Enter Current Monthly Payments");
        //clear and enter interest rate
        ReusableActionsLoggers.clearAction(driver, "//*[@id = 'lf_EffIntRateStudentLoans']", logger, "Clear Interest Rate");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_EffIntRateStudentLoans']", "5.05", logger, "Enter Interest Rate");
        //click continue
        ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn btn-primary lf-step-btn ng-binding ng-scope']", logger, "Continue Button");
    }//end of test case 1

    @Test(priority = 2)
    public void tc002_saveAndRecallAndCalculateRatePaymentPart2() throws InterruptedException {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc002_saveAndRecallAndCalculateRatePaymentPart2");

        //click save for later button
        ReusableActionsLoggers.clickAction(driver, "//*[@id = 'lf_save_later_btn']", logger, "Save for Later");
        //capture code
        String saveForLaterCode = ReusableActionsLoggers.getTextAction(driver, "//*[@id = 'lf-cfid-label']", logger, "Save for Later Code");
        //click on Student Loans Refinancing
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'cmp-listpro__item-text']", 19, logger, "Student Loans Refinancing");
        //click on Calculate Rate & Payment
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'description large']", 2, logger, "Calculate Rate & Payment");
        //recall previous work
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_code']", saveForLaterCode, logger, "Enter Code");
        ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn btn-primary btn-xs lf-code-button focus-only ng-binding']", logger, "Recall button");
        //click continue
        ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn btn-primary lf-step-btn ng-binding ng-scope']", logger, "Continue Button");
        //Do you own a home?
        ReusableActionsLoggers.clickAction(driver, "//*[@id = 'lf_DoYouOwnAHome__2']", logger, "No Own a Home");
        //enter zip code
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_ZipCode']", "11201", logger, "Enter Zip Code");
    }//end of test case 2

    @Test(priority = 3)
    public void tc003_educationRefinanceLoanInfo() throws InterruptedException {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc003_educationRefinanceLoanInfo");

        //click get results
        ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn btn-primary lf-step-btn ng-binding ng-scope']", logger, "Get Results");
        //capture APR info
        String APR_1 = ReusableActionsLoggers.getTextActionByIndex(driver, "//*[@class = 'lf-results-row-minor-label ng-binding']", 1, logger, "APR Info 1");
        String APR_2 = ReusableActionsLoggers.getTextActionByIndex(driver, "//*[@class = 'lf-results-row-minor-value ng-binding']", 1, logger, "APR Info 2");
        System.out.println(APR_1 + APR_2);
        //capture closing costs info
        String CC_1 = ReusableActionsLoggers.getTextActionByIndex(driver, "//*[@class = 'lf-results-row-minor-label ng-binding']", 2, logger, "Closing Costs 1");
        String CC_2 = ReusableActionsLoggers.getTextActionByIndex(driver, "//*[@class = 'lf-results-row-minor-value ng-binding']", 2, logger, "Closing Costs 2");
        System.out.println(CC_1 + CC_2);
        //capture estimated monthly savings
        String EMS_1 = ReusableActionsLoggers.getTextActionByIndex(driver, "//*[@class = 'lf-results-row-minor-label ng-binding']", 3, logger, "Estimated Monthly Savings 1");
        String EMS_2 = ReusableActionsLoggers.getTextActionByIndex(driver, "//*[@class = 'lf-results-row-minor-value ng-binding']", 3, logger, "Estimated Monthly Savings 2");
        System.out.println(EMS_1 + EMS_2);
        //initial monthly payment
        String IMP = ReusableActionsLoggers.getTextActionByIndex(driver, "//*[@class = 'lf-results-row-major-value ng-binding']", 0, logger, "Initial Monthly Payment");
        System.out.println("Initial Monthly Payment: " + IMP);
    }//end of test case 3

}//end of class
