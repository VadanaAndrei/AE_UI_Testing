package selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import config.Configuration;
import enums.Browser;

public class WebDriverFactory {

    private static WebDriver driver;

    public static void initialize() {
        String browserName = Configuration.run().browserName().toUpperCase();

        switch (Browser.valueOf(browserName)) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser: " + browserName);
        }
    }

    public static void end() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed"); // TODO: Change with log4j logger
        }
    }

    public static WebDriver get() {
        return driver;
    }

    private static WebDriver createChromeDriver() {
        String seleniumVersion = Configuration.run().seleniumVersion();

        if (seleniumVersion != null && !seleniumVersion.isEmpty()) {
            WebDriverManager.chromedriver().driverVersion(seleniumVersion).setup();
        } else {
            WebDriverManager.chromedriver().setup();
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=" + Configuration.run().browserWidth() + "," + Configuration.run().browserHeight());
        options.addArguments("--headless=new");

        System.out.println("Chrome driver initialized"); // TODO: Change with log4j logger
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {
        String seleniumVersion = Configuration.run().seleniumVersion();

        if (seleniumVersion != null && !seleniumVersion.isEmpty()) {
            WebDriverManager.firefoxdriver().driverVersion(seleniumVersion).setup();
        } else {
            WebDriverManager.firefoxdriver().setup();
        }

        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(
                Configuration.run().browserWidth(),
                Configuration.run().browserHeight()
        ));

        System.out.println("Firefox driver initialized"); // TODO: Change with log4j logger
        return driver;
    }

}
