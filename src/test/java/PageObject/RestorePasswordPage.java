package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestorePasswordPage {
    private WebDriver driver;
    @FindBy(css ="div.shadow-box__title")
    private WebElement title;
    @FindBy(css ="label.form__field-label")
    private WebElement emailLabel;
    @FindBy(id="email_field")
    private WebElement emailField;
    @FindBy(css="button[name=go]")
    private WebElement submitButton;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTitleValue(){
       return title.getText();
    }
    public String getEmailLabelValue(){
        return emailLabel.getText();
    }

    public boolean isSubmitButtonActive(){
        return submitButton.isEnabled();
    }

}
