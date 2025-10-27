package coreelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyPageFactory {

    private final WebDriver driver;

    public MyPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T on(Class<T> pageClass) {
        T page = PageFactory.initElements(driver, pageClass);
        return page;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
