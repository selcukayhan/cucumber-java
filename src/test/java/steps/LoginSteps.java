package steps;

import cucumber.api.java.en.When;
import objects.Buyer;
import org.openqa.selenium.WebDriver;

import static objects.BuyerPool.defaultUser;
import static objects.BuyerPool.invalidLoginUser;

public class LoginSteps {
    public WebDriver driver;

    public LoginSteps(){
        driver = Hooks.driver;
    }


    @When("^I log in using valid credentials$")
    public void  iLogInUsingValidCredentials() {
        Buyer buyer = defaultUser(driver).login();
    }

    @When("^I log in using invalid credentials$")
    public void  iLogInUsingInValidCredentials() {
        Buyer buyer = invalidLoginUser(driver).login();
    }
}

