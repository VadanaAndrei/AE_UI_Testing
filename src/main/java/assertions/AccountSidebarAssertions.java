package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.components.AccountSidebar;

import java.time.Duration;

public class AccountSidebarAssertions extends BaseAssertions{

    private final AccountSidebar accountSidebar;
    private final HomePage homePage;
    private final WebDriver driver;

    public AccountSidebarAssertions(WebDriver driver){
        super();
        this.driver = driver;
        this.accountSidebar = new AccountSidebar(driver);
        this.homePage = new HomePage(driver);
    }

    public AccountSidebarAssertions verifySignInErrorMessage(String expectedMessage){
        softAssertions.assertThat(accountSidebar.getLoginErrorMessage())
                .isEqualTo(expectedMessage);
        return this;
    }

    public AccountSidebarAssertions verifySuccessfulSignIn(String expectedMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getOpenAccountSidebarButton())).click();

        softAssertions.assertThat(accountSidebar.getSuccessfulSignInMessage())
                .isEqualTo(expectedMessage);

        return this;
    }
}
