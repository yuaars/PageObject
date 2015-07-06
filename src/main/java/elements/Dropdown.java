package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends HasText {
    private final Select wrappedSelect;

    public Dropdown(SearchContext host, By locator) {
        super(host, locator);
        wrappedSelect = new Select(wrappedElement);
    }

    @Override
    public String getText() {
        return wrappedSelect.getFirstSelectedOption().getText();
    }

    public boolean isMultiple() {
        return wrappedSelect.isMultiple();
    }

    public void selectByText(String text) {
        wrappedSelect.selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        wrappedSelect.selectByValue(value);
    }

    public void selectByIndex(int index) {
        wrappedSelect.selectByIndex(index);
    }
}
