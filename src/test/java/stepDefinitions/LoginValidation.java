package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.time.Duration;

public class LoginValidation {

    WebDriver driver;
    PageObjectManager pageObjectManager;
    LoginPage loginPage;

    @Given("The user is on the Opencart Homepage")
    public void the_user_is_on_the_opencart_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://opencart.abstracta.us/");
    }
    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() {
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        loginPage.clickonAccountDropdown();
        loginPage.clickonLoginButton();
    }
    @When("The login screen appears")
    public void the_login_screen_appears() {
        Assert.assertEquals(driver.getTitle(),"Account Login");
    }
    @Then("The user enters the {string} and {string}")
    public void the_user_enters_the_and(String username, String password) {
        loginPage.enterEmailAddress(username);
        loginPage.enterPassword(password);
    }
    @Then("User clicks the signin button")
    public void user_clicks_the_signin_button() {
        loginPage.clickSubmitButton();
    }
    @Then("The user should be logged in or shown error message based on credentials")
    public void the_user_should_be_logged_in_or_shown_error_message_based_on_credentials() {
        Assert.assertEquals(driver.getTitle(),"My Account");
        driver.quit();
    }

}
