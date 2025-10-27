package steps;

import org.openqa.selenium.WebDriver;

public class CreateAccountSteps extends BaseSteps<CreateAccountSteps>{

    public CreateAccountSteps(WebDriver driver){
        super(driver);
    }

    public CreateAccountSteps enterCredentials(String firstName, String lastName, String email, String password,
                                               String confirmPassword){
        createAccount().enterCredentials(firstName, lastName, email, password, confirmPassword);
        return this;
    }
}
