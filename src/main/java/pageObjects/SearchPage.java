package pageObjects;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class SearchPage extends BaseUtils {

  private static final Logger log = LogManager.getLogger(SearchPage.class);
  WebDriver driver;
  @FindBy(xpath = "//div[@id='search']//input")
  private WebElement searchBox;
  @FindBy(xpath = "//div[@id='search']//button")
  private WebElement searchButton;
  @FindBy(xpath = "//div[contains(@class,'product-layout')]//h4")
  private List<WebElement> product_Names;
  @FindBy(xpath = "//a[@title='Checkout']")
  private WebElement checkout;
  @FindBy(xpath = "//input[@id='button-payment-address']")
  private WebElement billingDetails_button;
  @FindBy(xpath = "//input[@id='button-shipping-address']")
  private WebElement shippingDetails_button;
  @FindBy(xpath = "//input[@id='button-shipping-method']")
  private WebElement deliveryMethod_button;
  @FindBy(xpath = "//input[@type='checkbox']")
  private WebElement getPaymentMethod_checkbox;
  @FindBy(xpath = "//input[@id='button-payment-method']")
  private WebElement paymentMethod_button;
  @FindBy(xpath = "//table[contains(@class,'table-hover')]//td/a")
  private List<WebElement> table_products;
  @FindBy(xpath = "//input[@id='button-confirm']")
  private WebElement confirm_Order_Button;


  public SearchPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void searchTheProduct(String keywords) {
    searchBox.sendKeys(keywords);
    searchButton.click();
  }

  public List<WebElement> sendProductNames() {
    return product_Names;
  }

  public void addProvidedItem(String itemName) {
    //Adds the provided item to the cart
    driver.findElement(By.xpath(
            "//img[@title='" + itemName + "']//following::button[contains(@onclick,'cart.add')][1]"))
        .click();
  }

  public void clickCheckout() {
    checkout.click();
  }

  public String placeOrder() {
    boolean order_is_correct = false;
    log.info(":::::Clicking Billing Details Continue Button:::::");
    billingDetails_button.click();
    log.info(":::::Clicking Shipping Details Continue Button:::::");
    shippingDetails_button.click();
    log.info(":::::Clicking delivery Details Continue Button:::::");
    deliveryMethod_button.click();
    log.info(":::::Clicking Payment Method Checkbox Button:::::");
    getPaymentMethod_checkbox.click();
    log.info(":::::Clicking Payment Method Continue Button:::::");
    paymentMethod_button.click();
    log.info(":::::Clicking Confirm Order Button:::::");
    confirm_Order_Button.click();

    waitUntilPageTitleIsFound(driver, "Your order has been placed!");

    return driver.getTitle();
  }
}
