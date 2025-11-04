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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(buttonLocator));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", button);

        } catch (Exception e) {
            System.err.println("Error closing the modal with js");
        }
    }

}
