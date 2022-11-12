package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_SwitchTabs {
    public static void main(String[] args) throws InterruptedException {
        //chromedriver setup using web driver manager
        WebDriverManager.chromedriver().setup();
        //define web driver

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing chrome window
        options.addArguments("start-maximized", "incognito");

        WebDriver driver = new ChromeDriver(options);
        //navigate to fidelis care site
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(3000);

        //click on shop for a plan
        driver.findElement(By.xpath("//*[text() = 'Shop For a Plan']")).click();
        //wait 2 seconds
        Thread.sleep(2000);

        //click medicaid managed care
        driver.findElement(By.xpath("//*[text() = 'Medicaid Managed Care']")).click();
        //wait 2 seconds
        Thread.sleep(2000);

        //click on find a doctor search icon (which will launch a new tab)
        driver.findElement(By.xpath("//*[@class = 'btn btn-outline-primary btn-external btn-show link-external']")).click();
        //wait 2 seconds
        Thread.sleep(2000);

        //store tabs in array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to the new tab
        driver.switchTo().window(tabs.get(1));

        //enter a zip code
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11230");
        //wait 2 seconds
        Thread.sleep(2000);

        //close the find a doctor tab
        driver.close();

        //switch to the initial tab (parent tab)
        driver.switchTo().window(tabs.get(0));

        //go to the home page
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(3000);

        //click on coverage, first match is index 0
        //driver.findElements(By.xpath("//*[@class = 'btn ng-binding btn-primary']")).get(0).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class = 'btn ng-binding btn-primary']")).click();

    }//end of main
}//end of class
