package pages;

public abstract class MyBasePage {

    public abstract void invoke();

    public abstract boolean isDisplayed();

    public abstract void verifyExpectedElementsAreDisplayed()  throws Throwable;
}
