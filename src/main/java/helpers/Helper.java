package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<WebElement> getVisibleElements(WebDriver driver, By locator) {
        List<WebElement> visibleElements = new ArrayList<WebElement>();
        for(WebElement element : driver.findElements(locator)) {
            if(element.isDisplayed()) {
                visibleElements.add(element);
            }
        }
        return visibleElements;
    }

    public static void check(WebElement checkBox) {
        setCheckboxTo(checkBox, true);
    }

    public static void uncheck(WebElement checkBox) {
        setCheckboxTo(checkBox, false);
    }

    public static void setCheckboxTo(WebElement checkbox, boolean wishToCheck) {
        if (checkbox.isSelected() != wishToCheck) {
            checkbox.click();
        }
    }

    public static WebElement getFirstSelectedOption(WebElement select) {
        for (WebElement option : select.findElements(By.tagName("option"))) {
            if (option.isSelected()) {
                return option;
            }
        }
        throw new NoSuchElementException("No options are selected");
    }

    public static void selectByIndex(WebElement select, int index) {
        select.findElements(By.tagName("option")).get(index).click();
    }

    public static void selectByValue(WebElement select, String value) {
        select.findElement(By.cssSelector(String.format("option[value='%s']", value))).click();
    }

    public static void selectByText(WebElement select, String text) {
        select.findElement(By.xpath(String.format("./option[text()='%s']", text))).click();
    }
}
