package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Checkbox extends ElementBase {

    public Checkbox(SearchContext host, By locator) {
        super(host, locator);
    }

    public boolean isSelected() {
        return wrappedElement.isSelected();
    }

    public void check() {
        setCheckboxTo(true);
    }

    public void uncheck() {
        setCheckboxTo(false);
    }

    public void setCheckboxTo(boolean wishToCheck) {
        if (isSelected() != wishToCheck) {
            click();
        }
    }
}
