package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageWithFlow {
    private final WebDriver driver;

    // elements
    private WebElement userField;
    private WebElement passwordField;
    private WebElement submitButton;
    //private WebElement validation;

    public LoginPageWithFlow(WebDriver driver) {
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
}
