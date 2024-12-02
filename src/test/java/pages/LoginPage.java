package pages;
//import io.qameta.allure.Step;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public void open() {
        driver.get(Base_URL);
    }

    @Step("Ввводим данные {user} и {password}")
    public void login(String user, String password) {
        fillUserInput(user);
        fillPasswordInput(password);
        clickSubmitBtn();
    }

    public void fillUserInput(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
    }

    public void fillPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }
@Step("Находим кнопку и отправляем данные")
    public void clickSubmitBtn() {
        driver.findElement(LOGIN_BUTTON).submit();
    }

    @Step("Получение текста из сообщения об ошибке")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
