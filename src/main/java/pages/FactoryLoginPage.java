package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FactoryLoginPage {

    @FindBy(id = "username")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(id = "flash")
    public WebElement validationMessage;

    @FindBy(css = "div")
    public List<WebElement> divs;

    public void login(String user, String pass) {
        userField.sendKeys(user);
        passwordField.sendKeys(pass);
        submitButton.click();
    }
}
