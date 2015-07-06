package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class InputField extends HasText {

    public InputField(SearchContext host, By locator) {
        super(host, locator);
    }

    public void clear() {
        wrappedElement.clear();
    }

    public void appendText(String value) {
        wrappedElement.sendKeys(value);
    }

    public void setText(String value) {
        clear();
        appendText(value);
    }

    @Override
    public String getText() {
        return wrappedElement.getAttribute("value");
    }
}
