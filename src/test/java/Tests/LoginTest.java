package Tests;

import TestSteps.LoginPageSteps;
import TestSteps.MainPageSteps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LoginTest extends BaseTest{
    MainPageSteps mainPageSteps;
    String login;
    String password;

    @Before
    public void initSteps(){
        mainPageSteps = new MainPageSteps(driver);
        login = System.getProperty("email");
        password = System.getProperty("password");
    }

    @Test
    public void testLogInSuccessful() {
        mainPageSteps.openMainPage()
                .clickOnLoginButton()
                .fillLoginAndPassword(login,password)
                .clickOnSubmitButton()
                .assertThatLogInSuccess()
                .saveAuthorizationCookies();
    }

}
