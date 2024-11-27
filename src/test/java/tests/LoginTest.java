package tests;
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
        @Test
    public void incorrectLoginChek() {
        loginPage.open();
        loginPage.login("standard-userss", "secret_sauce");
        assertEquals(productsPage.getErrorMsg(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockedoutuserLoginChek() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(productsPage.getErrorMsg(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void lockeduserandpasswordLoginChek() {
        loginPage.open();
        loginPage.login("error_user", "12345");
        assertEquals(productsPage.getErrorMsg(),
                "Epic sadface: Username and password do not match any user in this service");
    }


    @Test
    public void emptyPassswordInputCheck() {
        loginPage.open();
        loginPage.login("standart-user", " ");
        assertEquals(productsPage.getErrorMsg(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}


