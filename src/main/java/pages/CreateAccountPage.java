package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage extends BasePage{

    public CreateAccountPage(WebDriver driver){
        super(driver);
    }

    private final String firstNameFieldLocator = "#given_name";
    @FindBy(css = "#family_name")
    private WebElement lastNameFieldLocator;
    @FindBy(css = "input#email[type='email']")
    private WebElement emailFieldLocator;
    @FindBy(css = "input#password[type='password']")
    private WebElement passwordFieldLocator;
    private final String confirmPasswordFieldLocator = "input#confirmPassword[type='password']";
    @FindBy(css = "input#terms[type='checkbox']")
    private WebElement privacyCheckbox;
    @FindBy(css = "button.Form__submitButton[type='submit']")
    private WebElement createAccountButton;

    public void enterCredentials(String firstName, String lastName, String email, String password, String confirmPassword){
        By buttonLocator = By.cssSelector(firstNameFieldLocator);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));

        button.click();
        button.sendKeys(firstName);
        lastNameFieldLocator.click();
        lastNameFieldLocator.sendKeys(lastName);
        emailFieldLocator.click();
        emailFieldLocator.sendKeys(email);
        passwordFieldLocator.click();
        passwordFieldLocator.sendKeys(password);

        buttonLocator = By.cssSelector(confirmPasswordFieldLocator);
        button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));

        Actions actions = new Actions(driver);

        actions.moveToElement(button).perform();
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        button.sendKeys(confirmPassword);

        privacyCheckbox.click();
        createAccountButton.click();
    }

}
