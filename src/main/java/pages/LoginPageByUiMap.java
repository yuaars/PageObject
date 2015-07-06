package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;
import static helpers.Locators.getByText;

public class LoginPageByUiMap {
    private final WebDriver driver;

    // elements
    public static final By USER_NAME_FIELD = get("loginPage.loginForm.userName");
    public static final By PASSWORD_FIELD = get("loginPage.loginForm.password");
    public static final By SUBMIT_BUTTON = get("loginPage.loginForm.submit");
    public static final By VALIDATION_MESSAGE = get("loginPage.loginForm.validationMessage");
    public static final By TEMPLATE_EXAMPLE = getByText("text");

    public LoginPageByUiMap(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SUBMIT_BUTTON).click();
    }
}
