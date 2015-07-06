package pages.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterLoginPage {
    private final WebDriver driver;

    public static final By SIGNIN_FORM = By.cssSelector("#front-container form.signin");
    public static final By SIGNUP_FORM = By.cssSelector("#frontpage-signup-form");

    public TwitterLoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
