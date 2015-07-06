package internet;


import helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicElementTest {
    private WebDriver driver;
    private static final String BASE_URL = "http://the-internet.herokuapp.com/";

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test
    public void waitForElementToDisappearTest() {
        driver.findElement(By.linkText("Dynamic Controls")).click();
        By checkboxLocator = (By.cssSelector("input#checkbox"));
        Assert.assertTrue(driver.findElement(checkboxLocator).isDisplayed(), "checkbox is not found");
        By buttonLocator = By.cssSelector("#btn");
        driver.findElement(buttonLocator).click();
        Waiter.waitForElementDisappear(driver, checkboxLocator, 5000);
        Assert.assertEquals(driver.findElement(buttonLocator).getText(), "Add", "Button Add isn't appear");
        By messageLocator = By.id("message");
        Assert.assertTrue(driver.findElement(messageLocator).isDisplayed(),"Text isn't presented");
        Assert.assertEquals(driver.findElement(messageLocator).getText(), "It's gone!", "Text is wrong");
        Assert.assertTrue(driver.findElements(checkboxLocator).isEmpty());
    }

    @Test(dependsOnMethods = "waitForElementToDisappearTest")
    public void waitForElementToAppearTest() {
        By button = By.id("btn");
        By checkboxLocator = (By.cssSelector("input#checkbox"));
        driver.findElement(button).click();
        Waiter.waitForElementPresence(driver, checkboxLocator, 8000);
        By messageLocator = By.id("message");
        Assert.assertTrue(driver.findElement(messageLocator).isDisplayed(),"Text isn't presented");
        Assert.assertEquals(driver.findElement(messageLocator).getText(), "It's back!", "Text is wrong");
        Assert.assertTrue(driver.findElement(checkboxLocator).isDisplayed());
        Assert.assertEquals(driver.findElement(button).getText(), "Remove");
    }
}
