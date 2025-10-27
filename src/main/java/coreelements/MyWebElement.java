package coreelements;

import org.openqa.selenium.WebElement;

public class MyWebElement {

    private final WebElement element;

    public MyWebElement(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    public String getText() {
        return element.getText();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public WebElement getWrappedElement() {
        return element;
    }
}
