import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DZTest {
    @Test
    public void Test() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com");

        browser.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        browser.findElement(By.xpath("//input[@data-test='login-button']")).click();
        assert browser.findElement(By.xpath("//span[@class='title']")).isDisplayed();
        browser.close();

    }


    //негатив
    public class DZTest1 {
        @Test
        public void Test() {
            WebDriver browser = new ChromeDriver();
            browser.get("https://www.saucedemo.com");

            browser.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("user");
            browser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("sauce");
            browser.findElement(By.xpath("//input[@data-test='login-button']")).click();
            String errorMessage = browser.findElement(By.xpath("//h3[@data-test='error']")).getText();
            assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
            browser.close();
        }
    }

}

