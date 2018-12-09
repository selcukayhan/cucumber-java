package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class LoginSteps {

    public WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);

    public LoginSteps(){
        driver = Hooks.driver;
    }

    @Then("^User sign in with username: (.*) and password: (.*)")
    public void user_sign_in_with_username_and_password(String username, String password){
        loginPage.signIn(username,password);
    }


    @And("^Validates the Login Page$")
    public void validates_the_login_page()  {
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
    }

    @And("^User should not be logged in$")
    public void user_should_not_be_logged_in()  {
        Assert.assertTrue(driver.findElement(By.className("error")).isDisplayed());
    }
}
