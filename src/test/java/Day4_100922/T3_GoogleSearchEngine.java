package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_GoogleSearchEngine {
    public static void main(String[] args) throws InterruptedException {

            //Array List for cars
            ArrayList<String> cars = new ArrayList<>();
            cars.add("BMW");
            cars.add("Audi");
            cars.add("Mercedes");

            //define the web driver manger setup for chromedriver
            WebDriverManager.chromedriver().setup();
            //define the chrome driver to use for your test
            //creating an instance for a chrome driver(browser) to use for automation

            WebDriver driver = new ChromeDriver();

            for(int i = 0; i < cars.size(); i++){
                    //navigate to the google site
                    driver.navigate().to("https://www.google.com");

                    //maximize my window
                    //for windows
                    driver.manage().window().maximize();
                    //for mac
                    //driver.manage().window().fullscreen();

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
                    String result = driver.findElement(By.xpath("//*[@id ='result-stats']")).getText();
                    //split message to extract out the search number
                    String[] splitResult = result.split(" ");
                    System.out.println("The search number is " + cars.get(i) + splitResult[1]);

            }//end of for loop

            //quit the driver to end session
            driver.quit();

    }//end of main
}//end of class
