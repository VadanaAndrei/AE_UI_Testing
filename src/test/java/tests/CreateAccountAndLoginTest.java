package tests;

import config.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import utils.ContextConstants;
import utils.RandomUtils;
import utils.ScenarioContext;

@Epic("User Account Management")
@Feature("Account Creation and Login")
public class CreateAccountAndLoginTest extends BaseTest{

    @Test
    @Story("Create a new account and log in with it")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test creates a new account with random credentials, logs out, and then logs in again using " +
            "the same credentials to verify successful login.")
    public void createAccountAndLogin(){

        ScenarioContext.getInstance().put(ContextConstants.EMAIL, RandomUtils.generateRandomEmail());
        ScenarioContext.getInstance().put(ContextConstants.PASSWORD, Configuration.environment().mockPassword());

        homePageSteps
                .open()
                .acceptPrivacySettings()
                .openAccountSidebar()
                .clickCreateAccountButtton()
                .enterCredentials(Configuration.environment().mockFirstName(),
                        Configuration.environment().mockLastName(),
                        ScenarioContext.getInstance().get(ContextConstants.EMAIL, String.class),
                        ScenarioContext.getInstance().get(ContextConstants.PASSWORD, String.class),
                        ScenarioContext.getInstance().get(ContextConstants.PASSWORD, String.class))
                .closeDealModal();

        homePageSteps
                .openAccountSidebar()
                .logout()
                .openAccountSidebar()
                .clickSignInButton()
                .enterCredentials(ScenarioContext.getInstance().get(ContextConstants.EMAIL, String.class),
                        ScenarioContext.getInstance().get(ContextConstants.PASSWORD, String.class))
                .clickSignInButton();

        accountSidebarAssertions
                .verifySuccessfulSignIn("My Account")
                .assertAll();
    }
}
