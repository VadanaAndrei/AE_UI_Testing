package coreelements;

import annotations.IsAtPageMethod;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;

public interface ExtendedWebPage {

    default void isAtPage(WebDriver driver, Matcher<String> urlMatcher) {
        IsAtPageMethod.Utils.waitForPage(driver, urlMatcher);
    }

}
