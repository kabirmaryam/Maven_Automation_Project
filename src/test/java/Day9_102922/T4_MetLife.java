package Day9_102922;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.WebDriver;

import static ReusableLibrary.ReusableActions.setUpDriver;

public class T4_MetLife {
    public static void main(String[] args) throws InterruptedException {
        //call webdriver method from reusable library
        WebDriver driver = setUpDriver();
        //navigate to MetLife
        driver.navigate().to("https://www.metLife.com");
        //hover over the solutions dropdown
        //ReusableActions.mouseHover(driver, "//*[contains(text(), 'SOLUTIONS')]", "Solutions Dropdown");
        //or click on solutions dropdown
        ReusableActions.clickActionByIndex(driver, "//*[contains(text(), 'SOLUTIONS')]", 0, "Solutions Link");
        //click on dental link
        ReusableActions.clickAction(driver, "//*[text() = 'Dental']", "Dental Link");
        //capture the headline title
        String headlineTitle = ReusableActions.getTextAction(driver, "//*[@class = 'headline__title']", "Headline Title");
        //print out the title
        System.out.println("The headline title is " + headlineTitle);
        //quit driver
        driver.quit();
    }//end of main
}//end of class
