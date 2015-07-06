package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FramesTest {
    private WebDriver driver;
    private static final String BASE_URL = "http://the-internet.herokuapp.com/";
    private static final String [] ITEMS = new String [] {"Line 1", "Line 2", "Line 3"};

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void workWithFrameTest() throws InterruptedException {
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("iFrame")).click();
        driver.findElement(By.id("mceu_15-open")).click();
        driver.findElement(By.id("mceu_33-text")).click();
        driver.findElement(By.cssSelector("i.mce-i-bullist")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(ITEMS[0] + Keys.ENTER).perform();
        actions.sendKeys(ITEMS[1] + Keys.ENTER).perform();
        actions.sendKeys(ITEMS[2]).perform();
        driver.switchTo().frame("mce_0_ifr");
        List<WebElement> items = driver.findElements(By.cssSelector("body > ul > li"));
        Assert.assertEquals(items.size(), 3);
        for (int i = 0; i < items.size(); i++) {
            Assert.assertEquals(items.get(i).getText(), ITEMS[i]);
        }
        Thread.sleep(5000);
    }
}
