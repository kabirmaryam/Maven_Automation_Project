package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableActionsLoggers {

    //reusable method to define and launch webdriver
    public static WebDriver setUpDriver() {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        //options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setup driver method


    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }
    }//end of clickAction

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }
    }//end of clickActionByIndex

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }
    }//end of mouseHover

    public static void mouseHoverByIndex (WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }
    }//end of mouseHoverByIndex

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }
    }//end of sendKeysAction

    public static void sendKeysActionByIndex(WebDriver driver, String xpath, String userInput, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }
    }//end of sendKeysActionByIndex

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }
        return textOutput;
    }//end of getTextAction

    public static String getTextActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textOutput = "";
        try {
            ArrayList<WebElement> element = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            textOutput = element.get(index).getText();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }//end of catch
        return textOutput;
    }//end of getTextActionByIndex

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }
    }//end of submitAction

    public static void selectByText(WebDriver driver, String xpath, String text, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(text);
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select visible text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }//end of catch
    }//end of selectByText

    public static void switchToTabByIndex (WebDriver driver, int tabIndex, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
        } catch (Exception e) {
            System.out.println("Unable to switch tabs : " + elementName + " for reason: " + e);
        }//end of catch
    }//end of switchToByIndex

    public static void scrollByView (WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }//end of catch
    }//end of scrollByView

    public static void scrollByViewByIndex (WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully click on element: " + elementName + " for reason: " + e);
        }//end of catch
    }//end of scrollByViewByIndex

    public static void clearAction (WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to clear element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully cleared element: " + elementName + " for reason: " + e);
        }
    }//end of clearAction

    public static void clearActionByIndex (WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            logger.log(LogStatus.PASS, "Successfully click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to clear element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Successfully cleared element: " + elementName + " for reason: " + e);
        }
    }//end of clearActionByIndex

    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)){
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + "and Actual Text: " + actualText + " match");
        }
        else {
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + "and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText

}
