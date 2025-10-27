package pages.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivacySettingsModal {

    private final WebDriver driver;

    @FindBy(css = "#onetrust-button-group button#onetrust-accept-btn-handler")
    private WebElement acceptPrivacySettingsButton;

    public PrivacySettingsModal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void accept() {
        By acceptBtnLocator = By.cssSelector("#onetrust-button-group button#onetrust-accept-btn-handler");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptBtnLocator));
            button.click();

        } catch (TimeoutException e) {
            System.out.println("Privacy settings modal did not appear or button not clickable.");
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(acceptBtnLocator));
        }
    }
}
