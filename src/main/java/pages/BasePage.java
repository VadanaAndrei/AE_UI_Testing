package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.components.CountryModal;
import pages.components.DealModal;
import pages.components.PrivacySettingsModal;

public class BasePage {

    protected WebDriver driver;
    protected CountryModal countryModal;
    protected DealModal dealModal;
    protected PrivacySettingsModal privacySettingsModal;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        initModals();
    }

    public void initModals(){
        countryModal = new CountryModal(driver);
        dealModal = new DealModal(driver);
        privacySettingsModal = new PrivacySettingsModal(driver);
    }

    public void closeCountryModal(){
        countryModal.close();
    }

    public void closeDealModal(){
        dealModal.close();
    }

    public void acceptPrivacySettings(){
        privacySettingsModal.accept();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void navigateTo(String url){
        driver.get(url);
    }
}
