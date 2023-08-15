package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;

public class PageObjectManager {

  private WebDriver driver;
  private LoginPage loginPage;
  private SearchPage searchPage;
  private HomePage homePage;

  public PageObjectManager(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPage getLoginPage() {
    return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
  }

  public SearchPage getSearchPage() {
    return (searchPage == null) ? searchPage = new SearchPage(driver) : searchPage;
  }

  public HomePage getHomePage() {
    return (homePage == null) ? homePage = new HomePage(driver) : homePage;
  }
}
