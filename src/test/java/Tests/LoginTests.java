package Tests;

import TestSteps.LoginPageSteps;
import TestSteps.MainPageSteps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LoginTests extends BaseTest{
    MainPageSteps mainPageSteps;

    @Before
    public void initSteps(){
        mainPageSteps = new MainPageSteps(driver);
    }

    @Test
    public void testLogInSuccessful() {
        mainPageSteps.openMainPage()
                .clickOnLoginButton()
                .fillLoginAndPassword("al.kz93@mail.ru","090393Elka!")
                .clickOnSubmitButton()
                .assertThatLogInSuccess()
                .saveAuthorizationCookies();
    }

    @Test
    public void testLogInIncorrectEmail(){
        mainPageSteps.openMainPage()
                .clickOnLoginButton()
                .fillLoginOnly("incorrectmailmail.ru")
                .clickOnSubmitButton()
                .assertThatIncorrectMailMessageAppears();
    }
}
