package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Label extends HasText {

    public Label(SearchContext host, By locator) {
        super(host, locator);
    }
}
