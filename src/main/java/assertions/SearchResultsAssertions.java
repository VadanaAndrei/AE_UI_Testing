package assertions;

import models.Product;
import org.openqa.selenium.WebDriver;
import pages.SearchResultsPage;

import java.util.List;

public class SearchResultsAssertions extends BaseAssertions{

    private final SearchResultsPage searchResultsPage;

    public SearchResultsAssertions(WebDriver driver){
        super();
        searchResultsPage = new SearchResultsPage(driver);
    }

    public SearchResultsAssertions verifyNumberOfProducts(int number){
        List<Product> products = searchResultsPage.getProducts();
        softAssertions.assertThat(products.size())
                .as("Number of products")
                .isEqualTo(number);

        return this;
    }
}
