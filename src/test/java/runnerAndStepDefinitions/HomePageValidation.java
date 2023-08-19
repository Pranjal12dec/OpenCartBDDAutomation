package runnerAndStepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;

public class HomePageValidation {

  TestContext testContext;
  HomePage homePage;

  public HomePageValidation(TestContext context) {
    testContext = context;
    homePage = testContext.getPageObjectManager().getHomePage();
  }

  @Given("The user is on the Opencart Homepage")
  public void the_user_is_on_the_opencart_homepage() {
    homePage.navigateToHomepage();
  }

  @Then("The header should be available on the page")
  public void theHeaderShouldBeAvailableOnThePage() {
    homePage.validateHeaderItems();
  }

  @And("the Navigation Links should be available on the page")
  public void theNavigationLinksShouldBeAvailableOnThePage() {
    homePage.validateNavigationItems();
  }

  @And("the Hero Image carousel should be available on the page")
  public void theHeroImageCarouselShouldBeAvailableOnThePage() {
    homePage.validateHeroImageCarousel();
  }

  @And("the Feature section items should be shown on the page")
  public void theFeatureSectionItemsShouldBeShownOnThePage() {
    homePage.validateFeaturedItems();
  }

  @And("the Brand carousel should be available on the page")
  public void theBrandCarouselShouldBeAvailableOnThePage() {
    homePage.validateBrandCarousel();
  }

  @And("the Footer Links should be available on the page")
  public void theFooterLinksShouldBeAvailableOnThePage() {
    homePage.validateFooterLinks();
  }

}
