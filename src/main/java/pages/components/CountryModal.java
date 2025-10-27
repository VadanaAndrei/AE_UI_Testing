package pages.components;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CountryModal {

    private final WebDriver driver;

    @FindBy(xpath = "//button[contains(@class, 'qa-btn-close') and @name='close']")
    private WebElement countryModalCloseButton;

    public CountryModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void close() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(countryModalCloseButton)).click();
        } catch (TimeoutException e) {
            System.out.println("Country modal did not appear or button not clickable.");
        }
    }
}
