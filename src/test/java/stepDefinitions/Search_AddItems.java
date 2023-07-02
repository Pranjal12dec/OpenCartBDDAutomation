package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SearchPage;

public class Search_AddItems {

  TestContext testContext;
  SearchPage searchPage;

  public Search_AddItems(TestContext context) {
    testContext = context;
    searchPage = testContext.getPageObjectManager().getSearchPage();
  }

  @Then("The user searches for {string}")
  public void theUserSearchesForMacbook(String searchtext) {
    searchPage.sendSearchKey(searchtext);
    searchPage.clickSearchButton();
  }

  @And("adds the Macbook Pro SKU item to the cart")
  public void addsTheMacbookProSKUItemToTheCart() {
    searchPage.addMPBtoCart();
  }

  @Then("the Macbook Pro SKU should get added to the cart")
  public void theMacbookProSKUShouldGetAddedToTheCart() {
    searchPage.verifyAddtoCartMessage();
  }
}
