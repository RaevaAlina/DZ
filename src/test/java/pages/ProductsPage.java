package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By TITLE = By.cssSelector("[class=title]");
    private final By TITLE2 = By.xpath("//*[text()='Products']");
    private final By errorMsg = By.xpath("//h3");
    private final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final String ADD_REMOVE_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public boolean titleDisplayed() {
        return driver.findElement(TITLE2).isDisplayed();

    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();//
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();
    }

    public void Remove(String product) {
        By addRemove = By.xpath(String.format(ADD_REMOVE_PATTERN, product));
        driver.findElement(addRemove).click();
    }
}



