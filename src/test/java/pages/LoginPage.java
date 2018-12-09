package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends MainPage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how=How.ID, using="username")
    public static WebElement username;

    @FindBy(how=How.ID, using="password")
    public static WebElement password;

    @FindBy(how=How.ID, using="userLoginSubmitButton")
    public static WebElement signin_button;

    @FindBy(how=How.ID, using="qr-login-promotion")
    public static WebElement close_qr_promotion_popup;

    public void getAndInitLoginPage() {
        PageFactory.initElements(driver,LoginPage.class);
        sign_in_button_main_page.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("qr-login-promotion")));
    }

    public void signIn(String user_name,String secret) {
        close_qr_promotion_popup.click();
        username.sendKeys(user_name);
        password.sendKeys(secret);
        signin_button.click();
    }
}