package tests;

import assertions.AccountSidebarAssertions;
import assertions.SearchResultsAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverFactory;
import steps.AccountSidebarSteps;
import steps.HomePageSteps;
import steps.SearchResultsSteps;
import steps.SearchSidebarSteps;
import utils.ScenarioContext;

public class BaseTest {

    protected static WebDriver driver;
    protected HomePageSteps homePageSteps;
    protected SearchSidebarSteps searchSidebarSteps;
    protected SearchResultsSteps searchResultsSteps;
    protected AccountSidebarSteps accountSidebarSteps;
    protected AccountSidebarAssertions accountSidebarAssertions;
    protected SearchResultsAssertions searchResultsAssertions;

    @BeforeAll
    public static void setup(){
        WebDriverFactory.initialize();
        driver = WebDriverFactory.get();
    }

    @BeforeEach
    public void testSetup(){
        homePageSteps = new HomePageSteps(driver);
        searchSidebarSteps = new SearchSidebarSteps(driver);
        searchResultsSteps = new SearchResultsSteps(driver);
        accountSidebarSteps = new AccountSidebarSteps(driver);

        accountSidebarAssertions = new AccountSidebarAssertions(driver);
        searchResultsAssertions = new SearchResultsAssertions(driver);
    }

    @AfterAll
    public static void teardown(){
        ScenarioContext.getInstance().removeAll();
        WebDriverFactory.end();
    }
}
