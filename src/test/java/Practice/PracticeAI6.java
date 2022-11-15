package Practice;

import ReusableLibrary.ReusableActionsLoggers;
import ReusableLibrary.ReusableAnnotations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static ReusableLibrary.ReusableAnnotations.driver;

public class PracticeAI6 extends ReusableAnnotations {

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

        driver.switchTo().frame("lf_tool_frame");
        Thread.sleep(4000);

        ReusableActionsLoggers.clickAction(driver, "//*[@class = 'btn btn-primary lf-CTA-btn ng-binding']", logger, "Save button" );

        Thread.sleep(7000);
    }
}
