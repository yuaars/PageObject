package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FactoryLoginPage;
import pages.LoginPage;
import pages.LoginPageByStatic;

import java.util.concurrent.TimeUnit;

public class AuthenticationTest {
    private WebDriver driver;
    private static final String BASE_URL = "http://the-internet.herokuapp.com/login";

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get(BASE_URL);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getCreds() {
        return new Object[][] {
                {"invalidUser", "", false},
//                {"", "invalidPassword", false},
//                {"invalidUser", "invalidPassword", false},
//                {"tomsmith", "SuperSecretPassword!", true},
        };
    }

    @Test(dataProvider = "getCreds")
    public void loginTest(String userName, String pass, boolean isValid) {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 8);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        if(isValid) {
            Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/secure");
            Assert.assertTrue(message.getText().contains("You logged into a secure area!"));
            Assert.assertTrue(message.getAttribute("class").contains("success"));
        } else {
            Assert.assertEquals(driver.getCurrentUrl(), BASE_URL);
            Assert.assertTrue(message.getText().contains("is invalid"));
            Assert.assertTrue(message.getAttribute("class").contains("error"));
        }
    }

    @Test(dataProvider = "getCreds")
    public void loginPageObjectTest(String userName, String pass, boolean isValid) {
        LoginPageByStatic.login(userName, pass);
        WebDriverWait wait = new WebDriverWait(driver, 8);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageByStatic.VALIDATION_MESSAGE));
        if(isValid) {
            Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/secure");
            Assert.assertTrue(message.getText().contains("You logged into a secure area!"));
            Assert.assertTrue(message.getAttribute("class").contains("success"));
        } else {
            Assert.assertEquals(driver.getCurrentUrl(), BASE_URL);
            Assert.assertTrue(message.getText().contains("is invalid"));
            Assert.assertTrue(message.getAttribute("class").contains("error"));
        }
    }

    @Test
    public void logoutFlowTest() {
        new LoginPage(driver)
                .login("tomsmith", "SuperSecretPassword!")
                .verifySuccessfulLogin()
                .logout()
                .verifySuccessfulLogout();
    }

    @Test
    public void factoryLoginTest() {
        FactoryLoginPage page = PageFactory.initElements(driver, FactoryLoginPage.class);
        page.login("tomsmith", "SuperSecretPassword!");
        WebDriverWait wait = new WebDriverWait(driver, 8);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageByStatic.VALIDATION_MESSAGE));
        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/secure");
        Assert.assertTrue(message.getText().contains("You logged into a secure area!"));
        Assert.assertTrue(message.getAttribute("class").contains("success"));
    }

    @Test
    public void factoryNegativeLoginTest() {
        FactoryLoginPage page = PageFactory.initElements(driver, FactoryLoginPage.class);
        page.login("user", "SuperSecretPassword!");
        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL);
        Assert.assertTrue(page.validationMessage.getText().contains("Your username is invalid!"));
        Assert.assertTrue(page.validationMessage.getAttribute("class").contains("error"));
    }
}
