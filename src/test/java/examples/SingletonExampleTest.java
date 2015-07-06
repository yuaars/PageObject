package examples;

import helpers.WebDriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageByStatic;

import java.net.MalformedURLException;

import static helpers.WebDriverSingleton.getDriver;
import static helpers.WebDriverSingleton.quit;

public class SingletonExampleTest {
    public static final String BASE_URL = "https://twitter.com/?lang=en-gb";

    @BeforeMethod
    public void setup() throws MalformedURLException {
        WebDriverSingleton.initDriver("chrome");
        getDriver().get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        quit();
    }

    @Test
    public void loginNegativeTest() throws InterruptedException {
        LoginPageByStatic.login("111", "123");
    }
}
