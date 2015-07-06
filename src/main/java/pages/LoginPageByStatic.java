package pages;

import org.openqa.selenium.By;

import static helpers.WebDriverSingleton.getDriver;

public class LoginPageByStatic {
    // elements
    public static final By USER_NAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");
    public static final By VALIDATION_MESSAGE = By.id("flash");

    // behavior
    public static void login(String userName, String password) {
        getDriver().findElement(USER_NAME_FIELD).sendKeys(userName);
        getDriver().findElement(PASSWORD_FIELD).sendKeys(password);
        getDriver().findElement(SUBMIT_BUTTON).click();
    }
}
