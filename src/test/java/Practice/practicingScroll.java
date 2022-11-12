package Practice;

import ReusableLibrary.ReusableActions;
import ReusableLibrary.ReusableActionsLoggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class practicingScroll extends ReusableAnnotations {


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
            driver.navigate().to("https://www.pnc.com/en/personal-banking/virtual-wallet-overview.html?lnksrc=topnav");

            //clear zip code
            ReusableActionsLoggers.clearAction(driver, "//*[@class = 'required']", logger, "Clear Zip Code" );
            //enter zip code
            ReusableActionsLoggers.sendKeysAction(driver, "//*[@class = 'required']", "11208", logger, "Enter Zip Code");
            //click submit
            ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn-secondary']", logger, "Click Zip Code");

            Thread.sleep(3000);

            //ReusableActionsLoggers.scrollByViewByIndex(driver, "//*[@class = 'featuredtextmed']", 13, logger, "mobile app");

            ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class = 'btn-blue']", 1, logger, "apply");

            Thread.sleep(2000);

            driver.navigate().refresh();

            Thread.sleep(4000);

            ReusableActionsLoggers.clickActionByIndex(driver, "//*[@class='mat-radio-container']", 1, logger, "No Radio Button");

            Thread.sleep(4000);

        }

    }
