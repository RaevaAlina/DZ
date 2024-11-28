package tests;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{
    @Test
 public void addGoods() {
        loginPage.open();
        loginPage.login( "standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");}

    @Test
  public void removeg() {
            loginPage.open();
            loginPage.login( "standard_user","secret_sauce");
            productsPage.Remove( "Sauce Labs Bolt T-Shirt");

        }
}

