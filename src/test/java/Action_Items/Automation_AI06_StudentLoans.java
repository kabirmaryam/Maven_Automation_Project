package Action_Items;

import ReusableLibrary.ReusableActions;
import ReusableLibrary.ReusableActionsLoggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static ReusableLibrary.ReusableAnnotations.driver;

public class Automation_AI06_StudentLoans extends ReusableAnnotations {

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

        Thread.sleep(2000);

        //define JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down to 800 pixels
        jse.executeScript("scroll(0,3600)");
        Thread.sleep(4000);

        //switch into the calculator
        driver.switchTo().frame("lf_tool_frame");

        //click Undergraduate Degree
        ReusableActionsLoggers.clickAction(driver, "//*[@id = 'lf_HighestDegree__3']", logger, "Undergraduate Degree");
        //highlight and enter total student loan balances
        driver.findElement(By.xpath("//*[@id = 'lf_RefiStudentLoanBalances']")).sendKeys(Keys.CONTROL, "a");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_RefiStudentLoanBalances']", "53400", logger, "Enter Loan Balance");
        //highlight and enter current monthly payments
        driver.findElement(By.xpath("//*[@id = 'lf_TotalStudentLoanPayments']")).sendKeys(Keys.CONTROL, "a");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_TotalStudentLoanPayments']", "1500", logger, "Enter Current Monthly Payments");
        //highlight and enter interest rate
        driver.findElement(By.xpath("//*[@id = 'lf_EffIntRateStudentLoans']")).sendKeys(Keys.CONTROL, "a");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lf_EffIntRateStudentLoans']", "5.05", logger, "Enter Interest Rate");
        Thread.sleep(3000);

        //click continue
        //ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn btn-primary lf-step-btn ng-binding ng-scope']", logger, "Continue Button");
    }//end of test case 1

    @Test(priority = 2)
    public void tc002_recallAndCalculateRatePaymentPart2() throws InterruptedException {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc002_recallAndCalculateRatePaymentPart2");

        //click save for later button
        ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn btn-primary lf-CTA-btn ng-binding']", logger, "Save for Later" );
        Thread.sleep(3000);
        //capture code
        String saveForLaterCode = ReusableActionsLoggers.getTextAction(driver, "//*[@id = 'lf-cfid-label']", logger, "Save for Later Code");
        Thread.sleep(2000);

        //define JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down to 800 pixels
        jse.executeScript("scroll(-3600,0)");
        Thread.sleep(4000);

        //switch outside the iframe calculator
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //click on Products & Services
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'cmp-listpro__item-text']", 1, logger, "Products & Services");
        //click on Student Loans Refinancing
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'cmp-listpro__item-text']", 19, logger, "Student Loans Refinancing");

        //scroll down to 800 pixels
        jse.executeScript("scroll(0,3600)");

        Thread.sleep(2000);
        //switch into the calculator
        driver.switchTo().frame("lf_tool_frame");
        Thread.sleep(2000);

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
        Thread.sleep(2000);

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
