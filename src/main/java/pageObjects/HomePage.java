package pageObjects;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import managers.FileReaderManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class HomePage extends BaseUtils {

  WebDriver driver;
  JavascriptExecutor jse;
  //Page Elements
  @FindBy(id = "top")
  private WebElement nav_container;
  @FindBy(xpath = "//span[normalize-space()='Currency']")
  private WebElement nav_item_currency;
  @FindBy(xpath = "//span[normalize-space()='123456789']")
  private WebElement nav_item_number;
  @FindBy(xpath = "//span[normalize-space()='My Account']")
  private WebElement nav_item_myAccount;
  @FindBy(id = "wishlist-total")
  private WebElement nav_wishlist_total;
  @FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
  private WebElement nav_shopping_cart;
  @FindBy(xpath = "//span[normalize-space()='Checkout']")
  private WebElement nav_checkout;
  @FindBy(id = "logo")
  private WebElement logo;
  @FindBy(id = "search")
  private WebElement searchBox;
  @FindBy(id = "cart")
  private WebElement headerCart;
  @FindBy(xpath = "//nav[@id='menu']//li[@class]")
  private List<WebElement> navItems_withChild;
  @FindBy(xpath = "//nav[@id='menu']//li[@class][3]/following-sibling::li[position()<5]")
  private List<WebElement> navItems_withoutChild;
  @FindBy(xpath = "//div[@id='slideshow0']")
  private WebElement carousel_container;
  @FindBy(xpath = "//div[@id='slideshow0']//img")
  private List<WebElement> banner_items;
  @FindBy(xpath = "//div[@id='content']//div[@class='row']")
  private WebElement featuredSection_container;
  @FindBy(xpath = "//div[@id='content']//div[@class='row']//img")
  private List<WebElement> featureditem_images;
  @FindBy(xpath = "//div[@id='content']//div[@class='row']//h4/a")
  private List<WebElement> featureditem_links;
  @FindBy(xpath = "//footer//a")
  private List<WebElement> footer_Links;
  @FindBy(xpath = "//div[@id='carousel0']")
  private WebElement brandCarousel_container;
  @FindBy(xpath = "//div[@id='carousel-banner-1']//span[@class='fa fa-chevron-right']")
  private WebElement right_arrow;
  @FindBy(xpath = "//div[@id='carousel0']//img")
  private List<WebElement> brand_logo_items;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    jse = (JavascriptExecutor) driver;
    PageFactory.initElements(driver, this);
  }

  //Public Methods
  public void navigateToHomepage() {
    driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL());
  }

  public void validateHeaderItems() {
    assertThat(nav_container.isDisplayed() && nav_item_currency.isDisplayed()
        && nav_item_number.isDisplayed() && nav_item_myAccount.isDisplayed()
        && nav_wishlist_total.isDisplayed() && nav_shopping_cart.isDisplayed()
        && nav_checkout.isDisplayed()).isTrue();
  }

  public void validateNavigationItems() {
    boolean navItemsVisible = (navItems_withChild.size() + navItems_withoutChild.size()) >= 8;
    assertThat(logo.isDisplayed() && searchBox.isDisplayed() && headerCart.isDisplayed()
        && navItemsVisible).isTrue();
  }

  public void validateHeroImageCarousel() {
    assertThat(carousel_container.isDisplayed()).isTrue();
    findBrokenElements(banner_items, "src");
  }

  public void validateFeaturedItems() {
    assertThat(featuredSection_container.isDisplayed()).isTrue();
    findBrokenElements(featureditem_images, "src");
    findBrokenElements(featureditem_links, "href");
  }

  public void validateFooterLinks() {
    assertThat(footer_Links.size()).isGreaterThanOrEqualTo(15);
    findBrokenElements(footer_Links, "href");
  }

  public void validateBrandCarousel() {
    assertThat(brandCarousel_container.isDisplayed()).isTrue();
    findBrokenElements(brand_logo_items, "src");
  }

}
