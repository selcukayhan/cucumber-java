package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends Page {

    @FindBy(id = "nav-link-accountList")
    private WebElement headerBar;

    @FindBy(id = "searchData")
    private WebElement searchBar;

    @FindBy(className = "nav-action-inner")
    private WebElement signInButton;

    @FindBy(className = "searchBtn")
    private WebElement searchButton;

    @FindBy(css = "a.menuLink.user")
    private WebElement username;

    @FindBy(xpath = "//*[@title='Hesabım']")
    private WebElement myAccount;

    @FindBy(xpath = "//*[@title='Favorilerim']")
    private WebElement myFavorites;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage callLoginPage() {
        moveTo(headerBar);
        clickTo(signInButton);
        return new LoginPage(driver);
    }
}
