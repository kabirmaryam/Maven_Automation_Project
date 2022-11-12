package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Automation_AI04 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //start chrome maximized and in incognito mode
        options.addArguments("start-fullscreen","incognito");
        //define chromedriver and pass options
        WebDriver driver = new ChromeDriver(options);

        //define array list for destination
        ArrayList<String> whereTo = new ArrayList<>();
        whereTo.add("Miami");
        whereTo.add("San Francisco");
        whereTo.add("Texas");

        //define array list of number of adults
        ArrayList<Integer> adultTravelers = new ArrayList<>();
        adultTravelers.add(2);
        adultTravelers.add(3);
        adultTravelers.add(4);

        //define array list of child age
        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("5");
        childAge.add("9");
        childAge.add("16");

        //start of for loop to iterate through every destination
        for (int i=0; i < whereTo.size(); i++) {

            //navigate to hotels.com website
            driver.navigate().to("https://hotels.com");
            //wait 2 seconds
            Thread.sleep(2000);

            try {
                //click on search destination and type in destination from whereTo array list
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
                //wait 1 second
                Thread.sleep(1000);
                //enter ith index of whereTo into search field
                driver.findElement(By.xpath("//*[@id ='destination_form_field']")).sendKeys(whereTo.get(i));
                //wait 2 seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Search destination error: " + e);
            }

            try {
                //click on the first search result of the destination searched
                ArrayList<WebElement> searchResult = new ArrayList<>(driver.findElements(By.xpath("//*[@class= 'is-subText truncate']")));
                searchResult.get(0).click();
                //wait 2 seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Destination result error: " + e);
            }

            try {
                //click on travelers field
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
                //wait 2 seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Traveler field error: " + e);
            }

            try {
                //reset adult travelers to 1 by clicking the minus button
                ArrayList<WebElement> minus = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));
                minus.get(0).click();
                //wait 2 seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Reset adult traveler error: " + e);
            }

            //start of for loop to iterate the number of clicks to change the number of adult travelers from adult travelers array list
            for (int j = 0; j < adultTravelers.get(i); j++) {
                try {
                    //click on plus sign to change the number of adult travelers
                    driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']")).click();
                    //wait 2 seconds
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Change number of adult travelers error: " + e);
                }
            }//end of number of adult travelers for loop

            try {
                //increase number of child travelers to 1
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
                //wait 2 seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Change number of child travelers to 1 error: " + e);
            }

            try {
                //use select command to change child age
                WebElement age = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
                //wait 2 seconds
                Thread.sleep(2000);
                Select dropDownChildAge = new Select(age);
                //select by visible text
                //i represents the child ages being called from the childAge array list to match with the visible text in child age drop down
                dropDownChildAge.selectByVisibleText(childAge.get(i));
                //wait 2 seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Select child age error : " + e);
            }

            try {
                //click on done for travelers
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
                //wait 2 seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Click on done for travelers error: " + e);
            }

            try {
                //click on search button
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
                //wait 4 seconds
                Thread.sleep(4000);
            } catch (Exception e) {
                System.out.println("Search button error: " + e);
            }


            try {
                //define web element for hotel links
                ArrayList<WebElement> hotelLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-card-link']")));

                if (i == 0) {
                    //4th index is the 2nd resort on search results list
                    (hotelLinks.get(4)).click();
                    //wait 3 seconds
                    Thread.sleep(3000);
                }
                if (i == 1) {
                    //5th index is the 3rd resort on search results list
                    (hotelLinks.get(5)).click();
                    //wait 3 seconds
                    Thread.sleep(3000);
                }
                if (i == 2) {
                    //2nd index is the 2nd resort on search results list
                    (hotelLinks.get(2)).click();
                    //wait 3 seconds
                    Thread.sleep(3000);
                }
            } catch (Exception e) {
                System.out.println("Clicking on hotel error: " + e);
            }


            //declare an array list for all tabs
            ArrayList<String> hotelTabs = new ArrayList<>(driver.getWindowHandles());
            //switch to hotel tab
            driver.switchTo().window(hotelTabs.get(1));

            //wait 3 seconds
            Thread.sleep(3000);


            try {
                //capture hotel name
                String name = driver.findElement(By.xpath("//*[@class = 'uitk-spacing uitk-spacing-padding-small-blockend-four uitk-spacing-padding-large-blockstart-three']")).getText();
                //wait 4 seconds
                Thread.sleep(4000);
                //split by line to capture the first line where hotel name is
                String[] hotelName = name.split("\\R");
                //print hotel name
                System.out.println(hotelName[0]);
            } catch (Exception e) {
                System.out.println("Hotel name error: " + e);
            }

            //wait 5 seconds
            Thread.sleep(5000);

            try {
                //click reserve a room
                driver.findElement(By.xpath("//*[@data-stid = 'navbar-quick-reserve-button']")).click();
                //wait 3 seconds
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Reserve a room error: " + e);
            }

            try {
                //capture first hotel price per night
                ArrayList<WebElement> price = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")));
                //wait 4 seconds
                Thread.sleep(4000);
                String hotelPrice = price.get(0).getText();
                System.out.println(hotelPrice);
            } catch (Exception e) {
                System.out.println("Hotel price error: " + e);
            }

            try {
                //wait 3 seconds
                Thread.sleep(3000);
                //click on reserve
                ArrayList<WebElement> reserve = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'uitk-button uitk-button-medium uitk-button-primary']")));
                reserve.get(0).click();
                //wait 3 seconds
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Reserve button error: " + e);
            }

            try {
                //capture the check-in & check-out notes
                String notes = driver.findElement(By.xpath("//*[@class = 'booking-details-travel-details-wrapper fs-base clear pb-mouse bottom-separator travel-details-bottom null']")).getText();
                //wait 4 seconds
                Thread.sleep(4000);
                //capture line 1 (check in notes) and line 2 (check out notes)
                String[] checkInCheckOutNotes = notes.split("\\R");
                System.out.println(checkInCheckOutNotes[0]);
                System.out.println(checkInCheckOutNotes[1]);
            } catch (Exception e) {
                System.out.println("Notes error: " + e);
            }

            //to separate each destination hotel
            System.out.println("**********************************************");

            //close current tab
            driver.close();

            //wait 3 seconds
            Thread.sleep(3000);

            //switch back to first tab
            driver.switchTo().window(hotelTabs.get(0));

            //wait 3 seconds
            Thread.sleep(3000);

        }//end of destinations for loop

        //quit driver
        driver.quit();

    }//end of main

}//end of class

