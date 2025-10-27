package pages;

import config.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    @FindBy(css = "button[aria-label='Search']")
    private WebElement openSearchSidebarButton;

    @FindBy(css = "a[data-testid=\"account-sign-in-link\"]")
    private WebElement openAccountSidebarButtonNotLoggedIn;

    @FindBy(css = "button[data-testid='account-menu-button']")
    private WebElement openAccountSidebarButtonLoggedIn;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(Configuration.environment().homepageUrl());
    }

    public void openSearchSidebar(){
        openSearchSidebarButton.click();
    }

    public void openAccountSidebar(){
        By loggedInButton = By.cssSelector("button[data-testid='account-menu-button']");
        By notLoggedInButton = By.cssSelector("a[data-testid=\"account-sign-in-link\"]");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(loggedInButton)).click();
        }catch (TimeoutException e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(notLoggedInButton)).click();
        }
    }

    public By getOpenAccountSidebarButton(){
        return By.cssSelector("button[data-testid='account-menu-button']");
    }
}
