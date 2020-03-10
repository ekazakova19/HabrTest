package Tests;

import TestSteps.LoginPageSteps;
import org.junit.Before;
import org.junit.Test;

public class RestorePasswordTest extends BaseTest {
    LoginPageSteps loginPageSteps;

    @Before
    public void initSteps(){
        loginPageSteps = new LoginPageSteps(driver);

    }
    @Test
    public void testRestorePasswordFormElements(){
        loginPageSteps.openLogInPage()
                .clickOnForgotPasswordLink()
                .assertThatAllElementsOnFormPresented();
    }
}
