package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "ap_email")
    private WebElement emailTextBox;

    @FindBy(id = "ap_password")
    private WebElement passwordTextBox;

    @FindBy(className = "nav-line-2")
    private WebElement signIn;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(Buyer buyer) {
        typeTo(emailTextBox, buyer.getEmail());
        typeTo(passwordTextBox, buyer.getPassword());
        clickTo(signInButton);

        return new HomePage(driver);
    }
}
