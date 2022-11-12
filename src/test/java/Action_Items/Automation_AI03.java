package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Automation_AI03 {
    public static void main(String[] args) throws InterruptedException {

        //declare and define zip code array list
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("10010");
        zipCode.add("10028");
        zipCode.add("10036");

        //set up chrome web driver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing chrome window
        options.addArguments("start-maximized", "incognito");

        //define web driver and pass options into method
        WebDriver driver = new ChromeDriver(options);

        for(int i = 0; i < zipCode.size(); i++){

            //navigate to weight watchers find a workshop link
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //wait a few seconds
            Thread.sleep(3000);

            //click on find a workshop
            driver.findElements(By.xpath("//*[@icon='location']"));

            //click on in-person
            driver.findElement(By.xpath("//*[text() = 'In-Person']")).click();

            //wait 3 seconds
            Thread.sleep(3000);

            //clear and search for zip code
            WebElement zipCodeSearch = driver.findElement(By.xpath("//*[@id='location-search']"));
            //click on zip code search
            zipCodeSearch.click();
            //clear the zip code
            zipCodeSearch.clear();
            //type new zip code in search field
            zipCodeSearch.sendKeys(zipCode.get(i));
            //click on search arrow
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).submit();

            //wait 3 seconds
            Thread.sleep(3000);

            ArrayList<WebElement> wwLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));

            if(i == 0){
                (wwLinks.get(0)).click();
            }if(i == 1){
                (wwLinks.get(1)).click();
            }if(i == 2){
                (wwLinks.get(2)).click();
            }//end of conditional statement

            //wait 3 seconds
            Thread.sleep(3000);

            //capture addresses
            String location = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
            String[] locationAddress = location.split("\\R");
            System.out.println(locationAddress[0] + " " + locationAddress[1]);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement viewStudioSchedules = driver.findElement(By.xpath("//*[@id = 'studioWorkshopSchedule']"));
            //scroll into view of studio schedules
            jse.executeScript("arguments[0].scrollIntoView(true);", viewStudioSchedules);

            //capture table
            Thread.sleep(5000);
            WebElement scheduleTable = driver.findElement(By.xpath("//*[@class = 'scheduleContainerMobile-1RfmF']"));
            System.out.println(scheduleTable.getText());

        }//end of loop

        //quit driver
        driver.quit();

    }//end of main
}//end of class
