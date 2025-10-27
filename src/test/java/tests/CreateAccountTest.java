package tests;

import config.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

@Epic("User Account Management")
@Feature("Account Creation")
public class CreateAccountTest extends BaseTest{

    @Test
    @Story("Create a new user account")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test creates a new account using provided credentials and verifies account creation success.")
    public void createAccount(){
        homePageSteps
                .open()
                .acceptPrivacySettings()
                .openAccountSidebar()
                .clickCreateAccountButtton()
                .enterCredentials(Configuration.environment().mockFirstName(),
                        Configuration.environment().mockLastName(),
                        RandomUtils.generateRandomEmail(),
                        Configuration.environment().mockPassword(),
                        Configuration.environment().mockPassword())
                .closeDealModal();

        accountSidebarAssertions
                .verifySuccessfulSignIn("My Account")
                .assertAll();
    }
}
