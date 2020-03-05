package PageObject;

import PageObject.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
   private WebDriver driver;
   private WebDriverWait wait;
   public final static String url = "https://habr.com/ru/";


   @FindBy(id="login")
   private WebElement logInButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,5);
    }


    public void clickOnLoginButton(){
        logInButton.click();
        wait.until(ExpectedConditions.urlContains("login"));
    }

}
