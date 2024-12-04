package tests;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test(description = "Добавление товара в корзину")
    @Epic("Добавление товара в корзину")
    @Feature("ND")
    @Story("ND.21")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("RaevaAlina alinaisupova@gmail.com")
    @TmsLink("DZ")
    @Issue("1")
    @Description("Проверка добавление товара в корзину")
    @Flaky
    public void addGoods() {
        loginPage.open();
        loginPage.login(user,password);
        assertTrue(productsPage.titleDisplayed());
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
    }

    @DataProvider()
    public Object[][] addGoodsData() {
            return new Object[][]{
                    {user,password, "Sauce Labs Backpack"},
                    {user,password, "Sauce Labs Fleece Jacket"},
                    {user,password, "Sauce Labs Onesie"},
            };}

    @Test(dataProvider = "addGoodsData")
    public void switchProducts(String user, String password, String productTitle) {
        loginPage.open();
        loginPage.login(user,password);
        productsPage.addToCart(productTitle);
    }
}