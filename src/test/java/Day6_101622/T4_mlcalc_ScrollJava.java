package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_mlcalc_ScrollJava {
    public static void main(String[] args) throws InterruptedException {
        //chromedriver setup using web driver manager
        WebDriverManager.chromedriver().setup();
        //define web driver

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing chrome window
        options.addArguments("start-maximized", "incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com");

        //wait 3 seconds
        Thread.sleep(3000);

        //define JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down to 800 pixels
        jse.executeScript("scroll(0,800)");
        //wait 2 seconds
        Thread.sleep(2000);
        //scroll up to 400 pixels
        jse.executeScript("scroll(0,-400)");
        //wait 2 seconds
        Thread.sleep(2000);

        //declare calculate button into web element variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));
        //scroll into view of calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        //wait 2 seconds
        Thread.sleep(5000);

        //quit chrome
        driver.quit();

    }//end of main
}//end of class
