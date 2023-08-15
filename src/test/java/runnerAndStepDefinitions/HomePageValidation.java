package runnerAndStepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.io.IOException;
import pageObjects.HomePage;

public class HomePageValidation {

  TestContext testContext;
  HomePage homePage;

  public HomePageValidation(TestContext context) {
    testContext = context;
    homePage = testContext.getPageObjectManager().getHomePage();
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
  public void theHeroImageCarouselShouldBeAvailableOnThePage() throws IOException {
    homePage.validateHeroImageCarousel();
  }

  @And("the Feature section items should be shown on the page")
  public void theFeatureSectionItemsShouldBeShownOnThePage() throws IOException {
    homePage.validateFeaturedItems();
  }

  @And("the Brand carousel should be available on the page")
  public void theBrandCarouselShouldBeAvailableOnThePage() throws IOException {
    homePage.validateBrandCarousel();
  }

  @And("the Footer Links should be available on the page")
  public void theFooterLinksShouldBeAvailableOnThePage() throws IOException {
    homePage.validateFooterLinks();
  }

}
