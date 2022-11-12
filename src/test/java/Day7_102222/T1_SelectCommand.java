package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectCommand {
    public static void main(String[] args) throws InterruptedException {
        //chromedriver setup using web driver manager
        WebDriverManager.chromedriver().setup();
        //define web driver

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing chrome window
        options.addArguments("start-maximized", "incognito");

        WebDriver driver = new ChromeDriver(options);
        //navigate to mcalc.com
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name ='sm']"));
        Select startMonthDropDown = new Select(startMonth);
        //select by visible text
        startMonthDropDown.selectByVisibleText("Nov");


        //use select command for year dropdown
        //WebElement startYear = driver.findElement(By.xpath("//*[@name ='sy']"));
        //Select startYearDropDown = new Select(startYear);
        //select by visible text
        //startYearDropDown.selectByVisibleText("2023");
        driver.findElement(By.xpath("//*[@name='sy']"));
        driver.findElement(By.xpath("//*[text()='2023']")).click();

        //quit driver
        //driver.quit();


    }//end of main
}//end of class
