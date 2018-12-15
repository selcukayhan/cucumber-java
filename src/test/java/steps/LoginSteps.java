package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import objects.Buyer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static objects.BuyerPool.defaultUser;
import static objects.BuyerPool.invalidLoginUser;

import objects.LoginPage;

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

