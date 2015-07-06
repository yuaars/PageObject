package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageBy {
    private final WebDriver driver;

    // elements
    public static final By USER_NAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");
    public static final By VALIDATION_MESSAGE = By.id("flash");

    public LoginPageBy(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SUBMIT_BUTTON).click();
    }
}
