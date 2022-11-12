package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_mlcalc_forloop {
    public static void main(String[] args) throws InterruptedException {
        //chromedriver setup using web driver manager
        WebDriverManager.chromedriver().setup();
        //define web driver

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing chrome window
        options.addArguments("start-maximized", "incognito");

        WebDriver driver = new ChromeDriver(options);

        //create sets of array list for purchase price, down payment, interest rate
        ArrayList<String> purchasePrice, downPayment, interestRate;
        purchasePrice = new ArrayList<>();
        purchasePrice.add("350000");
        purchasePrice.add("370000");
        purchasePrice.add("380000");

        //down payment array list
        downPayment = new ArrayList<>();
        downPayment.add("20");
        downPayment.add("30");
        downPayment.add("35");

        //interest rate array list
        interestRate = new ArrayList<>();
        interestRate.add("3.4");
        interestRate.add("4.1");
        interestRate.add("4.1");

        for(int i = 0; i < interestRate.size(); i++) {
            //navigate to yahoo.com
            driver.navigate().to("https://www.mlcalc.com");

            Thread.sleep(3000);

            //clear and enter a new value on purchase price field
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            //clear the purchase price
            pPrice.clear();
            //type new value on the purchase price
            pPrice.sendKeys(purchasePrice.get(i));

            //clear and enter a new value on down payment field
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            //clear the down payment
            dPayment.clear();
            //type new value on the down payment
            dPayment.sendKeys(downPayment.get(i));

            WebElement intRate = driver.findElement(By.xpath("//*[@name='ir']"));
            //clear interest rate
            intRate.clear();
            //type new value on the interest rate
            intRate.sendKeys(interestRate.get(i));

            //click the calculate button
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();

            //sleep statement
            Thread.sleep(3000);

            //capture and print the monthly payment value
            String mntPayment = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
            System.out.println("Monthly Payment: " + mntPayment);

        }//end of for loop

        //quit driver
        driver.quit();

    }//end of java
}//end of class
