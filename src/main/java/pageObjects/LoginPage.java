package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //Finding the Page WebElements
    @FindBy(className = "caret")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Login")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    //Public Methods
    public void clickonAccountDropdown(){
        myAccountDropdown.click();
    }

    public void clickonLoginButton(){
        loginButton.click();
    }

    public void enterEmailAddress(String userName){
        emailField.sendKeys(userName);
    }

    public void enterPassword(String Password){
        passwordField.sendKeys(Password);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }
}
