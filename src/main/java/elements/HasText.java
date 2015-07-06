package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public abstract class HasText extends ElementBase {

    public HasText(SearchContext host, By locator) {
        super(host, locator);
    }

    public String getText() {
        return wrappedElement.getText();
    }
}
