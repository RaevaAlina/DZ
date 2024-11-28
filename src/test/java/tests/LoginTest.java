package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.titleDisplayed());
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"error_user", "12345", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce ", "Epic sadface: Username is required"}

        };
    }

    @Test(dataProvider = "loginData")
    public void errorlogin(String user, String password, String errorMSG) {
        loginPage.open();
        loginPage.login(user, password);
        loginPage.getErrorMessage();
        assertEquals(loginPage.getErrorMessage(), errorMSG);
    }
}


