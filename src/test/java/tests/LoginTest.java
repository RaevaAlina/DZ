package tests;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Epic("Модуль логина интеренет-магазина")
    @Feature("ND")
    @Story("ND.2")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("RaevaAlina alinaisupova@gmail.com")
    @TmsLink("DZ")
    @Issue("1")
    @Description("Проверка входа в систему интренет-магазина")
    @Flaky
    @Test(description ="Авторизация под верными данными")
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.titleDisplayed());
        assertEquals(productsPage.getTitle(), "Product");
       //AllureUtils.takeScreenshot(driver);

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
    public void errorLogin(String user,String password,String errorMSG) {
        loginPage.open();
        loginPage.login(user,password);
        loginPage.getErrorMessage();
        assertEquals(loginPage.getErrorMessage(), errorMSG);
    }
}


