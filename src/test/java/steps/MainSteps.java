package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

public class MainSteps {

    private  WebDriver driver;

    public MainSteps(){
        driver = Hooks.driver;
    }

    @Given("^User on www\\.sahibinden\\.com$")
    public void user_on_www_sahibinden_com() {
        MainPage mainPage = new MainPage(driver);
    }
    @When("^User click on sign in button$")
    public void user_click_on_sign_in_button() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getAndInitLoginPage();
    }

    @And("^Validates the Home Page$")
    public void validates_the_home_page() {
        Assert.assertTrue(driver.findElement(By.className("homepage-content")).isDisplayed());
    }

    @And("^User should be logged in$")
    public void user_should_be_logged_in()  {
        Assert.assertTrue(driver.findElement(By.className("username-area")).isDisplayed());
    }
}
