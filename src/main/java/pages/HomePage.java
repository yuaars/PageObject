package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    private final WebDriver driver;

    private final WebElement logoutButton;
    private final WebElement message;

    public HomePage(WebDriver driver)  {
        this.driver = driver;
        logoutButton = driver.findElement(By.cssSelector("a.button"));
        message = driver.findElement(By.id("flash"));
    }

    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    public HomePage verifySuccessfulLogin() {
        WebElement message = getMessage();
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.getAttribute("class").contains("success"));
        Assert.assertTrue(message.getText().contains("You logged into a secure area!"));
        return this;
    }

    private WebElement getMessage() {
        return message;
    }
}
