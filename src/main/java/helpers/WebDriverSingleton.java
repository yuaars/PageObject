package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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
        String browserType=System.getProperty("browser",browser);
        String remote=System.getProperty("remote",null);
        if(remote==null){
            switch (browserType) {
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "ie":
                    driver=new InternetExplorerDriver();
                    break;
                case "chrome":
                    driver=new ChromeDriver();
                    break;
                default:
                    driver=new FirefoxDriver();
                    break;
            }
        }else{
            DesiredCapabilities capabilities;
            switch (browserType) {
                case "firefox":
                    capabilities = DesiredCapabilities.firefox();
                    break;
                case "ie":
                    capabilities = DesiredCapabilities.internetExplorer();
                    break;
                case "chrome":
                    capabilities = DesiredCapabilities.chrome();
                    break;
                case "htmlunit":
                    capabilities = DesiredCapabilities.htmlUnit();
                    break;
                default:
                    capabilities = DesiredCapabilities.firefox();
                    break;
            }
            try {
                driver=new RemoteWebDriver(new URL(remote),capabilities);
            } catch (MalformedURLException ex) {
                // do nothing
            }

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
