package runnerAndStepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import pageObjects.SearchPage;

public class SearchValidation {

  private static final Logger log = LogManager.getLogger(SearchValidation.class);
  TestContext testContext;
  SearchPage searchPage;

  public SearchValidation(TestContext context) {
    testContext = context;
    searchPage = testContext.getPageObjectManager().getSearchPage();
  }

  @Then("The user searches for {string} SKU")
  public void theUserSearchesForMacbookSKU(String searchKey) {
    log.info("::::: Searching for Product - " + searchKey + " :::::");
    searchPage.searchTheProduct(searchKey);
  }

  @And("All searched item should be of {string} type")
  public void allSearchedItemShouldBeOfMacbookType(String searchedItem) {
    for (WebElement element : searchPage.sendProductNames()) {
      log.info(":::::Does searched Item contains " + searchedItem + "? ---->" +
          assertThat(element.getText()).contains(searchedItem));
    }
  }

  @And("User adds the {string} SKU item to the cart")
  public void userAddsTheSKUItemToTheCart(String itemName) {
    log.info("::::: Adding the Product - " + itemName + " to cart :::::");
    searchPage.addProvidedItem(itemName);
  }

  @Then("The user proceeds with the checkout")
  public void theUserProceedsWithTheCheckout() {
    log.info("::::: Clicking Checkout Button :::::");
    searchPage.clickCheckout();
  }

  @And("User should be able to place the order successfully")
  public void userShouldBeAbleToPlaceTheOrderSuccessfully() {
    log.info("::::: Checkout Process Started :::::");
    assertThat(searchPage.placeOrder()).isEqualTo("Your order has been placed!");
    log.info("::::: Order Placed! :::::");
  }
}
