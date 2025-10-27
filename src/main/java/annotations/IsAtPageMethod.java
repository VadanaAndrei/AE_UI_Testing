package annotations;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public @interface IsAtPageMethod {

    class Utils {

        private static final int TIMEOUT_SECONDS = 30;

        public static void waitForPage(WebDriver driver, Matcher<String> urlMatcher) {
            String pageNotLoadedMessage = String.format(
                    "Page was not loaded in %d seconds!", TIMEOUT_SECONDS
            );

            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS))
                    .withMessage(pageNotLoadedMessage)
                    .until((ExpectedCondition<Boolean>) d ->
                            d != null && urlMatcher.matches(d.getCurrentUrl())
                    );
        }
    }

}
