package Day12_110622;

import ReusableLibrary.ReusableActionsLoggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import static ReusableLibrary.ReusableAnnotations.driver;
import static ReusableLibrary.ReusableAnnotations.logger;

public class T2_GoogleSearch_ReusableAnnotations extends ReusableAnnotations {
    @Test
    public void searchForBMW() {
        driver.navigate().to("https://www.google.com");
        //search for BMW on the search field
        ReusableActionsLoggers.sendKeysAction(driver, "//*[@name='q']", "BMW", logger, "Search Field");
        //hit submit on google search button
        ReusableActionsLoggers.submitAction(driver, "//*[@name='btnK']", logger, "Google Search");
    }//end of test 1

    @Test(dependsOnMethods = "searchForBMW")
    public void captureSearchNumber() {
        //capture the search results text
        String results = ReusableActionsLoggers.getTextAction(driver, "//*[@id='result-stats']", logger, "Search Results");
        String[] arrayResult = results.split(" ");
        //print back to html report by using log INFO
        logger.log(LogStatus.INFO, "Search number for BMW is " + arrayResult[1]);
    }//end of test 2

}//end of class
