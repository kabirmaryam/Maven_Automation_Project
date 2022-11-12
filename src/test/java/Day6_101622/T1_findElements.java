package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_findElements {
    public static void main(String[] args) throws InterruptedException {
        //chromedriver setup using web driver manager
        WebDriverManager.chromedriver().setup();
        //define web driver

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing chrome window
        options.addArguments("start-maximized", "incognito");

        WebDriver driver = new ChromeDriver(options);
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(3000);

        //using find elements I want to click on the second link within the group which is News
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();

        //quit driver
        driver.quit();

    }//end of main
}//end of class
