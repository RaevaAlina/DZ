package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By title = By.xpath("//span[@class='title']");

    @Step("Проверка отображения заголовка")
    public boolean titleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    @Step("Нажимаем кнопку Добавить в корзину")
    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();
    }
}
