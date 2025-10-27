package steps;

import org.openqa.selenium.WebDriver;

public class SearchResultsSteps extends BaseSteps<SearchResultsSteps>{

    public SearchResultsSteps(WebDriver driver){
        super(driver);
    }

    public SearchResultsSteps getProducts(){
        searchResultsPage().getProducts();
        return this;
    }
}
