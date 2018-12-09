package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class Login {

    public WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);

    public Login(){
        driver = Hooks.driver;
    }

    @Then("^User sign in with username: (.*) and password: (.*)")
    public void i_should_login(String username, String password){
        loginPage.signIn(username,password);
    }


    @And("^Validates the Login Page$")
    public void validatesTheLoginPage()  {
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
    }

    @And("^User should not be logged in$")
    public void userShouldNotBeLoggedIn()  {
        Assert.assertTrue(driver.findElement(By.className("error")).isDisplayed());
    }
}
