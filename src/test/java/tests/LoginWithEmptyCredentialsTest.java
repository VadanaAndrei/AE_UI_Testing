package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Epic("User Account Management")
@Feature("Login")
public class LoginWithEmptyCredentialsTest extends BaseTest{

    @Test
    @Story("Login attempt with empty credentials")
    @Description("Verify that logging in with empty email and password fields shows the proper error message")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithEmptyCredentials(){
        homePageSteps
                .open()
                .acceptPrivacySettings()
                .openAccountSidebar()
                .enterCredentials("", "")
                .clickSignInButton();

        accountSidebarAssertions
                .verifySignInErrorMessage("Email or mobile number is required.")
                .assertAll();
    }
}
