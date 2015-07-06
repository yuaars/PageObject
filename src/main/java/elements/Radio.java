package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Radio extends Checkbox {

    public Radio(SearchContext host, By locator) {
        super(host, locator);
    }
}
