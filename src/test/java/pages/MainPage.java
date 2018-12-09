package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public  class MainPage {
    public static WebDriver driver;

    @FindBy(how= How.CLASS_NAME, using="login-text")
    public static WebElement sign_in_button_main_page;

    public  MainPage(WebDriver driver){
        MainPage.driver = driver;
        PageFactory.initElements(driver,MainPage.class);
        driver.get("https://www.sahibinden.com/");
    }

}
