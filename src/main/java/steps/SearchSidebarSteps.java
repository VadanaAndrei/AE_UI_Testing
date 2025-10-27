package steps;

import org.openqa.selenium.WebDriver;

public class SearchSidebarSteps extends BaseSteps<SearchSidebarSteps>{

    public SearchSidebarSteps(WebDriver driver){
        super(driver);
    }

    public SearchResultsSteps searchFor(String input){
        searchSidebar().searchFor(input);
        return new SearchResultsSteps(driver);
    }
}
