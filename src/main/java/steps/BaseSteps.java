package steps;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.components.AccountSidebar;
import pages.components.SearchSidebar;

public class BaseSteps<T extends BaseSteps<T>> {

    protected WebDriver driver;

    protected BaseSteps(WebDriver driver){
        this.driver = driver;
    }

    @SuppressWarnings("unchecked")
    public T acceptPrivacySettings(){
        basePage().acceptPrivacySettings();
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T closeDealModal(){
        basePage().closeDealModal();
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T closeCountryModal(){
        basePage().closeCountryModal();
        return (T) this;
    }

    protected BasePage basePage() {
        return new BasePage(driver);
    }

    protected HomePage homePage(){
        return new HomePage(driver);
    }

    protected SearchSidebar searchSidebar(){
        return new SearchSidebar(driver);
    }

    protected SearchResultsPage searchResultsPage(){
        return new SearchResultsPage(driver);
    }

    protected AccountSidebar accountSidebar(){
        return new AccountSidebar(driver);
    }

    protected CreateAccountPage createAccount(){
        return new CreateAccountPage(driver);
    }
}
