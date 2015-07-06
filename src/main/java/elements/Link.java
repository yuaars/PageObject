package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Link extends HasText {

    public Link(SearchContext host, By locator) {
        super(host, locator);
    }

    public String getLinkUrl() {
        return wrappedElement.getAttribute("href");
    }
}
