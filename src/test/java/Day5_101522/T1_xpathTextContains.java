package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_xpathTextContains {
    public static void main(String[] args) throws InterruptedException {
        //chromedriver setup using web driver manager
        WebDriverManager.chromedriver().setup();
        //define web driver
        WebDriver driver = new ChromeDriver();
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");

        //maximize driver
        driver.manage().window().maximize();

        //click on sign in button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();
        //wait 2 seconds
        Thread.sleep(2000);

        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //wait 2 seconds
        Thread.sleep(2000);
        //click on bell icon
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor')]")).click();
        //wait 2 seconds
        Thread.sleep(2000);

        //quit driver
        driver.quit();

    }//end of main
}//end of java
