package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {

    @FindBy(css = "div[class=\"Grid__grid\"] > div > div > [data-testid^='product-card-']")
    private List<WebElement> returnedProducts;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    //doesn't get all the products if the page needs to be scrolled
    public List<Product> getProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfAllElements(returnedProducts));

        return returnedProducts.stream()
                .map(e -> {
                    String name = "";
                    List<WebElement> nameElements = e.findElements(By.cssSelector("[data-testid='product-card-title']"));
                    if (!nameElements.isEmpty()) {
                        name = nameElements.get(0).getText().trim();
                    }

                    double currentPrice = 0.0;
                    List<WebElement> priceElements = e.findElements(By.cssSelector("[data-testid='currentPrice']"));

                    if (!priceElements.isEmpty()) {
                        WebElement priceElement = priceElements.get(0);

                        String priceText = priceElement.getText().trim();
                        if (!priceText.isEmpty()) {
                            String cleanedPrice = priceText
                                    .replaceAll("[^0-9.,]", "")
                                    .replace(",", ".");
                            try {
                                currentPrice = Double.parseDouble(cleanedPrice);
                            } catch (NumberFormatException ignored) {
                                System.err.println("Error converting the price: " + priceText + " for: " + name);
                            }
                        }
                    }

                    Product product = new Product(name, currentPrice);
                    System.out.println("Product fetched: " + product);
                    return product;
                })
                .collect(Collectors.toList());
    }

}
