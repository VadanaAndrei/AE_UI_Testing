package steps;

import org.openqa.selenium.WebDriver;

public class AccountSidebarSteps extends BaseSteps<AccountSidebarSteps>{

    public AccountSidebarSteps(WebDriver driver){
        super(driver);
    }

    public AccountSidebarSteps goToInputCredentials(){
        accountSidebar().clickGoToInputCredentialsButton();
        return this;
    }

    public AccountSidebarSteps enterCredentials(String email, String password){
        accountSidebar().enterCredentials(email, password);
        return this;
    }

    public AccountSidebarSteps clickSignInButton(){
        accountSidebar().clickSignInButton();
        return this;
    }

    public CreateAccountSteps clickCreateAccountButtton(){
        accountSidebar().clickCreateAccountButton();
        return new CreateAccountSteps(driver);
    }

    public HomePageSteps logout(){
        accountSidebar().logout();
        return new HomePageSteps(driver);
    }
}
