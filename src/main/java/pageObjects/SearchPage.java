package pageObjects;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

  WebDriver driver;
  @FindBy(xpath = "//input[@name='search']")
  private WebElement searchBox;
  @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
  private WebElement searchButton;
  @FindBy(xpath = "//div[contains(@class,'product-layout')][3]//button[1]")
  private WebElement MPB_addtoCart;
  @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
  private WebElement addtoCart_Message;

  public SearchPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void sendSearchKey(String keywords) {
    searchBox.sendKeys(keywords);
  }

  public void clickSearchButton() {
    searchButton.click();
  }

  public void addMPBtoCart() {
    MPB_addtoCart.click();
  }

  public void verifyAddtoCartMessage() {
    assertThat(addtoCart_Message.isDisplayed()).isTrue();
  }

}
