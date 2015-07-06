package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    
    public static void waitForElementPresence(WebDriver driver, final By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElements(locator).size() > 0;
            }
        });
    }

    public static void waitForJquery(WebDriver driver, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }

    public static void waitForPageToLoad(WebDriver driver, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return js.executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public static void waitForElementDisappear(WebDriver driver, final By locator, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout, 50);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElements(locator).size() == 0;
            }
        });
    }
}
