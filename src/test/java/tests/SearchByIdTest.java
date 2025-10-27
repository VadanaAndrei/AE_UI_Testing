package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Epic("Search Functionality")
@Feature("Search by ID")
public class SearchByIdTest extends BaseTest {

    @Test
    @Story("Search for a product by ID")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test searches for a product by its ID and verifies that the correct result is displayed.")
    public void SearchProductById() {
        homePageSteps
                .open()
                .acceptPrivacySettings()
                .openSearchSidebar()
                .searchFor("0111_6840_252")
                .getProducts();

        searchResultsAssertions
                .verifyNumberOfProducts(1)
                .assertAll();
    }
}
