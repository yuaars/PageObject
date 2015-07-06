package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static helpers.WebDriverSingleton.getDriver;

public class LoginPageSingleton {

    // elements
    private WebElement userField;
    private WebElement passwordField;
    private WebElement submitButton;
    //private WebElement validation;

    public LoginPageSingleton() {
        userField = getDriver().findElement(By.id("username"));
        passwordField = getDriver().findElement(By.id("password"));
        submitButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        //validation = driver.findElement(By.id("flash"));
    }

    // behavior
    public HomePage login(String userName, String password) {
        userField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
        return new HomePage(getDriver());
    }

    private WebElement getMessage() {
        return getDriver().findElement(By.id("flash"));
    }

    public LoginPageSingleton verifySuccessfulLogout() {
        WebElement message = getMessage();
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.getAttribute("class").contains("success"));
        Assert.assertTrue(message.getText().contains("You logged out of the secure area!"));
        return this;
    }
}
