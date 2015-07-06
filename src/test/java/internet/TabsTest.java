package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabsTest {
    private WebDriver driver;
    private static final String BASE_URL = "http://the-internet.herokuapp.com/";

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test
    public void createTabTest() {
        driver.findElement(By.linkText("Multiple Windows")).click();
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL + "windows");
        driver.findElement(By.cssSelector("a[target]")).click();
        Set<String> handles = driver.getWindowHandles();
        Assert.assertEquals(handles.size(), 2);
        driver.switchTo().window(new ArrayList<String>(handles).get(1));
        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL + "windows/new");
    }

    @Test(dependsOnMethods = "createTabTest")
    public void closeTabTest() {
        driver.close();
        driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL + "windows");
    }
}
