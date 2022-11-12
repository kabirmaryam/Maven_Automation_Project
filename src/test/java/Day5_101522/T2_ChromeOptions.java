package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void main(String[] args) {
        //chromedriver setup using web driver manager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing chrome window
        options.addArguments("start-maximized", "incognito");
        //options.addArguments("headless");

        //for mac use start fullscreen 
        //options.addArguments("start-fullscreen");

        //define web driver and pass options into method
        WebDriver driver = new ChromeDriver(options);

        //navigate to google.com
        driver.navigate().to("https://www.google.com");

        //locate element for search field and type cars
        //this is an example of relative xpath
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //extract out the number and print the search number only

        //extract out the number and print the search number only
        String[] arrayResult = searchResult.split(" ");
        System.out.println("My search number is " + arrayResult[1]);

        //quit driver
        driver.quit();

    }//end of main
}//end of class
