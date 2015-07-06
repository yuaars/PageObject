package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageByUiMap;

import java.util.concurrent.TimeUnit;

public class UiMapTest {
    private WebDriver driver;
    public static final String BASE_URL = "https://twitter.com/?lang=en-gb";
    public static final String ERROR_MESSAGE_TEXT = "We could not verify your credentials. Please double-check and try again.";


    @BeforeMethod
    public  void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void  quit() {
        driver.quit();
    }

    @Test
    public void loginNegativeTest() throws InterruptedException {
        LoginPageByUiMap page = new LoginPageByUiMap(driver);
        page.login("111", "123");
    }
}
