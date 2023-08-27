package pageObjects;

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
  @FindBy(xpath = "//div[@class='btn-group']//span")
  private WebElement nav_item_currency;
  @FindBy(xpath = "//ul[@class='list-inline']//i")
  private List<WebElement> right_nav_items;
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

  public boolean validateHeaderItems() {
    boolean isRightNavDisplayed = right_nav_items.size() >= 5;
    return (nav_container.isDisplayed() && nav_item_currency.isDisplayed()
        && isRightNavDisplayed);
  }

  public boolean validateNavigationItems() {
    boolean isNavItemsVisible = (navItems_withChild.size() + navItems_withoutChild.size()) >= 8;
    return (logo.isDisplayed() && searchBox.isDisplayed() && headerCart.isDisplayed()
        && isNavItemsVisible);
  }

  public boolean validateHeroImageCarousel() {
    findBrokenElements(banner_items, "src");
    return carousel_container.isDisplayed();
  }

  public boolean validateFeaturedItems() {
    findBrokenElements(featureditem_images, "src");
    findBrokenElements(featureditem_links, "href");
    return featuredSection_container.isDisplayed();
  }

  public boolean validateBrandCarousel() {
    findBrokenElements(brand_logo_items, "src");
    return brandCarousel_container.isDisplayed();
  }

  public int validateFooterLinks() {
    findBrokenElements(footer_Links, "href");
    return footer_Links.size();
  }
}