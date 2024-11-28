package pages;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    public static final String Base_URL="https://www.saucedemo.com";
    WebDriver driver;
    public BasePage(WebDriver driver){
    this.driver=driver ;
    };

}
