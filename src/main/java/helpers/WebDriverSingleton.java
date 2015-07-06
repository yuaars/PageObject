package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton () {}

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver("default");
        }

        return driver;
    }

    public static WebDriver initDriver(String browser) {
        String browserType = System.getProperty("browser", browser);
        switch (browserType) {
            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "ie":
                driver = new InternetExplorerDriver();
                break;

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "htmlunit":
                driver = new HtmlUnitDriver();
                break;

            default:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
