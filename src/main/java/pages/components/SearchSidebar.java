package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchSidebar {

    private final WebDriver driver;

    @FindBy(css = "input[aria-label='Search']")
    private WebElement searchInputField;

    @FindBy(css = "button[aria-label='Search'][tabindex='-1']")
    private WebElement submitSearchButton;

    public SearchSidebar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String productId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(searchInputField));
        input.click();
        input.sendKeys(productId);
        wait.until(ExpectedConditions.elementToBeClickable(submitSearchButton)).click();
    }
}
