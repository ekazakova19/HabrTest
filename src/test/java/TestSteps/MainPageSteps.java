package TestSteps;

import PageObject.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MainPageSteps extends BaseSteps{
    WebDriver driver;
    MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(MainPageSteps.class);

    public MainPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        mainPage = new MainPage(driver);
    }

    public MainPageSteps openMainPage(){
        openUrl(mainPage.url);
        logger.info("Step: Open main page - completed");
        return this;
    }

    public LoginPageSteps clickOnLoginButton(){
        mainPage.clickOnLoginButton();
        logger.info("Step: Click on LogIn button - completed");
        return new LoginPageSteps(driver);
    }

}
