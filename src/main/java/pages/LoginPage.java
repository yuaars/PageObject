package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private final WebDriver driver;

    // elements
    private WebElement userField;
    private WebElement passwordField;
    private WebElement submitButton;
    //private WebElement validation;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        userField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        //validation = driver.findElement(By.id("flash"));
    }

    // behavior
    public HomePage login(String userName, String password) {
        userField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
        return new HomePage(driver);
    }

    private WebElement getMessage() {
        return driver.findElement(By.id("flash"));
    }

    public LoginPage verifySuccessfulLogout() {
        WebElement message = getMessage();
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.getAttribute("class").contains("success"));
        Assert.assertTrue(message.getText().contains("You logged out of the secure area!"));
        return this;
    }
}
