package runnerAndStepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.LoginPage;

public class LoginPageValidation {

  private static final Logger log = LogManager.getLogger(LoginPageValidation.class);
  TestContext testContext;
  LoginPage loginPage;

  public LoginPageValidation(TestContext context) {
    testContext = context;
    loginPage = testContext.getPageObjectManager().getLoginPage();
  }

  @Given("User navigates to the login page")
  public void user_navigates_to_the_login_page() {
    loginPage.clickOnLoginButton();
  }

  @When("The login screen appears")
  public void the_login_screen_appears() {
    assertThat(loginPage.getCurrentPageName()).isEqualTo("Account Login");
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
    if (loginPage.getCurrentPageName().equalsIgnoreCase("My Account")) {
      log.info("-----------------------------------------------------------------------------");
      log.info("<---- User has successfully logged in ---->");
      log.info("--------------------------------------------------------------------------\n\n");
    } else {
      log.error("-----------------------------------------------------------------------------");
      log.error("<---- User was unable to login ---->");
      log.error("Error Message:: " + loginPage.getLoginErrorMessage());
      log.error("--------------------------------------------------------------------------\n\n");
      assertThat(loginPage.getLoginErrorMessage())
          .isEqualTo("Warning: No match for E-Mail Address and/or Password.");
    }
  }
}