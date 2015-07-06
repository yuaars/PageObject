package helpers;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static final Properties LOCATORS;

    private enum LocatorType {
        id, name, css, xpath, text, partText;
    }

    static {
        LOCATORS = new Properties();
        InputStream in = Locators.class.getResourceAsStream("/locators.properties");
        try {
            LOCATORS.load(in);
        } catch (IOException e) {
            System.out.println("Couldn't load locators for error" + e.getMessage());
        }
    }

    public static By get(String locatorKey, String arg) {
        return getLocator(String.format(LOCATORS.getProperty(locatorKey), arg));
    }

    public static By get(String locatorKey) {
        return getLocator(LOCATORS.getProperty(locatorKey));
    }

    public static By getByText(String text) {
        return get("temp.text", text);
    }

    private static By getLocator(String locatorString) {
        String[] locatorItems = locatorString.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[0]);
        switch (locatorType) {
            case id:
                return By.id(locatorItems[1]);
            case name:
                return By.name(locatorItems[1]);
            case css:
                return By.cssSelector(locatorItems[1]);
            case xpath:
                return By.xpath(locatorItems[1]);
            case text:
                return By.linkText(locatorItems[1]);
            case partText:
                return By.partialLinkText(locatorItems[1]);
            default:
                throw new IllegalArgumentException("Locator type is unknown: " + locatorType);
        }
    }
}
