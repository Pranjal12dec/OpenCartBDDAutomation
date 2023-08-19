package runnerAndStepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginValidation {

  TestContext testContext;
  LoginPage loginPage;

  public LoginValidation(TestContext context) {
    testContext = context;
    loginPage = testContext.getPageObjectManager().getLoginPage();
  }

  @Given("User navigates to the login page")
  public void user_navigates_to_the_login_page() {
    loginPage.clickonAccountDropdown();
    loginPage.clickonLoginButton();
  }

  @When("The login screen appears")
  public void the_login_screen_appears() {
    loginPage.checkLoginScreen("Account Login");
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
    loginPage.checkLoginScreen("My Account");
  }
}
