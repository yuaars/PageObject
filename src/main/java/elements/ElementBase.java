package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ElementBase {
    protected final SearchContext host;
    protected final WebElement wrappedElement;
    protected final By locator;

    public ElementBase(SearchContext host, By locator) {
        this.host = host;
        this.locator = locator;
        wrappedElement = host.findElement(locator);
    }

    public void click() {
        wrappedElement.click();
    }

    public void focus() {
        wrappedElement.sendKeys("");
    }

    public boolean isEnabled() {
        return wrappedElement.isEnabled();
    }

    // region Element methods
    public WebElement getWrappedElement() {
        return wrappedElement;
    }

    public SearchContext getHost() {
        return host;
    }

    public By getLocator() {
        return locator;
    }
    // endregion
}
