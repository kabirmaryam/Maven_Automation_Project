package Day10_103022;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T3_TestNG_DependsOn {

    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver(){
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test()
    public void SearchForCar() {
        driver.navigate().to("https://www.google.com");
        //enter a car in search field
        ReusableActions.sendKeysAction(driver,"//*[@name ='q']", "BMW", "Search Field");
        //hit submit on the google search button
        ReusableActions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");
    }//end of test 1

    @Test(dependsOnMethods = "SearchForCar")
    public void CaptureSearchNumber() {
        String result = ReusableActions.getTextAction(driver, "//*[@id='result-stats']", "Search Result");
        String[] arrayResult = result.split(" ");
        System.out.println("Result is: " + arrayResult[1]);
    }//end of test 2
}
