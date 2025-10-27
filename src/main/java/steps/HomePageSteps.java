package steps;

import org.openqa.selenium.WebDriver;

public class HomePageSteps extends BaseSteps<HomePageSteps>{

    public HomePageSteps(WebDriver driver){
        super(driver);
    }

    public HomePageSteps open(){
        homePage().open();
        return this;
    }

    public SearchSidebarSteps openSearchSidebar(){
        homePage().openSearchSidebar();
        return new SearchSidebarSteps(driver);
    }

    public AccountSidebarSteps openAccountSidebar(){
        homePage().openAccountSidebar();
        return new AccountSidebarSteps(driver);
    }
}
