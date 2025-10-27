package pages.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountSidebar {

    private final WebDriver driver;

    @FindBy(css = "button[data-test-btn='signin']")
    private WebElement goToInputCredentialsButton;

    @FindBy(css = "#phoneOrEmail")
    private WebElement emailField;

    @FindBy(css = "input#password[type=\"password\"]")
    private WebElement passwordField;

    @FindBy(css = ".Form__submitButton.button--primary[type=\"submit\"]")
    private WebElement signInButton;

    @FindBy(css = "[data-testid=\"input-message-phoneOrEmail\"] div")
    private WebElement signInErrorMessage;

    @FindBy(css = ".AccountWelcome__container.alignment__flexCenterVertical.typography__bodySmall")
    private WebElement successfulSignInMessage;

    @FindBy(css = "span[data-testid='create-account-link']")
    private WebElement createAccountButton;

    private final String signOutButtonLocator = "span[data-testid='account-menu-signout']";

    public AccountSidebar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickGoToInputCredentialsButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(goToInputCredentialsButton)).click();
    }

    public void enterCredentials(String email, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.click();
        emailInput.sendKeys(email);
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public String getLoginErrorMessage(){
        return signInErrorMessage.getText();
    }

    public String getSuccessfulSignInMessage(){
        return successfulSignInMessage.getText();
    }

    public void clickCreateAccountButton() {
        By buttonLocator = By.cssSelector("span[data-testid='create-account-link']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));

        try {
            button.click();
        }
        catch(ElementClickInterceptedException e){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", button);
        }
    }

    public void logout(){
        By buttonLocator = By.cssSelector(signOutButtonLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));

        try{
            button.click();
        } catch (ElementClickInterceptedException e){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", button);
        }
    }
}
