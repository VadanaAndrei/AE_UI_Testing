package pages.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DealModal {

    private final WebDriver driver;

    public DealModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void close(){
        By buttonLocator = By.cssSelector("button[aria-label='Close dialog']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));

        button.click();
    }

}
