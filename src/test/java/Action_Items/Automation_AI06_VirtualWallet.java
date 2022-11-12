package Action_Items;

import ReusableLibrary.ReusableActions;
import ReusableLibrary.ReusableActionsLoggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Automation_AI06_VirtualWallet extends ReusableAnnotations {
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
    public void tc001_applyingForVirtualWallet() throws InterruptedException {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc001_applyingForVirtualWallet");

        //navigate to pnc homepage
        driver.navigate().to("https://www.pnc.com/en/personal-banking.html");

        Thread.sleep(3000);

        //click on Products & Services
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'cmp-listpro__item-text']", 1, logger, "Products & Services");
        //click on virtual wallet
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'cmp-listpro__item-text']", 2, logger, "Virtual Wallet");
        //clear zip code
        ReusableActionsLoggers.clearAction(driver, "//*[@class = 'required']", logger, "Clear Zip Code" );
        //enter zip code
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@class = 'required']", "11208", logger, "Enter Zip Code");
        //click submit
        ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn-secondary']", logger, "Click Zip Code");
        Thread.sleep(5000);
        //click apply now
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'btn-blue']", 1, logger, "Apply for Checking & Savings button");
        Thread.sleep(3000);
        //click no due to being a new customer
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class='mat-radio-container']", 1, logger, "No Radio Button");
        Thread.sleep(3000);
        //click next
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@type = 'button']", 1, logger, "Next button");
    }//end of test case 1

    @Test(priority = 2)
    public void tc002_fillingOutInfoPage1() throws InterruptedException {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc002_fillingOutInfoPage1");

        //enter first name
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'firstName']", "Maryam", logger, "First Name");
        //enter last name
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'lastName']", "Kabir", logger, "Last Name");
        //enter date of birth
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'field-info-dob']", "01/10/1999", logger, "Date of Birth");
        //enter email address
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'email']", "kabirmaryam000@gmail.com", logger, "Email Address");
        //re-enter email address
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'email2']", "kabirmaryam000@gmail.com", logger, "Email Address");
        //enter phone number
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id='primaryPhoneNumber']", "9174962531", logger, "Phone Number");
        //citizenship status
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'mat-radio-outer-circle']", 0, logger, "US Citizenship");
        //enter SSN
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'field-ssn']", "123456789", logger, "SSN");
        //address
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'primaryAddressLine1']", "96 Schermerhorn Street", logger, "Address Line 1");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'primaryAddressLine2']", "11B", logger, "Address Line 2");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'primaryCity-label']", "Brooklyn", logger, "City");
        ReusableActionsLoggers.selectByText(driver, "//*[@aria-labelledby = 'primaryStateProvince-label']", "NY", logger, "State");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id= 'primaryPostalCode']", "11201", logger, "Zip Code");
        //lived in the current address for less than 6 months
        ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'mat-radio-container']", 4, logger, "No button");
        //id type
        ReusableActionsLoggers.selectByText(driver, "//*[@aria-labelledby = 'type-label']", "Driver's License", logger, "Selecting Driver's License");
        Thread.sleep(2000);
        //id information
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id ='driversLicenseNumber']", "123456789", logger, "Driver's License Number");
        ReusableActionsLoggers.selectByText(driver, "//*[@aria-labelledby = 'field-your-issuing-state-label']", "New York", logger, "Issuing State");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'issueDate']", "03/04/2021", logger, "Issue Date");
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id= 'expirationDate']", "04/07/2028", logger, "Expiration Date");
    }//end of test case 2

    @Test(priority = 3)
    public void tc003_fillingOutInfoPage2AndCapturingReviewInfo() throws InterruptedException {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc003_fillingOutInfoPage2AndCapturingReviewInfo");

        Thread.sleep(3000);
        //click next
        ReusableActionsLoggers.clickAction(driver, "//*[@class= 'mat-focus-indicator wbb-button mat-raised-button mat-button-base blue-btn primary-btn']", logger, "Next button 1");
        Thread.sleep(2000);
        //click continue on pop-up
        ReusableActionsLoggers.clickAction(driver, "//*[@id= 'blue-button-id']", logger, "Continue button");
        //occupation
        ReusableActionsLoggers.selectByText(driver, "//*[@aria-labelledby= 'occupation-label']", "ENGINEER", logger, "Occupation");
        //employer
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'employer']", "JetBlue Airways", logger, "Employer");
        //work phone number
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@id = 'workPhoneNumber']", "718-286-7900", logger, "Work Phone Number");
        //start date
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@class = 'wbb-datepicker-core-native ng-tns-c62-6 cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid']", "03/2022", logger, "Work Start Date");
        //click next
        ReusableActionsLoggers.clickAction(driver, "//*[@class = 'mat-focus-indicator wbb-button mat-raised-button mat-button-base blue-btn primary-btn']", logger, "Next Button 2");
        Thread.sleep(3000);
        //capture text
        String submitWarning = ReusableActionsLoggers.getTextAction(driver, "//*[@class = 'aox-review-aem-disclosure-content ng-star-inserted']", logger, "Submit Warning");
        System.out.println(submitWarning);
    }//end of test case 3

}//end of class

















