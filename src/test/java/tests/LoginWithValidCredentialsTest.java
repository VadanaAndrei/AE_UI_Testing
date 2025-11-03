package tests;

import config.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Epic("User Account Management")
@Feature("Login")
public class LoginWithValidCredentialsTest extends BaseTest {

    @Test
    @Story("Login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("This test logs in with valid credentials and verifies successful login.")
    public void loginWithValidCredentials(){
        homePageSteps
                .open()
                .acceptPrivacySettings()
                .openAccountSidebar()
                .enterCredentials(Configuration.environment().aeEmail(), Configuration.environment().aePassword())
                .clickSignInButton();

        accountSidebarAssertions
                .verifySuccessfulSignIn("My Account Wrong")
                .assertAll();
    }
}
