package pageObjects;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  WebDriver driver;
  //Finding the Page WebElements
  @FindBy(xpath = "//span[normalize-space()='My Account']")
  private WebElement myAccountDropdown;
  @FindBy(xpath = "//a[normalize-space()='Login']")
  private WebElement loginButton;
  @FindBy(xpath = "//input[@id='input-email']")
  private WebElement emailField;
  @FindBy(xpath = "//input[@id='input-password']")
  private WebElement passwordField;
  @FindBy(xpath = "//button[@type='submit']")
  private WebElement submitButton;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  //Public Methods

  public void clickonAccountDropdown() {
    myAccountDropdown.click();
  }

  public void clickonLoginButton() {
    loginButton.click();
  }

  public void enterEmailAddress(String userName) {
    emailField.sendKeys(userName);
  }

  public void enterPassword(String Password) {
    passwordField.sendKeys(Password);
  }

  public void clickSubmitButton() {
    submitButton.click();
  }

  public void checkLoginScreen(String expected) {
    assertThat(driver.getTitle()).isEqualTo(expected);
  }
}
