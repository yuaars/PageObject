package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Button extends HasText {

    public Button(SearchContext host, By locator) {
        super(host, locator);
    }

    public String getAttribute(String attributeName) {
        return wrappedElement.getAttribute(attributeName);
    }
}
