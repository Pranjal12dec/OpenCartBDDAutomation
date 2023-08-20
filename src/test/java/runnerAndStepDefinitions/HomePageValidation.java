package runnerAndStepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePage;

public class HomePageValidation {
  private static final Logger log = LogManager.getLogger(HomePageValidation.class);
  TestContext testContext;
  HomePage homePage;

  public HomePageValidation(TestContext context) {
    testContext = context;
    homePage = testContext.getPageObjectManager().getHomePage();
  }

  @Given("The user is on the Opencart Homepage")
  public void the_user_is_on_the_opencart_homepage() {
    log.info("-----------------------------------------------------------------------------");
    log.info("<---- Opening HomePage URL ---->");
    homePage.navigateToHomepage();
    log.info("");
    log.info("--------------------------------------------------------------------------\n\n");
  }

  @Then("The header should be available on the page")
  public void theHeaderShouldBeAvailableOnThePage() {
    assertThat(homePage.validateHeaderItems()).isTrue();
  }

  @And("the Navigation Links should be available on the page")
  public void theNavigationLinksShouldBeAvailableOnThePage() {
    assertThat(homePage.validateNavigationItems()).isTrue();
  }

  @And("the Hero Image carousel should be available on the page")
  public void theHeroImageCarouselShouldBeAvailableOnThePage() {
    assertThat(homePage.validateHeroImageCarousel()).isTrue();
  }

  @And("the Feature section items should be shown on the page")
  public void theFeatureSectionItemsShouldBeShownOnThePage() {
    assertThat(homePage.validateFeaturedItems()).isTrue();
  }

  @And("the Brand carousel should be available on the page")
  public void theBrandCarouselShouldBeAvailableOnThePage() {
    assertThat(homePage.validateBrandCarousel()).isTrue();
  }

  @And("the Footer Links should be available on the page")
  public void theFooterLinksShouldBeAvailableOnThePage() {
    assertThat(homePage.validateFooterLinks()).isGreaterThanOrEqualTo(15);
  }
}
