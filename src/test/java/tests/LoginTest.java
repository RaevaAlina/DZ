package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("ND")
    @Story("ND.2")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("RaevaAlina alinaisupova@gmail.com")
    @TmsLink("DZ")
    @Issue("1")
    @Description("Проверка входа в систему интренет-магазина")
    @Flaky
    @Test(description = "Авторизация под верными данными")
    public void correctLogin() {
        loginPage
                .open()
                .login(user, password);
        assertTrue(productsPage.titleDisplayed());
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {user, "12345", "Epic sadface: Username and password do not match any user in this service"},
                {"", password, "Epic sadface: Username is required"},
        };
    }

    @Test(dataProvider = "loginData", description = "Авторизация невалидного пользователя")
    public void errorLogin(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}