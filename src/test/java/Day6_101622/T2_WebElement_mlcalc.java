package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_mlcalc {
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
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(3000);

        //clear and enter a new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));

        //clear the purchase price
        pPrice.clear();

        //type new value on the purchase price
        pPrice.sendKeys("450000");

        //clear and enter a new value on down payment field
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));

        //clear the down payment
        dPayment.clear();

        //type new value on the down payment
        dPayment.sendKeys("25");

    }//end of main
}//end of class
