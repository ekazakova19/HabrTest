package TestSteps;

import Helper.CookieManager;
import PageObject.LogInPage;
import PageObject.NavigationBarElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;


public class LoginPageSteps extends BaseSteps {
    private LogInPage logInPage;
    private NavigationBarElement navigationBar;
    public WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPageSteps.class);


    public LoginPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
       logInPage = new LogInPage(driver);
       navigationBar = new NavigationBarElement(driver);
    }

    public LoginPageSteps openLogInPage(){
        openUrl(logInPage.url);
        logger.info("Step: Open login page - completed");
        return this;
    }
    public LoginPageSteps fillLoginAndPassword(String email, String password){
        if(email==null || password==null){
            logger.error("Email or password has not been passed as system property. Please rerun with correct parameters");
            throw new IllegalArgumentException("Email or password has not been passed as system property. Please rerun with correct parameters");
        }
        else {
            logInPage.fillEmailField(email);
            logInPage.fillPasswordField(password);
            logger.info("Step: Fill email and password - completed");
            return this;
        }
    }
    public LoginPageSteps fillLoginOnly(String email){
        logInPage.fillEmailField(email);
        logger.info("Step: Fill email - completed");
        return this;
    }
    public LoginPageSteps fillPasswordOnly(String pass){
        logInPage.fillEmailField(pass);
        logger.info("Step: Fill password - completed");
        return this;
    }

    public LoginPageSteps clickOnSubmitButton(){
        logInPage.clickOnSubmitButton();
        logger.info("Step: Click on submit button - completed");
        return this;
    }

    public RestorePasswordPageSteps clickOnForgotPasswordLink(){
        try {
            logInPage.clickOnForgotPasswordLink();
            logger.info("Step: Click on forgot password link - completed");
            return new RestorePasswordPageSteps(driver);
        } catch (TimeoutException e) {
            logger.error("Link not opened due to error {} ", e.getMessage());
            throw e;
        }
    }

    public LoginPageSteps assertThatLogInSuccess(){
        try {
            Assert.assertTrue("Login failure",navigationBar.isUserMenuPresented());
            logger.info("Step: Check that login is successful - completed");
            return this;
        } catch (AssertionError e) {
            logger.info("Step: Check that login is successful - Login is not successful. Error {} ", e.getMessage());
            throw e;
        }
    }

    public LoginPageSteps assertThatIncorrectMailMessageAppears(){
        try {
            Assert.assertEquals("Введите корректный e-mail",logInPage.getErrorMessage());
            logger.info("Step: Check that error message appears - completed");
            return this;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.error("Step: Check that error message appears - fails. Error {}",e.getMessage());
            throw e;
        }
    }

    public void saveAuthorizationCookies(){
        CookieManager cookieManager = new CookieManager(driver);
        cookieManager.saveCookiesToFile();
    }

    public void assertThatReCaptchaAppears(){
        logInPage.getCaptcha();
        logger.info("Step: Check that captcha appears - completed");
    }



}
