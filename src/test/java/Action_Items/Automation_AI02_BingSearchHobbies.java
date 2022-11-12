package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Automation_AI02_BingSearchHobbies {
    public static void main(String[] args) throws InterruptedException {
        //declare and define ArrayList for hobbies
        ArrayList<String> hobbies = new ArrayList<>();
        //add values for hobbies array
        hobbies.add("sewing");
        hobbies.add("baking");
        hobbies.add("weight lifting");
        hobbies.add("watching anime");

        //define the web driver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        WebDriver driver = new ChromeDriver();

        //create for loop for
        for(int i = 0; i < hobbies.size(); i++) {
            //navigate to the google site
            driver.navigate().to("https://www.bing.com");

            //maximize my window
            driver.manage().window().maximize();

            //sleep statement
            Thread.sleep(3000);


            //search a keyword on the search field
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies.get(i));
            //hit submit on the google search button
            driver.findElement(By.xpath("//*[@viewBox='0 0 25 25']")).submit();

            //sleep statement
            Thread.sleep(3000);

            //capture search result text
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //split message to extract out the search number
            String[] splitResult = result.split(" ");
            System.out.println("The search number for " + hobbies.get(i) + " is " + splitResult[0]);
        }//end of for loop

        //quit the driver to end session
        driver.quit();

    }//end of main
}//end of class
