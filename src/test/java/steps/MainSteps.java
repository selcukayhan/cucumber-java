package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import objects.Buyer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import objects.LoginPage;
import objects.Buyer;
import objects.BuyerPool;
import objects.BasePage;
import sun.rmi.runtime.Log;
import static objects.BuyerPool.defaultUser;

public class MainSteps {

        public WebDriver driver;

        public MainSteps(){
            driver = Hooks.driver;
        }

    @Given("^I am a user of amazon\\.com$")
    public void iAmAUserOfAmazomCom() {
        Buyer buyer = defaultUser(driver);}

    @Then("^I should be logged in$")
    public void iShouldBeLoogedIn() {
        Assert.assertTrue(driver.findElement(By.id("nav-your-amazon-text")).isDisplayed());
    }

    @Then("^I should not be logged in$")
    public void iShouldNotBeLoggedIn() {
        Assert.assertTrue(driver.findElement(By.id("auth-error-message-box")).isDisplayed());
    }

}
