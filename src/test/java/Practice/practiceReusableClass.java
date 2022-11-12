package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practiceReusableClass {
    public static void selectByText(WebDriver driver, String xpath, int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.deselectByIndex(index);

        }catch(Exception e) {
            System.out.println("Unable to select index for : " + elementName + " for reason: " + e);
        }//end of catch

    }//end of select by visible text

    public static void selectByValue(WebDriver driver, String xpath, String value, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByValue(value);

        }catch(Exception e) {
            System.out.println("Unable to select visible text for : " + elementName + " for reason: " + e);
        }//end of catch

    }//End of select by value

    public static void selectByText(WebDriver driver, String xpath, String text, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(text);

        }catch(Exception e) {
            System.out.println("Unable to select visible text for : " + elementName + " for reason: " + e);
        }//end of catch

    }//End of select by visible text



}
