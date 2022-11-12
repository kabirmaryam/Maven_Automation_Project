package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class chromeOptionsWithForLoop {
    public static void main(String[] args) throws InterruptedException {

        //Array List for cars
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Mercedes");

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

        for(int i = 0; i < cars.size(); i++){
            //navigate to the google site
            driver.navigate().to("https://www.google.com");

            //sleep statement
            Thread.sleep(3000);

            //search a keyword on the search field
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));
            //hit submit on the google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //sleep statement
            Thread.sleep(3000);

            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //split message to extract out the search number
            String[] splitResult = result.split(" ");
            System.out.println("The search number is " + cars.get(i) + splitResult[1]);

        }//end of for loop

        //quit the driver to end session
        driver.quit();



    }
}
