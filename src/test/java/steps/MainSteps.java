package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.Buyer;
import objects.Crawler;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    @When("^Crawler visits departments from dropdown and write results to dropbox")
    public void crawlerVisitsAmazonHomePageAndGetsDepartmentLinks(){
        Crawler crawler = new Crawler(driver);
        crawler.getUrlsAndWriteResponseToFileAndUploadToDropbox();
    }

}
