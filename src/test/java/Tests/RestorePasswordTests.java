package Tests;

import TestSteps.LoginPageSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class RestorePasswordTests extends BaseTest {
    LoginPageSteps loginPageSteps;
    private static final Logger logger = LogManager.getLogger(RestorePasswordTests.class);

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
