package Action_Items;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Automation_AI05 {

    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test()
    public void findADoctor() throws InterruptedException {
        //navigate to uhc.com
        driver.navigate().to("https://www.uhc.com/");

        Thread.sleep(4000);

        //click on find a doctor
        ReusableActions.clickActionByIndex(driver,"//*[text() = 'Find a doctor']",0,"Find a doctor");
        //scroll into view of find a dentist
        ReusableActions.scrollByView(driver, "//*[contains (@aria-label, 'Find a dentist')]", "Find a dentist");
        Thread.sleep(3000);
        //click on find a dentist link
        ReusableActions.clickAction(driver, "//*[contains (@aria-label, 'Find a dentist')]", "Find a dentist link");
        Thread.sleep(3000);
        //switching to new tab
        ReusableActions.switchToTabByIndex(driver, 1, "second tab");
        //click on Employer and Individual Plans
        ReusableActions.clickAction(driver,"//*[@aria-label = 'Employer and Individual Plans']","Employer and Individual Plans");
    }//end of Test Case 1

    @Test(dependsOnMethods = "findADoctor")
    public void doctorByLocation() throws InterruptedException {
        //enter a zip code
        ReusableActions.sendKeysAction(driver, "//*[@id = 'location']", "11208", "zip code" );

        Thread.sleep(4000);

        //click continue button
        ReusableActions.clickAction(driver, "//*[@type = 'submit']", "Continue");

        Thread.sleep(2000);

        //click on National Options PPO 30
        ReusableActions.clickAction(driver, "//*[text() = '*National Options PPO 30']", "National Options");

        //wait few seconds
        Thread.sleep(3000);

        //refresh the page
        driver.navigate().refresh();

        //wait few seconds
        Thread.sleep(3000);

        //click on General Dentists
        ReusableActions.clickActionByIndex(driver, "//*[@class= 'sc-jgPyTC gXqeMb']", 0, "General Dentists");
    }//end of Test Case 2

    @Test(dependsOnMethods = "doctorByLocation")
    public void doctorInfo() throws InterruptedException {

        Thread.sleep(4000);

        //select a mile from dropdown
        ReusableActions.selectByText(driver, "//*[@class, 'radiusMiles ng-pristine ng-valid')]", "Within 1 Mile", "mile drop down");

        //wait few seconds
        Thread.sleep(3000);
        //refresh the page
        driver.navigate().refresh();
        //wait few seconds
        Thread.sleep(3000);

        //select a mile from dropdown
        ReusableActions.selectByText(driver, "//*[@class, 'radiusMiles ng-pristine ng-valid')]", "Within 1 Mile", "mile drop down");

        driver.navigate().refresh();

        //select first dentist on the list
        ReusableActions.clickActionByIndex(driver,"//*[@data-test-id='provider-name-link']",0,"dentist name");
        //wait few second
        Thread.sleep(3000);

        //click save button
        ReusableActions.clickActionByIndex(driver, "//*[text() = 'Save']", 0, "Save button");
        Thread.sleep(5000);

        //capture address
        String doctorAddress = ReusableActions.getTextActionByIndex(driver, "//*[contains (@class, 'td c-4-dt-tbl')]", 0, "doctor address");
        //split doctor address
        String[] doctorAddressSplit = doctorAddress.split("\\R");
        //capture miles
        String doctorMiles = ReusableActions.getTextActionByIndex(driver, "//*[contains (@class, 'td c-4-dt-tbl')]", 1, "doctor miles");
        //split doctor miles
        String[] doctorMilesSplit = doctorMiles.split("\\R");
        //capture network
        String doctorNetwork = ReusableActions.getTextActionByIndex(driver, "//*[contains (@class, 'td c-4-dt-tbl')]", 2, "doctor network");
        System.out.println("Address: " + doctorAddressSplit[1] + " " + doctorAddressSplit[2] + "\n" + "Miles: " + doctorMilesSplit[1] + "\n" + "Network: " + doctorNetwork);
        //close tab
        driver.close();
    }//end of Test Case 3

    @Test (dependsOnMethods = "doctorInfo")
    public void searchDoctor() {
        ReusableActions.switchToTabByIndex(driver,0, "first tab");
        ReusableActions.sendKeysAction(driver, "//*[@id = 'search-desktop']", "doctor", "search doctor");
        ReusableActions.clickAction(driver, "//*[@id = 'search__button-desktop']", "search button");
        String searchResults = ReusableActions.getTextAction(driver, "//*[@id='search-results-count__header']", "search results");
        String[] searchResultsSplit = searchResults.split("results");
        System.out.println("Search Results: " + searchResultsSplit[0]);
    }//end of Test Case 4

}//end of class
