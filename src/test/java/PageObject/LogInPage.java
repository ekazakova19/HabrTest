package PageObject;

import TestSteps.LoginPageSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public static final String url ="https://account.habr.com/login/";
    @FindBy(id="email_field")
    private WebElement emailField;
    @FindBy(id="password_field")
    private WebElement passwordField;
    @FindBy(css="button[name=go]")
    private WebElement submitButton;
    @FindBy(css = "div.s-error")
    private WebElement errorMessage;
    @FindBy(css="a.form__remind-password-link")
    private WebElement forgotPasswordLink;


    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,5);
    }

    public void fillEmailField(String email){
        if(!isTextFieldIsEmpty(emailField)){
            emailField.clear();
        }
        emailField.sendKeys(email);
    }

    public void fillPasswordlField(String password){
        if(!isTextFieldIsEmpty(passwordField)){
            passwordField.clear();
        }
        passwordField.sendKeys(password);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }


    public boolean isTextFieldIsEmpty(WebElement element){
        if(element.getAttribute("value").isEmpty()){
            return true;
        }
        return false;
    }

    public void clickOnForgotPasswordLink(){
        forgotPasswordLink.click();
        wait.until(ExpectedConditions.titleContains("Restore password"));

    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }


}
